package com.hyd.basedata.entity.vo;

import javax.annotation.Generated;

/**
 * @author yanduohuang
 * @date 2021/2/1 14:01
 */
public class ZoneVO {
    private String name;

    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ZoneVO{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
