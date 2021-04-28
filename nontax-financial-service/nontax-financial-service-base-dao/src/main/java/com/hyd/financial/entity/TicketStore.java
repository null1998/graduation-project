package com.hyd.financial.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import java.io.Serializable;
import java.time.LocalDate;
@Data
@NoArgsConstructor
public class TicketStore implements Serializable {
    private Long id;

    private Long ticketId;

    private Long unitId;

    private Long warehouseId;

    private String startNumber;

    private String endNumber;

    private Long number;

    private Long userId;

    private LocalDate operateDate;

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

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(LocalDate operateDate) {
        this.operateDate = operateDate;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
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
        TicketStore other = (TicketStore) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTicketId() == null ? other.getTicketId() == null : this.getTicketId().equals(other.getTicketId()))
            && (this.getUnitId() == null ? other.getUnitId() == null : this.getUnitId().equals(other.getUnitId()))
            && (this.getWarehouseId() == null ? other.getWarehouseId() == null : this.getWarehouseId().equals(other.getWarehouseId()))
            && (this.getStartNumber() == null ? other.getStartNumber() == null : this.getStartNumber().equals(other.getStartNumber()))
            && (this.getEndNumber() == null ? other.getEndNumber() == null : this.getEndNumber().equals(other.getEndNumber()))
            && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getOperateDate() == null ? other.getOperateDate() == null : this.getOperateDate().equals(other.getOperateDate()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTicketId() == null) ? 0 : getTicketId().hashCode());
        result = prime * result + ((getUnitId() == null) ? 0 : getUnitId().hashCode());
        result = prime * result + ((getWarehouseId() == null) ? 0 : getWarehouseId().hashCode());
        result = prime * result + ((getStartNumber() == null) ? 0 : getStartNumber().hashCode());
        result = prime * result + ((getEndNumber() == null) ? 0 : getEndNumber().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getOperateDate() == null) ? 0 : getOperateDate().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", ticketId=").append(ticketId);
        sb.append(", unitId=").append(unitId);
        sb.append(", warehouseId=").append(warehouseId);
        sb.append(", startNumber=").append(startNumber);
        sb.append(", endNumber=").append(endNumber);
        sb.append(", number=").append(number);
        sb.append(", userId=").append(userId);
        sb.append(", operateDate=").append(operateDate);
        sb.append(", version=").append(version);
        sb.append("]");
        return sb.toString();
    }
}
