package com.hyd.financial.service;

import com.hyd.financial.entity.WarehouseInventory;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/2 9:17
 */
public interface IWarehouseInventoryService {
    /**
     * 保存
     * @param warehouseInventory 仓库库存
     * @return 仓库库存id
     */
    Long save(WarehouseInventory warehouseInventory);

    /**
     * 删除
     * @param id 仓库库存id
     * @return 是否删除成功
     */
    Boolean remove(Long id);

    /**
     * 更新
     * @param warehouseInventory 仓库库存
     * @return 更新行数
     */
    Integer update(WarehouseInventory warehouseInventory);

    /**
     * 根据输入条件（仓库ID，票据ID，状态）查询仓库库存列表
     * @param warehouseInventory 仓库库存
     * @return 满足条件的仓库库存列表
     */
    List<WarehouseInventory> listWarehouseInventory(WarehouseInventory warehouseInventory);
}
