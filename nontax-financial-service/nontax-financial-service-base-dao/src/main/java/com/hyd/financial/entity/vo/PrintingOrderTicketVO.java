package com.hyd.financial.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import java.io.Serializable;
import java.math.BigDecimal;
@Data
@NoArgsConstructor
public class PrintingOrderTicketVO implements Serializable {
    private Long id;

    private Long printingOrderId;

    private Long ticketId;
    private BigDecimal price;
    private String ticketName;
    private Long number;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrintingOrderId() {
        return printingOrderId;
    }

    public void setPrintingOrderId(Long printingOrderId) {
        this.printingOrderId = printingOrderId;
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "PrintingOrderTicketVO{" +
                "id=" + id +
                ", printingOrderId=" + printingOrderId +
                ", ticketId=" + ticketId +
                ", price=" + price +
                ", ticketName='" + ticketName + '\'' +
                ", number=" + number +
                ", version=" + version +
                ", startNumber='" + startNumber + '\'' +
                ", endNumber='" + endNumber + '\'' +
                '}';
    }
}
