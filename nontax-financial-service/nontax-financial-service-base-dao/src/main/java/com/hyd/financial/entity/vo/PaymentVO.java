package com.hyd.financial.entity.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.Generated;

public class PaymentVO implements Serializable {
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

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String orderType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDate orderDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDate payDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer status;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long version;

    private String payType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private static final long serialVersionUID = 1L;

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

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

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDate payDate) {
        this.payDate = payDate;
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
        return "PaymentVO{" +
                "id=" + id +
                ", orderNumber=" + orderNumber +
                ", sourceOrderNumber=" + sourceOrderNumber +
                ", srcUnitId=" + srcUnitId +
                ", srcUnitName='" + srcUnitName + '\'' +
                ", desUnitId=" + desUnitId +
                ", desUnitName='" + desUnitName + '\'' +
                ", totalPrice=" + totalPrice +
                ", orderType='" + orderType + '\'' +
                ", orderDate=" + orderDate +
                ", payDate=" + payDate +
                ", status=" + status +
                ", version=" + version +
                ", payType='" + payType + '\'' +
                '}';
    }
}
