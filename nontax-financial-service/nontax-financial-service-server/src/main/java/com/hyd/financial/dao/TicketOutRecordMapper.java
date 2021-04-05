package com.hyd.financial.dao;
import java.util.List;
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
}
