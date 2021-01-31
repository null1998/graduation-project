package com.hyd.basedata.entity.vo;

/**
 * @author yanduohuang
 * @date 2021/1/29 16:41
 */
public class UnitVO {
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
        return "UnitVO{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
