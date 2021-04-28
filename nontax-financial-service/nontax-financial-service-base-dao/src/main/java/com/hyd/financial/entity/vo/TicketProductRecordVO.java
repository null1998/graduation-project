package com.hyd.financial.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import java.io.Serializable;
import java.time.LocalDate;
@Data
@NoArgsConstructor
public class TicketProductRecordVO implements Serializable {
    private Long id;

    private Long orderNumber;

    private Long printUnitId;

    private Long ticketId;
    private String ticketName;

    private String startNumber;

    private String endNumber;
    private Integer number;
    private Long printOrderNumber;

    private Long version;

    private LocalDate createdDate;

    private static final long serialVersionUID = 1L;

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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

    public Long getPrintUnitId() {
        return printUnitId;
    }

    public void setPrintUnitId(Long printUnitId) {
        this.printUnitId = printUnitId;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

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

    public Long getPrintOrderNumber() {
        return printOrderNumber;
    }

    public void setPrintOrderNumber(Long printOrderNumber) {
        this.printOrderNumber = printOrderNumber;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "TicketProductRecordVO{" +
                "id=" + id +
                ", orderNumber=" + orderNumber +
                ", printUnitId=" + printUnitId +
                ", ticketId=" + ticketId +
                ", ticketName='" + ticketName + '\'' +
                ", startNumber='" + startNumber + '\'' +
                ", endNumber='" + endNumber + '\'' +
                ", number=" + number +
                ", printOrderNumber=" + printOrderNumber +
                ", version=" + version +
                ", createdDate='" + createdDate + '\'' +
                '}';
    }
}
