package com.hyd.user.center.entity.vo;


/**
 * @author yanduohuang
 * @date 2021/2/3 18:04
 */
public class UserRoleVO {
    private Long id;

    private Long userId;

    private Long roleId;

    private Long version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "UserRoleVO{" +
                "id=" + id +
                ", userId=" + userId +
                ", roleId=" + roleId +
                ", version=" + version +
                '}';
    }
}
