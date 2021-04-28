package com.hyd.user.center.web.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import java.io.Serializable;
@Data
@NoArgsConstructor
public class RoleRelateDTO implements Serializable {
    private Long id;

    private Long parentRoleId;

    private Long childRoleId;

    private Long version;

    private static final long serialVersionUID = 1L;

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
        RoleRelateDTO other = (RoleRelateDTO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getParentRoleId() == null ? other.getParentRoleId() == null : this.getParentRoleId().equals(other.getParentRoleId()))
            && (this.getChildRoleId() == null ? other.getChildRoleId() == null : this.getChildRoleId().equals(other.getChildRoleId()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()));
    }

    @Override
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
