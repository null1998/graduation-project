package com.hyd.financial.service.impl;

import com.hyd.common.core.exception.BusinessException;
import com.hyd.common.core.exception.code.BusinessErrorCode;
import com.hyd.common.util.IdGenerator;
import com.hyd.financial.dao.PrintingPlanLimitDateBaseMapper;
import com.hyd.financial.dao.PrintingPlanLimitDateMapper;
import com.hyd.financial.entity.PrintingPlanLimitDate;
import com.hyd.financial.service.IPrintingPlanLimitDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/20 16:41
 */
@Service
public class PrintingPlanLimitDateService implements IPrintingPlanLimitDateService {
    @Autowired
    private IdGenerator idGenerator;
    @Autowired
    private PrintingPlanLimitDateMapper printingPlanLimitDateMapper;

    @Caching(evict = {@CacheEvict(value = {"PrintingPlanLimitDateService::listByUnitId"},key = "#printingPlanLimitDate.unitId")})
    @Override
    public Long save(PrintingPlanLimitDate printingPlanLimitDate) {
        if (printingPlanLimitDate == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("印制计划时间限制为空"));
        }
        long id = idGenerator.snowflakeId();
        printingPlanLimitDate.setId(id);
        printingPlanLimitDateMapper.insertSelective(printingPlanLimitDate);
        return id;
    }
    @Caching(evict = {@CacheEvict(value = {"PrintingPlanLimitDateService::listByUnitId"},allEntries = true)})
    @Override
    public Boolean remove(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        return printingPlanLimitDateMapper.deleteByPrimaryKey(id) == 1;
    }
    @Cacheable(value = {"PrintingPlanLimitDateService::listByUnitId"},key = "#unitId")
    @Override
    public List<PrintingPlanLimitDate> listByUnitId(Long unitId) {
        if (unitId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("单位ID为空"));
        }
        return printingPlanLimitDateMapper.listByUnitId(unitId);
    }
}
