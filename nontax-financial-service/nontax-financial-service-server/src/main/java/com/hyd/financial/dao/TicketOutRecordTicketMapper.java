package com.hyd.financial.dao;
import java.util.List;
import org.mybatis.dynamic.sql.SqlBuilder;
import com.hyd.financial.entity.TicketOutRecordTicket;
/**
 * 票据出库记录票据
 * @author huangyanduo
 * @date 2021-04-05
 */
public interface TicketOutRecordTicketMapper extends TicketOutRecordTicketBaseMapper {
    /**
     * 通用查询，支持字段id
     * @param ticketOutRecordTicket 票据出库记录票据
     * @return 票据出库记录票据列表
     */
    default List<TicketOutRecordTicket> commonQuery(TicketOutRecordTicket ticketOutRecordTicket) {
        return this.select(c->c.where(TicketOutRecordTicketDynamicSqlSupport.id, SqlBuilder.isEqualToWhenPresent(ticketOutRecordTicket.getId())));
    }
}
