package com.hyd.financial.web.qo;


/**
 * @author yanduohuang
 * @date 2021/3/18 19:07
 */
public class PrintingOrderQO {
    private Long id;
    private Long unitId;

    private Long printUnitId;
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getPrintUnitId() {
        return printUnitId;
    }

    public void setPrintUnitId(Long printUnitId) {
        this.printUnitId = printUnitId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PrintingOrderQO{" +
                "id=" + id +
                ", unitId=" + unitId +
                ", printUnitId=" + printUnitId +
                ", status=" + status +
                '}';
    }
}
