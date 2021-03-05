package com.hyd.core.filter;

import com.alibaba.fastjson.JSONObject;
import com.hyd.common.util.TimeUtil;
import com.hyd.common.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * 网关过滤器
 */
@Slf4j
@Component
public class MyGlobalFilter implements GlobalFilter, Ordered {

    public static final String AUTHORIZATION_URL = "http://authorization-server/authorization?token=%s&url=%s&method=%s";
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获取请求路径
        String url = exchange.getRequest().getURI().toString();
        url = url.split("\\?")[0];
        String method = exchange.getRequest().getMethod().name();
        //跳过鉴权
        if (url.contains("user/login")||url.contains("/user/op/logout")) {
            log.info(String.format("\n===>跳过鉴权%s %s",method,url));
            return chain.filter(exchange);
        }
        //获取token
        Object token = exchange.getRequest().getHeaders().get("accessToken") == null ? null : exchange.getRequest().getHeaders().get("accessToken").get(0);
        // 鉴权结果
        JSONObject resp = restTemplate.getForObject(String.format(AUTHORIZATION_URL,token,url,method), JSONObject.class);
        if (resp != null && resp.getJSONObject("head") != null) {
            log.info("\n===>鉴权结果"+resp.toJSONString());
            JSONObject head = resp.getJSONObject("head");
            Integer code = head.getInteger("code");
            // 鉴权通过
            if (code != null && code == 0) {
                // 可能有刷新的token，放在响应头中方便前端刷新token
                if (head.getString("accessToken") != null) {
                    JSONObject parseToken = TokenUtil.parseToken(head.getString("accessToken"));
                    log.info("\n===>token置于HTTP响应头中"
                            +"\n===>有效期至"+ TimeUtil.getDateTimeOfTimestamp(parseToken.getJSONObject("payload").getLong("exp"))
                            +"\n===>解析的token"+ parseToken.toJSONString());
                    ArrayList<String> list = new ArrayList<>();
                    list.add("accessToken");
                    // 服务端设置该字段，浏览器才能获取额外的头字段
                    exchange.getResponse().getHeaders().setAccessControlExposeHeaders(list);
                    exchange.getResponse().getHeaders().add("accessToken",head.getString("accessToken"));
                }
                return chain.filter(exchange);
            }
        }
        resp = resp == null ? new JSONObject():resp;
        log.info("\n===>鉴权失败"+resp.toJSONString());
        // 设置头
        exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);
        // 鉴权不通过，设置响应体为resp并返回
        return exchange.getResponse().writeWith(Flux.just(exchange.getResponse().bufferFactory().wrap(resp.toJSONString().getBytes(StandardCharsets.UTF_8))));
    }

    @Override
    public int getOrder() {
        return -2;
    }
}
