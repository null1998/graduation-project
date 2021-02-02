package com.hyd.financial.entity.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class WarehouseInventoryVO implements Serializable {
    private Long id;

    private Long warehouseId;

    private Long ticketId;

    private Long number;

    private BigDecimal price;

    private String start;

    private String end;

    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "WarehouseInventoryVO{" +
                "id=" + id +
                ", warehouseId=" + warehouseId +
                ", ticketId=" + ticketId +
                ", number=" + number +
                ", price=" + price +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", status=" + status +
                '}';
    }
}
