package com.hyd.core.filter;

import com.alibaba.fastjson.JSON;
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

/**
 * 网关过滤器
 */
@Slf4j
@Component
public class MyGlobalFilter implements GlobalFilter, Ordered {

    public static final String AUTHORIZATION_URL = "http://authorization-server";
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获取请求路径
        String uri = exchange.getRequest().getURI().toString();
        //跳过鉴权
        if (uri.contains("user/login")
                || uri.contains("user/info")
                || uri.contains("user/logout")
                || uri.contains("token/refresh")
                || uri.contains("token/disable")) {
            log.info("跳过鉴权"+uri);
            return chain.filter(exchange);
        }
        //获取token
        Object token = exchange.getRequest().getHeaders().get("accessToken") == null ? null : exchange.getRequest().getHeaders().get("accessToken").get(0);
        // 鉴权结果
        String resp = restTemplate.getForObject(AUTHORIZATION_URL + "/authorization?token=" + token + "&url=" + uri, String.class);
        log.info("鉴权结果"+resp);
        Integer code = JSON.parseObject(resp).getJSONObject("head").getInteger("code");
        // 鉴权通过
        if (code.equals(20000)) {
            return chain.filter(exchange);
        }
        // 设置头
        exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);
        // 鉴权不通过，设置响应体为resp并返回
        return exchange.getResponse().writeWith(Flux.just(exchange.getResponse().bufferFactory().wrap(resp.getBytes(StandardCharsets.UTF_8))));
    }

    @Override
    public int getOrder() {
        return -2;
    }
}
