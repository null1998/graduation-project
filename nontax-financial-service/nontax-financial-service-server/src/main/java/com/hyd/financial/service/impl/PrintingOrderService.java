package com.hyd.financial.service.impl;

import com.hyd.basedata.entity.Unit;
import com.hyd.basedata.entity.Warehouse;
import com.hyd.basedata.service.IUnitService;
import com.hyd.basedata.service.IWarehouseService;
import com.hyd.common.core.exception.BusinessException;
import com.hyd.common.core.exception.code.BusinessErrorCode;
import com.hyd.common.util.BeanUtil;
import com.hyd.common.util.IdGenerator;
import com.hyd.financial.dao.PrintingOrderMapper;
import com.hyd.financial.entity.PrintingOrder;
import com.hyd.financial.entity.TicketStore;
import com.hyd.financial.entity.TicketStoreRecord;
import com.hyd.financial.entity.TicketStoreRecordTicket;
import com.hyd.financial.service.*;
import com.hyd.financial.web.dto.AutoStoreAndOutDTO;
import com.hyd.financial.web.dto.PrintingOrderDTO;
import com.hyd.financial.web.dto.PrintingOrderTicketDTO;
import com.hyd.financial.web.qo.PrintingOrderQO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author yanduohuang
 * @date 2021/3/18 18:50
 */
@Service
public class PrintingOrderService implements IPrintingOrderService {
    @Autowired
    private IdGenerator idGenerator;
    @Autowired
    private PrintingOrderMapper printingOrderMapper;
    @Autowired
    private IUnitService unitService;
    @Autowired
    private IWarehouseService warehouseService;
    @Autowired
    private IPrintingOrderTicketService printingOrderTicketService;
    @Autowired
    private ITicketStoreRecordService ticketStoreRecordService;
    @Autowired
    private ITicketStoreRecordTicketService ticketStoreRecordTicketService;
    @Autowired
    private ITicketStoreService ticketStoreService;
    @Autowired
    private IPrintingOrderService printingOrderService;
    @Caching(evict = {@CacheEvict(value = "PrintingOrderService::commonQuery",allEntries = true)})
    @Override
    public Long save(PrintingOrder printingOrder) {
        if (printingOrder == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("印制订单为空"));
        }
        long id = idGenerator.snowflakeId();
        long orderNumber = idGenerator.snowflakeId();
        printingOrder.setId(id);
        printingOrder.setOrderNumber(orderNumber);
        printingOrderMapper.insertSelective(printingOrder);
        return id;
    }
    @Transactional
    @Caching(evict = {@CacheEvict(value = "PrintingOrderService::commonQuery",allEntries = true),
            @CacheEvict(value = {"PrintingOrderService::getById"},key = "#id")})
    @Override
    public Boolean remove(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        List<PrintingOrderTicketDTO> printingOrderTicketDTOList = printingOrderTicketService.listByPrintingOrderId(id);
        for (PrintingOrderTicketDTO printingOrderTicketDTO : printingOrderTicketDTOList) {
            printingOrderTicketService.remove(printingOrderTicketDTO.getId());
        }
        return printingOrderMapper.deleteByPrimaryKey(id) == 1;
    }
    @Caching(evict = {@CacheEvict(value = "PrintingOrderService::commonQuery",allEntries = true),
    @CacheEvict(value = {"PrintingOrderService::getById"},key = "#printingOrder.id")})
    @Override
    public Integer update(PrintingOrder printingOrder) {
        if (printingOrder == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("印制订单为空"));
        }
        return printingOrderMapper.updateByPrimaryKeySelective(printingOrder);
    }
    @Cacheable(value = {"PrintingOrderService::getById"},key = "#id")
    @Override
    public PrintingOrderDTO getById(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        Optional<PrintingOrder> optional = printingOrderMapper.selectByPrimaryKey(id);
        if (optional.isPresent()) {
            PrintingOrderDTO printingOrderDTO = BeanUtil.copy(optional.get(), PrintingOrderDTO.class);
            if (printingOrderDTO.getPrintUnitId()!=null) {
                printingOrderDTO.setPrintUnitName(unitService.getUnitById(printingOrderDTO.getPrintUnitId()).getName());
            }
            if (printingOrderDTO.getWarehouseId() != null) {
                printingOrderDTO.setWarehouseName(warehouseService.getWarehouseById(printingOrderDTO.getWarehouseId()).getName());
            }
            return printingOrderDTO;
        }
        return new PrintingOrderDTO();
    }

    @Cacheable(value = {"PrintingOrderService::commonQuery"},key = "#printingOrder.toString()")
    @Override
    public List<PrintingOrderDTO> commonQuery(PrintingOrderQO printingOrder) {
        if (printingOrder == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("印制订单为空"));
        }
        List<PrintingOrder> printingOrderList = printingOrderMapper.commonQuery(printingOrder);
        List<PrintingOrderDTO> printingOrderDTOList = BeanUtil.copyList(printingOrderList, PrintingOrderDTO.class);
        batchSetProperties(printingOrderDTOList);
        return printingOrderDTOList;
    }

    @Override
    public void autoStore(List<AutoStoreAndOutDTO> autoStoreAndOutDTOList) {
        if (autoStoreAndOutDTOList == null || autoStoreAndOutDTOList.isEmpty()) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("参数为空"));
        }
        // 更新印制订单状态为已入库
        PrintingOrder printingOrder = new PrintingOrder();
        printingOrder.setId(autoStoreAndOutDTOList.get(0).getPrintingOrderId());
        printingOrder.setStatus(3);
        Integer update = printingOrderService.update(printingOrder);
        if (update != 1) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_OTHER_EXCEPTION, new Exception("更新印制订单失败"));
        }
        // 生成票据入库单
        TicketStoreRecord record = BeanUtil.copy(autoStoreAndOutDTOList.get(0), TicketStoreRecord.class);
        Long recordId = ticketStoreRecordService.save(record);
        for (AutoStoreAndOutDTO autoStoreAndOutDTO : autoStoreAndOutDTOList) {
            // 添加库存
            TicketStore ticketStore = BeanUtil.copy(autoStoreAndOutDTO, TicketStore.class);
            ticketStore.setNumber(autoStoreAndOutDTO.getNeedNumber());
            ticketStoreService.save(ticketStore);
            // 添加票据入库记录号段
            TicketStoreRecordTicket ticketStoreRecordTicket = BeanUtil.copy(autoStoreAndOutDTO, TicketStoreRecordTicket.class);
            ticketStoreRecordTicket.setTicketStoreRecordId(recordId);
            ticketStoreRecordTicket.setNumber(autoStoreAndOutDTO.getNeedNumber());
            ticketStoreRecordTicketService.save(ticketStoreRecordTicket);
        }

    }

    private void batchSetProperties(List<PrintingOrderDTO> printingOrderDTOList) {
        if (printingOrderDTOList != null) {
            List<Long> warehouseIdList = printingOrderDTOList.stream().map(PrintingOrderDTO::getWarehouseId).collect(Collectors.toList());
            List<Long> printUnitIdList = printingOrderDTOList.stream().map(PrintingOrderDTO::getPrintUnitId).collect(Collectors.toList());
            List<Long> unitIdList = printingOrderDTOList.stream().map(PrintingOrderDTO::getUnitId).collect(Collectors.toList());
            Map<Long, String> warehouseMap = warehouseService.listByWarehouseIdList(warehouseIdList).stream().collect(Collectors.toMap(Warehouse::getId, Warehouse::getName));
            Map<Long, String> printUnitMap = unitService.listByUnitIdList(printUnitIdList).stream().collect(Collectors.toMap(Unit::getId, Unit::getName));
            Map<Long, String> unitMap = unitService.listByUnitIdList(unitIdList).stream().collect(Collectors.toMap(Unit::getId, Unit::getName));
            printingOrderDTOList.forEach(e->{
                e.setWarehouseName(warehouseMap.get(e.getWarehouseId()));
                e.setPrintUnitName(printUnitMap.get(e.getPrintUnitId()));
                e.setUnitName(unitMap.get(e.getUnitId()));
            });
        }
    }

}
