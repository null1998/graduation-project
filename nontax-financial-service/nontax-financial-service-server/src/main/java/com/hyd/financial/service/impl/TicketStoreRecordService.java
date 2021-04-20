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
import com.hyd.financial.web.dto.LineChartDTO;
import com.hyd.financial.web.dto.TicketStoreRecordDTO;
import com.hyd.financial.web.dto.TicketStoreRecordTicketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Key;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

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
            @CacheEvict(value = {"TicketStoreRecordService::getById"},key = "#id")})
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
    @CacheEvict(value = {"TicketStoreRecordService::getById"},key = "#ticketStoreRecord.id")})
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
        List<Long> sourceUnitIdList = ticketStoreRecordDTOList.stream().map(TicketStoreRecordDTO::getSourceUnitId).collect(Collectors.toList());
        List<Long> sourceWarehouseIdList = ticketStoreRecordDTOList.stream().map(TicketStoreRecordDTO::getSourceWarehouseId).collect(Collectors.toList());
        Map<Long, String> sourceUnitNameMap = unitService.listByUnitIdList(sourceUnitIdList).stream().collect(Collectors.toMap(Unit::getId, Unit::getName));
        Map<Long, String> sourceWarehouseNameMap = warehouseService.listByWarehouseIdList(sourceWarehouseIdList).stream().collect(Collectors.toMap(Warehouse::getId, Warehouse::getName));
        Map<Long, String> dictionaryRemarkMap = dictionaryService.listByCategoryName("票据入库方式分类").stream().collect(Collectors.toMap(Dictionary::getId, Dictionary::getRemark));
        ticketStoreRecordDTOList.forEach(e->{
            e.setSourceUnitName(sourceUnitNameMap.get(e.getSourceUnitId()));
            e.setSourceWarehouseName(sourceWarehouseNameMap.get(e.getSourceWarehouseId()));
            e.setTheWay(dictionaryRemarkMap.get(e.getDictionaryId()));
        });
        return ticketStoreRecordDTOList;
    }

    @Override
    public LineChartDTO recent(Long unitId) {
        if (unitId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("单位ID为空"));
        }
        LocalDate end = LocalDate.now();
        LocalDate start = end.minusWeeks(1).plusDays(1);
        List<TicketStoreRecord> ticketStoreRecordList = ticketStoreRecordMapper.recent(start, end, unitId);
        Map<LocalDate, Long> map = ticketStoreRecordList.stream().collect(Collectors.groupingBy(TicketStoreRecord::getStoreDate, Collectors.counting()));
        LineChartDTO lineChartDTO = new LineChartDTO();
        List<String> duration = new ArrayList<>();
        List<Long> numbers = new ArrayList<>();
        lineChartDTO.setDuration(duration);
        lineChartDTO.setNumbers(numbers);
        while (start.isBefore(end) || start.isEqual(end)) {
            duration.add(start.format(DateTimeFormatter.ofPattern("MM-dd")));
            numbers.add(map.getOrDefault(start, 0L));
            start = start.plusDays(1);
        }
        return lineChartDTO;
    }
}
