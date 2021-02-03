package com.hyd.financial.web.dto;

import javax.annotation.Generated;
import java.io.Serializable;
import java.time.LocalDateTime;

public class SettlementDTO implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long bussinessDictionaryId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long bussinessOrderNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDateTime settlementDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long settlementUnit;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long settlementTypeDictionaryId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long unitId;

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
    public Long getBussinessDictionaryId() {
        return bussinessDictionaryId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setBussinessDictionaryId(Long bussinessDictionaryId) {
        this.bussinessDictionaryId = bussinessDictionaryId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getBussinessOrderNumber() {
        return bussinessOrderNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setBussinessOrderNumber(Long bussinessOrderNumber) {
        this.bussinessOrderNumber = bussinessOrderNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LocalDateTime getSettlementDate() {
        return settlementDate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSettlementDate(LocalDateTime settlementDate) {
        this.settlementDate = settlementDate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getSettlementUnit() {
        return settlementUnit;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSettlementUnit(Long settlementUnit) {
        this.settlementUnit = settlementUnit;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getSettlementTypeDictionaryId() {
        return settlementTypeDictionaryId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSettlementTypeDictionaryId(Long settlementTypeDictionaryId) {
        this.settlementTypeDictionaryId = settlementTypeDictionaryId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getUnitId() {
        return unitId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUnitId(Long unitId) {
        this.unitId = unitId;
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
        SettlementDTO other = (SettlementDTO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBussinessDictionaryId() == null ? other.getBussinessDictionaryId() == null : this.getBussinessDictionaryId().equals(other.getBussinessDictionaryId()))
            && (this.getBussinessOrderNumber() == null ? other.getBussinessOrderNumber() == null : this.getBussinessOrderNumber().equals(other.getBussinessOrderNumber()))
            && (this.getSettlementDate() == null ? other.getSettlementDate() == null : this.getSettlementDate().equals(other.getSettlementDate()))
            && (this.getSettlementUnit() == null ? other.getSettlementUnit() == null : this.getSettlementUnit().equals(other.getSettlementUnit()))
            && (this.getSettlementTypeDictionaryId() == null ? other.getSettlementTypeDictionaryId() == null : this.getSettlementTypeDictionaryId().equals(other.getSettlementTypeDictionaryId()))
            && (this.getUnitId() == null ? other.getUnitId() == null : this.getUnitId().equals(other.getUnitId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()));
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBussinessDictionaryId() == null) ? 0 : getBussinessDictionaryId().hashCode());
        result = prime * result + ((getBussinessOrderNumber() == null) ? 0 : getBussinessOrderNumber().hashCode());
        result = prime * result + ((getSettlementDate() == null) ? 0 : getSettlementDate().hashCode());
        result = prime * result + ((getSettlementUnit() == null) ? 0 : getSettlementUnit().hashCode());
        result = prime * result + ((getSettlementTypeDictionaryId() == null) ? 0 : getSettlementTypeDictionaryId().hashCode());
        result = prime * result + ((getUnitId() == null) ? 0 : getUnitId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        return result;
    }
}
