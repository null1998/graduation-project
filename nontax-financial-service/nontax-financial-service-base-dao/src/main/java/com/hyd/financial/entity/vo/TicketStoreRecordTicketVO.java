package com.hyd.financial.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import java.io.Serializable;
@Data
@NoArgsConstructor
public class TicketStoreRecordTicketVO implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long ticketStoreRecordId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long ticketId;
    private String ticketName;
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String startNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String endNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long number;

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
    public Long getTicketStoreRecordId() {
        return ticketStoreRecordId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTicketStoreRecordId(Long ticketStoreRecordId) {
        this.ticketStoreRecordId = ticketStoreRecordId;
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
