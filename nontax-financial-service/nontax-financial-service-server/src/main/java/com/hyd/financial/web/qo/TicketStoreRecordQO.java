package com.hyd.financial.web.qo;

import com.hyd.common.core.pojo.qo.BaseQO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import java.io.Serializable;
@Data
@NoArgsConstructor
public class TicketStoreRecordQO extends BaseQO implements Serializable {
    private Long id;

    private Long orderNumber;

    private Long sourceOrderNumber;

    private Long unitId;

    private Long sourceUnitId;
    private String sourceUnitName;

    private Long sourceWarehouseId;

    private Long version;

    private static final long serialVersionUID = 1L;
    private Long dictionaryId;
    private String storeDate;

    public String getSourceUnitName() {
        return sourceUnitName;
    }

    public void setSourceUnitName(String sourceUnitName) {
        this.sourceUnitName = sourceUnitName;
    }

    public String getStoreDate() {
        return storeDate;
    }

    public void setStoreDate(String storeDate) {
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
        return "TicketStoreRecordQO{" +
                "id=" + id +
                ", orderNumber=" + orderNumber +
                ", sourceOrderNumber=" + sourceOrderNumber +
                ", unitId=" + unitId +
                ", sourceUnitId=" + sourceUnitId +
                ", sourceUnitName='" + sourceUnitName + '\'' +
                ", sourceWarehouseId=" + sourceWarehouseId +
                ", version=" + version +
                ", dictionaryId=" + dictionaryId +
                ", storeDate='" + storeDate + '\'' +
                "} " + super.toString();
    }
}
