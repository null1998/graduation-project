package com.hyd.financial.service.impl;

import com.hyd.common.core.exception.BusinessException;
import com.hyd.common.core.exception.code.BusinessErrorCode;
import com.hyd.common.util.IdGenerator;
import com.hyd.financial.dao.WarehouseInventoryMapper;
import com.hyd.financial.entity.WarehouseInventory;
import com.hyd.financial.service.IWarehouseInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/2 9:28
 */
@Service
public class WarehouseInventoryService implements IWarehouseInventoryService {
    @Autowired
    private WarehouseInventoryMapper warehouseInventoryMapper;
    @Autowired
    private IdGenerator idGenerator;
    @CacheEvict(value = {"WarehouseInventoryService::listWarehouseInventory"},allEntries = true)
    @Override
    public Long save(WarehouseInventory warehouseInventory) {
        if (warehouseInventory == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("仓库库存为空"));
        }
        long id = idGenerator.snowflakeId();
        warehouseInventory.setId(id);
        warehouseInventoryMapper.insertSelective(warehouseInventory);
        return id;
    }
    @CacheEvict(value = {"WarehouseInventoryService::listWarehouseInventory"},allEntries = true)
    @Override
    public Boolean remove(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        return warehouseInventoryMapper.deleteByPrimaryKey(id) == 1;
    }
    @CacheEvict(value = {"WarehouseInventoryService::listWarehouseInventory"},allEntries = true)
    @Override
    public Integer update(WarehouseInventory warehouseInventory) {
        if (warehouseInventory == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("仓库库存为空"));
        }
        return warehouseInventoryMapper.updateByPrimaryKeySelective(warehouseInventory);
    }
    @Cacheable(value = {"WarehouseInventoryService::listWarehouseInventory"},key = "#warehouseInventory.toString()")
    @Override
    public List<WarehouseInventory> listWarehouseInventory(WarehouseInventory warehouseInventory) {
        if (warehouseInventory == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("查询仓库库存条件为空"));
        }
        return warehouseInventoryMapper.listWarehouseInventory(warehouseInventory.getWarehouseId(), warehouseInventory.getTicketId(), warehouseInventory.getStatus());
    }
}
