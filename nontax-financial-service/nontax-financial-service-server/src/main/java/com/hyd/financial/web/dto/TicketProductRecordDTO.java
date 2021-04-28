package com.hyd.financial.web.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import java.io.Serializable;
import java.time.LocalDate;
@Data
@NoArgsConstructor
public class TicketProductRecordDTO implements Serializable {
    private Long id;

    private Long orderNumber;

    private Long ticketId;
    private String ticketName;

    private String startNumber;

    private String endNumber;

    private Long printOrderNumber;

    private Long version;

    private Long printUnitId;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate createdDate;
    private static final long serialVersionUID = 1L;
    private Integer number;

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

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
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

    public Long getPrintUnitId() {
        return printUnitId;
    }

    public void setPrintUnitId(Long printUnitId) {
        this.printUnitId = printUnitId;
    }

    @Override
    public String toString() {
        return "TicketProductRecordDTO{" +
                "id=" + id +
                ", orderNumber=" + orderNumber +
                ", ticketId=" + ticketId +
                ", ticketName='" + ticketName + '\'' +
                ", startNumber='" + startNumber + '\'' +
                ", endNumber='" + endNumber + '\'' +
                ", printOrderNumber=" + printOrderNumber +
                ", version=" + version +
                ", printUnitId=" + printUnitId +
                ", createdDate='" + createdDate + '\'' +
                ", number=" + number +
                '}';
    }
}
