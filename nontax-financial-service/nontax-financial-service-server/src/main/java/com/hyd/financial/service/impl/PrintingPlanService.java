package com.hyd.financial.service.impl;

import com.hyd.common.core.exception.BusinessException;
import com.hyd.common.core.exception.code.BusinessErrorCode;
import com.hyd.common.util.IdGenerator;
import com.hyd.financial.dao.PrintingPlanMapper;
import com.hyd.financial.entity.PrintingPlan;
import com.hyd.financial.entity.PrintingPlanLimitDate;
import com.hyd.financial.service.IPrintingPlanLimitDateService;
import com.hyd.financial.service.IPrintingPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yanduohuang
 * @date 2021/2/24 16:25
 */
@Service
public class PrintingPlanService implements IPrintingPlanService {
    @Autowired
    private IdGenerator idGenerator;
    @Autowired
    private PrintingPlanMapper printingPlanMapper;
    @Autowired
    private IPrintingPlanLimitDateService printingPlanLimitDateService;
    @Autowired
    private IPrintingPlanService printingPlanService;

    @Caching(evict = {@CacheEvict(value = {"PrintingPlanService::listByParentUnitIdAndStatusAndYear",
            "PrintingPlanService::listByUnitId"},allEntries = true)})
    @Override
    public Long save(PrintingPlan printingPlan) {
        if (printingPlan == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("印制计划为空"));
        }
        long id = idGenerator.snowflakeId();
        printingPlan.setId(id);
        long orderNumber = idGenerator.snowflakeId();
        printingPlan.setOrderNumber(orderNumber);
        printingPlan.setStatus(0);
        printingPlanMapper.insertSelective(printingPlan);
        return id;
    }

    @Caching(evict = {@CacheEvict(value = {"PrintingPlanService::listByParentUnitIdAndStatusAndYear",
            "PrintingPlanService::listByUnitId"},allEntries = true)})
    @Override
    public Boolean removeById(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        return printingPlanMapper.deleteByPrimaryKey(id) == 1;
    }
    @Caching(evict = {@CacheEvict(value = {"PrintingPlanService::listByParentUnitIdAndStatusAndYear",
            "PrintingPlanService::listByUnitId"},allEntries = true)})
    @Override
    public Integer update(PrintingPlan printingPlan) {
        if (printingPlan == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("印制计划为空"));
        }
        return printingPlanMapper.updateByPrimaryKeySelective(printingPlan);
    }
    @Cacheable(value = {"PrintingPlanService::listByParentUnitIdAndStatusAndYear"}, key = "#parentUnitId+'&&'+#printingPlanStatus+'&&'+#year")
    @Override
    public List<PrintingPlan> listByParentUnitIdAndStatusAndYear(Long parentUnitId, Integer printingPlanStatus, Integer year) {
        if (parentUnitId == null || printingPlanStatus == null || year == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("参数为空"));
        }
        return printingPlanMapper.listByParentUnitIdAndStatus(parentUnitId, printingPlanStatus,year);
    }
    @Cacheable(value = {"PrintingPlanService::listByUnitId"},key = "#unitId")
    @Override
    public List<PrintingPlan> listByUnitId(Long unitId) {
        if (unitId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("单位ID为空"));
        }
        return printingPlanMapper.listByUnitId(unitId);
    }

    @Override
    public Boolean getSubmitStatus(Long unitId) {
        if (unitId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("单位ID为空"));
        }
        // 查询是否在提交的时间范围内
        Boolean inRangeOfLimitDate = printingPlanLimitDateService.inRangeOfLimitDate(unitId);
        if (Boolean.TRUE.equals(inRangeOfLimitDate)) {
            // 最新的印制计划时间限制
            PrintingPlanLimitDate lastPrintingPlanLimitDate = printingPlanLimitDateService.listByChildUnitId(unitId);
            if (lastPrintingPlanLimitDate != null && lastPrintingPlanLimitDate.getYear() != null) {
                // 列出自己历年的印制计划
                List<PrintingPlan> printingPlanList = printingPlanService.listByUnitId(unitId);
                if (printingPlanList != null && !printingPlanList.isEmpty()) {
                    List<PrintingPlan> sortList = printingPlanList.stream().sorted(Comparator.comparing(PrintingPlan::getYear).reversed()).collect(Collectors.toList());
                    return sortList.get(0).getYear() >= lastPrintingPlanLimitDate.getYear() && sortList.get(0).getStatus() == 2;
                }
            }
        }
        return false;
    }
}
