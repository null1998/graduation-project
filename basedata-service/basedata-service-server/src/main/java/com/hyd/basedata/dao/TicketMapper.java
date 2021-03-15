package com.hyd.basedata.dao;

import com.hyd.basedata.entity.Ticket;
import org.mybatis.dynamic.sql.SqlBuilder;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/3/16 1:23
 */
public interface TicketMapper extends TicketBaseMapper {
    default List<Ticket> listByZoneId(Long zoneId) {
        return this.select(c -> c.where(TicketDynamicSqlSupport.zoneId, SqlBuilder.isEqualTo(zoneId)));
    }
}
