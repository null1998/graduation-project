package com.hyd.financial.web.qo;

import com.hyd.common.core.pojo.qo.BaseQO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import java.io.Serializable;
import java.math.BigDecimal;
@Data
@NoArgsConstructor
public class TicketClaimQO extends BaseQO implements Serializable {
    private Long id;

    private Long orderNumber;

    private Long userId;

    private Long unitId;

    private Long warehouseId;

    private Long targetUnitId;

    private String date;

    private BigDecimal totalPrice;

    private String opinion;

    private Integer status;

    private Long version;
    private String targetUnitName;
    private String unitName;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
        return "TicketClaimQO{" +
                "id=" + id +
                ", orderNumber=" + orderNumber +
                ", userId=" + userId +
                ", unitId=" + unitId +
                ", warehouseId=" + warehouseId +
                ", targetUnitId=" + targetUnitId +
                ", date='" + date + '\'' +
                ", totalPrice=" + totalPrice +
                ", opinion='" + opinion + '\'' +
                ", status=" + status +
                ", version=" + version +
                ", targetUnitName='" + targetUnitName + '\'' +
                ", unitName='" + unitName + '\'' +
                '}';
    }
}
