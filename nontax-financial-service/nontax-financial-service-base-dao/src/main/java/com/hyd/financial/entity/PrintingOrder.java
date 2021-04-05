package com.hyd.financial.entity;

import java.io.Serializable;
import javax.annotation.Generated;

public class PrintingOrder implements Serializable {
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

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long warehouseId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String person;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String tel;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String remark;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer status;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long version;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer payStatus;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private static final long serialVersionUID = 1L;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getOrderNumber() {
        return orderNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
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
    public String getPerson() {
        return person;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPerson(String person) {
        this.person = person;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getTel() {
        return tel;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTel(String tel) {
        this.tel = tel;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getRemark() {
        return remark;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getStatus() {
        return status;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setStatus(Integer status) {
        this.status = status;
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
    public Integer getPayStatus() {
        return payStatus;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
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
        PrintingOrder other = (PrintingOrder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderNumber() == null ? other.getOrderNumber() == null : this.getOrderNumber().equals(other.getOrderNumber()))
            && (this.getStart() == null ? other.getStart() == null : this.getStart().equals(other.getStart()))
            && (this.getEnd() == null ? other.getEnd() == null : this.getEnd().equals(other.getEnd()))
            && (this.getUnitId() == null ? other.getUnitId() == null : this.getUnitId().equals(other.getUnitId()))
            && (this.getPrintUnitId() == null ? other.getPrintUnitId() == null : this.getPrintUnitId().equals(other.getPrintUnitId()))
            && (this.getWarehouseId() == null ? other.getWarehouseId() == null : this.getWarehouseId().equals(other.getWarehouseId()))
            && (this.getPerson() == null ? other.getPerson() == null : this.getPerson().equals(other.getPerson()))
            && (this.getTel() == null ? other.getTel() == null : this.getTel().equals(other.getTel()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getPayStatus() == null ? other.getPayStatus() == null : this.getPayStatus().equals(other.getPayStatus()));
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderNumber() == null) ? 0 : getOrderNumber().hashCode());
        result = prime * result + ((getStart() == null) ? 0 : getStart().hashCode());
        result = prime * result + ((getEnd() == null) ? 0 : getEnd().hashCode());
        result = prime * result + ((getUnitId() == null) ? 0 : getUnitId().hashCode());
        result = prime * result + ((getPrintUnitId() == null) ? 0 : getPrintUnitId().hashCode());
        result = prime * result + ((getWarehouseId() == null) ? 0 : getWarehouseId().hashCode());
        result = prime * result + ((getPerson() == null) ? 0 : getPerson().hashCode());
        result = prime * result + ((getTel() == null) ? 0 : getTel().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getPayStatus() == null) ? 0 : getPayStatus().hashCode());
        return result;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", start=").append(start);
        sb.append(", end=").append(end);
        sb.append(", unitId=").append(unitId);
        sb.append(", printUnitId=").append(printUnitId);
        sb.append(", warehouseId=").append(warehouseId);
        sb.append(", person=").append(person);
        sb.append(", tel=").append(tel);
        sb.append(", remark=").append(remark);
        sb.append(", status=").append(status);
        sb.append(", version=").append(version);
        sb.append(", payStatus=").append(payStatus);
        sb.append("]");
        return sb.toString();
    }
}