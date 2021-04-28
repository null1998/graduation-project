package com.hyd.financial.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import java.io.Serializable;
import java.time.LocalDate;
@Data
@NoArgsConstructor
public class PrintingOrderVO implements Serializable {
    private Long id;

    private Long orderNumber;

    private LocalDate start;

    private LocalDate end;

    private Long unitId;
    private String unitName;
    private Long printUnitId;
    private String printUnitName;

    private Long warehouseId;
    private String warehouseName;

    private Long version;

    private Integer status;
    private String person;
    private String tel;
    private static final long serialVersionUID = 1L;
    private Integer payStatus;

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public String getPrintUnitName() {
        return printUnitName;
    }

    public void setPrintUnitName(String printUnitName) {
        this.printUnitName = printUnitName;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getPrintUnitId() {
        return printUnitId;
    }

    public void setPrintUnitId(Long printUnitId) {
        this.printUnitId = printUnitId;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PrintingOrderVO{" +
                "id=" + id +
                ", orderNumber=" + orderNumber +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", unitId=" + unitId +
                ", unitName='" + unitName + '\'' +
                ", printUnitId=" + printUnitId +
                ", printUnitName='" + printUnitName + '\'' +
                ", warehouseId=" + warehouseId +
                ", warehouseName='" + warehouseName + '\'' +
                ", version=" + version +
                ", status=" + status +
                ", person='" + person + '\'' +
                ", tel='" + tel + '\'' +
                ", payStatus=" + payStatus +
                '}';
    }
}
