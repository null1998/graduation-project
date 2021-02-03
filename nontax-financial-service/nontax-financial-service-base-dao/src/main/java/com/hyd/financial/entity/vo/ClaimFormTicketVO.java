package com.hyd.financial.entity.vo;

import java.math.BigDecimal;

/**
 * @author yanduohuang
 * @date 2021/2/3 10:09
 */
public class ClaimFormTicketVO {
    private Long id;

    private Long claimFormId;

    private Long ticketId;

    private Long number;

    private BigDecimal price;

    private String start;

    private String end;

    private Long version;

    private Long warehouseInventoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClaimFormId() {
        return claimFormId;
    }

    public void setClaimFormId(Long claimFormId) {
        this.claimFormId = claimFormId;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getWarehouseInventoryId() {
        return warehouseInventoryId;
    }

    public void setWarehouseInventoryId(Long warehouseInventoryId) {
        this.warehouseInventoryId = warehouseInventoryId;
    }

    @Override
    public String toString() {
        return "ClaimFormTicketVO{" +
                "id=" + id +
                ", claimFormId=" + claimFormId +
                ", ticketId=" + ticketId +
                ", number=" + number +
                ", price=" + price +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", version=" + version +
                ", warehouseInventoryId=" + warehouseInventoryId +
                '}';
    }
}
