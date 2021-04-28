package com.hyd.financial.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import java.io.Serializable;
@Data
@NoArgsConstructor
public class TicketStoreRecordTicketVO implements Serializable {
    private Long id;

    private Long ticketStoreRecordId;

    private Long ticketId;
    private String ticketName;
    private String startNumber;

    private String endNumber;

    private Long number;

    private Long version;

    private static final long serialVersionUID = 1L;

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

    public Long getTicketStoreRecordId() {
        return ticketStoreRecordId;
    }

    public void setTicketStoreRecordId(Long ticketStoreRecordId) {
        this.ticketStoreRecordId = ticketStoreRecordId;
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
        return "TicketStoreRecordTicketVO{" +
                "id=" + id +
                ", ticketStoreRecordId=" + ticketStoreRecordId +
                ", ticketId=" + ticketId +
                ", ticketName='" + ticketName + '\'' +
                ", startNumber='" + startNumber + '\'' +
                ", endNumber='" + endNumber + '\'' +
                ", number=" + number +
                ", version=" + version +
                '}';
    }
}
