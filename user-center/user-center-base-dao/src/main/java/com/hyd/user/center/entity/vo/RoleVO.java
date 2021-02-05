package com.hyd.user.center.entity.vo;


import javax.annotation.Generated;

/**
 * @author yanduohuang
 * @date 2021/2/3 18:06
 */
public class RoleVO {
    private Long id;

    private String name;
    private String type;

    private String remark;
    private Long version;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "RoleVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", remark='" + remark + '\'' +
                ", version=" + version +
                '}';
    }
}
