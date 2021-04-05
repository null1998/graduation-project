package com.hyd.financial.entity;

import java.io.Serializable;
import javax.annotation.Generated;

public class TicketOutRecord implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long orderNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long targetOrderNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long unitId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long targetUnitId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String outType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String outDate;

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
    public Long getTargetOrderNumber() {
        return targetOrderNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTargetOrderNumber(Long targetOrderNumber) {
        this.targetOrderNumber = targetOrderNumber;
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
    public Long getTargetUnitId() {
        return targetUnitId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTargetUnitId(Long targetUnitId) {
        this.targetUnitId = targetUnitId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getOutType() {
        return outType;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setOutType(String outType) {
        this.outType = outType;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getOutDate() {
        return outDate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setOutDate(String outDate) {
        this.outDate = outDate;
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
        TicketOutRecord other = (TicketOutRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderNumber() == null ? other.getOrderNumber() == null : this.getOrderNumber().equals(other.getOrderNumber()))
            && (this.getTargetOrderNumber() == null ? other.getTargetOrderNumber() == null : this.getTargetOrderNumber().equals(other.getTargetOrderNumber()))
            && (this.getUnitId() == null ? other.getUnitId() == null : this.getUnitId().equals(other.getUnitId()))
            && (this.getTargetUnitId() == null ? other.getTargetUnitId() == null : this.getTargetUnitId().equals(other.getTargetUnitId()))
            && (this.getOutType() == null ? other.getOutType() == null : this.getOutType().equals(other.getOutType()))
            && (this.getOutDate() == null ? other.getOutDate() == null : this.getOutDate().equals(other.getOutDate()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()));
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderNumber() == null) ? 0 : getOrderNumber().hashCode());
        result = prime * result + ((getTargetOrderNumber() == null) ? 0 : getTargetOrderNumber().hashCode());
        result = prime * result + ((getUnitId() == null) ? 0 : getUnitId().hashCode());
        result = prime * result + ((getTargetUnitId() == null) ? 0 : getTargetUnitId().hashCode());
        result = prime * result + ((getOutType() == null) ? 0 : getOutType().hashCode());
        result = prime * result + ((getOutDate() == null) ? 0 : getOutDate().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        return result;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", targetOrderNumber=").append(targetOrderNumber);
        sb.append(", unitId=").append(unitId);
        sb.append(", targetUnitId=").append(targetUnitId);
        sb.append(", outType=").append(outType);
        sb.append(", outDate=").append(outDate);
        sb.append(", version=").append(version);
        sb.append("]");
        return sb.toString();
    }
}