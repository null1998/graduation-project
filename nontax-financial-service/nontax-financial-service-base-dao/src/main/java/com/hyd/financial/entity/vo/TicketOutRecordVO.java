package com.hyd.financial.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import java.io.Serializable;
import java.time.LocalDate;
@Data
@NoArgsConstructor
public class TicketOutRecordVO implements Serializable {
    private Long id;

    private Long orderNumber;

    private Long targetOrderNumber;

    private Long unitId;

    private Long targetUnitId;
    private String targetUnitName;
    private String outType;

    private LocalDate outDate;

    private Long version;

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

    public Long getTargetOrderNumber() {
        return targetOrderNumber;
    }

    public void setTargetOrderNumber(Long targetOrderNumber) {
        this.targetOrderNumber = targetOrderNumber;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getTargetUnitId() {
        return targetUnitId;
    }

    public void setTargetUnitId(Long targetUnitId) {
        this.targetUnitId = targetUnitId;
    }

    public String getOutType() {
        return outType;
    }

    public void setOutType(String outType) {
        this.outType = outType;
    }

    public LocalDate getOutDate() {
        return outDate;
    }

    public void setOutDate(LocalDate outDate) {
        this.outDate = outDate;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getTargetUnitName() {
        return targetUnitName;
    }

    public void setTargetUnitName(String targetUnitName) {
        this.targetUnitName = targetUnitName;
    }

    @Override
    public String toString() {
        return "TicketOutRecordVO{" +
                "id=" + id +
                ", orderNumber=" + orderNumber +
                ", targetOrderNumber=" + targetOrderNumber +
                ", unitId=" + unitId +
                ", targetUnitId=" + targetUnitId +
                ", targetUnitName='" + targetUnitName + '\'' +
                ", outType='" + outType + '\'' +
                ", outDate='" + outDate + '\'' +
                ", version=" + version +
                '}';
    }
}
