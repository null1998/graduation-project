package com.hyd.basedata.dao;

import com.hyd.basedata.entity.Dictionary;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.select.join.EqualTo;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/3/14 17:40
 */
public interface DictionaryMapper extends DictionaryBaseMapper {
    default List<Dictionary> listByCategoryName(String categoryName){
        return this.select(c -> c.leftJoin(DictionaryCategoryDynamicSqlSupport.dictionaryCategory).on(DictionaryCategoryDynamicSqlSupport.id, new EqualTo(DictionaryDynamicSqlSupport.categoryId))
                .where(DictionaryCategoryDynamicSqlSupport.name, SqlBuilder.isEqualTo(categoryName)));
    }
}
