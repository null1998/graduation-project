package com.hyd.financial.service.impl;

import com.hyd.basedata.entity.Ticket;
import com.hyd.basedata.service.ITicketService;
import com.hyd.common.core.exception.BusinessException;
import com.hyd.common.core.exception.code.BusinessErrorCode;
import com.hyd.common.util.BeanUtil;
import com.hyd.common.util.IdGenerator;
import com.hyd.financial.dao.TicketStoreRecordTicketMapper;
import com.hyd.financial.entity.TicketStoreRecordTicket;
import com.hyd.financial.service.ITicketStoreRecordTicketService;
import com.hyd.financial.util.TicketCodeConvertUtil;
import com.hyd.financial.web.dto.TicketStoreRecordDTO;
import com.hyd.financial.web.dto.TicketStoreRecordTicketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 票据入库记录票据
 * @author huangyanduo
 * @date 2021-03-24
 */
@Service
public class TicketStoreRecordTicketService implements ITicketStoreRecordTicketService {

    @Autowired
    private IdGenerator idGenerator;

    @Autowired
    private TicketStoreRecordTicketMapper ticketStoreRecordTicketMapper;

    @Autowired
    private ITicketService ticketService;

	/**
     * 保存票据入库记录票据
     * @param ticketStoreRecordTicket 票据入库记录票据
     * @return id
     */
    @Caching(evict = {@CacheEvict(value = {"TicketStoreRecordTicketService::commonQuery"},allEntries = true)})
    @Override
    public Long save(TicketStoreRecordTicket ticketStoreRecordTicket) {
        if (ticketStoreRecordTicket == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("票据入库记录票据为空"));
        }
        long id = idGenerator.snowflakeId();
        ticketStoreRecordTicket.setId(id);
        calculateNumber(ticketStoreRecordTicket);
        ticketStoreRecordTicketMapper.insertSelective(ticketStoreRecordTicket);
        return id;
    }

	/**
     * 删除票据入库记录票据
     * @param id
     * @return 是否删除成功
     */
    @Caching(evict = {@CacheEvict(value = {"TicketStoreRecordTicketService::commonQuery"},allEntries = true),
            @CacheEvict(value = {"TicketStoreRecordTicketService::commonQuery"},key = "#id")})
    @Override
    public Boolean remove(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        return ticketStoreRecordTicketMapper.deleteByPrimaryKey(id) == 1;
    }

	/**
     * 更新票据入库记录票据
     * @param ticketStoreRecordTicket 票据入库记录票据
     * @return 更新的行数
     */
    @Caching(evict = {@CacheEvict(value = {"TicketStoreRecordTicketService::commonQuery"},allEntries = true),
    @CacheEvict(value = {"TicketStoreRecordTicketService::commonQuery"},key = "#ticketStoreRecordTicket.id")})
    @Override
    public Integer update(TicketStoreRecordTicket ticketStoreRecordTicket) {
        if (ticketStoreRecordTicket == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("票据入库记录票据为空"));
        }
        calculateNumber(ticketStoreRecordTicket);
        return ticketStoreRecordTicketMapper.updateByPrimaryKeySelective(ticketStoreRecordTicket);
    }

	/**
     * 根据id查询票据入库记录票据
     * @param id
     * @return 票据入库记录票据
     */
    @Cacheable(value = "TicketStoreRecordTicketService::getById",key = "#id")
    @Override
    public TicketStoreRecordTicket getById(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        Optional<TicketStoreRecordTicket> optional = ticketStoreRecordTicketMapper.selectByPrimaryKey(id);
        return optional.orElseGet(TicketStoreRecordTicket::new);
    }

	/**
     * 通用查询，支持字段id,ticketStoreRecordId
     * @param ticketStoreRecordTicket 票据入库记录票据
     * @return 票据入库记录票据列表
     */
	@Cacheable(value = "TicketStoreRecordTicketService::commonQuery",key = "#ticketStoreRecordTicket.toString()")
    @Override
    public List<TicketStoreRecordTicketDTO> commonQuery(TicketStoreRecordTicket ticketStoreRecordTicket) {
        if (ticketStoreRecordTicket == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("票据入库记录票据为空"));
        }
        List<TicketStoreRecordTicket> ticketStoreRecordTicketList = ticketStoreRecordTicketMapper.commonQuery(ticketStoreRecordTicket);
        List<TicketStoreRecordTicketDTO> ticketStoreRecordTicketDTOList = BeanUtil.copyList(ticketStoreRecordTicketList, TicketStoreRecordTicketDTO.class);
        for (TicketStoreRecordTicketDTO ticketStoreRecordTicketDTO : ticketStoreRecordTicketDTOList) {
            if (ticketStoreRecordTicketDTO.getTicketId()!=null) {
                Ticket ticket = ticketService.getTicketById(ticketStoreRecordTicketDTO.getTicketId());
                ticketStoreRecordTicketDTO.setTicketName(ticket.getName());
            }
        }
        return ticketStoreRecordTicketDTOList;
    }

    /**
     * 计算number
     * @param ticketStoreRecordTicket
     */
    private void calculateNumber(TicketStoreRecordTicket ticketStoreRecordTicket) {
	    if (ticketStoreRecordTicket!=null) {
            String startNumber = ticketStoreRecordTicket.getStartNumber();
            String endNumber = ticketStoreRecordTicket.getEndNumber();
            if (startNumber!=null&&endNumber!=null) {
                Long s = TicketCodeConvertUtil.stringConvertLong(startNumber);
                Long e = TicketCodeConvertUtil.stringConvertLong(endNumber);
                if (e>=s) {
                    ticketStoreRecordTicket.setNumber(e-s+1);
                }
            }
	    }
    }
}
