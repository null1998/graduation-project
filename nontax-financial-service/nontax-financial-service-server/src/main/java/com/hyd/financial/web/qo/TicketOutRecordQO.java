package com.hyd.financial.web.qo;

import com.hyd.common.core.pojo.qo.BaseQO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.Objects;
@Data
@NoArgsConstructor
public class TicketOutRecordQO extends BaseQO implements Serializable {
    private Long id;

    private Long orderNumber;

    private Long targetOrderNumber;

    private Long unitId;

    private Long targetUnitId;
    private String targetUnitName;

    private String outType;

    private String outDate;

    private Long version;

    private static final long serialVersionUID = 1L;

    public String getTargetUnitName() {
        return targetUnitName;
    }

    public void setTargetUnitName(String targetUnitName) {
        this.targetUnitName = targetUnitName;
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

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketOutRecordQO that = (TicketOutRecordQO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(orderNumber, that.orderNumber) &&
                Objects.equals(targetOrderNumber, that.targetOrderNumber) &&
                Objects.equals(unitId, that.unitId) &&
                Objects.equals(targetUnitId, that.targetUnitId) &&
                Objects.equals(targetUnitName, that.targetUnitName) &&
                Objects.equals(outType, that.outType) &&
                Objects.equals(outDate, that.outDate) &&
                Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderNumber, targetOrderNumber, unitId, targetUnitId, targetUnitName, outType, outDate, version);
    }

    @Override
    public String toString() {
        return "TicketOutRecordQO{" +
                "id=" + id +
                ", orderNumber=" + orderNumber +
                ", targetOrderNumber=" + targetOrderNumber +
                ", unitId=" + unitId +
                ", targetUnitId=" + targetUnitId +
                ", targetUnitName='" + targetUnitName + '\'' +
                ", outType='" + outType + '\'' +
                ", outDate='" + outDate + '\'' +
                ", version=" + version +
                "} " + super.toString();
    }
}
