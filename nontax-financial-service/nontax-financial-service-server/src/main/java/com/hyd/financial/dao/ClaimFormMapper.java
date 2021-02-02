package com.hyd.financial.dao;

import com.hyd.financial.entity.ClaimForm;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.isIn;

/**
 * @author yanduohuang
 * @date 2021/2/2 11:30
 */
public interface ClaimFormMapper extends ClaimFormBaseMapper{
    /**
     * 根据申领单位ID查询
     * @param claimUnitId 申领单位ID
     * @return 申领单列表
     */
    default List<ClaimForm> listByClaimUnitId(Long claimUnitId) {
        return this.select(c -> c.where(ClaimFormDynamicSqlSupport.claimUnitId, SqlBuilder.isEqualTo(claimUnitId)));
    }

    /**
     * 根据申领单位ID列表查询申领单
     * @param claimFormUnitIdList 申领单位ID列表
     * @return 申领单列表
     */
    default List<ClaimForm> listClaimFormByUnitIdList(List<Long> claimFormUnitIdList) {
        return this.select(c -> c.where(ClaimFormDynamicSqlSupport.claimUnitId, isIn(claimFormUnitIdList)));
    }
}
