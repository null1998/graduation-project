package com.hyd.financial.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import java.io.Serializable;
@Data
@NoArgsConstructor
public class PrintingOrderTicket implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long printingOrderId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long ticketId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long number;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long version;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String startNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String endNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private static final long serialVersionUID = 1L;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getPrintingOrderId() {
        return printingOrderId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPrintingOrderId(Long printingOrderId) {
        this.printingOrderId = printingOrderId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getTicketId() {
        return ticketId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getNumber() {
        return number;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setNumber(Long number) {
        this.number = number;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getVersion() {
        return version;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setVersion(Long version) {
        this.version = version;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getStartNumber() {
        return startNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setStartNumber(String startNumber) {
        this.startNumber = startNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getEndNumber() {
        return endNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setEndNumber(String endNumber) {
        this.endNumber = endNumber;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
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
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
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
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
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
