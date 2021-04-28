package com.hyd.financial.web.qo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import java.io.Serializable;
@Data
@NoArgsConstructor
public class TicketStoreQO implements Serializable {
    private Long id;

    private Long ticketId;

    private Long unitId;

    private Long warehouseId;

    private String startNumber;

    private String endNumber;
    private Long number;
    private Long userId;

    private String operateDate;

    private Long version;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(String startNumber) {
        this.startNumber = startNumber;
    }

    public String getEndNumber() {
        return endNumber;
    }

    public void setEndNumber(String endNumber) {
        this.endNumber = endNumber;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "TicketStoreQO{" +
                "id=" + id +
                ", ticketId=" + ticketId +
                ", unitId=" + unitId +
                ", warehouseId=" + warehouseId +
                ", startNumber='" + startNumber + '\'' +
                ", endNumber='" + endNumber + '\'' +
                ", number=" + number +
                ", userId=" + userId +
                ", operateDate='" + operateDate + '\'' +
                ", version=" + version +
                '}';
    }
}
