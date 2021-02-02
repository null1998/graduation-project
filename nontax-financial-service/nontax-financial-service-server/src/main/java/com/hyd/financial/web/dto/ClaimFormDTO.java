package com.hyd.financial.web.dto;

import javax.annotation.Generated;
import java.io.Serializable;
import java.time.LocalDateTime;

public class ClaimFormDTO implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long orderNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDateTime claimDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long claimUnitId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String claimPerson;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long claimWarehouseId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String remark;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String checkOpinion;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDateTime successDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer status;

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
    public Long getOrderNumber() {
        return orderNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LocalDateTime getClaimDate() {
        return claimDate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setClaimDate(LocalDateTime claimDate) {
        this.claimDate = claimDate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getClaimUnitId() {
        return claimUnitId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setClaimUnitId(Long claimUnitId) {
        this.claimUnitId = claimUnitId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getClaimPerson() {
        return claimPerson;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setClaimPerson(String claimPerson) {
        this.claimPerson = claimPerson;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getClaimWarehouseId() {
        return claimWarehouseId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setClaimWarehouseId(Long claimWarehouseId) {
        this.claimWarehouseId = claimWarehouseId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getRemark() {
        return remark;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getCheckOpinion() {
        return checkOpinion;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCheckOpinion(String checkOpinion) {
        this.checkOpinion = checkOpinion;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LocalDateTime getSuccessDate() {
        return successDate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSuccessDate(LocalDateTime successDate) {
        this.successDate = successDate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getStatus() {
        return status;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setStatus(Integer status) {
        this.status = status;
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
        ClaimFormDTO other = (ClaimFormDTO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderNumber() == null ? other.getOrderNumber() == null : this.getOrderNumber().equals(other.getOrderNumber()))
            && (this.getClaimDate() == null ? other.getClaimDate() == null : this.getClaimDate().equals(other.getClaimDate()))
            && (this.getClaimUnitId() == null ? other.getClaimUnitId() == null : this.getClaimUnitId().equals(other.getClaimUnitId()))
            && (this.getClaimPerson() == null ? other.getClaimPerson() == null : this.getClaimPerson().equals(other.getClaimPerson()))
            && (this.getClaimWarehouseId() == null ? other.getClaimWarehouseId() == null : this.getClaimWarehouseId().equals(other.getClaimWarehouseId()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCheckOpinion() == null ? other.getCheckOpinion() == null : this.getCheckOpinion().equals(other.getCheckOpinion()))
            && (this.getSuccessDate() == null ? other.getSuccessDate() == null : this.getSuccessDate().equals(other.getSuccessDate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()));
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderNumber() == null) ? 0 : getOrderNumber().hashCode());
        result = prime * result + ((getClaimDate() == null) ? 0 : getClaimDate().hashCode());
        result = prime * result + ((getClaimUnitId() == null) ? 0 : getClaimUnitId().hashCode());
        result = prime * result + ((getClaimPerson() == null) ? 0 : getClaimPerson().hashCode());
        result = prime * result + ((getClaimWarehouseId() == null) ? 0 : getClaimWarehouseId().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCheckOpinion() == null) ? 0 : getCheckOpinion().hashCode());
        result = prime * result + ((getSuccessDate() == null) ? 0 : getSuccessDate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        return result;
    }
}
