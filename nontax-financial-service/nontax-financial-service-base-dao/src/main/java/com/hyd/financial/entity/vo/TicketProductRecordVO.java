package com.hyd.financial.entity.vo;

import javax.annotation.Generated;
import java.io.Serializable;

public class TicketProductRecordVO implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long orderNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long printUnitId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long ticketId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String startNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String endNumber;
    private Integer number;
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long printOrderNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long version;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String createdDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private static final long serialVersionUID = 1L;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
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
    public Long getOrderNumber() {
        return orderNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
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
    public Long getTicketId() {
        return ticketId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
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
    public Long getPrintOrderNumber() {
        return printOrderNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPrintOrderNumber(Long printOrderNumber) {
        this.printOrderNumber = printOrderNumber;
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
    public String getCreatedDate() {
        return createdDate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "TicketProductRecordVO{" +
                "id=" + id +
                ", orderNumber=" + orderNumber +
                ", printUnitId=" + printUnitId +
                ", ticketId=" + ticketId +
                ", startNumber='" + startNumber + '\'' +
                ", endNumber='" + endNumber + '\'' +
                ", printOrderNumber=" + printOrderNumber +
                ", version=" + version +
                ", createdDate='" + createdDate + '\'' +
                ", number=" + number +
                '}';
    }
}
