package com.hyd.financial.dao;
import java.util.List;
import com.hyd.financial.entity.TicketStore;
import org.mybatis.dynamic.sql.SqlBuilder;

/**
 * 票据库存
 * @author huangyanduo
 * @date 2021-03-25
 */
public interface TicketStoreMapper extends TicketStoreBaseMapper {
    /**
     * 通用查询，支持字段id，unitId
     * @param ticketStore 票据库存
     * @return 票据库存列表
     */
    default List<TicketStore> commonQuery(TicketStore ticketStore) {
        return this.select(c->c.where(TicketStoreDynamicSqlSupport.id, SqlBuilder.isEqualToWhenPresent(ticketStore.getId()))
                .and(TicketStoreDynamicSqlSupport.unitId,SqlBuilder.isEqualToWhenPresent(ticketStore.getUnitId())));
    }
}
