package com.hyd.financial.dao;

import com.hyd.basedata.dao.UnitDynamicSqlSupport;
import com.hyd.financial.entity.ClaimForm;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.select.join.EqualTo;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
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

    /**
     * 根据父级单位ID查询下级单位提交的申领单
     * @param parentUnitId 父级单位ID
     * @return 申领单列表
     */
    default List<ClaimForm> listChildClaimFormByParentUnitId(Long parentUnitId) {
        return this.select(c -> c
                .leftJoin(UnitDynamicSqlSupport.unit).on(UnitDynamicSqlSupport.id, new EqualTo(ClaimFormDynamicSqlSupport.claimUnitId))
                .where(UnitDynamicSqlSupport.parentId, isEqualTo(parentUnitId)));
    }
}
