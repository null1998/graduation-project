package com.hyd.financial.dao;

import com.hyd.financial.entity.PrintingPlanTicket;
import org.mybatis.dynamic.sql.SqlBuilder;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/25 9:24
 */
public interface PrintingPlanTicketMapper extends PrintingPlanTicketBaseMapper {
    /**
     * 根据印制计划ID查询印制计划票据列表
     * @param printingPlanId 印制计划ID
     * @return 印制计划票据列表
     */
    default List<PrintingPlanTicket> listByPrintingPlanId(Long printingPlanId) {
        return this.select(c->c.where(PrintingPlanTicketDynamicSqlSupport.printingPlanId, SqlBuilder.isEqualToWhenPresent(printingPlanId)));
    }
}
