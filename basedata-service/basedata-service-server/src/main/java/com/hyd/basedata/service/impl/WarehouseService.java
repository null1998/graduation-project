package com.hyd.basedata.service.impl;

import com.hyd.basedata.dao.UnitBaseMapper;
import com.hyd.basedata.dao.WarehouseBaseMapper;
import com.hyd.basedata.entity.Unit;
import com.hyd.basedata.entity.Warehouse;
import com.hyd.basedata.service.IWarehouseService;
import com.hyd.basedata.util.MnemonicUtil;
import com.hyd.common.core.exception.BusinessException;
import com.hyd.common.core.exception.code.BusinessErrorCode;
import com.hyd.common.util.IdGenerator;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author yanduohuang
 * @date 2021/2/1 16:50
 */
@Service
public class WarehouseService implements IWarehouseService {
    @Autowired
    private WarehouseBaseMapper warehouseBaseMapper;
    @Autowired
    private UnitBaseMapper unitBaseMapper;
    @Autowired
    private IdGenerator idGenerator;
    @Override
    public Long save(Warehouse warehouse) {
        if (warehouse == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("仓库为空"));
        }
        long id = idGenerator.snowflakeId();
        warehouse.setId(id);
        warehouse.setMnemonic(MnemonicUtil.buildMnemonic(warehouse.getName()));
        warehouseBaseMapper.insertSelective(warehouse);
        return id;
    }
    @CacheEvict(value = {"WarehouseService::getWarehouseById"},key = "#id")
    @Override
    public Boolean remove(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        return warehouseBaseMapper.deleteByPrimaryKey(id) == 1;
    }
    @CacheEvict(value = {"WarehouseService::getWarehouseById"},key = "#warehouse.id")
    @Override
    public Integer update(Warehouse warehouse) {
        if (warehouse == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("仓库为空"));
        }
        return warehouseBaseMapper.updateByPrimaryKeySelective(warehouse);
    }
    @Cacheable(value = {"WarehouseService::getWarehouseById"},key = "#id")
    @Override
    public Warehouse getWarehouseById(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        Optional<Warehouse> optional = warehouseBaseMapper.selectByPrimaryKey(id);
        if (!optional.isPresent()) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_OTHER_EXCEPTION, new Exception("未查询到相应的仓库记录"));
        }
        return optional.get();
    }

    @Override
    public void init() {
        List<Unit> unitList = unitBaseMapper.select(QueryExpressionDSL::where);
        for (Unit unit : unitList) {
            Warehouse warehouse = new Warehouse();
            warehouse.setId(idGenerator.snowflakeId());
            warehouse.setName(unit.getName()+"第一仓库");
            warehouse.setCode(unit.getCode()+"01");
            warehouse.setMnemonic(MnemonicUtil.buildMnemonic(warehouse.getName()));
            warehouse.setAddress(warehouse.getName());
            warehouse.setUnitId(unit.getId());
            warehouseBaseMapper.insertSelective(warehouse);
        }
    }
}
