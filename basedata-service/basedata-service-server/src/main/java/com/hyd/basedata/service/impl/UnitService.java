package com.hyd.basedata.service.impl;

import com.hyd.basedata.dao.UnitMapper;
import com.hyd.basedata.entity.Unit;
import com.hyd.basedata.service.IUnitService;
import com.hyd.basedata.util.MnemonicUtil;
import com.hyd.common.core.exception.BusinessException;
import com.hyd.common.core.exception.code.BusinessErrorCode;
import com.hyd.common.util.IdGenerator;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    private IUnitService unitService;
    @Caching(evict = {@CacheEvict(value = {"UnitService::listUnitByParentId","UnitService::listAll","UnitService::getByCode","UnitService::commonQuery"}, allEntries = true)})
    @Override
    public Long save(Unit unit) {
        if (unit == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("单位为空"));
        }
        long uid = idGenerator.snowflakeId();
        unit.setId(uid);
        unit.setMnemonic(MnemonicUtil.buildMnemonic(unit.getName()));
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
    @Caching(evict = {@CacheEvict(value = {"UnitService::getUnitById","UnitService::getProvinceUnitByChildId"}, key="#id"),
            @CacheEvict(value = {"UnitService::listUnitByParentId","UnitService::listAll","UnitService::getByCode","UnitService::commonQuery"}, allEntries = true)})
    @Override
    public Boolean remove(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        return unitMapper.deleteByPrimaryKey(id) == 1;
    }
    @Caching(evict = {@CacheEvict(value = {"UnitService::getUnitById","UnitService::getProvinceUnitByChildId"}, key="#unit.id"),
            @CacheEvict(value = {"UnitService::listUnitByParentId","UnitService::listAll","UnitService::commonQuery"}, allEntries = true),
            @CacheEvict(value = {"UnitService::getByCode"},key = "#unit.code")})
    @Override
    public Integer update(Unit unit) {
        if (unit == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("单位为空"));
        }
        return unitMapper.updateByPrimaryKeySelective(unit);
    }
    @Cacheable(value = {"UnitService::listAll"})
    @Override
    public List<Unit> listAll() {
        return unitMapper.select(QueryExpressionDSL::where);
    }
    @Cacheable(value = {"UnitService::getByCode"},key = "#code")
    @Override
    public Unit getByCode(String code) {
        if (code == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("编码为空"));
        }
        return unitMapper.getByCode(code);
    }
    @Cacheable(value = {"UnitService::getProvinceUnitByChildUnitId"},key = "#id")
    @Override
    public Unit getProvinceUnitByChildId(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        // 查询下级单位
        Unit unit = unitService.getUnitById(id);
        if (unit.getCode() != null && unit.getCode().length() >= 4) {
            // 该下级单位对应的省级单位编码
            String provinceCode = unit.getCode().substring(0, 4);
            return unitService.getByCode(provinceCode);
        }
        return new Unit();
    }
    @Cacheable(value = {"UnitService::commonQuery"},key = "#unit.toString()")
    @Override
    public List<Unit> commonQuery(Unit unit) {
        if (unit == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("单位为空"));
        }
        return unitMapper.commonQuery(unit);
    }

    @Override
    public List<Unit> getSuperiorUnitList(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        Unit unit = unitService.getUnitById(id);
        ArrayList<Unit> superiorUnitList = new ArrayList<>();
        // 递归查询
        if (unit.getParentId() != null) {
            superiorUnitList.add(unitService.getUnitById(unit.getParentId()));
            superiorUnitList.addAll(getSuperiorUnitList(unit.getParentId()));
        }
        return superiorUnitList;
    }

}
