package com.hyd.financial.entity.vo;

import java.time.LocalDateTime;

/**
 * @author yanduohuang
 * @date 2021/2/3 11:18
 */
public class SettlementVO {
    private Long id;

    private Long bussinessDictionaryId;

    private Long bussinessOrderNumber;

    private LocalDateTime settlementDate;

    private Long settlementUnit;

    private Long settlementTypeDictionaryId;

    private Long unitId;

    private Integer status;

    private Long version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBussinessDictionaryId() {
        return bussinessDictionaryId;
    }

    public void setBussinessDictionaryId(Long bussinessDictionaryId) {
        this.bussinessDictionaryId = bussinessDictionaryId;
    }

    public Long getBussinessOrderNumber() {
        return bussinessOrderNumber;
    }

    public void setBussinessOrderNumber(Long bussinessOrderNumber) {
        this.bussinessOrderNumber = bussinessOrderNumber;
    }

    public LocalDateTime getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(LocalDateTime settlementDate) {
        this.settlementDate = settlementDate;
    }

    public Long getSettlementUnit() {
        return settlementUnit;
    }

    public void setSettlementUnit(Long settlementUnit) {
        this.settlementUnit = settlementUnit;
    }

    public Long getSettlementTypeDictionaryId() {
        return settlementTypeDictionaryId;
    }

    public void setSettlementTypeDictionaryId(Long settlementTypeDictionaryId) {
        this.settlementTypeDictionaryId = settlementTypeDictionaryId;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "SettlementVO{" +
                "id=" + id +
                ", bussinessDictionaryId=" + bussinessDictionaryId +
                ", bussinessOrderNumber=" + bussinessOrderNumber +
                ", settlementDate=" + settlementDate +
                ", settlementUnit=" + settlementUnit +
                ", settlementTypeDictionaryId=" + settlementTypeDictionaryId +
                ", unitId=" + unitId +
                ", status=" + status +
                ", version=" + version +
                '}';
    }
}
