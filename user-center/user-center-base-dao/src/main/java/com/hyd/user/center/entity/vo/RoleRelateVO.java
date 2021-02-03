package com.hyd.user.center.entity.vo;


/**
 * @author yanduohuang
 * @date 2021/2/3 18:10
 */
public class RoleRelateVO {
    private Long id;

    private Long parentRoleId;

    private Long childRoleId;

    private Long version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentRoleId() {
        return parentRoleId;
    }

    public void setParentRoleId(Long parentRoleId) {
        this.parentRoleId = parentRoleId;
    }

    public Long getChildRoleId() {
        return childRoleId;
    }

    public void setChildRoleId(Long childRoleId) {
        this.childRoleId = childRoleId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "RoleRelateVO{" +
                "id=" + id +
                ", parentRoleId=" + parentRoleId +
                ", childRoleId=" + childRoleId +
                ", version=" + version +
                '}';
    }
}
