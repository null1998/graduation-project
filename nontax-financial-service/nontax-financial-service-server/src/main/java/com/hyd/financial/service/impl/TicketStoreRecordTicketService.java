package com.hyd.financial.service.impl;

import com.hyd.basedata.entity.Ticket;
import com.hyd.basedata.service.ITicketService;
import com.hyd.common.core.exception.BusinessException;
import com.hyd.common.core.exception.code.BusinessErrorCode;
import com.hyd.common.util.BeanUtil;
import com.hyd.common.util.IdGenerator;
import com.hyd.financial.dao.TicketStoreRecordTicketMapper;
import com.hyd.financial.entity.TicketStoreRecord;
import com.hyd.financial.entity.TicketStoreRecordTicket;
import com.hyd.financial.service.ITicketStoreRecordService;
import com.hyd.financial.service.ITicketStoreRecordTicketService;
import com.hyd.financial.util.TicketCodeConvertUtil;
import com.hyd.financial.web.dto.RecordDTO;
import com.hyd.financial.web.dto.TicketStoreRecordDTO;
import com.hyd.financial.web.dto.TicketStoreRecordTicketDTO;
import com.hyd.financial.web.qo.TicketStoreRecordQO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

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

    @Autowired
    private ITicketStoreRecordService ticketStoreRecordService;

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
            @CacheEvict(value = {"TicketStoreRecordTicketService::getById"},key = "#id")})
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
    @CacheEvict(value = {"TicketStoreRecordTicketService::getById"},key = "#ticketStoreRecordTicket.id")})
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
        List<Long> ticketIdList = ticketStoreRecordTicketDTOList.stream().map(TicketStoreRecordTicketDTO::getTicketId).collect(Collectors.toList());
        Map<Long, String> ticketNameMap = ticketService.listByTicketIdList(ticketIdList).stream().collect(Collectors.toMap(Ticket::getId, Ticket::getName));
        ticketStoreRecordTicketDTOList.forEach(e->{
            e.setTicketName(ticketNameMap.get(e.getTicketId()));
        });
        return ticketStoreRecordTicketDTOList;
    }
    /**
     * 根据单位id查询该单位每种票据的入库汇总数，按月统计
     * @param unitId 单位id
     * @return 票据记录
     */
    @Override
    public List<RecordDTO> getByUnitId(Long unitId) {
        if (unitId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("单位ID为空"));
        }
        Map<Long, RecordDTO> map = new HashMap<>();
        TicketStoreRecordQO query = new TicketStoreRecordQO();
        query.setUnitId(unitId);
        // 查询该单位的所有入库记录
        List<TicketStoreRecordDTO> ticketStoreRecordDTOList = ticketStoreRecordService.commonQuery(query);
        for (TicketStoreRecordDTO ticketStoreRecordDTO : ticketStoreRecordDTOList) {
            if (ticketStoreRecordDTO.getStoreDate() == null) {
                continue;
            }
            LocalDate storeDate = ticketStoreRecordDTO.getStoreDate();
            // 必须是当年的记录
            if (storeDate.getYear() == LocalDate.now().getYear()) {
                TicketStoreRecordTicket query2 = new TicketStoreRecordTicket();
                query2.setTicketStoreRecordId(ticketStoreRecordDTO.getId());
                // 查找入库记录对应的票据
                List<TicketStoreRecordTicket> ticketStoreRecordTicketList = ticketStoreRecordTicketMapper.commonQuery(query2);
                for (TicketStoreRecordTicket ticketStoreRecordTicket : ticketStoreRecordTicketList) {
                    if (map.get(ticketStoreRecordTicket.getTicketId()) == null) {
                        RecordDTO recordDTO = new RecordDTO();
                        Map<Integer, Long> number = new HashMap<>();
                        number.put(storeDate.getMonthValue(),ticketStoreRecordTicket.getNumber());
                        recordDTO.setNumber(number);
                        map.put(ticketStoreRecordTicket.getTicketId(), recordDTO);
                    } else {
                        RecordDTO recordDTO = map.get(ticketStoreRecordTicket.getTicketId());
                        Map<Integer, Long> number = recordDTO.getNumber();
                        Long n = number.getOrDefault(storeDate.getMonthValue(), 0L);
                        number.put(storeDate.getMonthValue(), n + ticketStoreRecordTicket.getNumber());
                    }
                }
            }

        }
        ArrayList<RecordDTO> list = new ArrayList<>();
        map.forEach((k,v)->{
            Ticket ticket = ticketService.getTicketById(k);
            v.setTicketName(ticket.getName());
            list.add(v);
        });
        return list;
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
