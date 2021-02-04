package com.hyd.user.center.web.qo;

/**
 * @author yanduohuang
 * @date 2021/2/4 17:38
 */
public class PermissionQO {
    private String name;
    private String action;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "PermissionQO{" +
                "name='" + name + '\'' +
                ", action='" + action + '\'' +
                '}';
    }
}
