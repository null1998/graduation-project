package com.hyd.financial.dao;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hyd.financial.entity.TicketStoreRecord;
import org.mybatis.dynamic.sql.SqlBuilder;
import com.hyd.financial.entity.TicketOutRecord;
/**
 * 票据出库记录
 * @author huangyanduo
 * @date 2021-04-05
 */
public interface TicketOutRecordMapper extends TicketOutRecordBaseMapper {
    /**
     * 通用查询，支持字段id
     * @param ticketOutRecord 票据出库记录
     * @return 票据出库记录列表
     */
    default List<TicketOutRecord> commonQuery(TicketOutRecord ticketOutRecord) {
        return this.select(c->c.where(TicketOutRecordDynamicSqlSupport.id, SqlBuilder.isEqualToWhenPresent(ticketOutRecord.getId())));
    }
    /**
     * 查询某单位一段时间内的出库记录
     * @param start
     * @param end
     * @param unitId
     * @return
     */
    default List<TicketOutRecord> recent(LocalDate start, LocalDate end, Long unitId) {
        if (start == null || end == null || unitId == null) {
            return new ArrayList<>();
        }
        return this.select(c->c.where(TicketOutRecordDynamicSqlSupport.unitId, SqlBuilder.isEqualTo(unitId))
                .and(TicketOutRecordDynamicSqlSupport.outDate, SqlBuilder.isBetween(start).and(end)));
    }
}
