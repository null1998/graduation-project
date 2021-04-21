package com.hyd.financial.dao;

import com.hyd.basedata.dao.UnitDynamicSqlSupport;
import com.hyd.financial.entity.TicketStoreRecord;
import com.hyd.financial.web.qo.TicketStoreRecordQO;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.select.join.EqualTo;

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
     * 通用查询，支持字段id，unitId,sourceUnitName
     * @param ticketStoreRecord
     * @return 票据入库记录列表
     */
    default List<TicketStoreRecord> commonQuery(TicketStoreRecordQO ticketStoreRecord) {
        String sourceUnitName = StringUtils.wrap(StringUtils.trimToNull(ticketStoreRecord.getSourceUnitName()), "%");

        return this.select(c->c.leftJoin(UnitDynamicSqlSupport.unit)
                .on(TicketStoreRecordDynamicSqlSupport.sourceUnitId,new EqualTo(UnitDynamicSqlSupport.id))
                .where(TicketStoreRecordDynamicSqlSupport.id, SqlBuilder.isEqualToWhenPresent(ticketStoreRecord.getId()))
                .and(TicketStoreRecordDynamicSqlSupport.unitId, SqlBuilder.isEqualToWhenPresent(ticketStoreRecord.getUnitId()))
                .and(UnitDynamicSqlSupport.name,SqlBuilder.isLikeWhenPresent(sourceUnitName)));
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
