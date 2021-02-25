package com.hyd.financial.entity.vo;

import javax.annotation.Generated;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PrintingPlanLimitDateVO implements Serializable {
    private Long id;

    private Integer year;

    private LocalDate startDate;

    private LocalDate endDate;

    private Long version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "PrintingPlanLimitDateVO{" +
                "id=" + id +
                ", year=" + year +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", version=" + version +
                '}';
    }
}
