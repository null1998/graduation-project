package com.hyd.basedata.dao;

import com.hyd.basedata.entity.Unit;
import com.hyd.basedata.entity.Warehouse;
import org.mybatis.dynamic.sql.SqlBuilder;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/3/24 13:41
 */
public interface WarehouseMapper extends WarehouseBaseMapper {
    /**
     * 通用查询，支持字段id，unitId
     * @param warehouse 仓库
     * @return 仓库列表
     */
    default List<Warehouse> commonQuery(Warehouse warehouse) {
        return this.select(c->c.where(WarehouseDynamicSqlSupport.id, SqlBuilder.isEqualToWhenPresent(warehouse.getId()))
                .and(WarehouseDynamicSqlSupport.unitId,SqlBuilder.isEqualToWhenPresent(warehouse.getUnitId())));
    }
    /**
     * 根据数组查询
     * @param warehouseIdList
     * @return
     */
    default List<Warehouse> listByWarehouseIdList(List<Long> warehouseIdList) {
        return this.select(c -> c.where(WarehouseDynamicSqlSupport.id, SqlBuilder.isIn(warehouseIdList)));
    }
}
