package com.hyd.core.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
        String method = exchange.getRequest().getMethod().name();
        //跳过鉴权
        if (url.contains("user/login")||url.contains("/user/logout")) {
            log.info("跳过鉴权"+url);
            return chain.filter(exchange);
        }
        //获取token
        Object token = exchange.getRequest().getHeaders().get("accessToken") == null ? null : exchange.getRequest().getHeaders().get("accessToken").get(0);
        // 鉴权结果
        JSONObject resp = restTemplate.getForObject(String.format(AUTHORIZATION_URL,token,url,method), JSONObject.class);
        log.info("鉴权结果"+resp);
        if (resp != null && resp.getJSONObject("head") != null) {
            JSONObject head = resp.getJSONObject("head");
            Integer code = head.getInteger("code");
            // 鉴权通过
            if (code != null && code == 0) {
                // 如果发现有刷新的token则覆盖旧token
                if (head.getString("accessToken") != null) {
                    ArrayList<String> list = new ArrayList<>();
                    list.add("accessToken");
                    // 服务端设置该字段，浏览器才能获取额外的头字段
                    exchange.getResponse().getHeaders().setAccessControlExposeHeaders(list);
                    exchange.getResponse().getHeaders().add("accessToken",head.getString("accessToken"));
                }
                return chain.filter(exchange);
            }
        }

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
