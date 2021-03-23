package com.hyd.financial.entity;

import java.io.Serializable;
import javax.annotation.Generated;

public class TicketStoreRecord implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long orderNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long sourceOrderNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long unitId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long sourceUnitId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long sourceWarehouseId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long version;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long dictionaryId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String storeDate;

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
    public Long getSourceOrderNumber() {
        return sourceOrderNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSourceOrderNumber(Long sourceOrderNumber) {
        this.sourceOrderNumber = sourceOrderNumber;
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
    public Long getSourceUnitId() {
        return sourceUnitId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSourceUnitId(Long sourceUnitId) {
        this.sourceUnitId = sourceUnitId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getSourceWarehouseId() {
        return sourceWarehouseId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSourceWarehouseId(Long sourceWarehouseId) {
        this.sourceWarehouseId = sourceWarehouseId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getVersion() {
        return version;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setVersion(Long version) {
        this.version = version;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getDictionaryId() {
        return dictionaryId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setDictionaryId(Long dictionaryId) {
        this.dictionaryId = dictionaryId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getStoreDate() {
        return storeDate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setStoreDate(String storeDate) {
        this.storeDate = storeDate;
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
        TicketStoreRecord other = (TicketStoreRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderNumber() == null ? other.getOrderNumber() == null : this.getOrderNumber().equals(other.getOrderNumber()))
            && (this.getSourceOrderNumber() == null ? other.getSourceOrderNumber() == null : this.getSourceOrderNumber().equals(other.getSourceOrderNumber()))
            && (this.getUnitId() == null ? other.getUnitId() == null : this.getUnitId().equals(other.getUnitId()))
            && (this.getSourceUnitId() == null ? other.getSourceUnitId() == null : this.getSourceUnitId().equals(other.getSourceUnitId()))
            && (this.getSourceWarehouseId() == null ? other.getSourceWarehouseId() == null : this.getSourceWarehouseId().equals(other.getSourceWarehouseId()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getDictionaryId() == null ? other.getDictionaryId() == null : this.getDictionaryId().equals(other.getDictionaryId()))
            && (this.getStoreDate() == null ? other.getStoreDate() == null : this.getStoreDate().equals(other.getStoreDate()));
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderNumber() == null) ? 0 : getOrderNumber().hashCode());
        result = prime * result + ((getSourceOrderNumber() == null) ? 0 : getSourceOrderNumber().hashCode());
        result = prime * result + ((getUnitId() == null) ? 0 : getUnitId().hashCode());
        result = prime * result + ((getSourceUnitId() == null) ? 0 : getSourceUnitId().hashCode());
        result = prime * result + ((getSourceWarehouseId() == null) ? 0 : getSourceWarehouseId().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getDictionaryId() == null) ? 0 : getDictionaryId().hashCode());
        result = prime * result + ((getStoreDate() == null) ? 0 : getStoreDate().hashCode());
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
        sb.append(", sourceOrderNumber=").append(sourceOrderNumber);
        sb.append(", unitId=").append(unitId);
        sb.append(", sourceUnitId=").append(sourceUnitId);
        sb.append(", sourceWarehouseId=").append(sourceWarehouseId);
        sb.append(", version=").append(version);
        sb.append(", dictionaryId=").append(dictionaryId);
        sb.append(", storeDate=").append(storeDate);
        sb.append("]");
        return sb.toString();
    }
}