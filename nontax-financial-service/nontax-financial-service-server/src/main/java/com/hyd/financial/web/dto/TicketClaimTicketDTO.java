package com.hyd.financial.web.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.annotation.Generated;

public class TicketClaimTicketDTO implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long ticketClaimId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long ticketId;
    private String ticketName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long number;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private BigDecimal price;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long version;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private static final long serialVersionUID = 1L;

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getTicketClaimId() {
        return ticketClaimId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTicketClaimId(Long ticketClaimId) {
        this.ticketClaimId = ticketClaimId;
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
    public BigDecimal getPrice() {
        return price;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPrice(BigDecimal price) {
        this.price = price;
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
    public String toString() {
        return "TicketClaimTicketDTO{" +
                "id=" + id +
                ", ticketClaimId=" + ticketClaimId +
                ", ticketId=" + ticketId +
                ", ticketName='" + ticketName + '\'' +
                ", number=" + number +
                ", price=" + price +
                ", version=" + version +
                '}';
    }
}
