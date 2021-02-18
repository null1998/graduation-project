package com.hyd.financial.service.impl;

import com.hyd.common.core.exception.BusinessException;
import com.hyd.common.core.exception.code.BusinessErrorCode;
import com.hyd.common.util.IdGenerator;
import com.hyd.financial.dao.SettlementMapper;
import com.hyd.financial.entity.Settlement;
import com.hyd.financial.service.ISettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/3 11:25
 */
@Service
public class SettlementService implements ISettlementService {
    @Autowired
    private SettlementMapper settlementMapper;
    @Autowired
    private IdGenerator idGenerator;
    @Caching(evict = {@CacheEvict(value = "SettlementService::listBySettlementUnitId",allEntries = true),
            @CacheEvict(value = "SettlementService::listByUnitId",allEntries = true)})
    @Override
    public Long save(Settlement settlement) {
        if (settlement == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("结算单为空"));
        }
        long id = idGenerator.snowflakeId();
        settlement.setId(id);
        settlementMapper.insertSelective(settlement);
        return id;
    }
    @Caching(evict = {@CacheEvict(value = "SettlementService::listBySettlementUnitId",allEntries = true),
            @CacheEvict(value = "SettlementService::listByUnitId",allEntries = true)})
    @Override
    public Boolean remove(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        return settlementMapper.deleteByPrimaryKey(id) == 1;
    }
    @Caching(evict = {@CacheEvict(value = "SettlementService::listBySettlementUnitId",allEntries = true),
            @CacheEvict(value = "SettlementService::listByUnitId",allEntries = true)})
    @Override
    public Integer update(Settlement settlement) {
        if (settlement == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("结算单为空"));
        }
        return settlementMapper.updateByPrimaryKeySelective(settlement);
    }
    @Cacheable(value = "SettlementService::listBySettlementUnitId",key="#settlementUnitId")
    @Override
    public List<Settlement> listBySettlementUnitId(Long settlementUnitId) {
        if (settlementUnitId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("结算单位ID为空"));
        }
        return settlementMapper.listBySettlementUnitId(settlementUnitId);
    }
    @Cacheable(value = "SettlementService::listByUnitId",key="#unitId")
    @Override
    public List<Settlement> listByUnitId(Long unitId) {
        if (unitId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("处理单位ID为空"));
        }
        return settlementMapper.listByUnitId(unitId);
    }
}
