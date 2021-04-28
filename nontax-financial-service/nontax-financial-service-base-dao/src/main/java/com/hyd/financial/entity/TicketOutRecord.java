package com.hyd.financial.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import java.io.Serializable;
import java.time.LocalDate;
@Data
@NoArgsConstructor
public class TicketOutRecord implements Serializable {
    private Long id;

    private Long orderNumber;

    private Long targetOrderNumber;

    private Long unitId;

    private Long targetUnitId;

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
