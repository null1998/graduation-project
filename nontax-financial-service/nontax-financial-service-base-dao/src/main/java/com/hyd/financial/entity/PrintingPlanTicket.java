package com.hyd.financial.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import java.io.Serializable;
@Data
@NoArgsConstructor
public class PrintingPlanTicket implements Serializable {
    private Long id;

    private Long printingPlanId;

    private Long ticketId;

    private Long theFirstSeason;

    private Long theSecondSeason;

    private Long theThirdSeason;

    private Long theFourthSeason;

    private Long lastYear;

    private Long version;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrintingPlanId() {
        return printingPlanId;
    }

    public void setPrintingPlanId(Long printingPlanId) {
        this.printingPlanId = printingPlanId;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Long getTheFirstSeason() {
        return theFirstSeason;
    }

    public void setTheFirstSeason(Long theFirstSeason) {
        this.theFirstSeason = theFirstSeason;
    }

    public Long getTheSecondSeason() {
        return theSecondSeason;
    }

    public void setTheSecondSeason(Long theSecondSeason) {
        this.theSecondSeason = theSecondSeason;
    }

    public Long getTheThirdSeason() {
        return theThirdSeason;
    }

    public void setTheThirdSeason(Long theThirdSeason) {
        this.theThirdSeason = theThirdSeason;
    }

    public Long getTheFourthSeason() {
        return theFourthSeason;
    }

    public void setTheFourthSeason(Long theFourthSeason) {
        this.theFourthSeason = theFourthSeason;
    }

    public Long getLastYear() {
        return lastYear;
    }

    public void setLastYear(Long lastYear) {
        this.lastYear = lastYear;
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
        PrintingPlanTicket other = (PrintingPlanTicket) that;
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

    public PrintingPlanTicket(Long ticketId, Long theFirstSeason, Long theSecondSeason, Long theThirdSeason, Long theFourthSeason) {
        this.ticketId = ticketId;
        this.theFirstSeason = theFirstSeason;
        this.theSecondSeason = theSecondSeason;
        this.theThirdSeason = theThirdSeason;
        this.theFourthSeason = theFourthSeason;
    }
}
