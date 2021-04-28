package com.hyd.financial.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import java.io.Serializable;
@Data
@NoArgsConstructor
public class PrintingOrderTicket implements Serializable {
    private Long id;

    private Long printingOrderId;

    private Long ticketId;

    private Long number;

    private Long version;

    private String startNumber;

    private String endNumber;

    private static final long serialVersionUID = 1L;

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
        PrintingOrderTicket other = (PrintingOrderTicket) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPrintingOrderId() == null ? other.getPrintingOrderId() == null : this.getPrintingOrderId().equals(other.getPrintingOrderId()))
            && (this.getTicketId() == null ? other.getTicketId() == null : this.getTicketId().equals(other.getTicketId()))
            && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getStartNumber() == null ? other.getStartNumber() == null : this.getStartNumber().equals(other.getStartNumber()))
            && (this.getEndNumber() == null ? other.getEndNumber() == null : this.getEndNumber().equals(other.getEndNumber()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPrintingOrderId() == null) ? 0 : getPrintingOrderId().hashCode());
        result = prime * result + ((getTicketId() == null) ? 0 : getTicketId().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getStartNumber() == null) ? 0 : getStartNumber().hashCode());
        result = prime * result + ((getEndNumber() == null) ? 0 : getEndNumber().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", printingOrderId=").append(printingOrderId);
        sb.append(", ticketId=").append(ticketId);
        sb.append(", number=").append(number);
        sb.append(", version=").append(version);
        sb.append(", startNumber=").append(startNumber);
        sb.append(", endNumber=").append(endNumber);
        sb.append("]");
        return sb.toString();
    }
}
