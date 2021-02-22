package com.hyd.basedata.dao;

import com.hyd.basedata.entity.Unit;
import org.mybatis.dynamic.sql.SqlBuilder;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/2 11:24
 */
public interface UnitMapper extends UnitBaseMapper {
    /**
     * 根据父单位ID查询
     * @param parentId 父单位ID
     * @return 单位列表
     */
    default List<Unit> listUnitByParentId(Long parentId) {
        return this.select(c -> c.where(UnitDynamicSqlSupport.parentId, SqlBuilder.isEqualTo(parentId)));
    }

}
