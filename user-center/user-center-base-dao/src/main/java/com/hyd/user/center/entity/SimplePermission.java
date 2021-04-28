package com.hyd.user.center.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yanduohuang
 * @date 2021/4/13 22:36
 */
@Data
@NoArgsConstructor
public class SimplePermission{
    private String url;
    private String method;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "SimplePermission{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}
