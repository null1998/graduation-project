package com.hyd.basedata.service.impl;

import com.hyd.basedata.dao.UnitBaseMapper;
import com.hyd.basedata.dao.WarehouseBaseMapper;
import com.hyd.basedata.dao.WarehouseDynamicSqlSupport;
import com.hyd.basedata.dao.WarehouseMapper;
import com.hyd.basedata.entity.Unit;
import com.hyd.basedata.entity.Warehouse;
import com.hyd.basedata.entity.vo.WarehouseVO;
import com.hyd.basedata.service.IUnitService;
import com.hyd.basedata.service.IWarehouseService;
import com.hyd.basedata.util.MnemonicUtil;
import com.hyd.common.core.exception.BusinessException;
import com.hyd.common.core.exception.code.BusinessErrorCode;
import com.hyd.common.util.BeanUtil;
import com.hyd.common.util.IdGenerator;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yanduohuang
 * @date 2021/2/1 16:50
 */
@Service
public class WarehouseService implements IWarehouseService {
    @Autowired
    private WarehouseMapper warehouseMapper;
    @Autowired
    private UnitBaseMapper unitBaseMapper;
    @Autowired
    private IdGenerator idGenerator;
    @Autowired
    private IUnitService unitService;
    @Caching(evict = {@CacheEvict(value = {"WarehouseService::listByUnitId","WarehouseService::commonQuery"},allEntries = true)})
    @Override
    public Long save(Warehouse warehouse) {
        if (warehouse == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("仓库为空"));
        }
        long id = idGenerator.snowflakeId();
        warehouse.setId(id);
        warehouse.setMnemonic(MnemonicUtil.buildMnemonic(warehouse.getName()));
        warehouseMapper.insertSelective(warehouse);
        return id;
    }
    @Caching(evict = {@CacheEvict(value = {"WarehouseService::listByUnitId","WarehouseService::commonQuery"},allEntries = true),
            @CacheEvict(value = {"WarehouseService::getWarehouseById"},key = "#id")})
    @Override
    public Boolean remove(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        return warehouseMapper.deleteByPrimaryKey(id) == 1;
    }
    @Caching(evict = {@CacheEvict(value = {"WarehouseService::listByUnitId","WarehouseService::commonQuery"},allEntries = true),
            @CacheEvict(value = {"WarehouseService::getWarehouseById",},key = "#warehouse.id")})
    @Override
    public Integer update(Warehouse warehouse) {
        if (warehouse == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("仓库为空"));
        }
        return warehouseMapper.updateByPrimaryKeySelective(warehouse);
    }
    @Cacheable(value = {"WarehouseService::getWarehouseById"},key = "#id")
    @Override
    public Warehouse getWarehouseById(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        Optional<Warehouse> optional = warehouseMapper.selectByPrimaryKey(id);
        if (!optional.isPresent()) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_OTHER_EXCEPTION, new Exception("未查询到相应的仓库记录"));
        }
        return optional.get();
    }
    @Cacheable(value = {"WarehouseService::commonQuery"},key = "#warehouse.toString()")
    @Override
    public List<WarehouseVO> commonQuery(Warehouse warehouse) {
        if (warehouse == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("仓库为空"));
        }
        List<Warehouse> warehouseList = warehouseMapper.commonQuery(warehouse);
        List<Long> unitIdList = warehouseList.stream().map(Warehouse::getUnitId).collect(Collectors.toList());
        Map<Long,String> unitNameMap = unitService.listByUnitIdList(unitIdList).stream().collect(Collectors.toMap(Unit::getId, Unit::getName));
        List<WarehouseVO> warehouseVOList = BeanUtil.copyList(warehouseList, WarehouseVO.class);
        warehouseVOList.forEach(e->e.setUnitName(unitNameMap.get(e.getUnitId())));
        return warehouseVOList;
    }
    @Cacheable(value = {"WarehouseService::listByUnitId"},key = "#unitId")
    @Override
    public List<Warehouse> listByUnitId(Long unitId) {
        if (unitId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("单位ID为空"));
        }
        return warehouseMapper.select(c -> c.where(WarehouseDynamicSqlSupport.unitId, SqlBuilder.isEqualToWhenPresent(unitId)));
    }

    @Override
    public List<Warehouse> listByWarehouseIdList(List<Long> warehouseIdList) {
        if (warehouseIdList == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("参数为空"));
        }
        return warehouseMapper.listByWarehouseIdList(warehouseIdList);
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
            warehouseMapper.insertSelective(warehouse);
        }
    }
}
