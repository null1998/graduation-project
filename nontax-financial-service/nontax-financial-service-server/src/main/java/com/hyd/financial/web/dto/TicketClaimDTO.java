package com.hyd.financial.web.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@NoArgsConstructor
public class TicketClaimDTO implements Serializable {
    private Long id;

    private Long orderNumber;

    private Long userId;

    private Long unitId;

    private Long warehouseId;

    private Long targetUnitId;
    private String targetUnitName;
    private String warehouseName;
    private String unitName;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate claimDate;

    private BigDecimal totalPrice;

    private String opinion;

    private Integer status;

    private Long version;

    private static final long serialVersionUID = 1L;
    private Integer payStatus;

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getTargetUnitName() {
        return targetUnitName;
    }

    public void setTargetUnitName(String targetUnitName) {
        this.targetUnitName = targetUnitName;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Long getTargetUnitId() {
        return targetUnitId;
    }

    public void setTargetUnitId(Long targetUnitId) {
        this.targetUnitId = targetUnitId;
    }

    public LocalDate getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(LocalDate claimDate) {
        this.claimDate = claimDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
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
        return "TicketClaimDTO{" +
                "id=" + id +
                ", orderNumber=" + orderNumber +
                ", userId=" + userId +
                ", unitId=" + unitId +
                ", warehouseId=" + warehouseId +
                ", targetUnitId=" + targetUnitId +
                ", targetUnitName='" + targetUnitName + '\'' +
                ", warehouseName='" + warehouseName + '\'' +
                ", unitName='" + unitName + '\'' +
                ", claimDate=" + claimDate +
                ", totalPrice=" + totalPrice +
                ", opinion='" + opinion + '\'' +
                ", status=" + status +
                ", version=" + version +
                ", payStatus=" + payStatus +
                '}';
    }
}
