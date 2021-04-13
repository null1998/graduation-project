package com.hyd.user.center.entity;

/**
 * @author yanduohuang
 * @date 2021/4/13 22:36
 */
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
