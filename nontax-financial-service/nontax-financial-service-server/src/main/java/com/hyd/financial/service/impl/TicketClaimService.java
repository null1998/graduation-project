package com.hyd.financial.service.impl;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.hyd.basedata.entity.Unit;
import com.hyd.basedata.entity.Warehouse;
import com.hyd.basedata.service.IUnitService;
import com.hyd.basedata.service.IWarehouseService;
import com.hyd.common.core.exception.BusinessException;
import com.hyd.common.core.exception.code.BusinessErrorCode;
import com.hyd.common.util.BeanUtil;
import com.hyd.common.util.IdGenerator;
import com.hyd.financial.dao.TicketClaimMapper;
import com.hyd.financial.entity.*;
import com.hyd.financial.service.*;
import com.hyd.financial.util.TicketCodeConvertUtil;
import com.hyd.financial.web.dto.AutoStoreAndOutDTO;
import com.hyd.financial.web.dto.TicketClaimDTO;
import com.hyd.financial.web.dto.TicketClaimTicketDTO;
import com.hyd.financial.web.dto.TicketStoreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 票据申领
 * @author huangyanduo
 * @date 2021-03-26
 */
@Service
public class TicketClaimService implements ITicketClaimService {

    @Autowired
    private IdGenerator idGenerator;

    @Autowired
    private TicketClaimMapper ticketClaimMapper;

    @Autowired
    private IUnitService unitService;

    @Autowired
    private IWarehouseService warehouseService;

    @Autowired
    private ITicketClaimTicketService ticketClaimTicketService;

    @Autowired
    private ITicketStoreService ticketStoreService;

    @Autowired
    private ITicketOutRecordTicketService ticketOutRecordTicketService;

    @Autowired
    private ITicketStoreRecordTicketService ticketStoreRecordTicketService;

    @Autowired
    private ITicketStoreRecordService ticketStoreRecordService;

    @Autowired
    private ITicketOutRecordService ticketOutRecordService;
    @Autowired
    private ITicketClaimService ticketClaimService;
	/**
     * 保存票据申领
     * @param ticketClaim 票据申领
     * @return id
     */
    @Caching(evict = {@CacheEvict(value = {"TicketClaimService::commonQuery"},allEntries = true)})
    @Override
    public Long save(TicketClaim ticketClaim) {
        if (ticketClaim == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("票据申领为空"));
        }
        long id = idGenerator.snowflakeId();
        ticketClaim.setId(id);
        long orderNumber = idGenerator.snowflakeId();
        ticketClaim.setOrderNumber(orderNumber);
        ticketClaimMapper.insertSelective(ticketClaim);
        return id;
    }

	/**
     * 删除票据申领
     * @param id
     * @return 是否删除成功
     */
    @Caching(evict = {@CacheEvict(value = {"TicketClaimService::commonQuery"},allEntries = true),
            @CacheEvict(value = {"TicketClaimService::getById"},key = "#id")})
    @Override
    public Boolean remove(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        TicketClaimTicket query = new TicketClaimTicket();
        query.setTicketClaimId(id);
        List<TicketClaimTicketDTO> ticketClaimTicketDTOList = ticketClaimTicketService.commonQuery(query);
        for (TicketClaimTicketDTO ticketClaimTicketDTO : ticketClaimTicketDTOList) {
            ticketClaimTicketService.remove(ticketClaimTicketDTO.getId());
        }
        return ticketClaimMapper.deleteByPrimaryKey(id) == 1;
    }

	/**
     * 更新票据申领
     * @param ticketClaim 票据申领
     * @return 更新的行数
     */
    @Caching(evict = {@CacheEvict(value = {"TicketClaimService::commonQuery"},allEntries = true),
    @CacheEvict(value = {"TicketClaimService::getById"},key = "#ticketClaim.id")})
    @Override
    public Integer update(TicketClaim ticketClaim) {
        if (ticketClaim == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("票据申领为空"));
        }
        return ticketClaimMapper.updateByPrimaryKeySelective(ticketClaim);
    }

	/**
     * 根据id查询票据申领
     * @param id
     * @return 票据申领
     */
    @Cacheable(value = "TicketClaimService::getById",key = "#id")
    @Override
    public TicketClaimDTO getById(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        Optional<TicketClaim> optional = ticketClaimMapper.selectByPrimaryKey(id);
		if (optional.isPresent()){
			TicketClaim ticketClaim = optional.get();
			TicketClaimDTO ticketClaimDTO = BeanUtil.copy(ticketClaim,TicketClaimDTO.class);
			setProperties(ticketClaimDTO);
			return ticketClaimDTO;
		}
        return new TicketClaimDTO();
    }

	/**
     * 通用查询，支持字段id,unitId,targetUnitId，status
     * @param ticketClaim 票据申领
     * @return 票据申领列表
     */
	@Cacheable(value = "TicketClaimService::commonQuery",key = "#ticketClaim.toString()")
    @Override
    public List<TicketClaimDTO> commonQuery(TicketClaim ticketClaim) {
        if (ticketClaim == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("票据申领为空"));
        }
        List<TicketClaim> ticketClaimList = ticketClaimMapper.commonQuery(ticketClaim);
		List<TicketClaimDTO> ticketClaimDTOList = BeanUtil.copyList(ticketClaimList, TicketClaimDTO.class);
		batchSetProperties(ticketClaimDTOList);
		return ticketClaimDTOList;
    }
    /**
     * 自动减库存，生成出库记录，更新申领单
     * @param autoStoreAndOutDTOList
     */
    @Transactional(rollbackFor = Exception.class)
    @Caching(evict = {@CacheEvict(value = {"TicketClaimService::commonQuery","TicketClaimService::getById"},allEntries = true)})
    @Override
    public void autoOut(List<AutoStoreAndOutDTO> autoStoreAndOutDTOList) {
        if (autoStoreAndOutDTOList == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("参数为空"));
        }
        TicketOutRecord record = BeanUtil.copy(autoStoreAndOutDTOList.get(0), TicketOutRecord.class);
        // 生成票据出库单
        Long recordId = ticketOutRecordService.save(record);
        for (AutoStoreAndOutDTO autoStoreAndOutDTO : autoStoreAndOutDTOList) {
            // 检查库存是否足够
            TicketStoreDTO store = ticketStoreService.getById(autoStoreAndOutDTO.getStoreId());
            if (store.getNumber() < autoStoreAndOutDTO.getNeedNumber()) {
                throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_OTHER_EXCEPTION, new Exception("库存不足"));
            }
            String startNumber = store.getStartNumber();
            Long endNumber = TicketCodeConvertUtil.stringConvertLong(startNumber) + autoStoreAndOutDTO.getNeedNumber();
            // 更新库存
            TicketStore ticketStore = new TicketStore();
            ticketStore.setId(autoStoreAndOutDTO.getStoreId());
            ticketStore.setNumber(store.getNumber() - autoStoreAndOutDTO.getNeedNumber());
            ticketStore.setStartNumber(TicketCodeConvertUtil.longConvertString(endNumber));
            ticketStore.setOperateDate(autoStoreAndOutDTO.getOperateDate());
            ticketStore.setUserId(autoStoreAndOutDTO.getUserId());
            ticketStoreService.update(ticketStore);
            // 添加出库记录号段
            TicketOutRecordTicket ticketOutRecordTicket = new TicketOutRecordTicket();
            ticketOutRecordTicket.setTicketOutRecordId(recordId);
            ticketOutRecordTicket.setTicketId(autoStoreAndOutDTO.getTicketId());
            ticketOutRecordTicket.setNumber(autoStoreAndOutDTO.getNeedNumber());
            ticketOutRecordTicket.setStartNumber(startNumber);
            ticketOutRecordTicket.setEndNumber(TicketCodeConvertUtil.longConvertString(endNumber - 1));
            ticketOutRecordTicketService.save(ticketOutRecordTicket);
            // 更新票据申领单上的号段
            TicketClaimTicket ticketClaimTicket = new TicketClaimTicket();
            ticketClaimTicket.setId(autoStoreAndOutDTO.getTicketClaimTicketId());
            ticketClaimTicket.setStartNumber(startNumber);
            ticketClaimTicket.setEndNumber(TicketCodeConvertUtil.longConvertString(endNumber - 1));
            ticketClaimTicketService.update(ticketClaimTicket);
        }
    }
    /**
     * 自动增库存，生成入库记录号段
     * @param autoStoreAndOutDTOList
     */
    @Transactional(rollbackFor = Exception.class)
    @Caching(evict = {@CacheEvict(value = {"TicketClaimService::commonQuery","TicketClaimService::getById"},allEntries = true)})
    @Override
    public void autoStore(List<AutoStoreAndOutDTO> autoStoreAndOutDTOList) {
        if (autoStoreAndOutDTOList == null || autoStoreAndOutDTOList.isEmpty()) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("参数为空"));
        }
        TicketClaim ticketClaim = new TicketClaim();
        ticketClaim.setId(autoStoreAndOutDTOList.get(0).getTicketClaimId());
        ticketClaim.setStatus(4);
        Integer update = ticketClaimService.update(ticketClaim);
        if (update != 1) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_OTHER_EXCEPTION, new Exception("更新申领订单失败"));
        }
        // 生成票据入库单
        TicketStoreRecord record = BeanUtil.copy(autoStoreAndOutDTOList.get(0), TicketStoreRecord.class);
        Long recordId = ticketStoreRecordService.save(record);
        for (AutoStoreAndOutDTO autoStoreAndOutDTO : autoStoreAndOutDTOList) {
            // 添加库存
            TicketStore ticketStore = BeanUtil.copy(autoStoreAndOutDTO, TicketStore.class);
            ticketStore.setNumber(autoStoreAndOutDTO.getNeedNumber());
            ticketStoreService.save(ticketStore);
            // 添加票据入库记录号段
            TicketStoreRecordTicket ticketStoreRecordTicket = BeanUtil.copy(autoStoreAndOutDTO, TicketStoreRecordTicket.class);
            ticketStoreRecordTicket.setTicketStoreRecordId(recordId);
            ticketStoreRecordTicket.setNumber(autoStoreAndOutDTO.getNeedNumber());
            ticketStoreRecordTicketService.save(ticketStoreRecordTicket);
        }
    }

    /**
	 * 补充一些字段的值
	 * @param ticketClaimDTO 票据申领
	 */
	private void setProperties(TicketClaimDTO ticketClaimDTO) {
		if (ticketClaimDTO != null){
		    if (ticketClaimDTO.getTargetUnitId() != null) {
                Unit targetUnit = unitService.getUnitById(ticketClaimDTO.getTargetUnitId());
                ticketClaimDTO.setTargetUnitName(targetUnit.getName());
            }
            if (ticketClaimDTO.getWarehouseId() != null) {
                Warehouse warehouse = warehouseService.getWarehouseById(ticketClaimDTO.getWarehouseId());
                ticketClaimDTO.setWarehouseName(warehouse.getName());
            }
            if (ticketClaimDTO.getUnitId() != null) {
                Unit unit = unitService.getUnitById(ticketClaimDTO.getUnitId());
                ticketClaimDTO.setUnitName(unit.getName());
            }
		}
	}
	private void batchSetProperties(List<TicketClaimDTO> ticketClaimDTOList) {
        if (ticketClaimDTOList != null) {
            List<Long> targetUnitIdList = ticketClaimDTOList.stream().map(TicketClaimDTO::getTargetUnitId).collect(Collectors.toList());
            List<Long> warehouseIdList = ticketClaimDTOList.stream().map(TicketClaimDTO::getWarehouseId).collect(Collectors.toList());
            List<Long> unitIdList = ticketClaimDTOList.stream().map(TicketClaimDTO::getUnitId).collect(Collectors.toList());
            Map<Long, String> targetUnitNameMap = unitService.listByUnitIdList(targetUnitIdList).stream().collect(Collectors.toMap(Unit::getId, Unit::getName));
            Map<Long, String> unitNameMap = unitService.listByUnitIdList(unitIdList).stream().collect(Collectors.toMap(Unit::getId, Unit::getName));
            Map<Long, String> warehouseNameMap = warehouseService.listByWarehouseIdList(warehouseIdList).stream().collect(Collectors.toMap(Warehouse::getId, Warehouse::getName));
            ticketClaimDTOList.forEach(e->{
                e.setTargetUnitName(targetUnitNameMap.get(e.getTargetUnitId()));
                e.setUnitName(unitNameMap.get(e.getUnitId()));
                e.setWarehouseName(warehouseNameMap.get(e.getWarehouseId()));
            });
        }
    }
}
