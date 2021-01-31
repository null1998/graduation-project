package com.hyd.basedata.service.impl;

import com.hyd.basedata.dao.UnitBaseMapper;
import com.hyd.basedata.dao.UnitDynamicSqlSupport;
import com.hyd.basedata.entity.Unit;
import com.hyd.basedata.service.IUnitService;
import com.sd365.common.core.annotation.stuffer.IdGenerator;
import com.sd365.common.core.common.exception.BusinessException;
import com.sd365.common.core.common.exception.code.BusinessErrorCode;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author yanduohuang
 * @date 2021/1/29 16:28
 */
@Service
public class UnitService implements IUnitService {
    @Autowired
    private UnitBaseMapper unitBaseMapper;
    @Autowired
    IdGenerator idGenerator;
    @Override
    public Long save(Unit unit) {
        if (unit == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("单位为空"));
        }
        LocalDateTime now = LocalDateTime.now();
        long uid = idGenerator.snowflakeId();
        unit.setId(uid);
        unit.setCreatedTime(now);
        unit.setUpdatedTime(now);
        unitBaseMapper.insertSelective(unit);
        return uid;
    }

    @Override
    public Unit getUnitById(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        Optional<Unit> optional = unitBaseMapper.selectByPrimaryKey(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("未查询到相应的单位记录");
        }
        return optional.get();
    }

    @Override
    public List<Unit> listUnit(Long parentUnitId) {
        if (parentUnitId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("父单位ID为空"));
        }
        return unitBaseMapper.select(c -> c.where(UnitDynamicSqlSupport.parentUnit, SqlBuilder.isEqualTo(parentUnitId)));
    }

    @Override
    public Boolean remove(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        return unitBaseMapper.deleteByPrimaryKey(id) == 1;
    }

    @Override
    public Integer update(Unit unit) {
        if (unit == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("单位为空"));
        }
        unit.setUpdatedTime(LocalDateTime.now());
        return unitBaseMapper.updateByPrimaryKeySelective(unit);
    }
}
