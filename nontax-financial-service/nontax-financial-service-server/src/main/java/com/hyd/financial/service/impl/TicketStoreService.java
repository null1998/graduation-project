package com.hyd.financial.service.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.hyd.basedata.entity.Ticket;
import com.hyd.basedata.entity.Warehouse;
import com.hyd.basedata.service.ITicketService;
import com.hyd.basedata.service.IWarehouseService;
import com.hyd.common.core.exception.BusinessException;
import com.hyd.common.core.exception.code.BusinessErrorCode;
import com.hyd.common.util.BeanUtil;
import com.hyd.common.util.IdGenerator;
import com.hyd.financial.dao.TicketStoreMapper;
import com.hyd.financial.entity.TicketStore;
import com.hyd.financial.service.ITicketStoreService;
import com.hyd.financial.util.TicketCodeConvertUtil;
import com.hyd.financial.web.dto.TicketProductRecordDTO;
import com.hyd.financial.web.dto.TicketStoreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

/**
 * 票据库存
 * @author huangyanduo
 * @date 2021-03-25
 */
@Service
public class TicketStoreService implements ITicketStoreService {

    @Autowired
    private IdGenerator idGenerator;

    @Autowired
    private TicketStoreMapper ticketStoreMapper;

    @Autowired
    private ITicketService ticketService;

    @Autowired
    private IWarehouseService warehouseService;

    @Autowired
    private ITicketStoreService ticketStoreService;

	/**
     * 保存票据库存
     * @param ticketStore 票据库存
     * @return id
     */
    @Caching(evict = {@CacheEvict(value = {"TicketStoreService::commonQuery","TicketStoreService::getUnitStorage"},allEntries = true)})
    @Override
    public Long save(TicketStore ticketStore) {
        if (ticketStore == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("票据库存为空"));
        }
        long id = idGenerator.snowflakeId();
        ticketStore.setId(id);
        if (ticketStore.getStartNumber()!=null&&ticketStore.getEndNumber()!=null) {
            Long s = TicketCodeConvertUtil.stringConvertLong(ticketStore.getStartNumber());
            Long e = TicketCodeConvertUtil.stringConvertLong(ticketStore.getEndNumber());
            if (e>=s) {
                ticketStore.setNumber(e - s + 1);
            }
        }
        ticketStoreMapper.insertSelective(ticketStore);
        return id;
    }

	/**
     * 删除票据库存
     * @param id
     * @return 是否删除成功
     */
    @Caching(evict = {@CacheEvict(value = {"TicketStoreService::commonQuery","TicketStoreService::getUnitStorage"},allEntries = true),
            @CacheEvict(value = {"TicketStoreService::getById"},key = "#id")})
    @Override
    public Boolean remove(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        return ticketStoreMapper.deleteByPrimaryKey(id) == 1;
    }
    /**
     * 批量删除
     * @param idList
     * @return
     */
    @Override
    public Integer removeAll(List<Long> idList) {
        if (idList == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("参数为空"));
        }
        Integer deleteAll = ticketStoreMapper.deleteAll(idList);
        if (deleteAll != idList.size()) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_DB_OTHER_EXCEPTION, new Exception("删除失败"));
        }
        return deleteAll;
    }

    /**
     * 更新票据库存
     * @param ticketStore 票据库存
     * @return 更新的行数
     */
    @Caching(evict = {@CacheEvict(value = {"TicketStoreService::commonQuery","TicketStoreService::getUnitStorage"},allEntries = true),
    @CacheEvict(value = {"TicketStoreService::getById"},key = "#ticketStore.id")})
    @Override
    public Integer update(TicketStore ticketStore) {
        if (ticketStore == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("票据库存为空"));
        }
        if (ticketStore.getStartNumber()!=null&&ticketStore.getEndNumber()!=null) {
            Long s = TicketCodeConvertUtil.stringConvertLong(ticketStore.getStartNumber());
            Long e = TicketCodeConvertUtil.stringConvertLong(ticketStore.getEndNumber());
            if (e>=s) {
                ticketStore.setNumber(e-s+1);
            }
        }
        return ticketStoreMapper.updateByPrimaryKeySelective(ticketStore);
    }

	/**
     * 根据id查询票据库存
     * @param id
     * @return 票据库存
     */
    @Cacheable(value = "TicketStoreService::getById",key = "#id")
    @Override
    public TicketStoreDTO getById(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        Optional<TicketStore> optional = ticketStoreMapper.selectByPrimaryKey(id);
		if (optional.isPresent()){
			TicketStore ticketStore = optional.get();
			TicketStoreDTO ticketStoreDTO = BeanUtil.copy(ticketStore,TicketStoreDTO.class);
			setProperties(ticketStoreDTO);
			return ticketStoreDTO;
		}
        return new TicketStoreDTO();
    }

	/**
     * 通用查询，支持字段id，unitId，ticketId
     * @param ticketStore 票据库存
     * @return 票据库存列表
     */
	@Cacheable(value = "TicketStoreService::commonQuery",key = "#ticketStore.toString()")
    @Override
    public List<TicketStoreDTO> commonQuery(TicketStore ticketStore) {
        if (ticketStore == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("票据库存为空"));
        }
        List<TicketStore> ticketStoreList = ticketStoreMapper.commonQuery(ticketStore);
		List<TicketStoreDTO> ticketStoreDTOList = BeanUtil.copyList(ticketStoreList, TicketStoreDTO.class);
        batchSetProperties(ticketStoreDTOList);
		return ticketStoreDTOList;
    }
    /**
     * 查询单位票据库存
     * @param unitId 单位id
     * @return 票据库存列表
     */
    @Cacheable(value = "TicketStoreService::getUnitStorage",key = "#unitId")
    @Override
    public List<TicketStoreDTO> getUnitStorage(Long unitId) {
        if (unitId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("单位ID为空"));
        }
        return null;
    }

    @Override
    public List<TicketStoreDTO> sum(Long unitId) {
        if (unitId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("单位ID为空"));
        }
        TicketStore query = new TicketStore();
        query.setUnitId(unitId);
        List<TicketStoreDTO> ticketStoreDTOList = ticketStoreService.commonQuery(query);
        // 给票据名赋值
        List<Long> ticketIdList = ticketStoreDTOList.stream().map(TicketStoreDTO::getTicketId).collect(Collectors.toList());
        Map<Long, String> ticketNameMap = ticketService.listByTicketIdList(ticketIdList).stream().collect(Collectors.toMap(Ticket::getId, Ticket::getName));
        ticketStoreDTOList.forEach(e->{
            e.setTicketName(ticketNameMap.get(e.getTicketId()));
        });
        // 根据票据名对数量进行分组求和
        Map<String, Long> map = ticketStoreDTOList.stream().collect(Collectors.groupingBy(TicketStoreDTO::getTicketName, Collectors.summingLong(TicketStoreDTO::getNumber)));
        // 将结果封装返回
        List<TicketStoreDTO> result = new ArrayList<>();
        map.forEach((k,v)->{
            TicketStoreDTO ticketStoreDTO = new TicketStoreDTO();
            ticketStoreDTO.setTicketName(k);
            ticketStoreDTO.setNumber(v);
            result.add(ticketStoreDTO);
        });
        return result;
    }

    /**
	 * 补充一些字段的值
	 * @param ticketStoreDTO 票据库存
	 */
	private void setProperties(TicketStoreDTO ticketStoreDTO) {
		if (ticketStoreDTO!=null){
            Ticket ticket = ticketService.getTicketById(ticketStoreDTO.getTicketId());
            if (ticket != null) {
                ticketStoreDTO.setTicketName(ticket.getName());
            }
        }
	}
	private void batchSetProperties(List<TicketStoreDTO> ticketStoreDTOList) {
        if (ticketStoreDTOList != null) {
            List<Long> ticketIdList = ticketStoreDTOList.stream().map(TicketStoreDTO::getTicketId).collect(Collectors.toList());
            List<Long> warehouseIdList = ticketStoreDTOList.stream().map(TicketStoreDTO::getWarehouseId).collect(Collectors.toList());
            Map<Long, String> ticketNameMap = ticketService.listByTicketIdList(ticketIdList).stream().collect(Collectors.toMap(Ticket::getId, Ticket::getName));
            Map<Long, String> warehouseNameMap = warehouseService.listByWarehouseIdList(warehouseIdList).stream().collect(Collectors.toMap(Warehouse::getId, Warehouse::getName));
            ticketStoreDTOList.forEach(e->{
                e.setTicketName(ticketNameMap.get(e.getTicketId()));
                e.setWarehouseName(warehouseNameMap.get(e.getWarehouseId()));
            });
        }
    }
}
