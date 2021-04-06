package com.hyd.financial.web.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.annotation.Generated;

public class PaymentDTO implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long orderNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long sourceOrderNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long srcUnitId;
    private String srcUnitName;
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long desUnitId;
    private String desUnitName;
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private BigDecimal totalPrice;
    private String payType;
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String orderType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String date;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String payDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer status;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long version;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private static final long serialVersionUID = 1L;

    public String getSrcUnitName() {
        return srcUnitName;
    }

    public void setSrcUnitName(String srcUnitName) {
        this.srcUnitName = srcUnitName;
    }

    public String getDesUnitName() {
        return desUnitName;
    }

    public void setDesUnitName(String desUnitName) {
        this.desUnitName = desUnitName;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
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
    public Long getSourceOrderNumber() {
        return sourceOrderNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSourceOrderNumber(Long sourceOrderNumber) {
        this.sourceOrderNumber = sourceOrderNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getSrcUnitId() {
        return srcUnitId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSrcUnitId(Long srcUnitId) {
        this.srcUnitId = srcUnitId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getDesUnitId() {
        return desUnitId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setDesUnitId(Long desUnitId) {
        this.desUnitId = desUnitId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getOrderType() {
        return orderType;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getDate() {
        return date;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setDate(String date) {
        this.date = date;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getPayDate() {
        return payDate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPayDate(String payDate) {
        this.payDate = payDate;
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

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "id=" + id +
                ", orderNumber=" + orderNumber +
                ", sourceOrderNumber=" + sourceOrderNumber +
                ", srcUnitId=" + srcUnitId +
                ", srcUnitName='" + srcUnitName + '\'' +
                ", desUnitId=" + desUnitId +
                ", desUnitName='" + desUnitName + '\'' +
                ", totalPrice=" + totalPrice +
                ", payType='" + payType + '\'' +
                ", orderType='" + orderType + '\'' +
                ", date='" + date + '\'' +
                ", payDate='" + payDate + '\'' +
                ", status=" + status +
                ", version=" + version +
                '}';
    }
}
