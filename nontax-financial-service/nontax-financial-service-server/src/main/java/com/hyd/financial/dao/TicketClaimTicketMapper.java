package com.hyd.financial.dao;
import java.util.List;
import com.hyd.financial.entity.TicketClaimTicket;
import org.mybatis.dynamic.sql.SqlBuilder;

/**
 * 票据申领票据
 * @author huangyanduo
 * @date 2021-03-26
 */
public interface TicketClaimTicketMapper extends TicketClaimTicketBaseMapper {
    /**
     * 通用查询，支持字段id
     * @param ticketClaimTicket 票据申领票据
     * @return 票据申领票据列表
     */
    default List<TicketClaimTicket> commonQuery(TicketClaimTicket ticketClaimTicket) {
        return this.select(c->c.where(TicketClaimTicketDynamicSqlSupport.id, SqlBuilder.isEqualToWhenPresent(ticketClaimTicket.getId())));
    }
}
