package com.hyd.financial.dao;

import com.hyd.financial.entity.TicketStoreRecordTicket;
import org.mybatis.dynamic.sql.SqlBuilder;

import java.util.List;

/**
 * 票据入库记录票据
 * @author huangyanduo
 * @date 2021-03-24
 */
public interface TicketStoreRecordTicketMapper extends TicketStoreRecordTicketBaseMapper {
    /**
     * 通用查询，支持字段id,ticketStoreRecordId
     * @param ticketStoreRecordTicket
     * @return 票据入库记录票据列表
     */
    default List<TicketStoreRecordTicket> commonQuery(TicketStoreRecordTicket ticketStoreRecordTicket) {
        return this.select(c->c.where(TicketStoreRecordTicketDynamicSqlSupport.id, SqlBuilder.isEqualToWhenPresent(ticketStoreRecordTicket.getId()))
                .and(TicketStoreRecordTicketDynamicSqlSupport.ticketStoreRecordId, SqlBuilder.isEqualToWhenPresent(ticketStoreRecordTicket.getTicketStoreRecordId())));
    }
}
