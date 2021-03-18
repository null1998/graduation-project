package com.hyd.financial.entity;

import java.io.Serializable;
import javax.annotation.Generated;

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
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()));
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
        return result;
    }
}