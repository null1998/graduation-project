package com.hyd.financial.service.impl;

import com.hyd.basedata.dao.UnitMapper;
import com.hyd.basedata.entity.Unit;
import com.hyd.basedata.service.IUnitService;
import com.hyd.financial.dao.ClaimFormBaseMapper;
import com.hyd.financial.dao.ClaimFormMapper;
import com.hyd.financial.entity.ClaimForm;
import com.hyd.financial.service.IClaimFormService;
import com.sd365.common.core.annotation.stuffer.IdGenerator;
import com.sd365.common.core.common.exception.BusinessException;
import com.sd365.common.core.common.exception.code.BusinessErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    private IUnitService unitService;
    @Autowired
    private IdGenerator idGenerator;
    @Override
    public Long save(ClaimForm claimForm) {
        if (claimForm == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("申领单为空"));
        }
        long id = idGenerator.snowflakeId();
        claimForm.setId(id);
        claimFormBaseMapper.insertSelective(claimForm);
        return id;
    }

    @Override
    public Boolean remove(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        return claimFormBaseMapper.deleteByPrimaryKey(id) == 1;
    }

    @Override
    public Integer update(ClaimForm claimForm) {
        if (claimForm == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("申领单为空"));
        }
        return claimFormBaseMapper.updateByPrimaryKeySelective(claimForm);
    }

    @Override
    public List<ClaimForm> listByClaimUnitId(Long claimUnitId) {
        if (claimUnitId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("申领单位ID为空"));
        }
        return claimFormMapper.listByClaimUnitId(claimUnitId);
    }

    @Override
    public List<ClaimForm> listChildClaimFormByParentUnitId(Long parentUnitId) {
        if (parentUnitId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("父级单位ID为空"));
        }
        // 查询父级单位的所有下属单位
        List<Unit> unitList = unitService.listUnitByParentId(parentUnitId);
        ArrayList<Long> unitIdList = new ArrayList<>();
        for (Unit unit : unitList) {
            unitIdList.add(unit.getId());
        }
        // 根据单位ID列表查询申领单列表
        return claimFormMapper.listClaimFormByUnitIdList(unitIdList);
    }
}
