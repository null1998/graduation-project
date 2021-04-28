package com.hyd.financial.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import java.io.Serializable;
@Data
@NoArgsConstructor
public class TicketOutRecordTicketVO implements Serializable {
    private Long id;

    private Long ticketOutRecordId;

    private Long ticketId;

    private String startNumber;

    private String endNumber;

    private Long number;

    private Long version;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTicketOutRecordId() {
        return ticketOutRecordId;
    }

    public void setTicketOutRecordId(Long ticketOutRecordId) {
        this.ticketOutRecordId = ticketOutRecordId;
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
        TicketOutRecordTicketVO other = (TicketOutRecordTicketVO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTicketOutRecordId() == null ? other.getTicketOutRecordId() == null : this.getTicketOutRecordId().equals(other.getTicketOutRecordId()))
            && (this.getTicketId() == null ? other.getTicketId() == null : this.getTicketId().equals(other.getTicketId()))
            && (this.getStartNumber() == null ? other.getStartNumber() == null : this.getStartNumber().equals(other.getStartNumber()))
            && (this.getEndNumber() == null ? other.getEndNumber() == null : this.getEndNumber().equals(other.getEndNumber()))
            && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTicketOutRecordId() == null) ? 0 : getTicketOutRecordId().hashCode());
        result = prime * result + ((getTicketId() == null) ? 0 : getTicketId().hashCode());
        result = prime * result + ((getStartNumber() == null) ? 0 : getStartNumber().hashCode());
        result = prime * result + ((getEndNumber() == null) ? 0 : getEndNumber().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
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
        sb.append(", ticketOutRecordId=").append(ticketOutRecordId);
        sb.append(", ticketId=").append(ticketId);
        sb.append(", startNumber=").append(startNumber);
        sb.append(", endNumber=").append(endNumber);
        sb.append(", number=").append(number);
        sb.append(", version=").append(version);
        sb.append("]");
        return sb.toString();
    }
}
