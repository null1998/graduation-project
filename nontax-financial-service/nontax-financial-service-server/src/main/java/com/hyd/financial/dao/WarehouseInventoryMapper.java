package com.hyd.financial.dao;

import com.hyd.financial.entity.WarehouseInventory;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualToWhenPresent;

/**
 * @author yanduohuang
 * @date 2021/2/2 9:34
 */
public interface WarehouseInventoryMapper extends WarehouseInventoryBaseMapper {
    /**
     * 根据输入的条件查询仓库库存,并按数量排序
     * @param warehouseId 仓库ID
     * @param ticketId 票据ID
     * @param status 仓库状态
     * @return
     */
    default List<WarehouseInventory> listWarehouseInventory(Long warehouseId, Long ticketId, Integer status) {
        return this.select(c -> c.where(WarehouseInventoryDynamicSqlSupport.warehouseId, isEqualToWhenPresent(warehouseId))
                .and(WarehouseInventoryDynamicSqlSupport.ticketId, isEqualToWhenPresent(ticketId))
                .and(WarehouseInventoryDynamicSqlSupport.status, isEqualToWhenPresent(status))
                .orderBy(WarehouseInventoryDynamicSqlSupport.number));
    }
}
