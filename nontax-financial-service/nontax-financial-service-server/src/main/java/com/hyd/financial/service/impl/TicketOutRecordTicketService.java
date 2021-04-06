package com.hyd.financial.service.impl;
import java.util.List;
import java.util.Optional;

import com.hyd.common.core.exception.BusinessException;
import com.hyd.common.core.exception.code.BusinessErrorCode;
import com.hyd.common.util.BeanUtil;
import com.hyd.common.util.IdGenerator;
import com.hyd.financial.dao.TicketOutRecordTicketMapper;
import com.hyd.financial.entity.TicketOutRecordTicket;
import com.hyd.financial.service.ITicketOutRecordTicketService;
import com.hyd.financial.web.dto.TicketOutRecordTicketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

/**
 * 票据出库记录票据
 * @author huangyanduo
 * @date 2021-04-05
 */
@Service
public class TicketOutRecordTicketService implements ITicketOutRecordTicketService {

    @Autowired
    private IdGenerator idGenerator;

    @Autowired
    private TicketOutRecordTicketMapper ticketOutRecordTicketMapper;

	/**
     * 保存票据出库记录票据
     * @param ticketOutRecordTicket 票据出库记录票据
     * @return id
     */
    @Caching(evict = {@CacheEvict(value = {"TicketOutRecordTicketService::commonQuery"},allEntries = true)})
    @Override
    public Long save(TicketOutRecordTicket ticketOutRecordTicket) {
        if (ticketOutRecordTicket == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("票据出库记录票据为空"));
        }
        long id = idGenerator.snowflakeId();
        ticketOutRecordTicket.setId(id);
        ticketOutRecordTicketMapper.insertSelective(ticketOutRecordTicket);
        return id;
    }

	/**
     * 删除票据出库记录票据
     * @param id
     * @return 是否删除成功
     */
    @Caching(evict = {@CacheEvict(value = {"TicketOutRecordTicketService::commonQuery"},allEntries = true),
            @CacheEvict(value = {"TicketOutRecordTicketService::getById"},key = "#id")})
    @Override
    public Boolean remove(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        return ticketOutRecordTicketMapper.deleteByPrimaryKey(id) == 1;
    }

	/**
     * 更新票据出库记录票据
     * @param ticketOutRecordTicket 票据出库记录票据
     * @return 更新的行数
     */
    @Caching(evict = {@CacheEvict(value = {"TicketOutRecordTicketService::commonQuery"},allEntries = true),
    @CacheEvict(value = {"TicketOutRecordTicketService::getById"},key = "#ticketOutRecordTicket.id")})
    @Override
    public Integer update(TicketOutRecordTicket ticketOutRecordTicket) {
        if (ticketOutRecordTicket == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("票据出库记录票据为空"));
        }
        return ticketOutRecordTicketMapper.updateByPrimaryKeySelective(ticketOutRecordTicket);
    }

	/**
     * 根据id查询票据出库记录票据
     * @param id
     * @return 票据出库记录票据
     */
    @Cacheable(value = "TicketOutRecordTicketService::getById",key = "#id")
    @Override
    public TicketOutRecordTicketDTO getById(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        Optional<TicketOutRecordTicket> optional = ticketOutRecordTicketMapper.selectByPrimaryKey(id);
		if (optional.isPresent()){
			TicketOutRecordTicket ticketOutRecordTicket = optional.get();
			TicketOutRecordTicketDTO ticketOutRecordTicketDTO = BeanUtil.copy(ticketOutRecordTicket,TicketOutRecordTicketDTO.class);
			setProperties(ticketOutRecordTicketDTO);
			return ticketOutRecordTicketDTO;
		}
        return new TicketOutRecordTicketDTO();
    }

	/**
     * 通用查询，支持字段id
     * @param ticketOutRecordTicket 票据出库记录票据
     * @return 票据出库记录票据列表
     */
	@Cacheable(value = "TicketOutRecordTicketService::commonQuery",key = "#ticketOutRecordTicket.toString()")
    @Override
    public List<TicketOutRecordTicketDTO> commonQuery(TicketOutRecordTicket ticketOutRecordTicket) {
        if (ticketOutRecordTicket == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("票据出库记录票据为空"));
        }
        List<TicketOutRecordTicket> ticketOutRecordTicketList = ticketOutRecordTicketMapper.commonQuery(ticketOutRecordTicket);
		List<TicketOutRecordTicketDTO> ticketOutRecordTicketDTOList = BeanUtil.copyList(ticketOutRecordTicketList, TicketOutRecordTicketDTO.class);
		for (TicketOutRecordTicketDTO ticketOutRecordTicketDTO : ticketOutRecordTicketDTOList) {
			setProperties(ticketOutRecordTicketDTO);
		}
		return ticketOutRecordTicketDTOList;
    }
	/**
	 * 补充一些字段的值
	 * @param ticketOutRecordTicketDTO 票据出库记录票据
	 */
	private void setProperties(TicketOutRecordTicketDTO ticketOutRecordTicketDTO) {
		if (ticketOutRecordTicketDTO != null){
		}
	}
}
