package com.hyd.financial.service;

import com.hyd.financial.entity.ClaimForm;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/2 11:10
 */
public interface IClaimFormService {
    /**
     * 保存
     * @param claimForm 申领单
     * @return 申领单ID
     */
    Long save(ClaimForm claimForm);

    /**
     * 删除
     * @param id
     * @return 是否删除成功
     */
    Boolean remove(Long id);

    /**
     * 更新
     * @param claimForm 申领单
     * @return 更新行数
     */
    Integer update(ClaimForm claimForm);

    /**
     * 根据申领单位ID查询
     * @param claimUnitId 申领单位ID
     * @return 申领单列表
     */
    List<ClaimForm> listByClaimUnitId(Long claimUnitId);

    /**
     * 根据父单位ID查询下级单位申领单
     * @param parentUnitId 父单位ID
     * @return 申领单列表
     */
    @Transactional
    List<ClaimForm> listChildClaimFormByParentUnitId(Long parentUnitId);
}
