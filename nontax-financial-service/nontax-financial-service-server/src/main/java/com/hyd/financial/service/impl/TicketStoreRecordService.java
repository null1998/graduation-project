package com.hyd.financial.service.impl;

import com.hyd.common.core.exception.BusinessException;
import com.hyd.common.core.exception.code.BusinessErrorCode;
import com.hyd.common.util.IdGenerator;
import com.hyd.financial.dao.TicketStoreRecordMapper;
import com.hyd.financial.entity.TicketStoreRecord;
import com.hyd.financial.service.ITicketStoreRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 票据入库记录
 * @author huangyanduo
 * @date 2021-03-23
 */
@Service
public class TicketStoreRecordService implements ITicketStoreRecordService {

    @Autowired
    private IdGenerator idGenerator;

    @Autowired
    private TicketStoreRecordMapper ticketStoreRecordMapper;

	/**
     * 保存票据入库记录
     * @param ticketStoreRecord 票据入库记录
     * @return id
     */
    @Caching(evict = {@CacheEvict(value = {"TicketStoreRecordService::commonQuery"},allEntries = true)})
    @Override
    public Long save(TicketStoreRecord ticketStoreRecord) {
        if (ticketStoreRecord == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("票据入库记录为空"));
        }
        long id = idGenerator.snowflakeId();
        ticketStoreRecord.setId(id);
        ticketStoreRecordMapper.insertSelective(ticketStoreRecord);
        return id;
    }

	/**
     * 删除票据入库记录
     * @param id
     * @return 是否删除成功
     */
    @Caching(evict = {@CacheEvict(value = {"TicketStoreRecordService::commonQuery"},allEntries = true),
            @CacheEvict(value = {"TicketStoreRecordService::commonQuery"},key = "#id")})
    @Override
    public Boolean remove(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        return ticketStoreRecordMapper.deleteByPrimaryKey(id) == 1;
    }

	/**
     * 更新票据入库记录
     * @param ticketStoreRecord 票据入库记录
     * @return 更新的行数
     */
    @Caching(evict = {@CacheEvict(value = {"TicketStoreRecordService::commonQuery"},allEntries = true),
    @CacheEvict(value = {"TicketStoreRecordService::commonQuery"},key = "#ticketStoreRecord.id")})
    @Override
    public Integer update(TicketStoreRecord ticketStoreRecord) {
        if (ticketStoreRecord == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("票据入库记录为空"));
        }
        return ticketStoreRecordMapper.updateByPrimaryKeySelective(ticketStoreRecord);
    }

	/**
     * 根据id查询票据入库记录
     * @param id
     * @return 票据入库记录
     */
    @Cacheable(value = "TicketStoreRecordService::getById",key = "#id")
    @Override
    public TicketStoreRecord getById(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        Optional<TicketStoreRecord> optional = ticketStoreRecordMapper.selectByPrimaryKey(id);
        return optional.orElseGet(TicketStoreRecord::new);
    }

	/**
     * 通用查询，支持字段id
     * @param ticketStoreRecord 票据入库记录
     * @return 票据入库记录列表
     */
	@Cacheable(value = "TicketStoreRecordService::commonQuery",key = "#ticketStoreRecord.toString()")
    @Override
    public List<TicketStoreRecord> commonQuery(TicketStoreRecord ticketStoreRecord) {
        if (ticketStoreRecord == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("票据入库记录为空"));
        }
        return ticketStoreRecordMapper.commonQuery(ticketStoreRecord);
    }
}
