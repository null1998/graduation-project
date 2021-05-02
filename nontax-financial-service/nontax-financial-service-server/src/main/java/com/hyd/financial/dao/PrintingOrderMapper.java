package com.hyd.financial.dao;

import com.hyd.basedata.dao.UnitDynamicSqlSupport;
import com.hyd.financial.entity.PrintingOrder;
import com.hyd.financial.web.qo.PrintingOrderQO;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.select.join.EqualTo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/3/18 18:51
 */
public interface PrintingOrderMapper extends PrintingOrderBaseMapper {
    /**
     * 通用查询，支持id，unitId，printUnitId，status,printUnitName字段
     * @param printingOrder
     * @return
     */
    default List<PrintingOrder> commonQuery(PrintingOrderQO printingOrder) {
        String printUnitName = StringUtils.wrap(StringUtils.trimToNull(printingOrder.getPrintUnitName()), "%");
        return this.select(c->c.leftJoin(UnitDynamicSqlSupport.unit)
                .on(PrintingOrderDynamicSqlSupport.printUnitId,new EqualTo(UnitDynamicSqlSupport.id))
                .where(PrintingOrderDynamicSqlSupport.id, SqlBuilder.isEqualToWhenPresent(printingOrder.getId()))
                .and(PrintingOrderDynamicSqlSupport.unitId, SqlBuilder.isEqualToWhenPresent(printingOrder.getUnitId()))
                .and(PrintingOrderDynamicSqlSupport.printUnitId, SqlBuilder.isEqualToWhenPresent(printingOrder.getPrintUnitId()))
                .and(PrintingOrderDynamicSqlSupport.status, SqlBuilder.isEqualToWhenPresent(printingOrder.getStatus()))
                .and(UnitDynamicSqlSupport.name,SqlBuilder.isLikeWhenPresent(printUnitName))
        );
    }

    /**
     * 某印刷单位一周内订单量
     * @param printUnitId
     * @param start
     * @param end
     * @return
     */
    default List<PrintingOrder> recent(Long printUnitId, LocalDate start, LocalDate end) {
        if (start == null || end == null || printUnitId == null) {
            return new ArrayList<>();
        }
        return this.select(c->c.where(PrintingOrderDynamicSqlSupport.printUnitId,SqlBuilder.isEqualTo(printUnitId))
                .and(PrintingOrderDynamicSqlSupport.start, SqlBuilder.isBetween(start).and(end)));
    }
}
