package com.hyd.financial.web.dto;

import javax.annotation.Generated;
import java.io.Serializable;

public class PrintingPlanTicketDTO implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long printingPlanId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long ticketId;

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
        PrintingPlanTicketDTO other = (PrintingPlanTicketDTO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPrintingPlanId() == null ? other.getPrintingPlanId() == null : this.getPrintingPlanId().equals(other.getPrintingPlanId()))
            && (this.getTicketId() == null ? other.getTicketId() == null : this.getTicketId().equals(other.getTicketId()))
            && (this.getTheFirstSeason() == null ? other.getTheFirstSeason() == null : this.getTheFirstSeason().equals(other.getTheFirstSeason()))
            && (this.getTheSecondSeason() == null ? other.getTheSecondSeason() == null : this.getTheSecondSeason().equals(other.getTheSecondSeason()))
            && (this.getTheThirdSeason() == null ? other.getTheThirdSeason() == null : this.getTheThirdSeason().equals(other.getTheThirdSeason()))
            && (this.getTheFourthSeason() == null ? other.getTheFourthSeason() == null : this.getTheFourthSeason().equals(other.getTheFourthSeason()))
            && (this.getLastYear() == null ? other.getLastYear() == null : this.getLastYear().equals(other.getLastYear()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()));
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPrintingPlanId() == null) ? 0 : getPrintingPlanId().hashCode());
        result = prime * result + ((getTicketId() == null) ? 0 : getTicketId().hashCode());
        result = prime * result + ((getTheFirstSeason() == null) ? 0 : getTheFirstSeason().hashCode());
        result = prime * result + ((getTheSecondSeason() == null) ? 0 : getTheSecondSeason().hashCode());
        result = prime * result + ((getTheThirdSeason() == null) ? 0 : getTheThirdSeason().hashCode());
        result = prime * result + ((getTheFourthSeason() == null) ? 0 : getTheFourthSeason().hashCode());
        result = prime * result + ((getLastYear() == null) ? 0 : getLastYear().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        return result;
    }

    public PrintingPlanTicketDTO(Long ticketId, Long theFirstSeason, Long theSecondSeason, Long theThirdSeason, Long theFourthSeason) {
        this.ticketId = ticketId;
        this.theFirstSeason = theFirstSeason;
        this.theSecondSeason = theSecondSeason;
        this.theThirdSeason = theThirdSeason;
        this.theFourthSeason = theFourthSeason;
    }
}
