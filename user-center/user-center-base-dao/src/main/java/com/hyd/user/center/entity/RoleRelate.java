package com.hyd.user.center.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.annotation.Generated;
@Data
@NoArgsConstructor
public class RoleRelate implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long parentRoleId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long childRoleId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long version;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private static final long serialVersionUID = 1L;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getParentRoleId() {
        return parentRoleId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setParentRoleId(Long parentRoleId) {
        this.parentRoleId = parentRoleId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getChildRoleId() {
        return childRoleId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setChildRoleId(Long childRoleId) {
        this.childRoleId = childRoleId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getVersion() {
        return version;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        RoleRelate other = (RoleRelate) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getParentRoleId() == null ? other.getParentRoleId() == null : this.getParentRoleId().equals(other.getParentRoleId()))
            && (this.getChildRoleId() == null ? other.getChildRoleId() == null : this.getChildRoleId().equals(other.getChildRoleId()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()));
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getParentRoleId() == null) ? 0 : getParentRoleId().hashCode());
        result = prime * result + ((getChildRoleId() == null) ? 0 : getChildRoleId().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        return result;
    }
}
