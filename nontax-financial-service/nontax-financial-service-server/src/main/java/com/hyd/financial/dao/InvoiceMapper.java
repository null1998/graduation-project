package com.hyd.financial.dao;
import com.hyd.financial.entity.Invoice;
import org.mybatis.dynamic.sql.SqlBuilder;

import java.util.List;
/**
 * 开票管理
 * @author huangyanduo
 * @date 2021-04-22
 */
public interface InvoiceMapper extends InvoiceBaseMapper {
    /**
     * 通用查询，支持字段id,unitId
     * @param invoice 开票管理
     * @return 开票管理列表
     */
    default List<Invoice> commonQuery(Invoice invoice) {
        return this.select(c->c.where(InvoiceDynamicSqlSupport.id, SqlBuilder.isEqualToWhenPresent(invoice.getId()))
                .and(InvoiceDynamicSqlSupport.unitId,SqlBuilder.isEqualToWhenPresent(invoice.getUnitId())));
    }
}
