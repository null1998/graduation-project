package com.hyd.financial.dao;

import com.hyd.financial.entity.PrintingOrderTicket;
import org.mybatis.dynamic.sql.SqlBuilder;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/3/18 19:28
 */
public interface PrintingOrderTicketMapper extends PrintingOrderTicketBaseMapper{
    /**
     * 批量保存
     * @param printingOrderTicketList
     */
    default void saveList(List<PrintingOrderTicket> printingOrderTicketList) {
        this.insertMultiple(printingOrderTicketList);
    }

    /**
     * 根据印制订单id查询
     * @param printingOrderId
     * @return
     */
    default List<PrintingOrderTicket> listByPrintingOrderId(Long printingOrderId) {
        return this.select(c -> c.where(PrintingOrderTicketDynamicSqlSupport.printingOrderId, SqlBuilder.isEqualToWhenPresent(printingOrderId)));
    }
}
