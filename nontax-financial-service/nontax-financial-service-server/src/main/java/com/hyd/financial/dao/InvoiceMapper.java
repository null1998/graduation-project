package com.hyd.financial.dao;
import java.util.List;
import org.mybatis.dynamic.sql.SqlBuilder;
import com.hyd.financial.entity.Invoice;
/**
 * 开票管理
 * @author huangyanduo
 * @date 2021-04-22
 */
public interface InvoiceMapper extends InvoiceBaseMapper {
    /**
     * 通用查询，支持字段id
     * @param invoice 开票管理
     * @return 开票管理列表
     */
    default List<Invoice> commonQuery(Invoice invoice) {
        return this.select(c->c.where(InvoiceDynamicSqlSupport.id, SqlBuilder.isEqualToWhenPresent(invoice.getId())));
    }
}
