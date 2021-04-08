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
import com.hyd.financial.service.IPrintingOrderService;
import com.hyd.financial.service.IPrintingOrderTicketService;
import com.hyd.financial.web.dto.PrintingOrderDTO;
import com.hyd.financial.web.dto.PrintingOrderTicketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    public List<PrintingOrderDTO> commonQuery(PrintingOrder printingOrder) {
        if (printingOrder == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("印制订单为空"));
        }
        List<PrintingOrder> printingOrderList = printingOrderMapper.commonQuery(printingOrder);
        List<PrintingOrderDTO> printingOrderDTOList = BeanUtil.copyList(printingOrderList, PrintingOrderDTO.class);
        for (PrintingOrderDTO printingOrderDTO : printingOrderDTOList) {
            if (printingOrderDTO.getWarehouseId()!=null) {
                Warehouse warehouse = warehouseService.getWarehouseById(printingOrderDTO.getWarehouseId());
                printingOrderDTO.setWarehouseName(warehouse.getName());
            }
            if (printingOrderDTO.getPrintUnitId()!=null) {
                Unit printUnit = unitService.getUnitById(printingOrderDTO.getPrintUnitId());
                printingOrderDTO.setPrintUnitName(printUnit.getName());
            }
            if (printingOrderDTO.getUnitId() != null) {
                Unit unit = unitService.getUnitById(printingOrderDTO.getUnitId());
                printingOrderDTO.setUnitName(unit.getName());
            }
        }
        return printingOrderDTOList;
    }
}
