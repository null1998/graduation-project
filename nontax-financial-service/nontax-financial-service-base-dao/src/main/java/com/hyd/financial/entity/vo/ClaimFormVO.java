package com.hyd.financial.entity.vo;

import java.time.LocalDateTime;

/**
 * @author yanduohuang
 * @date 2021/2/2 11:09
 */
public class ClaimFormVO {
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

    @Override
    public String toString() {
        return "ClaimFormVO{" +
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
