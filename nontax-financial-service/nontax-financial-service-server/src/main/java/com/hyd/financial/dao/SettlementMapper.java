package com.hyd.financial.dao;

import com.hyd.financial.entity.Settlement;
import org.mybatis.dynamic.sql.SqlBuilder;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/3 11:26
 */
public interface SettlementMapper extends SettlementBaseMapper {
    default List<Settlement> listBySettlementUnitId(Long settlementUnitId) {
        return this.select(c -> c.where(SettlementDynamicSqlSupport.settlementUnit, SqlBuilder.isEqualTo(settlementUnitId)));
    }
    default List<Settlement> listByUnitId(Long unitId) {
        return this.select(c -> c.where(SettlementDynamicSqlSupport.unitId, SqlBuilder.isEqualTo(unitId)));
    }
}
