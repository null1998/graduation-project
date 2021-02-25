package com.hyd.financial.service.impl;

import com.hyd.common.core.exception.BusinessException;
import com.hyd.common.core.exception.code.BusinessErrorCode;
import com.hyd.common.util.IdGenerator;
import com.hyd.financial.dao.PrintingPlanTicketMapper;
import com.hyd.financial.entity.PrintingPlan;
import com.hyd.financial.entity.PrintingPlanTicket;
import com.hyd.financial.service.IPrintingPlanTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yanduohuang
 * @date 2021/2/25 9:23
 */
@Service
public class PrintingPlanTicketService implements IPrintingPlanTicketService {
    @Autowired
    private IdGenerator idGenerator;
    @Autowired
    private PrintingPlanTicketMapper printingPlanTicketMapper;
    @Autowired
    private IPrintingPlanTicketService printingPlanTicketService;

    @Caching(evict = {@CacheEvict(value = {"PrintingPlanTicketService::listByPrintingPlanId"},key = "#printingPlanTicket.printingPlanId")})
    @Override
    public Long save(PrintingPlanTicket printingPlanTicket) {
        if (printingPlanTicket == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("印制计划票据为空"));
        }
        long id = idGenerator.snowflakeId();
        printingPlanTicket.setId(id);
        printingPlanTicketMapper.insertSelective(printingPlanTicket);
        return id;
    }
    @Caching(evict = {@CacheEvict(value = {"PrintingPlanTicketService::listByPrintingPlanId"},allEntries = true)})
    @Override
    public Long saveByChildUnitPrintingPlanList(List<PrintingPlan> printingPlanList) {
        if (printingPlanList == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("印制计划列表为空"));
        }
        long id = idGenerator.snowflakeId();
        List<PrintingPlanTicket> printingPlanTicketList = new LinkedList<>();
        // 根据下级的印制计划单查询出每种票据的计划数量
        for (PrintingPlan printingPlan : printingPlanList) {
            printingPlanTicketList.addAll(printingPlanTicketService.listByPrintingPlanId(printingPlan.getId()));
        }
        // 根据票据分类
        Map<Long, List<PrintingPlanTicket>> map = printingPlanTicketList.stream().collect(Collectors.groupingBy(PrintingPlanTicket::getTicketId));
        // 根据票据汇总各个季度的数量
        List<PrintingPlanTicket> collect = map.entrySet().stream().map(e -> new PrintingPlanTicket(e.getKey(),
                e.getValue().stream().mapToLong(PrintingPlanTicket::getTheFirstSeason).sum(),
                e.getValue().stream().mapToLong(PrintingPlanTicket::getTheSecondSeason).sum(),
                e.getValue().stream().mapToLong(PrintingPlanTicket::getTheThirdSeason).sum(),
                e.getValue().stream().mapToLong(PrintingPlanTicket::getTheFourthSeason).sum())).collect(Collectors.toList());
        // 为印制计划票据生成id，附上票据计划id，插入数据库
        collect.forEach(e->{
            e.setId(idGenerator.snowflakeId());
            e.setPrintingPlanId(id);
            printingPlanTicketService.save(e);
        });

        return null;
    }

    @Caching(evict = {@CacheEvict(value = {"PrintingPlanTicketService::listByPrintingPlanId"},allEntries = true)})
    @Override
    public Boolean removeById(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        return printingPlanTicketMapper.deleteByPrimaryKey(id) == 1;
    }
    @Cacheable(value = {"PrintingPlanTicketService::listByPrintingPlanId"},key = "#printingPlanId")
    @Override
    public List<PrintingPlanTicket> listByPrintingPlanId(Long printingPlanId) {
        if (printingPlanId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("印制计划ID为空"));
        }
        return printingPlanTicketMapper.listByPrintingPlanId(printingPlanId);
    }
}
