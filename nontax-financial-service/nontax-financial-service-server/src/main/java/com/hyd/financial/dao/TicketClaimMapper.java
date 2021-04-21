package com.hyd.financial.dao;
import java.util.List;

import com.hyd.basedata.dao.UnitDynamicSqlSupport;
import com.hyd.financial.entity.TicketClaim;
import com.hyd.financial.web.qo.TicketClaimQO;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.select.join.EqualTo;

/**
 * 票据申领
 * @author huangyanduo
 * @date 2021-03-26
 */
public interface TicketClaimMapper extends TicketClaimBaseMapper {
    /**
     * 通用查询，支持字段id,unitId,targetUnitId，status,targetUnitName
     * @param ticketClaim 票据申领
     * @return 票据申领列表
     */
    default List<TicketClaim> commonQuery(TicketClaimQO ticketClaim) {
        String targetUnitName = StringUtils.wrap(StringUtils.trimToNull(ticketClaim.getTargetUnitName()), "%");
        return this.select(c->c.leftJoin(UnitDynamicSqlSupport.unit)
                .on(TicketClaimDynamicSqlSupport.targetUnitId,new EqualTo(UnitDynamicSqlSupport.id))
                .where(TicketClaimDynamicSqlSupport.id, SqlBuilder.isEqualToWhenPresent(ticketClaim.getId()))
                .and(TicketClaimDynamicSqlSupport.unitId, SqlBuilder.isEqualToWhenPresent(ticketClaim.getUnitId()))
                .and(TicketClaimDynamicSqlSupport.targetUnitId, SqlBuilder.isEqualToWhenPresent(ticketClaim.getTargetUnitId()))
                .and(TicketClaimDynamicSqlSupport.status, SqlBuilder.isEqualToWhenPresent(ticketClaim.getStatus()))
                .and(UnitDynamicSqlSupport.name,SqlBuilder.isLikeWhenPresent(targetUnitName)));
    }
}
