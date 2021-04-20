package com.hyd.financial.dao;

import com.hyd.financial.entity.TicketStoreRecord;
import org.mybatis.dynamic.sql.SqlBuilder;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 票据入库记录
 * @author huangyanduo
 * @date 2021-03-23
 */
public interface TicketStoreRecordMapper extends TicketStoreRecordBaseMapper {
    /**
     * 通用查询，支持字段id，unitId
     * @param ticketStoreRecord
     * @return 票据入库记录列表
     */
    default List<TicketStoreRecord> commonQuery(TicketStoreRecord ticketStoreRecord) {
        return this.select(c->c.where(TicketStoreRecordDynamicSqlSupport.id, SqlBuilder.isEqualToWhenPresent(ticketStoreRecord.getId()))
                .and(TicketStoreRecordDynamicSqlSupport.unitId, SqlBuilder.isEqualToWhenPresent(ticketStoreRecord.getUnitId())));
    }

    /**
     * 查询某单位一段时间内的入库记录
     * @param start
     * @param end
     * @param unitId
     * @return
     */
    default List<TicketStoreRecord> recent(LocalDate start, LocalDate end, Long unitId) {
        if (start == null || end == null || unitId == null) {
            return new ArrayList<>();
        }
        return this.select(c->c.where(TicketStoreRecordDynamicSqlSupport.unitId, SqlBuilder.isEqualTo(unitId))
                .and(TicketStoreRecordDynamicSqlSupport.storeDate, SqlBuilder.isBetween(start).and(end)));
    }
}
