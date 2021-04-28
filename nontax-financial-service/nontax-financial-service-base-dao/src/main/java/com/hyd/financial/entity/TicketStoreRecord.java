package com.hyd.financial.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import java.io.Serializable;
import java.time.LocalDate;
@Data
@NoArgsConstructor
public class TicketStoreRecord implements Serializable {
    private Long id;

    private Long orderNumber;

    private Long sourceOrderNumber;

    private Long unitId;

    private Long sourceUnitId;

    private Long sourceWarehouseId;

    private Long version;

    private Long dictionaryId;

    private LocalDate storeDate;

    private String storeType;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getSourceOrderNumber() {
        return sourceOrderNumber;
    }

    public void setSourceOrderNumber(Long sourceOrderNumber) {
        this.sourceOrderNumber = sourceOrderNumber;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getSourceUnitId() {
        return sourceUnitId;
    }

    public void setSourceUnitId(Long sourceUnitId) {
        this.sourceUnitId = sourceUnitId;
    }

    public Long getSourceWarehouseId() {
        return sourceWarehouseId;
    }

    public void setSourceWarehouseId(Long sourceWarehouseId) {
        this.sourceWarehouseId = sourceWarehouseId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getDictionaryId() {
        return dictionaryId;
    }

    public void setDictionaryId(Long dictionaryId) {
        this.dictionaryId = dictionaryId;
    }

    public LocalDate getStoreDate() {
        return storeDate;
    }

    public void setStoreDate(LocalDate storeDate) {
        this.storeDate = storeDate;
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
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
        TicketStoreRecord other = (TicketStoreRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderNumber() == null ? other.getOrderNumber() == null : this.getOrderNumber().equals(other.getOrderNumber()))
            && (this.getSourceOrderNumber() == null ? other.getSourceOrderNumber() == null : this.getSourceOrderNumber().equals(other.getSourceOrderNumber()))
            && (this.getUnitId() == null ? other.getUnitId() == null : this.getUnitId().equals(other.getUnitId()))
            && (this.getSourceUnitId() == null ? other.getSourceUnitId() == null : this.getSourceUnitId().equals(other.getSourceUnitId()))
            && (this.getSourceWarehouseId() == null ? other.getSourceWarehouseId() == null : this.getSourceWarehouseId().equals(other.getSourceWarehouseId()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getDictionaryId() == null ? other.getDictionaryId() == null : this.getDictionaryId().equals(other.getDictionaryId()))
            && (this.getStoreDate() == null ? other.getStoreDate() == null : this.getStoreDate().equals(other.getStoreDate()))
            && (this.getStoreType() == null ? other.getStoreType() == null : this.getStoreType().equals(other.getStoreType()));
    }

    @Override
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
        result = prime * result + ((getStoreType() == null) ? 0 : getStoreType().hashCode());
        return result;
    }

    @Override
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
        sb.append(", storeType=").append(storeType);
        sb.append("]");
        return sb.toString();
    }
}
