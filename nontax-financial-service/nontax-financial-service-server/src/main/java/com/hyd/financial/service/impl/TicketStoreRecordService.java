package com.hyd.financial.service.impl;

import com.hyd.basedata.entity.Dictionary;
import com.hyd.basedata.entity.Unit;
import com.hyd.basedata.entity.Warehouse;
import com.hyd.basedata.service.IDictionaryService;
import com.hyd.basedata.service.IUnitService;
import com.hyd.basedata.service.IWarehouseService;
import com.hyd.common.core.exception.BusinessException;
import com.hyd.common.core.exception.code.BusinessErrorCode;
import com.hyd.common.util.BeanUtil;
import com.hyd.common.util.IdGenerator;
import com.hyd.financial.dao.TicketStoreRecordMapper;
import com.hyd.financial.entity.TicketStoreRecord;
import com.hyd.financial.entity.TicketStoreRecordTicket;
import com.hyd.financial.service.ITicketStoreRecordService;
import com.hyd.financial.service.ITicketStoreRecordTicketService;
import com.hyd.financial.web.dto.TicketStoreRecordDTO;
import com.hyd.financial.web.dto.TicketStoreRecordTicketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
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

    @Autowired
    private IUnitService unitService;

    @Autowired
    private IWarehouseService warehouseService;

    @Autowired
    private IDictionaryService dictionaryService;

    @Autowired
    private ITicketStoreRecordTicketService ticketStoreRecordTicketService;
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
        long orderNumber = idGenerator.snowflakeId();
        ticketStoreRecord.setOrderNumber(orderNumber);
        ticketStoreRecordMapper.insertSelective(ticketStoreRecord);
        return id;
    }

	/**
     * 删除票据入库记录
     * @param id
     * @return 是否删除成功
     */
    @Transactional(rollbackFor=Exception.class)
    @Caching(evict = {@CacheEvict(value = {"TicketStoreRecordService::commonQuery"},allEntries = true),
            @CacheEvict(value = {"TicketStoreRecordService::commonQuery"},key = "#id")})
    @Override
    public Boolean remove(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        TicketStoreRecordTicket query = new TicketStoreRecordTicket();
        query.setTicketStoreRecordId(id);
        List<TicketStoreRecordTicketDTO> ticketStoreRecordTicketDTOList = ticketStoreRecordTicketService.commonQuery(query);
        for (TicketStoreRecordTicketDTO ticketStoreRecordTicketDTO : ticketStoreRecordTicketDTOList) {
            ticketStoreRecordTicketService.remove(ticketStoreRecordTicketDTO.getId());
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
    public List<TicketStoreRecordDTO> commonQuery(TicketStoreRecord ticketStoreRecord) {
        if (ticketStoreRecord == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("票据入库记录为空"));
        }
        List<TicketStoreRecord> ticketStoreRecordList = ticketStoreRecordMapper.commonQuery(ticketStoreRecord);
        List<TicketStoreRecordDTO> ticketStoreRecordDTOList = BeanUtil.copyList(ticketStoreRecordList, TicketStoreRecordDTO.class);
        for (TicketStoreRecordDTO ticketStoreRecordDTO : ticketStoreRecordDTOList) {
            if (ticketStoreRecordDTO.getSourceUnitId()!=null) {
                Unit unit = unitService.getUnitById(ticketStoreRecordDTO.getSourceUnitId());
                ticketStoreRecordDTO.setSourceUnitName(unit.getName());
            }
            if (ticketStoreRecordDTO.getSourceWarehouseId() != null) {
                Warehouse warehouse = warehouseService.getWarehouseById(ticketStoreRecordDTO.getSourceWarehouseId());
                ticketStoreRecordDTO.setSourceWarehouseName(warehouse.getName());
            }
            if (ticketStoreRecordDTO.getDictionaryId() != null) {
                List<Dictionary> dictionaryList = dictionaryService.listByCategoryName("票据入库方式分类");
                for (Dictionary dictionary : dictionaryList) {
                    if (Objects.equals(dictionary.getId(),ticketStoreRecordDTO.getDictionaryId())) {
                        ticketStoreRecordDTO.setTheWay(dictionary.getRemark());
                        break;
                    }
                }
            }
        }
        return ticketStoreRecordDTOList;
    }
}
