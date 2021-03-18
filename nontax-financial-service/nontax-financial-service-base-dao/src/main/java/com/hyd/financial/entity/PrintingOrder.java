package com.hyd.financial.entity;

import java.io.Serializable;
import javax.annotation.Generated;

public class PrintingOrder implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long ordernumber;

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
    private Long version;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer status;

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
    public Long getOrdernumber() {
        return ordernumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setOrdernumber(Long ordernumber) {
        this.ordernumber = ordernumber;
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
            && (this.getOrdernumber() == null ? other.getOrdernumber() == null : this.getOrdernumber().equals(other.getOrdernumber()))
            && (this.getStart() == null ? other.getStart() == null : this.getStart().equals(other.getStart()))
            && (this.getEnd() == null ? other.getEnd() == null : this.getEnd().equals(other.getEnd()))
            && (this.getUnitId() == null ? other.getUnitId() == null : this.getUnitId().equals(other.getUnitId()))
            && (this.getPrintUnitId() == null ? other.getPrintUnitId() == null : this.getPrintUnitId().equals(other.getPrintUnitId()))
            && (this.getWarehouseId() == null ? other.getWarehouseId() == null : this.getWarehouseId().equals(other.getWarehouseId()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrdernumber() == null) ? 0 : getOrdernumber().hashCode());
        result = prime * result + ((getStart() == null) ? 0 : getStart().hashCode());
        result = prime * result + ((getEnd() == null) ? 0 : getEnd().hashCode());
        result = prime * result + ((getUnitId() == null) ? 0 : getUnitId().hashCode());
        result = prime * result + ((getPrintUnitId() == null) ? 0 : getPrintUnitId().hashCode());
        result = prime * result + ((getWarehouseId() == null) ? 0 : getWarehouseId().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PrintingOrder{" +
                "id=" + id +
                ", ordernumber=" + ordernumber +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", unitId=" + unitId +
                ", printUnitId=" + printUnitId +
                ", warehouseId=" + warehouseId +
                ", version=" + version +
                ", status=" + status +
                '}';
    }
}
