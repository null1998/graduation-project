package com.hyd.basedata.dao;

import com.hyd.basedata.entity.Ticket;
import org.mybatis.dynamic.sql.SqlBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/3/16 1:23
 */
public interface TicketMapper extends TicketBaseMapper {
    default List<Ticket> listByZoneId(Long zoneId) {
        return this.select(c -> c.where(TicketDynamicSqlSupport.zoneId, SqlBuilder.isEqualTo(zoneId)));
    }
    /**
     * 通用查询。支持字段id，zoneId，year，name
     * @param ticket
     * @return
     */
    default List<Ticket> commonQuery(Ticket ticket) {
        return this.select(c->c.where(TicketDynamicSqlSupport.id,SqlBuilder.isEqualToWhenPresent(ticket.getId()))
                .and(TicketDynamicSqlSupport.zoneId,SqlBuilder.isEqualToWhenPresent(ticket.getZoneId()))
                .and(TicketDynamicSqlSupport.year,SqlBuilder.isEqualToWhenPresent(ticket.getYear()))
                .and(TicketDynamicSqlSupport.name,SqlBuilder.isEqualToWhenPresent(ticket.getName())));
    }

    /**
     * 根据数组查询
     * @param ticketIdList
     * @return
     */
    default List<Ticket> listByTicketIdList(List<Long> ticketIdList) {
        if (ticketIdList == null || ticketIdList.isEmpty()) {
            return new ArrayList<>();
        }
        return this.select(c -> c.where(TicketDynamicSqlSupport.id, SqlBuilder.isInWhenPresent(ticketIdList)));
    }
}
