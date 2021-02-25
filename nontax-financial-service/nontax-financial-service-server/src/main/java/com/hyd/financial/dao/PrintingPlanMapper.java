package com.hyd.financial.dao;

import com.hyd.basedata.dao.UnitDynamicSqlSupport;
import com.hyd.financial.entity.PrintingPlan;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.select.join.EqualTo;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/24 16:26
 */
public interface PrintingPlanMapper extends PrintingPlanBaseMapper{
    /**
     * 根据父单位ID,以及印制计划状态查询子单位的印制计划列表
     * @param parentUnitId 父单位ID
     * @param printingPlanStatus 印制计划状态
     * @param year 年度
     * @return 印制计划列表
     */
    default List<PrintingPlan> listByParentUnitIdAndStatus(Long parentUnitId, Integer printingPlanStatus, Integer year){
        return this.select(c->c.leftJoin(UnitDynamicSqlSupport.unit).on(UnitDynamicSqlSupport.id,new EqualTo(PrintingPlanDynamicSqlSupport.unitId))
                .where(UnitDynamicSqlSupport.parentId, SqlBuilder.isEqualTo(parentUnitId))
                .and(PrintingPlanDynamicSqlSupport.status,SqlBuilder.isEqualTo(printingPlanStatus))
                .and(PrintingPlanDynamicSqlSupport.year,SqlBuilder.isEqualTo(year)));
    }
    /**
     * 根据单位ID查询历年印制计划列表
     * @param unitId 单位ID
     * @return 印制计划列表
     */
    default List<PrintingPlan> listByUnitId(Long unitId){
        return this.select(c -> c.where(PrintingPlanDynamicSqlSupport.unitId, SqlBuilder.isEqualTo(unitId)));
    }

}
