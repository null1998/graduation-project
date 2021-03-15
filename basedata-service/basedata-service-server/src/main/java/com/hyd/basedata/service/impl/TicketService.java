package com.hyd.basedata.service.impl;


import com.hyd.basedata.dao.TicketMapper;
import com.hyd.basedata.entity.Ticket;
import com.hyd.basedata.service.ITicketService;
import com.hyd.basedata.util.MnemonicUtil;
import com.hyd.common.core.exception.BusinessException;
import com.hyd.common.core.exception.code.BusinessErrorCode;
import com.hyd.common.util.IdGenerator;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author yanduohuang
 * @date 2021/2/1 15:52
 */
@Service
public class TicketService implements ITicketService {
    @Autowired
    private TicketMapper ticketMapper;
    @Autowired
    private IdGenerator idGenerator;
    @Caching(evict = {@CacheEvict(value = {"TicketService::listAll","TicketService::listByZoneId"},allEntries = true)})
    @Override
    public Long save(Ticket ticket) {
        if (ticket == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("票据为空"));
        }
        long id = idGenerator.snowflakeId();
        ticket.setId(id);
        ticket.setMnemonic(MnemonicUtil.buildMnemonic(ticket.getName()));
        ticketMapper.insertSelective(ticket);
        return id;
    }
    @Caching(evict = {@CacheEvict(value = {"TicketService::getTicketById"},key="#id"),
            @CacheEvict(value = {"TicketService::listAll","TicketService::listByZoneId"},allEntries = true)})
    @Override
    public Boolean remove(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        return ticketMapper.deleteByPrimaryKey(id) == 1;
    }
    @Caching(evict = {@CacheEvict(value = {"TicketService::getTicketById"},key="#ticket.id"),
            @CacheEvict(value = {"TicketService::listAll","TicketService::listByZoneId"},allEntries = true)})
    @Override
    public Integer update(Ticket ticket) {
        if (ticket == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("票据为空"));
        }
        return ticketMapper.updateByPrimaryKeySelective(ticket);
    }
    @Cacheable(value = {"TicketService::getTicketById"},key="#id")
    @Override
    public Ticket getTicketById(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        Optional<Ticket> optional = ticketMapper.selectByPrimaryKey(id);
        if (!optional.isPresent()) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_OTHER_EXCEPTION, new Exception("未查询到相应的票据记录"));
        }
        return optional.get();
    }
    @Cacheable(value = {"TicketService::listByZoneId"},key="#zoneId")
    @Override
    public List<Ticket> listByZoneId(Long zoneId) {
        if (zoneId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("地区ID为空"));
        }
        return ticketMapper.listByZoneId(zoneId);
    }

    @Cacheable(value = {"TicketService::listAll"})
    @Override
    public List<Ticket> listAll() {
        return ticketMapper.select(QueryExpressionDSL::where);
    }
}
