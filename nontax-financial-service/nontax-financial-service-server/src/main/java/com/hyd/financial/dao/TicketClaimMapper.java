package com.hyd.financial.dao;
import java.util.List;
import com.hyd.financial.entity.TicketClaim;
import org.mybatis.dynamic.sql.SqlBuilder;

/**
 * 票据申领
 * @author huangyanduo
 * @date 2021-03-26
 */
public interface TicketClaimMapper extends TicketClaimBaseMapper {
    /**
     * 通用查询，支持字段id
     * @param ticketClaim 票据申领
     * @return 票据申领列表
     */
    default List<TicketClaim> commonQuery(TicketClaim ticketClaim) {
        return this.select(c->c.where(TicketClaimDynamicSqlSupport.id, SqlBuilder.isEqualToWhenPresent(ticketClaim.getId())));
    }
}
