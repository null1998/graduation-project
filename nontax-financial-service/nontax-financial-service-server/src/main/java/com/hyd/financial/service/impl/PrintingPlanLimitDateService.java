package com.hyd.financial.service.impl;

import com.hyd.basedata.entity.Unit;
import com.hyd.basedata.service.IUnitService;
import com.hyd.common.core.exception.BusinessException;
import com.hyd.common.core.exception.code.BusinessErrorCode;
import com.hyd.common.util.IdGenerator;
import com.hyd.financial.dao.PrintingPlanLimitDateMapper;
import com.hyd.financial.entity.PrintingPlanLimitDate;
import com.hyd.financial.service.IPrintingPlanLimitDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    private IUnitService unitService;
    @Autowired
    private IPrintingPlanLimitDateService printingPlanLimitDateService;

    @Caching(evict = {@CacheEvict(value = {"PrintingPlanLimitDateService::listByUnitId"},key = "#printingPlanLimitDate.unitId"),
            @CacheEvict(value = {"PrintingPlanLimitDateService::listByChildUnitId"},allEntries = true)})
    @Override
    public Long save(PrintingPlanLimitDate printingPlanLimitDate) {
        if (printingPlanLimitDate == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("印制计划时间限制为空"));
        }
        PrintingPlanLimitDate find = printingPlanLimitDateMapper.getByUnitIdAndYear(printingPlanLimitDate.getUnitId(), printingPlanLimitDate.getYear());
        if (find == null) {
            long id = idGenerator.snowflakeId();
            printingPlanLimitDate.setId(id);
            printingPlanLimitDateMapper.insertSelective(printingPlanLimitDate);
            return id;
        }
        return null;
    }
    @Caching(evict = {@CacheEvict(value = {"PrintingPlanLimitDateService::listByUnitId","PrintingPlanLimitDateService::listByChildUnitId"},allEntries = true)})
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
    @Cacheable(value = {"PrintingPlanLimitDateService::listByChildUnitId"},key = "#childUnitId")
    @Override
    public PrintingPlanLimitDate listByChildUnitId(Long childUnitId) {
        if (childUnitId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("下级单位ID为空"));
        }
        // 该下级单位对应的省级单位
        Unit unit = unitService.getProvinceUnitByChildId(childUnitId);
        // 查询出历年的印制计划时间限制
        List<PrintingPlanLimitDate> printingPlanLimitDateList = printingPlanLimitDateService.listByUnitId(unit.getId());
        if (printingPlanLimitDateList != null && !printingPlanLimitDateList.isEmpty()) {
            // 将列表按年度逆向排序
            List<PrintingPlanLimitDate> sortList = printingPlanLimitDateList.stream().sorted(Comparator.comparing(PrintingPlanLimitDate::getYear).reversed()).collect(Collectors.toList());
            // 最新的印制计划时间限制
            return sortList.get(0);
        }
        return null;
    }
    @Override
    public Boolean inRangeOfLimitDate(Long unitId) {
        if (unitId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("单位ID为空"));
        }
        // 最新的印制计划时间限制
        PrintingPlanLimitDate lastPrintingPlanLimitDate = printingPlanLimitDateService.listByChildUnitId(unitId);
        if (lastPrintingPlanLimitDate != null) {
            LocalDate startDate = lastPrintingPlanLimitDate.getStartDate();
            LocalDate endDate = lastPrintingPlanLimitDate.getEndDate();
            // 检查是否在时间范围内
            if (startDate != null &&  endDate != null) {
                LocalDate now = LocalDate.now();
                return now.isEqual(startDate) || now.isEqual(endDate) || now.isAfter(startDate) && now.isBefore(endDate);
            }
        }
        return false;
    }
}
