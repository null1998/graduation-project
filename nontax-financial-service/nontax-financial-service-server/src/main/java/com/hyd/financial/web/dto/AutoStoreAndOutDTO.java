package com.hyd.financial.web.dto;

/**
 * 自动加/减库存，生成入/出库记录，更新申领单
 * @author yanduohuang
 * @date 2021/4/11 22:20
 */
public class AutoStoreAndOutDTO {
    /**
     * 更新申领单号段
     */
    private Long ticketClaimTicketId;
    private Long needNumber;
    /**
     * 库存id
     */
    private Long storeId;
    /**
     * 生成票据出库记录,目标单号，目标单位，出库方式,出库日期
     */
    private Long targetOrderNumber;
    private Long targetUitId;
    private String outType;
    private String outDate;
    /**
     * 生成票据入库记录,来源单号，来源单位，入库方式,入库日期
     */
    private Long sourceOrderNumber;
    private Long sourceUnitId;
    private String storeType;
    private String storeDate;

    private Long unitId;
    private Long ticketId;
    private String startNumber;
    private String endNumber;
    private Long warehouseId;
    private Long userId;
    private String operateDate;

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate;
    }

    public String getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(String startNumber) {
        this.startNumber = startNumber;
    }

    public String getEndNumber() {
        return endNumber;
    }

    public void setEndNumber(String endNumber) {
        this.endNumber = endNumber;
    }

    public Long getTicketClaimTicketId() {
        return ticketClaimTicketId;
    }

    public void setTicketClaimTicketId(Long ticketClaimTicketId) {
        this.ticketClaimTicketId = ticketClaimTicketId;
    }

    public Long getNeedNumber() {
        return needNumber;
    }

    public void setNeedNumber(Long needNumber) {
        this.needNumber = needNumber;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }


    public Long getTargetOrderNumber() {
        return targetOrderNumber;
    }

    public void setTargetOrderNumber(Long targetOrderNumber) {
        this.targetOrderNumber = targetOrderNumber;
    }

    public Long getTargetUitId() {
        return targetUitId;
    }

    public void setTargetUitId(Long targetUitId) {
        this.targetUitId = targetUitId;
    }

    public String getOutType() {
        return outType;
    }

    public void setOutType(String outType) {
        this.outType = outType;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }

    public Long getSourceOrderNumber() {
        return sourceOrderNumber;
    }

    public void setSourceOrderNumber(Long sourceOrderNumber) {
        this.sourceOrderNumber = sourceOrderNumber;
    }

    public Long getSourceUnitId() {
        return sourceUnitId;
    }

    public void setSourceUnitId(Long sourceUnitId) {
        this.sourceUnitId = sourceUnitId;
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public String getStoreDate() {
        return storeDate;
    }

    public void setStoreDate(String storeDate) {
        this.storeDate = storeDate;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public String toString() {
        return "AutoStoreAndOutDTO{" +
                "ticketClaimTicketId=" + ticketClaimTicketId +
                ", needNumber=" + needNumber +
                ", storeId=" + storeId +
                ", targetOrderNumber=" + targetOrderNumber +
                ", targetUitId=" + targetUitId +
                ", outType='" + outType + '\'' +
                ", outDate='" + outDate + '\'' +
                ", sourceOrderNumber=" + sourceOrderNumber +
                ", sourceUnitId=" + sourceUnitId +
                ", storeType='" + storeType + '\'' +
                ", storeDate='" + storeDate + '\'' +
                ", unitId=" + unitId +
                ", ticketId=" + ticketId +
                ", startNumber='" + startNumber + '\'' +
                ", endNumber='" + endNumber + '\'' +
                ", warehouseId=" + warehouseId +
                ", userId=" + userId +
                ", operateDate='" + operateDate + '\'' +
                '}';
    }
}
