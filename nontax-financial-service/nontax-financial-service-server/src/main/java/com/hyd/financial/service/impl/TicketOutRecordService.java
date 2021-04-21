package com.hyd.financial.service.impl;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.hyd.basedata.entity.Unit;
import com.hyd.basedata.service.IUnitService;
import com.hyd.common.core.exception.BusinessException;
import com.hyd.common.core.exception.code.BusinessErrorCode;
import com.hyd.common.util.BeanUtil;
import com.hyd.common.util.IdGenerator;
import com.hyd.financial.dao.TicketOutRecordMapper;
import com.hyd.financial.entity.TicketOutRecord;
import com.hyd.financial.entity.TicketOutRecordTicket;
import com.hyd.financial.entity.TicketStoreRecord;
import com.hyd.financial.service.ITicketOutRecordService;
import com.hyd.financial.service.ITicketOutRecordTicketService;
import com.hyd.financial.web.dto.LineChartDTO;
import com.hyd.financial.web.dto.TicketOutRecordDTO;
import com.hyd.financial.web.dto.TicketOutRecordTicketDTO;
import com.hyd.financial.web.qo.TicketOutRecordQO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

/**
 * 票据出库记录
 * @author huangyanduo
 * @date 2021-04-05
 */
@Service
public class TicketOutRecordService implements ITicketOutRecordService {

    @Autowired
    private IdGenerator idGenerator;

    @Autowired
    private TicketOutRecordMapper ticketOutRecordMapper;

    @Autowired
    private IUnitService unitService;

    @Autowired
    private ITicketOutRecordTicketService ticketOutRecordTicketService;

	/**
     * 保存票据出库记录
     * @param ticketOutRecord 票据出库记录
     * @return id
     */
    @Caching(evict = {@CacheEvict(value = {"TicketOutRecordService::commonQuery"},allEntries = true)})
    @Override
    public Long save(TicketOutRecord ticketOutRecord) {
        if (ticketOutRecord == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("票据出库记录为空"));
        }
        long id = idGenerator.snowflakeId();
        ticketOutRecord.setId(id);
        long orderNumber = idGenerator.snowflakeId();
        ticketOutRecord.setOrderNumber(orderNumber);
        ticketOutRecordMapper.insertSelective(ticketOutRecord);
        return id;
    }

	/**
     * 删除票据出库记录
     * @param id
     * @return 是否删除成功
     */
    @Caching(evict = {@CacheEvict(value = {"TicketOutRecordService::commonQuery"},allEntries = true),
            @CacheEvict(value = {"TicketOutRecordService::getById"},key = "#id")})
    @Override
    public Boolean remove(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        TicketOutRecordTicket query = new TicketOutRecordTicket();
        query.setTicketOutRecordId(id);
        List<TicketOutRecordTicketDTO> ticketOutRecordTicketDTOList = ticketOutRecordTicketService.commonQuery(query);
        for (TicketOutRecordTicketDTO ticketOutRecordTicketDTO : ticketOutRecordTicketDTOList) {
            ticketOutRecordTicketService.remove(ticketOutRecordTicketDTO.getId());
        }
        return ticketOutRecordMapper.deleteByPrimaryKey(id) == 1;
    }

	/**
     * 更新票据出库记录
     * @param ticketOutRecord 票据出库记录
     * @return 更新的行数
     */
    @Caching(evict = {@CacheEvict(value = {"TicketOutRecordService::commonQuery"},allEntries = true),
    @CacheEvict(value = {"TicketOutRecordService::getById"},key = "#ticketOutRecord.id")})
    @Override
    public Integer update(TicketOutRecord ticketOutRecord) {
        if (ticketOutRecord == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("票据出库记录为空"));
        }
        return ticketOutRecordMapper.updateByPrimaryKeySelective(ticketOutRecord);
    }

	/**
     * 根据id查询票据出库记录
     * @param id
     * @return 票据出库记录
     */
    @Cacheable(value = "TicketOutRecordService::getById",key = "#id")
    @Override
    public TicketOutRecordDTO getById(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        Optional<TicketOutRecord> optional = ticketOutRecordMapper.selectByPrimaryKey(id);
		if (optional.isPresent()){
			TicketOutRecord ticketOutRecord = optional.get();
			TicketOutRecordDTO ticketOutRecordDTO = BeanUtil.copy(ticketOutRecord,TicketOutRecordDTO.class);
			setProperties(ticketOutRecordDTO);
			return ticketOutRecordDTO;
		}
        return new TicketOutRecordDTO();
    }

	/**
     * 通用查询，支持字段id,ticketOutRecordQO
     * @param ticketOutRecord 票据出库记录
     * @return 票据出库记录列表
     */
	@Cacheable(value = "TicketOutRecordService::commonQuery",key = "#ticketOutRecord.toString()")
    @Override
    public List<TicketOutRecordDTO> commonQuery(TicketOutRecordQO ticketOutRecord) {
        if (ticketOutRecord == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("票据出库记录为空"));
        }
        List<TicketOutRecord> ticketOutRecordList = ticketOutRecordMapper.commonQuery(ticketOutRecord);
		List<TicketOutRecordDTO> ticketOutRecordDTOList = BeanUtil.copyList(ticketOutRecordList, TicketOutRecordDTO.class);
        batchSetProperties(ticketOutRecordDTOList);
		return ticketOutRecordDTOList;
    }

    @Override
    public LineChartDTO recent(Long unitId) {
        if (unitId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("单位ID为空"));
        }
        LocalDate end = LocalDate.now();
        LocalDate start = end.minusWeeks(1).plusDays(1);
        List<TicketOutRecord> ticketOutRecordList = ticketOutRecordMapper.recent(start, end, unitId);
        Map<LocalDate, Long> map = ticketOutRecordList.stream().collect(Collectors.groupingBy(TicketOutRecord::getOutDate, Collectors.counting()));
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

    /**
	 * 补充一些字段的值
	 * @param ticketOutRecordDTO 票据出库记录
	 */
	private void setProperties(TicketOutRecordDTO ticketOutRecordDTO) {
		if (ticketOutRecordDTO != null){
            if (ticketOutRecordDTO.getTargetUnitId() != null) {
                Unit unit = unitService.getUnitById(ticketOutRecordDTO.getTargetUnitId());
                ticketOutRecordDTO.setTargetUnitName(unit.getName());
            }
		}
	}
    private void batchSetProperties(List<TicketOutRecordDTO> ticketOutRecordDTOList) {
        if (ticketOutRecordDTOList != null) {
            List<Long> targetUnitIdList = ticketOutRecordDTOList.stream().map(TicketOutRecordDTO::getTargetUnitId).collect(Collectors.toList());
            Map<Long, String> targetUnitNameMap = unitService.listByUnitIdList(targetUnitIdList).stream().collect(Collectors.toMap(Unit::getId, Unit::getName));
            ticketOutRecordDTOList.forEach(e->{
                e.setTargetUnitName(targetUnitNameMap.get(e.getTargetUnitId()));
            });
        }
    }
}
