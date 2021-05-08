package com.hyd.financial.dao;
import com.hyd.basedata.dao.UnitDynamicSqlSupport;
import com.hyd.financial.entity.TicketOutRecord;
import com.hyd.financial.web.qo.TicketOutRecordQO;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.select.join.EqualTo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 票据出库记录
 * @author huangyanduo
 * @date 2021-04-05
 */
public interface TicketOutRecordMapper extends TicketOutRecordBaseMapper {
    /**
     * 通用查询，支持字段id,targetUnitName,unitId,并按照出库时间倒序排列
     * @param ticketOutRecord 票据出库记录
     * @return 票据出库记录列表
     */
    default List<TicketOutRecord> commonQuery(TicketOutRecordQO ticketOutRecord) {
        String targetUnitName = StringUtils.wrap(StringUtils.trimToNull(ticketOutRecord.getTargetUnitName()), "%");

        return this.select(c->c.leftJoin(UnitDynamicSqlSupport.unit)
                .on(TicketOutRecordDynamicSqlSupport.targetUnitId,new EqualTo(UnitDynamicSqlSupport.id))
                .where(TicketOutRecordDynamicSqlSupport.id, SqlBuilder.isEqualToWhenPresent(ticketOutRecord.getId()))
                .and(UnitDynamicSqlSupport.name,SqlBuilder.isLikeWhenPresent(targetUnitName))
                .and(TicketOutRecordDynamicSqlSupport.unitId,SqlBuilder.isEqualToWhenPresent(ticketOutRecord.getUnitId()))
                .orderBy(TicketOutRecordDynamicSqlSupport.outDate.descending()));
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
