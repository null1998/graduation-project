package com.hyd.financial.web.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import java.io.Serializable;
import java.math.BigDecimal;
@Data
@NoArgsConstructor
public class TicketClaimTicketDTO implements Serializable {
    private Long id;

    private Long ticketClaimId;

    private Long ticketId;
    private String ticketName;

    private Long number;

    private BigDecimal price;

    private Long version;

    private static final long serialVersionUID = 1L;
    private String startNumber;

    private String endNumber;

    public String getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(String startNumber) {
        this.startNumber = startNumber;
    }

    public String getEndNumber() {
        return endNumber;
    }

    public void setEndNumber(String endNumber) {
        this.endNumber = endNumber;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTicketClaimId() {
        return ticketClaimId;
    }

    public void setTicketClaimId(Long ticketClaimId) {
        this.ticketClaimId = ticketClaimId;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "TicketClaimTicketDTO{" +
                "id=" + id +
                ", ticketClaimId=" + ticketClaimId +
                ", ticketId=" + ticketId +
                ", ticketName='" + ticketName + '\'' +
                ", number=" + number +
                ", price=" + price +
                ", version=" + version +
                ", startNumber='" + startNumber + '\'' +
                ", endNumber='" + endNumber + '\'' +
                '}';
    }
}
