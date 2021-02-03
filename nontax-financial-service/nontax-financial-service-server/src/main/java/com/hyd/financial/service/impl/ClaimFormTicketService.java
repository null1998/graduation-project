package com.hyd.financial.service.impl;

import com.hyd.financial.dao.ClaimFormTicketMapper;
import com.hyd.financial.entity.ClaimFormTicket;
import com.hyd.financial.service.IClaimFormTicketService;
import com.sd365.common.core.annotation.stuffer.IdGenerator;
import com.sd365.common.core.common.exception.BusinessException;
import com.sd365.common.core.common.exception.code.BusinessErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/3 9:47
 */
@Service
public class ClaimFormTicketService implements IClaimFormTicketService {
    @Autowired
    private ClaimFormTicketMapper claimFormTicketMapper;
    @Autowired
    private IdGenerator idGenerator;
    @CacheEvict(value = {"ClaimFormTicketService::listByClaimFormId"}, allEntries = true)
    @Override
    public Long save(ClaimFormTicket claimFormTicket) {
        if (claimFormTicket == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("申领单票据为空"));
        }
        long id = idGenerator.snowflakeId();
        claimFormTicket.setId(id);
        claimFormTicketMapper.insertSelective(claimFormTicket);
        return id;
    }
    @CacheEvict(value = {"ClaimFormTicketService::listByClaimFormId"}, allEntries = true)
    @Override
    public Boolean remove(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        return claimFormTicketMapper.deleteByPrimaryKey(id) == 1;
    }
    @CacheEvict(value = {"ClaimFormTicketService::listByClaimFormId"}, allEntries = true)
    @Override
    public Integer update(ClaimFormTicket claimFormTicket) {
        if (claimFormTicket == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("申领单票据为空"));
        }
        return claimFormTicketMapper.updateByPrimaryKeySelective(claimFormTicket);
    }
    @Cacheable(value = {"ClaimFormTicketService::listByClaimFormId"}, key = "#claimFormId")
    @Override
    public List<ClaimFormTicket> listByClaimFormId(Long claimFormId) {
        if (claimFormId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("申领单ID为空"));
        }
        return claimFormTicketMapper.listByClaimFormId(claimFormId);
    }
}
