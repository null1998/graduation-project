package com.hyd.financial.web.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import java.io.Serializable;
@Data
@NoArgsConstructor
public class PrintingPlanTicketDTO implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long printingPlanId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long ticketId;
    private String ticketName;
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long theFirstSeason;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long theSecondSeason;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long theThirdSeason;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long theFourthSeason;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long lastYear;

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
    public Long getPrintingPlanId() {
        return printingPlanId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPrintingPlanId(Long printingPlanId) {
        this.printingPlanId = printingPlanId;
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
    public Long getTheFirstSeason() {
        return theFirstSeason;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTheFirstSeason(Long theFirstSeason) {
        this.theFirstSeason = theFirstSeason;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getTheSecondSeason() {
        return theSecondSeason;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTheSecondSeason(Long theSecondSeason) {
        this.theSecondSeason = theSecondSeason;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getTheThirdSeason() {
        return theThirdSeason;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTheThirdSeason(Long theThirdSeason) {
        this.theThirdSeason = theThirdSeason;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getTheFourthSeason() {
        return theFourthSeason;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTheFourthSeason(Long theFourthSeason) {
        this.theFourthSeason = theFourthSeason;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getLastYear() {
        return lastYear;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setLastYear(Long lastYear) {
        this.lastYear = lastYear;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getVersion() {
        return version;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setVersion(Long version) {
        this.version = version;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }
}
