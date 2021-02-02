package com.hyd.financial.web;

import com.hyd.financial.entity.WarehouseInventory;
import com.hyd.financial.entity.vo.WarehouseInventoryVO;
import com.hyd.financial.service.IWarehouseInventoryService;
import com.hyd.financial.web.dto.WarehouseInventoryDTO;
import com.sd365.common.log.api.annotation.ApiLog;
import com.sd365.common.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/2 9:47
 */
@RestController
@RequestMapping("/warehouse/inventory")
public class WarehouseInventoryController {
    @Autowired
    private IWarehouseInventoryService warehouseInventoryService;

    /**
     * 保存仓库库存
     * @param warehouseInventoryDTO 仓库库存
     * @return 仓库库存ID
     */
    @ApiLog
    @PostMapping
    public Long save(@RequestBody WarehouseInventoryDTO warehouseInventoryDTO) {
        WarehouseInventory warehouseInventory = BeanUtil.copy(warehouseInventoryDTO, WarehouseInventory.class);
        return warehouseInventoryService.save(warehouseInventory);
    }

    /**
     * 删除
     * @param id
     * @return 是否删除成功
     */
    @ApiLog
    @DeleteMapping(value = "/{id}")
    public Boolean remove(@PathVariable("id") Long id) {
        return warehouseInventoryService.remove(id);
    }

    /**
     * 更新
     * @param warehouseInventoryDTO 仓库库存
     * @return 更新行数
     */
    @ApiLog
    @PutMapping
    public Integer update(@RequestBody WarehouseInventoryDTO warehouseInventoryDTO) {
        WarehouseInventory warehouseInventory = BeanUtil.copy(warehouseInventoryDTO, WarehouseInventory.class);
        return warehouseInventoryService.update(warehouseInventory);
    }

    /**
     * 根据输入条件（仓库ID，票据ID，状态）查询仓库库存列表
     * @param warehouseInventoryDTO 仓库库存
     * @return 满足条件的仓库库存列表
     */
    @ApiLog
    @GetMapping
    public List<WarehouseInventoryVO> listWarehouseInventory(@RequestBody WarehouseInventoryDTO warehouseInventoryDTO) {
        WarehouseInventory warehouseInventory = BeanUtil.copy(warehouseInventoryDTO, WarehouseInventory.class);
        List<WarehouseInventory> warehouseInventoryList = warehouseInventoryService.listWarehouseInventory(warehouseInventory);
        return BeanUtil.copyList(warehouseInventoryList, WarehouseInventoryVO.class);
    }
}
