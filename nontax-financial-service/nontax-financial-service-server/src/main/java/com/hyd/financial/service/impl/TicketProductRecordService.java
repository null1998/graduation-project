package com.hyd.financial.service.impl;

import com.hyd.basedata.entity.Ticket;
import com.hyd.basedata.service.ITicketService;
import com.hyd.common.core.exception.BusinessException;
import com.hyd.common.core.exception.code.BusinessErrorCode;
import com.hyd.common.util.BeanUtil;
import com.hyd.common.util.IdGenerator;
import com.hyd.financial.dao.TicketProductRecordMapper;
import com.hyd.financial.entity.TicketProductRecord;
import com.hyd.financial.service.ITicketProductRecordService;
import com.hyd.financial.util.TicketCodeConvertUtil;
import com.hyd.financial.web.dto.TicketProductRecordDTO;
import com.hyd.financial.web.dto.TicketStoreRecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yanduohuang
 * @date 2021/3/21 16:10
 */
@Service
public class TicketProductRecordService implements ITicketProductRecordService {
    @Autowired
    private IdGenerator idGenerator;
    @Autowired
    private TicketProductRecordMapper ticketProductRecordMapper;
    @Autowired
    private ITicketProductRecordService ticketProductRecordService;
    @Autowired
    private ITicketService ticketService;
    @Caching(evict = {@CacheEvict(value = {"TicketProductRecordService::commonQuery"},allEntries = true)})
    @Override
    public Long save(TicketProductRecord ticketProductRecord) {
        if (ticketProductRecord == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("票据生产记录为空"));
        }
        // id和orderNumber设值
        long id = idGenerator.snowflakeId();
        long orderNumber = idGenerator.snowflakeId();
        ticketProductRecord.setId(id);
        ticketProductRecord.setOrderNumber(orderNumber);
        // 完工登记的票据和生产数量
        Long ticketId = ticketProductRecord.getTicketId();
        Integer number = ticketProductRecord.getNumber();
        if (ticketId!=null&&number!=null&&number>0) {
            TicketProductRecord query = new TicketProductRecord();
            query.setTicketId(ticketId);
            // 查询该票据过去的生产记录
            List<TicketProductRecordDTO> ticketProductRecordDTOList = ticketProductRecordService.commonQuery(query);
            // 按终止号倒序
            ticketProductRecordDTOList = ticketProductRecordDTOList.stream().sorted(Comparator.comparing(TicketProductRecordDTO::getEndNumber).reversed()).collect(Collectors.toList());
            if (ticketProductRecordDTOList == null || ticketProductRecordDTOList.isEmpty()) {
                // 没有生产记录则初始化票号
                ticketProductRecord.setStartNumber(TicketCodeConvertUtil.longConvertString(0L));
                ticketProductRecord.setEndNumber(TicketCodeConvertUtil.longConvertString(Long.parseLong(number.toString())-1));
            } else {
                // 有生产记录则记录新的票号
                TicketProductRecordDTO lastRecord = ticketProductRecordDTOList.get(0);
                Long lastEndNumber = TicketCodeConvertUtil.stringConvertLong(lastRecord.getEndNumber());
                ticketProductRecord.setStartNumber(TicketCodeConvertUtil.longConvertString(lastEndNumber+1));
                ticketProductRecord.setEndNumber(TicketCodeConvertUtil.longConvertString(lastEndNumber+number));
            }
            ticketProductRecord.setCreatedDate(LocalDate.now().format(DateTimeFormatter.ISO_DATE));
            ticketProductRecordMapper.insertSelective(ticketProductRecord);
            return id;
        }


        return null;

    }
    @Caching(evict = {@CacheEvict(value = {"TicketProductRecordService::commonQuery"},allEntries = true),
            @CacheEvict(value = {"TicketProductRecordService::getById"},key = "#id")})
    @Override
    public Boolean remove(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        return ticketProductRecordMapper.deleteByPrimaryKey(id) == 1;
    }
    @Transactional(rollbackFor=Exception.class)
    @Caching(evict = {@CacheEvict(value = {"TicketProductRecordService::commonQuery"},allEntries = true),
    @CacheEvict(value = {"TicketProductRecordService::getById"},key = "#ticketProductRecord.id")})
    @Override
    public Integer update(TicketProductRecord ticketProductRecord) {
        if (ticketProductRecord == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("票据生产记录为空"));
        }
        Long oldId = ticketProductRecord.getId();
        Long id = ticketProductRecordService.save(ticketProductRecord);
        if (id!=null&&ticketProductRecord.getId()!=null) {
            ticketProductRecordService.remove(oldId);
            return 2;
        }
        return 0;
    }
    @Cacheable(value = "TicketProductRecordService::commonQuery",key = "#ticketProductRecord.toString()")
    @Override
    public List<TicketProductRecordDTO> commonQuery(TicketProductRecord ticketProductRecord) {
        if (ticketProductRecord == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("票据生产记录为空"));
        }
        List<TicketProductRecord> ticketProductRecordList = ticketProductRecordMapper.commonQuery(ticketProductRecord);
        List<TicketProductRecordDTO> ticketProductRecordDTOList = BeanUtil.copyList(ticketProductRecordList, TicketProductRecordDTO.class);
        List<Long> ticketIdList = ticketProductRecordDTOList.stream().map(TicketProductRecordDTO::getTicketId).collect(Collectors.toList());
        Map<Long, String> ticketNameMap = ticketService.listByTicketIdList(ticketIdList).stream().collect(Collectors.toMap(Ticket::getId, Ticket::getName));
        ticketProductRecordDTOList.forEach(e->{
            e.setTicketName(ticketNameMap.get(e.getTicketId()));
        });
        return ticketProductRecordDTOList;
    }

    @Override
    public List<TicketProductRecordDTO> sum(TicketProductRecord ticketProductRecord) {
        if (ticketProductRecord == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("票据生产记录为空"));
        }
        List<TicketProductRecordDTO> ticketProductRecordDTOList = ticketProductRecordService.commonQuery(ticketProductRecord);
        // 给票据名赋值
        List<Long> ticketIdList = ticketProductRecordDTOList.stream().map(TicketProductRecordDTO::getTicketId).collect(Collectors.toList());
        Map<Long, String> ticketNameMap = ticketService.listByTicketIdList(ticketIdList).stream().collect(Collectors.toMap(Ticket::getId, Ticket::getName));
        ticketProductRecordDTOList.forEach(e->{
            e.setTicketName(ticketNameMap.get(e.getTicketId()));
        });
        // 根据票据名对数量进行分组求和
        Map<String, Integer> map = ticketProductRecordDTOList.stream().collect(Collectors.groupingBy(TicketProductRecordDTO::getTicketName, Collectors.summingInt(TicketProductRecordDTO::getNumber)));
        // 将结果封装返回
        List<TicketProductRecordDTO> result = new ArrayList<>();
        map.forEach((k,v)->{
            TicketProductRecordDTO ticketProductRecordDTO = new TicketProductRecordDTO();
            ticketProductRecordDTO.setTicketName(k);
            ticketProductRecordDTO.setNumber(v);
            result.add(ticketProductRecordDTO);
        });
        return result;
    }

    @Cacheable(value = "TicketProductRecordService::getById",key = "#id")
    @Override
    public TicketProductRecord getById(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        Optional<TicketProductRecord> optional = ticketProductRecordMapper.selectByPrimaryKey(id);
        return optional.orElseGet(TicketProductRecord::new);
    }
}
