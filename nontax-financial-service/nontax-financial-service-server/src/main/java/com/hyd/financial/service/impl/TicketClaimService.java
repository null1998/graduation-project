package com.hyd.financial.service.impl;
import java.util.List;
import java.util.Optional;

import com.hyd.basedata.entity.Unit;
import com.hyd.basedata.entity.Warehouse;
import com.hyd.basedata.service.IUnitService;
import com.hyd.basedata.service.IWarehouseService;
import com.hyd.common.core.exception.BusinessException;
import com.hyd.common.core.exception.code.BusinessErrorCode;
import com.hyd.common.util.BeanUtil;
import com.hyd.common.util.IdGenerator;
import com.hyd.financial.dao.TicketClaimMapper;
import com.hyd.financial.entity.TicketClaim;
import com.hyd.financial.service.ITicketClaimService;
import com.hyd.financial.web.dto.TicketClaimDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

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
		for (TicketClaimDTO ticketClaimDTO : ticketClaimDTOList) {
			setProperties(ticketClaimDTO);
		}
		return ticketClaimDTOList;
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
}
