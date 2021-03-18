package com.hyd.financial.dao;

import com.hyd.financial.entity.PrintingOrder;
import org.mybatis.dynamic.sql.SqlBuilder;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/3/18 18:51
 */
public interface PrintingOrderMapper extends PrintingOrderBaseMapper {
    /**
     * 通用查询，支持id，unitId，printUnitId，status字段
     * @param printingOrder
     * @return
     */
    default List<PrintingOrder> commonQuery(PrintingOrder printingOrder) {
        return this.select(c->c.where(PrintingOrderDynamicSqlSupport.id, SqlBuilder.isEqualToWhenPresent(printingOrder.getId()))
                .and(PrintingOrderDynamicSqlSupport.unitId, SqlBuilder.isEqualToWhenPresent(printingOrder.getUnitId()))
                .and(PrintingOrderDynamicSqlSupport.printUnitId, SqlBuilder.isEqualToWhenPresent(printingOrder.getPrintUnitId()))
                .and(PrintingOrderDynamicSqlSupport.status, SqlBuilder.isEqualToWhenPresent(printingOrder.getStatus()))
        );
    }
}
