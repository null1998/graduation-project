package com.hyd.financial.web.dto;

import javax.annotation.Generated;
import java.io.Serializable;

public class PrintingOrderDTO implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long orderNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String start;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String end;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long unitId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long printUnitId;
    private String printUnitName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long warehouseId;
    private String warehouseName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long version;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer status;
    private String person;
    private String tel;
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private static final long serialVersionUID = 1L;
    private Integer payStatus;

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

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getStart() {
        return start;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setStart(String start) {
        this.start = start;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getEnd() {
        return end;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setEnd(String end) {
        this.end = end;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getUnitId() {
        return unitId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getPrintUnitId() {
        return printUnitId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPrintUnitId(Long printUnitId) {
        this.printUnitId = printUnitId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getWarehouseId() {
        return warehouseId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getVersion() {
        return version;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setVersion(Long version) {
        this.version = version;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getStatus() {
        return status;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PrintingOrderDTO{" +
                "id=" + id +
                ", orderNumber=" + orderNumber +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", unitId=" + unitId +
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
