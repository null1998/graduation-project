package com.hyd.user.center.dao;

import static com.hyd.user.center.dao.PermissionDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.hyd.user.center.entity.Permission;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface PermissionBaseMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, name, action, url, method, version, remark);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Permission> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Permission> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PermissionResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="action", property="action", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="method", property="method", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.BIGINT),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    List<Permission> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PermissionResult")
    Optional<Permission> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, permission, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, permission, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Permission record) {
        return MyBatis3Utils.insert(this::insert, record, permission, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(action).toProperty("action")
            .map(url).toProperty("url")
            .map(method).toProperty("method")
            .map(version).toProperty("version")
            .map(remark).toProperty("remark")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Permission> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, permission, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(action).toProperty("action")
            .map(url).toProperty("url")
            .map(method).toProperty("method")
            .map(version).toProperty("version")
            .map(remark).toProperty("remark")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Permission record) {
        return MyBatis3Utils.insert(this::insert, record, permission, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(action).toPropertyWhenPresent("action", record::getAction)
            .map(url).toPropertyWhenPresent("url", record::getUrl)
            .map(method).toPropertyWhenPresent("method", record::getMethod)
            .map(version).toPropertyWhenPresent("version", record::getVersion)
            .map(remark).toPropertyWhenPresent("remark", record::getRemark)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Permission> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, permission, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Permission> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, permission, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Permission> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, permission, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Permission> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, permission, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Permission record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(name).equalTo(record::getName)
                .set(action).equalTo(record::getAction)
                .set(url).equalTo(record::getUrl)
                .set(method).equalTo(record::getMethod)
                .set(version).equalTo(record::getVersion)
                .set(remark).equalTo(record::getRemark);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Permission record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(name).equalToWhenPresent(record::getName)
                .set(action).equalToWhenPresent(record::getAction)
                .set(url).equalToWhenPresent(record::getUrl)
                .set(method).equalToWhenPresent(record::getMethod)
                .set(version).equalToWhenPresent(record::getVersion)
                .set(remark).equalToWhenPresent(record::getRemark);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Permission record) {
        return update(c ->
            c.set(name).equalTo(record::getName)
            .set(action).equalTo(record::getAction)
            .set(url).equalTo(record::getUrl)
            .set(method).equalTo(record::getMethod)
            .set(version).equalTo(record::getVersion)
            .set(remark).equalTo(record::getRemark)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Permission record) {
        return update(c ->
            c.set(name).equalToWhenPresent(record::getName)
            .set(action).equalToWhenPresent(record::getAction)
            .set(url).equalToWhenPresent(record::getUrl)
            .set(method).equalToWhenPresent(record::getMethod)
            .set(version).equalToWhenPresent(record::getVersion)
            .set(remark).equalToWhenPresent(record::getRemark)
            .where(id, isEqualTo(record::getId))
        );
    }
}