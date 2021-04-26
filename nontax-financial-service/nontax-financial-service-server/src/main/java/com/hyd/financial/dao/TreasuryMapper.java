package com.hyd.financial.dao;
import java.util.List;
import org.mybatis.dynamic.sql.SqlBuilder;
import com.hyd.financial.entity.Treasury;
/**
 * 财政金库
 * @author huangyanduo
 * @date 2021-04-22
 */
public interface TreasuryMapper extends TreasuryBaseMapper {
    /**
     * 通用查询，支持字段id
     * @param treasury 财政金库
     * @return 财政金库列表
     */
    default List<Treasury> commonQuery(Treasury treasury) {
        return this.select(c->c.where(TreasuryDynamicSqlSupport.id, SqlBuilder.isEqualToWhenPresent(treasury.getId())));
    }
}
