package com.hyd.financial.service.impl;

import com.hyd.basedata.entity.Unit;
import com.hyd.basedata.service.IUnitService;
import com.hyd.financial.dao.ClaimFormBaseMapper;
import com.hyd.financial.dao.ClaimFormMapper;
import com.hyd.financial.entity.ClaimForm;
import com.hyd.financial.service.IClaimFormService;
import com.hyd.financial.web.dto.ClaimFormDTO;
import com.sd365.common.core.annotation.stuffer.IdGenerator;
import com.sd365.common.core.common.exception.BusinessException;
import com.sd365.common.core.common.exception.code.BusinessErrorCode;
import com.sd365.common.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/2 11:18
 */
@Service
public class ClaimFormService implements IClaimFormService {
    @Autowired
    private ClaimFormBaseMapper claimFormBaseMapper;
    @Autowired
    private ClaimFormMapper claimFormMapper;
    @Autowired
    private IdGenerator idGenerator;
    @Autowired
    private IUnitService unitService;
    @Caching(evict = {@CacheEvict(value = {"ClaimFormService::listByClaimUnitId"},allEntries = true)
            ,@CacheEvict(value = {"ClaimFormService::listChildClaimFormByParentUnitId"},allEntries = true)})
    @Override
    public Long save(ClaimForm claimForm) {
        if (claimForm == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("申领单为空"));
        }
        long id = idGenerator.snowflakeId();
        claimForm.setId(id);
        long orderNumber = idGenerator.snowflakeId();
        claimForm.setOrderNumber(orderNumber);
        claimForm.setClaimDate(LocalDateTime.now());
        claimFormBaseMapper.insertSelective(claimForm);
        return id;
    }
    @Caching(evict = {@CacheEvict(value = {"ClaimFormService::listByClaimUnitId"},allEntries = true)
            ,@CacheEvict(value = {"ClaimFormService::listChildClaimFormByParentUnitId"},allEntries = true)})
    @Override
    public Boolean remove(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        return claimFormBaseMapper.deleteByPrimaryKey(id) == 1;
    }
    @Caching(evict = {@CacheEvict(value = {"ClaimFormService::listByClaimUnitId"},key="#claimForm.claimUnitId")
    ,@CacheEvict(value = {"ClaimFormService::listChildClaimFormByParentUnitId"},allEntries = true)})
    @Override
    public Integer update(ClaimForm claimForm) {
        if (claimForm == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("申领单为空"));
        }
        return claimFormBaseMapper.updateByPrimaryKeySelective(claimForm);
    }
    @Cacheable(value = {"ClaimFormService::listByClaimUnitId"},key = "#claimUnitId")
    @Override
    public List<ClaimFormDTO> listByClaimUnitId(Long claimUnitId) {
        if (claimUnitId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("申领单位ID为空"));
        }
        List<ClaimForm> claimFormList = claimFormMapper.listByClaimUnitId(claimUnitId);
        return listClaimUnitName(claimFormList);
    }
    @Cacheable(value = {"ClaimFormService::listChildClaimFormByParentUnitId"},key = "#parentUnitId")
    @Override
    public List<ClaimFormDTO> listChildClaimFormByParentUnitId(Long parentUnitId) {
        if (parentUnitId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("父级单位ID为空"));
        }
        List<ClaimForm> claimFormList = claimFormMapper.listChildClaimFormByParentUnitId(parentUnitId);
        return listClaimUnitName(claimFormList);
    }

    /**
     * 根据申领单的单位ID查询单位名
     * @param claimFormList 申领单列表
     * @return 申领单列表
     */
    private List<ClaimFormDTO> listClaimUnitName(List<ClaimForm> claimFormList) {
        if (claimFormList == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("申领单为空"));
        }
        List<ClaimFormDTO> claimFormDTOList = BeanUtil.copyList(claimFormList, ClaimFormDTO.class);
        for (ClaimFormDTO claimFormDTO : claimFormDTOList) {
            Long claimUnitId = claimFormDTO.getClaimUnitId();
            if (claimUnitId != null) {
                Unit unit = unitService.getUnitById(claimUnitId);
                claimFormDTO.setClaimUnitName(unit.getName());
            }
        }
        return claimFormDTOList;
    }
}
