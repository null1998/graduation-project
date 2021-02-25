package com.hyd.user.center.web.qo;


import com.hyd.common.core.pojo.qo.BaseQO;

/**
 * @author yanduohuang
 * @date 2021/2/4 17:38
 */
public class PermissionQO extends BaseQO {
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
                "} " + super.toString();
    }
}
