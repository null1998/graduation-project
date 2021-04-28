package com.hyd.user.center.entity.vo;


import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yanduohuang
 * @date 2021/2/3 18:05
 */
@Data
@NoArgsConstructor
public class PermissionVO {
    private Long id;

    private String name;

    private String url;

    private String method;

    private String action;
    private String remark;
    private Long version;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "PermissionVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", action='" + action + '\'' +
                ", remark='" + remark + '\'' +
                ", version=" + version +
                '}';
    }
}
