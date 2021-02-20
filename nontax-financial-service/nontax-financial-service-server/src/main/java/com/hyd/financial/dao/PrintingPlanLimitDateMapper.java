package com.hyd.financial.dao;

import com.hyd.financial.entity.PrintingPlanLimitDate;
import org.mybatis.dynamic.sql.SqlBuilder;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/20 16:38
 */
public interface PrintingPlanLimitDateMapper extends PrintingPlanLimitDateBaseMapper {
    /**
     * 根据单位ID查询历年印制计划时间限制
     * @param unitId 单位ID
     * @return 历年印制计划时间限制
     */
    default List<PrintingPlanLimitDate> listByUnitId(Long unitId){
        return this.select(c->c.where(PrintingPlanLimitDateDynamicSqlSupport.unitId, SqlBuilder.isEqualToWhenPresent(unitId)));
    }
}
