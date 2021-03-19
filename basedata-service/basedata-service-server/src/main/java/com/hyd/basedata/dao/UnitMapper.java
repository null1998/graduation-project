package com.hyd.basedata.dao;

import com.hyd.basedata.entity.Unit;
import org.mybatis.dynamic.sql.SqlBuilder;

import java.util.List;
import java.util.Optional;

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
    /**
     * 根据单位编码查询单位
     * @param code 单位编码
     * @return 单位
     */
    default Unit getByCode(String code){
        Optional<Unit> optional = this.selectOne(c -> c.where(UnitDynamicSqlSupport.code, SqlBuilder.isEqualTo(code)));
        return optional.orElseGet(Unit::new);
    }
    /**
     * 通用查询，根据字段id，zoneId，dictionaryId
     * @param unit
     * @return
     */
    default List<Unit> commonQuery(Unit unit) {
        return this.select(c->c.where(UnitDynamicSqlSupport.id,SqlBuilder.isEqualToWhenPresent(unit.getId()))
                .and(UnitDynamicSqlSupport.zoneId,SqlBuilder.isEqualToWhenPresent(unit.getZoneId()))
                .and(UnitDynamicSqlSupport.dictionaryId,SqlBuilder.isEqualToWhenPresent(unit.getDictionaryId())));
    }

}
