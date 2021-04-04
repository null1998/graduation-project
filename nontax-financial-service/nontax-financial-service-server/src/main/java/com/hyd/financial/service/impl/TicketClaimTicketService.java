package com.hyd.financial.service.impl;
import java.util.List;
import java.util.Optional;

import com.hyd.basedata.entity.Ticket;
import com.hyd.basedata.service.ITicketService;
import com.hyd.basedata.service.IUnitService;
import com.hyd.common.core.exception.BusinessException;
import com.hyd.common.core.exception.code.BusinessErrorCode;
import com.hyd.common.util.BeanUtil;
import com.hyd.common.util.IdGenerator;
import com.hyd.financial.dao.TicketClaimTicketMapper;
import com.hyd.financial.entity.TicketClaimTicket;
import com.hyd.financial.service.ITicketClaimTicketService;
import com.hyd.financial.web.dto.TicketClaimTicketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

/**
 * 票据申领票据
 * @author huangyanduo
 * @date 2021-03-26
 */
@Service
public class TicketClaimTicketService implements ITicketClaimTicketService {

    @Autowired
    private IdGenerator idGenerator;

    @Autowired
    private TicketClaimTicketMapper ticketClaimTicketMapper;

    @Autowired
    private ITicketService ticketService;

	/**
     * 保存票据申领票据
     * @param ticketClaimTicket 票据申领票据
     * @return id
     */
    @Caching(evict = {@CacheEvict(value = {"TicketClaimTicketService::commonQuery"},allEntries = true)})
    @Override
    public Long save(TicketClaimTicket ticketClaimTicket) {
        if (ticketClaimTicket == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("票据申领票据为空"));
        }
        long id = idGenerator.snowflakeId();
        ticketClaimTicket.setId(id);
        ticketClaimTicketMapper.insertSelective(ticketClaimTicket);
        return id;
    }

	/**
     * 删除票据申领票据
     * @param id
     * @return 是否删除成功
     */
    @Caching(evict = {@CacheEvict(value = {"TicketClaimTicketService::commonQuery"},allEntries = true),
            @CacheEvict(value = {"TicketClaimTicketService::commonQuery"},key = "#id")})
    @Override
    public Boolean remove(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        return ticketClaimTicketMapper.deleteByPrimaryKey(id) == 1;
    }

	/**
     * 更新票据申领票据
     * @param ticketClaimTicket 票据申领票据
     * @return 更新的行数
     */
    @Caching(evict = {@CacheEvict(value = {"TicketClaimTicketService::commonQuery"},allEntries = true),
    @CacheEvict(value = {"TicketClaimTicketService::commonQuery"},key = "#ticketClaimTicket.id")})
    @Override
    public Integer update(TicketClaimTicket ticketClaimTicket) {
        if (ticketClaimTicket == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("票据申领票据为空"));
        }
        return ticketClaimTicketMapper.updateByPrimaryKeySelective(ticketClaimTicket);
    }

	/**
     * 根据id查询票据申领票据
     * @param id
     * @return 票据申领票据
     */
    @Cacheable(value = "TicketClaimTicketService::getById",key = "#id")
    @Override
    public TicketClaimTicketDTO getById(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        Optional<TicketClaimTicket> optional = ticketClaimTicketMapper.selectByPrimaryKey(id);
		if (optional.isPresent()){
			TicketClaimTicket ticketClaimTicket = optional.get();
			TicketClaimTicketDTO ticketClaimTicketDTO = BeanUtil.copy(ticketClaimTicket,TicketClaimTicketDTO.class);
			setProperties(ticketClaimTicketDTO);
			return ticketClaimTicketDTO;
		}
        return new TicketClaimTicketDTO();
    }

	/**
     * 通用查询，支持字段id
     * @param ticketClaimTicket 票据申领票据
     * @return 票据申领票据列表
     */
	@Cacheable(value = "TicketClaimTicketService::commonQuery",key = "#ticketClaimTicket.toString()")
    @Override
    public List<TicketClaimTicketDTO> commonQuery(TicketClaimTicket ticketClaimTicket) {
        if (ticketClaimTicket == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("票据申领票据为空"));
        }
        List<TicketClaimTicket> ticketClaimTicketList = ticketClaimTicketMapper.commonQuery(ticketClaimTicket);
		List<TicketClaimTicketDTO> ticketClaimTicketDTOList = BeanUtil.copyList(ticketClaimTicketList, TicketClaimTicketDTO.class);
		for (TicketClaimTicketDTO ticketClaimTicketDTO : ticketClaimTicketDTOList) {
			setProperties(ticketClaimTicketDTO);
		}
		return ticketClaimTicketDTOList;
    }
	/**
	 * 补充一些字段的值
	 * @param ticketClaimTicketDTO 票据申领票据
	 */
	private void setProperties(TicketClaimTicketDTO ticketClaimTicketDTO) {
		if (ticketClaimTicketDTO != null){
            if (ticketClaimTicketDTO.getTicketId() != null) {
                Ticket ticket = ticketService.getTicketById(ticketClaimTicketDTO.getTicketId());
                ticketClaimTicketDTO.setTicketName(ticket.getName());
            }
		}
	}
}
