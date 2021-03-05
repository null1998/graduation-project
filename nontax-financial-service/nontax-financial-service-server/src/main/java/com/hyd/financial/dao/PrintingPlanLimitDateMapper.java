package com.hyd.financial.dao;

import com.hyd.financial.entity.PrintingPlanLimitDate;
import org.mybatis.dynamic.sql.SqlBuilder;

import java.util.List;
import java.util.Optional;

/**
 * @author yanduohuang
 * @date 2021/2/20 16:38
 */
public interface PrintingPlanLimitDateMapper extends PrintingPlanLimitDateBaseMapper {
    /**
     * 根据单位ID查询历年印制计划时间限制,按year逆序
     * @param unitId 单位ID
     * @return 历年印制计划时间限制
     */
    default List<PrintingPlanLimitDate> listByUnitId(Long unitId){
        return this.select(c->c.where(PrintingPlanLimitDateDynamicSqlSupport.unitId, SqlBuilder.isEqualToWhenPresent(unitId)).orderBy(PrintingPlanLimitDateDynamicSqlSupport.year.descending()));
    }

    /**
     * 根据单位ID和年度查询印制计划时间限制
     * @param unitId 单位ID
     * @param year 年度
     * @return 印制计划时间限制
     */
    default PrintingPlanLimitDate getByUnitIdAndYear(Long unitId, Integer year) {
        Optional<PrintingPlanLimitDate> optional = this.selectOne(c->c.where(PrintingPlanLimitDateDynamicSqlSupport.unitId, SqlBuilder.isEqualToWhenPresent(unitId))
                .and(PrintingPlanLimitDateDynamicSqlSupport.year, SqlBuilder.isEqualToWhenPresent(year)));
        return optional.orElse(null);
    }
}
