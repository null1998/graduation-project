package com.hyd.financial.entity.vo;

import java.io.Serializable;
import javax.annotation.Generated;

public class TicketOutRecordVO implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long orderNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long targetOrderNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long unitId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long targetUnitId;
    private String targetUnitName;
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String outType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String outDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long version;

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
    public Long getTargetOrderNumber() {
        return targetOrderNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTargetOrderNumber(Long targetOrderNumber) {
        this.targetOrderNumber = targetOrderNumber;
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
    public Long getTargetUnitId() {
        return targetUnitId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTargetUnitId(Long targetUnitId) {
        this.targetUnitId = targetUnitId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getOutType() {
        return outType;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setOutType(String outType) {
        this.outType = outType;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getOutDate() {
        return outDate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getVersion() {
        return version;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
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
