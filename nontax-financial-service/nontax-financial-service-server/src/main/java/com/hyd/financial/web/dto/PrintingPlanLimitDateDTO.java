package com.hyd.financial.web.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
@Data
@NoArgsConstructor
public class PrintingPlanLimitDateDTO implements Serializable {
    private Long id;

    private Integer year;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate startDate;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate endDate;

    private Long unitId;

    private Long version;

    private static final long serialVersionUID = 1L;

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

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrintingPlanLimitDateDTO that = (PrintingPlanLimitDateDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(year, that.year) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(unitId, that.unitId) &&
                Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, startDate, endDate, unitId, version);
    }

    @Override
    public String toString() {
        return "PrintingPlanLimitDateDTO{" +
                "id=" + id +
                ", year=" + year +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", unitId=" + unitId +
                ", version=" + version +
                '}';
    }
}
