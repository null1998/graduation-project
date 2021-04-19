package com.hyd.financial.dao;
import java.util.List;
import org.mybatis.dynamic.sql.SqlBuilder;
import com.hyd.financial.entity.Payment;
/**
 * 票据结算
 * @author huangyanduo
 * @date 2021-03-26
 */
public interface PaymentMapper extends PaymentBaseMapper {
    /**
     * 通用查询，支持字段id,srcUnitId
     * @param payment 票据结算
     * @return 票据结算列表
     */
    default List<Payment> commonQuery(Payment payment) {
        return this.select(c->c.where(PaymentDynamicSqlSupport.id, SqlBuilder.isEqualToWhenPresent(payment.getId()))
                .and(PaymentDynamicSqlSupport.srcUnitId, SqlBuilder.isEqualToWhenPresent(payment.getSrcUnitId())));
    }

    /**
     * 批量删除
     * @param list
     * @return
     */
    default Integer deleteAll(List<Long> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return this.delete(c->c.where(PaymentDynamicSqlSupport.id, SqlBuilder.isIn(list)));
    }
}
