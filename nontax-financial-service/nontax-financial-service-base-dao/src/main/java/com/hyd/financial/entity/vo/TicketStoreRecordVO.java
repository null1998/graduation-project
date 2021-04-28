package com.hyd.financial.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import java.io.Serializable;
import java.time.LocalDate;
@Data
@NoArgsConstructor
public class TicketStoreRecordVO implements Serializable {
    private Long id;

    private Long orderNumber;

    private Long sourceOrderNumber;

    private Long unitId;

    private Long sourceUnitId;
    private String sourceUnitName;
    private Long sourceWarehouseId;
    private String sourceWarehouseName;
    private Long version;

    private static final long serialVersionUID = 1L;
    private Long dictionaryId;
    private LocalDate storeDate;
    private String theWay;
    private String storeType;

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public String getTheWay() {
        return theWay;
    }

    public void setTheWay(String theWay) {
        this.theWay = theWay;
    }

    public String getSourceUnitName() {
        return sourceUnitName;
    }

    public void setSourceUnitName(String sourceUnitName) {
        this.sourceUnitName = sourceUnitName;
    }

    public String getSourceWarehouseName() {
        return sourceWarehouseName;
    }

    public void setSourceWarehouseName(String sourceWarehouseName) {
        this.sourceWarehouseName = sourceWarehouseName;
    }

    public LocalDate getStoreDate() {
        return storeDate;
    }

    public void setStoreDate(LocalDate storeDate) {
        this.storeDate = storeDate;
    }

    public Long getDictionaryId() {
        return dictionaryId;
    }

    public void setDictionaryId(Long dictionaryId) {
        this.dictionaryId = dictionaryId;
    }
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

    @Override
    public String toString() {
        return "TicketStoreRecordVO{" +
                "id=" + id +
                ", orderNumber=" + orderNumber +
                ", sourceOrderNumber=" + sourceOrderNumber +
                ", unitId=" + unitId +
                ", sourceUnitId=" + sourceUnitId +
                ", sourceUnitName='" + sourceUnitName + '\'' +
                ", sourceWarehouseId=" + sourceWarehouseId +
                ", sourceWarehouseName='" + sourceWarehouseName + '\'' +
                ", version=" + version +
                ", dictionaryId=" + dictionaryId +
                ", storeDate='" + storeDate + '\'' +
                ", theWay='" + theWay + '\'' +
                ", storeType='" + storeType + '\'' +
                '}';
    }
}
