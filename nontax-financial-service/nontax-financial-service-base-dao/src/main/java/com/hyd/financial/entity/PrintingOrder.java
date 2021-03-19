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
    private String person;
    private String tel;
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private static final long serialVersionUID = 1L;

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
                ", person='" + person + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
