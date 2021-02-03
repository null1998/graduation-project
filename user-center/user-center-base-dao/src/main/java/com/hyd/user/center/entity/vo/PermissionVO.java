package com.hyd.user.center.entity.vo;


/**
 * @author yanduohuang
 * @date 2021/2/3 18:05
 */
public class PermissionVO {
    private Long id;

    private String name;

    private String url;

    private String action;

    private Long version;

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
                ", action='" + action + '\'' +
                ", version=" + version +
                '}';
    }
}
