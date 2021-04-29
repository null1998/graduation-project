package com.hyd.financial.web.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@NoArgsConstructor
public class InvoiceDTO implements Serializable {
    private Long id;

    private Long orderNumber;

    private Long unitId;

    private Long ticketId;

    private String ticketNumber;

    private BigDecimal price;

    private String invoicePeople;

    private String identityNumber;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate invoiceDate;

    private Long userId;

    private Integer status;

    private Long version;

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

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getInvoiceDTOPeople() {
        return invoicePeople;
    }

    public void setInvoiceDTOPeople(String invoicePeople) {
        this.invoicePeople = invoicePeople;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public LocalDate getInvoiceDTODate() {
        return invoiceDate;
    }

    public void setInvoiceDTODate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
        InvoiceDTO other = (InvoiceDTO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderNumber() == null ? other.getOrderNumber() == null : this.getOrderNumber().equals(other.getOrderNumber()))
            && (this.getUnitId() == null ? other.getUnitId() == null : this.getUnitId().equals(other.getUnitId()))
            && (this.getTicketId() == null ? other.getTicketId() == null : this.getTicketId().equals(other.getTicketId()))
            && (this.getTicketNumber() == null ? other.getTicketNumber() == null : this.getTicketNumber().equals(other.getTicketNumber()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getInvoiceDTOPeople() == null ? other.getInvoiceDTOPeople() == null : this.getInvoiceDTOPeople().equals(other.getInvoiceDTOPeople()))
            && (this.getIdentityNumber() == null ? other.getIdentityNumber() == null : this.getIdentityNumber().equals(other.getIdentityNumber()))
            && (this.getInvoiceDTODate() == null ? other.getInvoiceDTODate() == null : this.getInvoiceDTODate().equals(other.getInvoiceDTODate()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderNumber() == null) ? 0 : getOrderNumber().hashCode());
        result = prime * result + ((getUnitId() == null) ? 0 : getUnitId().hashCode());
        result = prime * result + ((getTicketId() == null) ? 0 : getTicketId().hashCode());
        result = prime * result + ((getTicketNumber() == null) ? 0 : getTicketNumber().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getInvoiceDTOPeople() == null) ? 0 : getInvoiceDTOPeople().hashCode());
        result = prime * result + ((getIdentityNumber() == null) ? 0 : getIdentityNumber().hashCode());
        result = prime * result + ((getInvoiceDTODate() == null) ? 0 : getInvoiceDTODate().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
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
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", unitId=").append(unitId);
        sb.append(", ticketId=").append(ticketId);
        sb.append(", ticketNumber=").append(ticketNumber);
        sb.append(", price=").append(price);
        sb.append(", invoicePeople=").append(invoicePeople);
        sb.append(", identityNumber=").append(identityNumber);
        sb.append(", invoiceDate=").append(invoiceDate);
        sb.append(", userId=").append(userId);
        sb.append(", status=").append(status);
        sb.append(", version=").append(version);
        sb.append("]");
        return sb.toString();
    }
}
