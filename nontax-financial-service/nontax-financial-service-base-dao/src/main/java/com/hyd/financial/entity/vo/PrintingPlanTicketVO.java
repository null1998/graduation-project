package com.hyd.financial.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import java.io.Serializable;
@Data
@NoArgsConstructor
public class PrintingPlanTicketVO implements Serializable {
    private Long id;

    private Long printingPlanId;

    private Long ticketId;
    private String ticketName;
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

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }


    public PrintingPlanTicketVO(Long ticketId, Long theFirstSeason, Long theSecondSeason, Long theThirdSeason, Long theFourthSeason) {
        this.ticketId = ticketId;
        this.theFirstSeason = theFirstSeason;
        this.theSecondSeason = theSecondSeason;
        this.theThirdSeason = theThirdSeason;
        this.theFourthSeason = theFourthSeason;
    }

    @Override
    public String toString() {
        return "PrintingPlanTicketVO{" +
                "id=" + id +
                ", printingPlanId=" + printingPlanId +
                ", ticketId=" + ticketId +
                ", ticketName='" + ticketName + '\'' +
                ", theFirstSeason=" + theFirstSeason +
                ", theSecondSeason=" + theSecondSeason +
                ", theThirdSeason=" + theThirdSeason +
                ", theFourthSeason=" + theFourthSeason +
                ", lastYear=" + lastYear +
                ", version=" + version +
                '}';
    }
}
