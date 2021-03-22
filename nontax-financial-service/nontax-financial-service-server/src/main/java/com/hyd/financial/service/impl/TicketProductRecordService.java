package com.hyd.financial.service.impl;

import com.hyd.common.core.exception.BusinessException;
import com.hyd.common.core.exception.code.BusinessErrorCode;
import com.hyd.common.util.IdGenerator;
import com.hyd.financial.dao.TicketProductRecordMapper;
import com.hyd.financial.entity.TicketProductRecord;
import com.hyd.financial.service.ITicketProductRecordService;
import com.hyd.financial.util.TicketCodeConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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
            List<TicketProductRecord> ticketProductRecordList = ticketProductRecordService.commonQuery(query);
            // 按终止号倒序
            ticketProductRecordList = ticketProductRecordList.stream().sorted(Comparator.comparing(TicketProductRecord::getEndNumber).reversed()).collect(Collectors.toList());
            if (ticketProductRecordList == null || ticketProductRecordList.isEmpty()) {
                // 没有生产记录则初始化票号
                ticketProductRecord.setStartNumber(TicketCodeConvertUtil.longConvertString(0L));
                ticketProductRecord.setEndNumber(TicketCodeConvertUtil.longConvertString(Long.parseLong(number.toString())-1));
            } else {
                // 有生产记录则记录新的票号
                TicketProductRecord lastRecord = ticketProductRecordList.get(0);
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
            @CacheEvict(value = {"TicketProductRecordService::commonQuery"},key = "#id")})
    @Override
    public Boolean remove(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        return ticketProductRecordMapper.deleteByPrimaryKey(id) == 1;
    }
    @Caching(evict = {@CacheEvict(value = {"TicketProductRecordService::commonQuery"},allEntries = true),
    @CacheEvict(value = {"TicketProductRecordService::commonQuery"},key = "#ticketProductRecord.id")})
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
    public List<TicketProductRecord> commonQuery(TicketProductRecord ticketProductRecord) {
        if (ticketProductRecord == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("票据生产记录为空"));
        }
        return ticketProductRecordMapper.commonQuery(ticketProductRecord);
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
