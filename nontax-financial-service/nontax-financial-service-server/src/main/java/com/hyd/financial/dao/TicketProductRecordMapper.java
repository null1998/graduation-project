package com.hyd.financial.dao;

import com.hyd.financial.entity.TicketProductRecord;
import org.apache.ibatis.jdbc.SQL;
import org.mybatis.dynamic.sql.SqlBuilder;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/3/21 16:16
 */
public interface TicketProductRecordMapper extends TicketProductRecordBaseMapper {
    /**
     * 通用查询，支持字段id，ticketId，printOrderNumber，printUnitId
     * @param ticketProductRecord
     * @return
     */
    default List<TicketProductRecord> commonQuery(TicketProductRecord ticketProductRecord) {
        return this.select(c->c.where(TicketProductRecordDynamicSqlSupport.id, SqlBuilder.isEqualToWhenPresent(ticketProductRecord.getId()))
                .and(TicketProductRecordDynamicSqlSupport.ticketId,SqlBuilder.isEqualToWhenPresent(ticketProductRecord.getTicketId()))
                .and(TicketProductRecordDynamicSqlSupport.printOrderNumber,SqlBuilder.isEqualToWhenPresent(ticketProductRecord.getPrintOrderNumber()))
                .and(TicketProductRecordDynamicSqlSupport.printUnitId, SqlBuilder.isEqualToWhenPresent(ticketProductRecord.getPrintUnitId()))
                .orderBy(TicketProductRecordDynamicSqlSupport.createdDate.descending()));
    }
}
