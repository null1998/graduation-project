package com.hyd.financial.web.qo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@NoArgsConstructor
public class TreasuryQO implements Serializable {
    private Long id;

    private Long unitId;

    private Long orderNumber;

    private Long invoiceOrderNumber;

    private BigDecimal price;

    private LocalDate operateDate;

    private Long version;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getInvoiceOrderNumber() {
        return invoiceOrderNumber;
    }

    public void setInvoiceOrderNumber(Long invoiceOrderNumber) {
        this.invoiceOrderNumber = invoiceOrderNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(LocalDate operateDate) {
        this.operateDate = operateDate;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
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
        TreasuryQO other = (TreasuryQO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUnitId() == null ? other.getUnitId() == null : this.getUnitId().equals(other.getUnitId()))
            && (this.getOrderNumber() == null ? other.getOrderNumber() == null : this.getOrderNumber().equals(other.getOrderNumber()))
            && (this.getInvoiceOrderNumber() == null ? other.getInvoiceOrderNumber() == null : this.getInvoiceOrderNumber().equals(other.getInvoiceOrderNumber()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getOperateDate() == null ? other.getOperateDate() == null : this.getOperateDate().equals(other.getOperateDate()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUnitId() == null) ? 0 : getUnitId().hashCode());
        result = prime * result + ((getOrderNumber() == null) ? 0 : getOrderNumber().hashCode());
        result = prime * result + ((getInvoiceOrderNumber() == null) ? 0 : getInvoiceOrderNumber().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getOperateDate() == null) ? 0 : getOperateDate().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", unitId=").append(unitId);
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", invoiceOrderNumber=").append(invoiceOrderNumber);
        sb.append(", price=").append(price);
        sb.append(", operateDate=").append(operateDate);
        sb.append(", version=").append(version);
        sb.append("]");
        return sb.toString();
    }
}
