package com.hyd.financial.service.impl;

import com.hyd.basedata.entity.Ticket;
import com.hyd.basedata.service.ITicketService;
import com.hyd.common.core.exception.BusinessException;
import com.hyd.common.core.exception.code.BusinessErrorCode;
import com.hyd.common.util.BeanUtil;
import com.hyd.common.util.IdGenerator;
import com.hyd.financial.dao.PrintingOrderTicketMapper;
import com.hyd.financial.entity.PrintingOrderTicket;
import com.hyd.financial.service.IPrintingOrderTicketService;
import com.hyd.financial.web.dto.PrintingOrderTicketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yanduohuang
 * @date 2021/3/18 19:21
 */
@Service
public class PrintingOrderTicketService implements IPrintingOrderTicketService {
    @Autowired
    private PrintingOrderTicketMapper printingOrderTicketMapper;
    @Autowired
    private ITicketService ticketService;
    @Autowired
    private IdGenerator idGenerator;

    @Caching(evict = {@CacheEvict(value = {"PrintingOrderTicketService::listByPrintingOrderId"},allEntries = true)})
    @Override
    public Long save(PrintingOrderTicket printingOrderTicket) {
        if (printingOrderTicket == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("印制订单票据为空"));
        }
        long id = idGenerator.snowflakeId();
        printingOrderTicket.setId(id);
        printingOrderTicketMapper.insertSelective(printingOrderTicket);
        return id;
    }
    @Transactional(rollbackFor=Exception.class)
    @Caching(evict = {@CacheEvict(value = {"PrintingOrderTicketService::listByPrintingOrderId"},allEntries = true)})
    @Override
    public void saveList(List<PrintingOrderTicket> printingOrderTicketList) {
        if (printingOrderTicketList == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("印制订单票据为空"));
        }
        for (PrintingOrderTicket printingOrderTicket : printingOrderTicketList) {
            long id = idGenerator.snowflakeId();
            printingOrderTicket.setId(id);
            printingOrderTicket.setVersion(0L);
        }
        printingOrderTicketMapper.saveList(printingOrderTicketList);
    }
    @Caching(evict = {@CacheEvict(value = {"PrintingOrderTicketService::listByPrintingOrderId"},allEntries = true)})
    @Override
    public Boolean remove(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        return printingOrderTicketMapper.deleteByPrimaryKey(id) == 1;
    }
    @Caching(evict = {@CacheEvict(value = {"PrintingOrderTicketService::listByPrintingOrderId"},allEntries = true)})
    @Override
    public Integer update(PrintingOrderTicket printingOrderTicket) {
        if (printingOrderTicket == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("印制订单票据为空"));
        }
        return printingOrderTicketMapper.updateByPrimaryKeySelective(printingOrderTicket);
    }
    @Cacheable(value = {"PrintingOrderTicketService::listByPrintingOrderId"},key = "#printingOrderId")
    @Override
    public List<PrintingOrderTicketDTO> listByPrintingOrderId(Long printingOrderId) {
        if (printingOrderId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("印制订单ID为空"));
        }
        List<PrintingOrderTicket> printingOrderTicketList = printingOrderTicketMapper.listByPrintingOrderId(printingOrderId);
        List<PrintingOrderTicketDTO> printingOrderTicketDTOList = BeanUtil.copyList(printingOrderTicketList, PrintingOrderTicketDTO.class);
        batchSetProperties(printingOrderTicketDTOList);
        return printingOrderTicketDTOList;
    }
    private void batchSetProperties(List<PrintingOrderTicketDTO> printingOrderTicketDTOList) {
        if (printingOrderTicketDTOList != null) {
            List<Long> ticketIdList = printingOrderTicketDTOList.stream().map(PrintingOrderTicketDTO::getTicketId).collect(Collectors.toList());
            Map<Long, String> ticketMap = ticketService.listByTicketIdList(ticketIdList).stream().collect(Collectors.toMap(Ticket::getId, Ticket::getName));
            Map<Long, BigDecimal> ticketPriceMap = ticketService.listByTicketIdList(ticketIdList).stream().collect(Collectors.toMap(Ticket::getId, Ticket::getPrice));
            printingOrderTicketDTOList.forEach(e->{
                e.setTicketName(ticketMap.get(e.getTicketId()));
                e.setPrice(ticketPriceMap.get(e.getTicketId()));
            });
        }
    }
}
