package com.hyd.financial.dao;

import com.hyd.financial.entity.ClaimFormTicket;
import org.mybatis.dynamic.sql.SqlBuilder;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/3 9:56
 */
public interface ClaimFormTicketMapper extends ClaimFormTicketBaseMapper{
    default List<ClaimFormTicket> listByClaimFormId(Long claimFormId) {
        return this.select(c -> c.where(ClaimFormTicketDynamicSqlSupport.claimFormId, SqlBuilder.isEqualTo(claimFormId)));
    }
}
