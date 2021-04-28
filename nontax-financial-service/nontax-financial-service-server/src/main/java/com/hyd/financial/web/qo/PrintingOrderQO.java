package com.hyd.financial.web.qo;


import com.hyd.common.core.pojo.qo.BaseQO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yanduohuang
 * @date 2021/3/18 19:07
 */
@Data
@NoArgsConstructor
public class PrintingOrderQO  extends BaseQO {
    private Long id;
    private Long unitId;

    private Long printUnitId;
    private String printUnitName;
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

    public String getPrintUnitName() {
        return printUnitName;
    }

    public void setPrintUnitName(String printUnitName) {
        this.printUnitName = printUnitName;
    }

    @Override
    public String toString() {
        return "PrintingOrderQO{" +
                "id=" + id +
                ", unitId=" + unitId +
                ", printUnitId=" + printUnitId +
                ", printUnitName='" + printUnitName + '\'' +
                ", status=" + status +
                "} " + super.toString();
    }
}
