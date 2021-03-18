package com.hyd.financial.service.impl;

import com.hyd.common.core.exception.BusinessException;
import com.hyd.common.core.exception.code.BusinessErrorCode;
import com.hyd.common.util.IdGenerator;
import com.hyd.financial.dao.PrintingOrderMapper;
import com.hyd.financial.entity.PrintingOrder;
import com.hyd.financial.service.IPrintingOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Caching(evict = {@CacheEvict(value = "PrintingOrderService::commonQuery",allEntries = true)})
    @Override
    public Long save(PrintingOrder printingOrder) {
        if (printingOrder == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("印制订单为空"));
        }
        long id = idGenerator.snowflakeId();
        long orderNumber = idGenerator.snowflakeId();
        printingOrder.setId(id);
        printingOrder.setOrdernumber(orderNumber);
        printingOrderMapper.insertSelective(printingOrder);
        return id;
    }
    @Caching(evict = {@CacheEvict(value = "PrintingOrderService::commonQuery",allEntries = true)})
    @Override
    public Boolean remove(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        return printingOrderMapper.deleteByPrimaryKey(id) == 1;
    }
    @Caching(evict = {@CacheEvict(value = "PrintingOrderService::commonQuery",allEntries = true)})
    @Override
    public Integer update(PrintingOrder printingOrder) {
        if (printingOrder == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("印制订单为空"));
        }
        return printingOrderMapper.updateByPrimaryKeySelective(printingOrder);
    }
    @Cacheable(value = {"PrintingOrderService::commonQuery"},key = "#printingOrder.toString()")
    @Override
    public List<PrintingOrder> commonQuery(PrintingOrder printingOrder) {
        if (printingOrder == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("印制订单为空"));
        }
        return printingOrderMapper.commonQuery(printingOrder);
    }
}
