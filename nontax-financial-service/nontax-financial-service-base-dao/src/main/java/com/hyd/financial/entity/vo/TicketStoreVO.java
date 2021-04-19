package com.hyd.financial.entity.vo;

import java.io.Serializable;
import java.time.LocalDate;
import javax.annotation.Generated;

public class TicketStoreVO implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long ticketId;
    private String ticketName;
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long unitId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long warehouseId;
    private String warehouseName;
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String startNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String endNumber;
    private Long number;
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long userId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDate operateDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long version;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private static final long serialVersionUID = 1L;

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
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
    public Long getTicketId() {
        return ticketId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
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
    public Long getWarehouseId() {
        return warehouseId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getStartNumber() {
        return startNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setStartNumber(String startNumber) {
        this.startNumber = startNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getEndNumber() {
        return endNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setEndNumber(String endNumber) {
        this.endNumber = endNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getUserId() {
        return userId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(LocalDate operateDate) {
        this.operateDate = operateDate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getVersion() {
        return version;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "TicketStoreVO{" +
                "id=" + id +
                ", ticketId=" + ticketId +
                ", ticketName='" + ticketName + '\'' +
                ", unitId=" + unitId +
                ", warehouseId=" + warehouseId +
                ", warehouseName='" + warehouseName + '\'' +
                ", startNumber='" + startNumber + '\'' +
                ", endNumber='" + endNumber + '\'' +
                ", number=" + number +
                ", userId=" + userId +
                ", operateDate='" + operateDate + '\'' +
                ", version=" + version +
                '}';
    }
}
