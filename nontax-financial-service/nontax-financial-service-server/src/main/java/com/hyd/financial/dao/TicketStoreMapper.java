package com.hyd.financial.dao;
import java.util.List;
import com.hyd.financial.entity.TicketStore;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.select.aggregate.Sum;

/**
 * 票据库存
 * @author huangyanduo
 * @date 2021-03-25
 */
public interface TicketStoreMapper extends TicketStoreBaseMapper {
    /**
     * 通用查询，支持字段id，unitId，ticketId，根据数量升序排列
     * @param ticketStore 票据库存
     * @return 票据库存列表
     */
    default List<TicketStore> commonQuery(TicketStore ticketStore) {
        return this.select(c->c.where(TicketStoreDynamicSqlSupport.id, SqlBuilder.isEqualToWhenPresent(ticketStore.getId()))
                .and(TicketStoreDynamicSqlSupport.unitId,SqlBuilder.isEqualToWhenPresent(ticketStore.getUnitId()))
                .and(TicketStoreDynamicSqlSupport.ticketId,SqlBuilder.isEqualToWhenPresent(ticketStore.getTicketId()))
                .orderBy(TicketStoreDynamicSqlSupport.number));
    }
    /**
     * 查询单位票据库存
     * @param unitId 单位id
     * @return 票据库存列表
     */
    default List<TicketStore> getUnitStore(Long unitId) {
       return null;
    }
}
