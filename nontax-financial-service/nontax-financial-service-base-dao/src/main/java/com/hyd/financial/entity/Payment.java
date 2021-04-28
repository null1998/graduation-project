package com.hyd.financial.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@NoArgsConstructor
public class Payment implements Serializable {
    private Long id;

    private Long orderNumber;

    private Long sourceOrderNumber;

    private Long srcUnitId;

    private Long desUnitId;

    private BigDecimal totalPrice;

    private String orderType;

    private LocalDate orderDate;

    private LocalDate payDate;

    private Integer status;

    private Long version;

    private String paytype;

    private static final long serialVersionUID = 1L;

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

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    @Override
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
        Payment other = (Payment) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderNumber() == null ? other.getOrderNumber() == null : this.getOrderNumber().equals(other.getOrderNumber()))
            && (this.getSourceOrderNumber() == null ? other.getSourceOrderNumber() == null : this.getSourceOrderNumber().equals(other.getSourceOrderNumber()))
            && (this.getSrcUnitId() == null ? other.getSrcUnitId() == null : this.getSrcUnitId().equals(other.getSrcUnitId()))
            && (this.getDesUnitId() == null ? other.getDesUnitId() == null : this.getDesUnitId().equals(other.getDesUnitId()))
            && (this.getTotalPrice() == null ? other.getTotalPrice() == null : this.getTotalPrice().equals(other.getTotalPrice()))
            && (this.getOrderType() == null ? other.getOrderType() == null : this.getOrderType().equals(other.getOrderType()))
            && (this.getOrderDate() == null ? other.getOrderDate() == null : this.getOrderDate().equals(other.getOrderDate()))
            && (this.getPayDate() == null ? other.getPayDate() == null : this.getPayDate().equals(other.getPayDate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getPaytype() == null ? other.getPaytype() == null : this.getPaytype().equals(other.getPaytype()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderNumber() == null) ? 0 : getOrderNumber().hashCode());
        result = prime * result + ((getSourceOrderNumber() == null) ? 0 : getSourceOrderNumber().hashCode());
        result = prime * result + ((getSrcUnitId() == null) ? 0 : getSrcUnitId().hashCode());
        result = prime * result + ((getDesUnitId() == null) ? 0 : getDesUnitId().hashCode());
        result = prime * result + ((getTotalPrice() == null) ? 0 : getTotalPrice().hashCode());
        result = prime * result + ((getOrderType() == null) ? 0 : getOrderType().hashCode());
        result = prime * result + ((getOrderDate() == null) ? 0 : getOrderDate().hashCode());
        result = prime * result + ((getPayDate() == null) ? 0 : getPayDate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getPaytype() == null) ? 0 : getPaytype().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", sourceOrderNumber=").append(sourceOrderNumber);
        sb.append(", srcUnitId=").append(srcUnitId);
        sb.append(", desUnitId=").append(desUnitId);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", orderType=").append(orderType);
        sb.append(", orderDate=").append(orderDate);
        sb.append(", payDate=").append(payDate);
        sb.append(", status=").append(status);
        sb.append(", version=").append(version);
        sb.append(", paytype=").append(paytype);
        sb.append("]");
        return sb.toString();
    }
}
