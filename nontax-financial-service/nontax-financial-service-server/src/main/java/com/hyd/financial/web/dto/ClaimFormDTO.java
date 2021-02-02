package com.hyd.financial.web.dto;

import javax.annotation.Generated;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class ClaimFormDTO implements Serializable {
    private Long id;

    private Long orderNumber;

    private LocalDateTime claimDate;

    private Long claimUnitId;

    private String claimUnitName;

    private String claimPerson;

    private Long claimWarehouseId;

    private String remark;

    private String checkOpinion;

    private LocalDateTime successDate;

    private Integer status;

    private Long version;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDateTime getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(LocalDateTime claimDate) {
        this.claimDate = claimDate;
    }

    public Long getClaimUnitId() {
        return claimUnitId;
    }

    public void setClaimUnitId(Long claimUnitId) {
        this.claimUnitId = claimUnitId;
    }

    public String getClaimUnitName() {
        return claimUnitName;
    }

    public void setClaimUnitName(String claimUnitName) {
        this.claimUnitName = claimUnitName;
    }

    public String getClaimPerson() {
        return claimPerson;
    }

    public void setClaimPerson(String claimPerson) {
        this.claimPerson = claimPerson;
    }

    public Long getClaimWarehouseId() {
        return claimWarehouseId;
    }

    public void setClaimWarehouseId(Long claimWarehouseId) {
        this.claimWarehouseId = claimWarehouseId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCheckOpinion() {
        return checkOpinion;
    }

    public void setCheckOpinion(String checkOpinion) {
        this.checkOpinion = checkOpinion;
    }

    public LocalDateTime getSuccessDate() {
        return successDate;
    }

    public void setSuccessDate(LocalDateTime successDate) {
        this.successDate = successDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClaimFormDTO that = (ClaimFormDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(orderNumber, that.orderNumber) &&
                Objects.equals(claimDate, that.claimDate) &&
                Objects.equals(claimUnitId, that.claimUnitId) &&
                Objects.equals(claimUnitName, that.claimUnitName) &&
                Objects.equals(claimPerson, that.claimPerson) &&
                Objects.equals(claimWarehouseId, that.claimWarehouseId) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(checkOpinion, that.checkOpinion) &&
                Objects.equals(successDate, that.successDate) &&
                Objects.equals(status, that.status) &&
                Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderNumber, claimDate, claimUnitId, claimUnitName, claimPerson, claimWarehouseId, remark, checkOpinion, successDate, status, version);
    }

    @Override
    public String toString() {
        return "ClaimFormDTO{" +
                "id=" + id +
                ", orderNumber=" + orderNumber +
                ", claimDate=" + claimDate +
                ", claimUnitId=" + claimUnitId +
                ", claimUnitName='" + claimUnitName + '\'' +
                ", claimPerson='" + claimPerson + '\'' +
                ", claimWarehouseId=" + claimWarehouseId +
                ", remark='" + remark + '\'' +
                ", checkOpinion='" + checkOpinion + '\'' +
                ", successDate=" + successDate +
                ", status=" + status +
                ", version=" + version +
                '}';
    }
}
