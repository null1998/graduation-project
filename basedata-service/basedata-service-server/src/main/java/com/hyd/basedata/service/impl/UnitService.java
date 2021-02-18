package com.hyd.basedata.service.impl;

import com.hyd.basedata.dao.UnitMapper;
import com.hyd.basedata.entity.Unit;
import com.hyd.basedata.service.IUnitService;
import com.hyd.common.core.exception.BusinessException;
import com.hyd.common.core.exception.code.BusinessErrorCode;
import com.hyd.common.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author yanduohuang
 * @date 2021/1/29 16:28
 */
@Service
public class UnitService implements IUnitService {
    @Autowired
    private UnitMapper unitMapper;
    @Autowired
    private IdGenerator idGenerator;
    @Caching(evict = {@CacheEvict(value = {"UnitService::getUnitById"}, allEntries = true),
            @CacheEvict(value = {"UnitService::listUnitByParentId"}, allEntries = true)})
    @Override
    public Long save(Unit unit) {
        if (unit == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("单位为空"));
        }
        long uid = idGenerator.snowflakeId();
        unit.setId(uid);
        unitMapper.insertSelective(unit);
        return uid;
    }
    @Cacheable(value = {"UnitService::getUnitById"},key="#id")
    @Override
    public Unit getUnitById(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        Optional<Unit> optional = unitMapper.selectByPrimaryKey(id);
        if (!optional.isPresent()) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_OTHER_EXCEPTION, new Exception("未查询到相应的单位记录"));
        }
        return optional.get();
    }
    @Cacheable(value = {"UnitService::listUnitByParentId"},key="#parentId")
    @Override
    public List<Unit> listUnitByParentId(Long parentId) {
        if (parentId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("父单位ID为空"));
        }
        return unitMapper.listUnitByParentId(parentId);
    }
    @Caching(evict = {@CacheEvict(value = {"UnitService::getUnitById"}, key="#id"),
            @CacheEvict(value = {"UnitService::listUnitByParentId"}, allEntries = true)})
    @Override
    public Boolean remove(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        return unitMapper.deleteByPrimaryKey(id) == 1;
    }
    @Caching(evict = {@CacheEvict(value = {"UnitService::getUnitById"}, key="#unit.id"),
            @CacheEvict(value = {"UnitService::listUnitByParentId"}, allEntries = true)})
    @Override
    public Integer update(Unit unit) {
        if (unit == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("单位为空"));
        }
        return unitMapper.updateByPrimaryKeySelective(unit);
    }

}
