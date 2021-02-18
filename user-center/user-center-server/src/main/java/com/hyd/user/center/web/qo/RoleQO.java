package com.hyd.user.center.web.qo;

import com.hyd.common.core.pojo.qo.BaseQO;

/**
 * @author yanduohuang
 * @date 2021/2/5 14:19
 */
public class RoleQO extends BaseQO {
    private String name;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "RoleQO{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
