package com.hyd.basedata.service.impl;

import com.hyd.basedata.dao.TicketBaseMapper;
import com.hyd.basedata.entity.Ticket;
import com.hyd.basedata.service.ITicketService;
import com.hyd.basedata.util.MnemonicUtil;
import com.sd365.common.core.annotation.stuffer.IdGenerator;
import com.sd365.common.core.common.exception.BusinessException;
import com.sd365.common.core.common.exception.code.BusinessErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author yanduohuang
 * @date 2021/2/1 15:52
 */
@Service
public class TicketService implements ITicketService {
    @Autowired
    private TicketBaseMapper ticketBaseMapper;
    @Autowired
    private IdGenerator idGenerator;
    @CacheEvict(value = {"TicketService::getTicketById"},allEntries = true)
    @Override
    public Long save(Ticket ticket) {
        if (ticket == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("票据为空"));
        }
        long id = idGenerator.snowflakeId();
        ticket.setId(id);
        ticket.setMnemonic(MnemonicUtil.buildMnemonic(ticket.getName()));
        ticketBaseMapper.insertSelective(ticket);
        return id;
    }
    @CacheEvict(value = {"TicketService::getTicketById"},key="#ticket.id")
    @Override
    public Boolean remove(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        return ticketBaseMapper.deleteByPrimaryKey(id) == 1;
    }
    @CacheEvict(value = {"TicketService::getTicketById"},key="#ticket.id")
    @Override
    public Integer update(Ticket ticket) {
        if (ticket == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("票据为空"));
        }
        return ticketBaseMapper.updateByPrimaryKeySelective(ticket);
    }
    @Cacheable(value = {"TicketService::getTicketById"},key="#id")
    @Override
    public Ticket getTicketById(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        Optional<Ticket> optional = ticketBaseMapper.selectByPrimaryKey(id);
        if (!optional.isPresent()) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_OTHER_EXCEPTION, new Exception("未查询到相应的票据记录"));
        }
        return optional.get();
    }
}
