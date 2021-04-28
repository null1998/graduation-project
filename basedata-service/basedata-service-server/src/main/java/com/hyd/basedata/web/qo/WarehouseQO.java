package com.hyd.basedata.web.qo;

import com.hyd.common.core.pojo.qo.BaseQO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yanduohuang
 * @date 2021/3/24 13:40
 */
@Data
@NoArgsConstructor
public class WarehouseQO extends BaseQO {
    private Long id;
    private Long unitId;

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

    @Override
    public String toString() {
        return "WarehouseQO{" +
                "id=" + id +
                ", unitId=" + unitId +
                "} " + super.toString();
    }
}
