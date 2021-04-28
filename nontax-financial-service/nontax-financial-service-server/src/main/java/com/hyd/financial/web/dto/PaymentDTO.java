package com.hyd.financial.web.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@NoArgsConstructor
public class PaymentDTO implements Serializable {
    private Long id;

    private Long orderNumber;

    private Long sourceOrderNumber;

    private Long srcUnitId;
    private String srcUnitName;
    private Long desUnitId;
    private String desUnitName;
    private BigDecimal totalPrice;
    private String payType;
    private String orderType;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate orderDate;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate payDate;

    private Integer status;

    private Long version;

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

    public Long getSourceOrderNumber() {
        return sourceOrderNumber;
    }

    public void setSourceOrderNumber(Long sourceOrderNumber) {
        this.sourceOrderNumber = sourceOrderNumber;
    }

    public Long getSrcUnitId() {
        return srcUnitId;
    }

    public void setSrcUnitId(Long srcUnitId) {
        this.srcUnitId = srcUnitId;
    }

    public Long getDesUnitId() {
        return desUnitId;
    }

    public void setDesUnitId(Long desUnitId) {
        this.desUnitId = desUnitId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getVersion() {
        return version;
    }

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
                ", orderDate=" + orderDate +
                ", payDate=" + payDate +
                ", status=" + status +
                ", version=" + version +
                '}';
    }
}
