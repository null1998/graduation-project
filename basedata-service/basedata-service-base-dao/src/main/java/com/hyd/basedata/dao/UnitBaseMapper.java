package com.hyd.basedata.dao;

import static com.hyd.basedata.dao.UnitDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.hyd.basedata.entity.Unit;
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
public interface UnitBaseMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, name, code, mnemonic, master, taxNumber, faxNumber, telNumber, address, email, website, zoneId, parentId, version);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Unit> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Unit> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UnitResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="mnemonic", property="mnemonic", jdbcType=JdbcType.VARCHAR),
        @Result(column="master", property="master", jdbcType=JdbcType.VARCHAR),
        @Result(column="tax_number", property="taxNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="fax_number", property="faxNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel_number", property="telNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="website", property="website", jdbcType=JdbcType.VARCHAR),
        @Result(column="zone_id", property="zoneId", jdbcType=JdbcType.BIGINT),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.BIGINT)
    })
    List<Unit> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UnitResult")
    Optional<Unit> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, unit, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, unit, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Unit record) {
        return MyBatis3Utils.insert(this::insert, record, unit, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(code).toProperty("code")
            .map(mnemonic).toProperty("mnemonic")
            .map(master).toProperty("master")
            .map(taxNumber).toProperty("taxNumber")
            .map(faxNumber).toProperty("faxNumber")
            .map(telNumber).toProperty("telNumber")
            .map(address).toProperty("address")
            .map(email).toProperty("email")
            .map(website).toProperty("website")
            .map(zoneId).toProperty("zoneId")
            .map(parentId).toProperty("parentId")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Unit> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, unit, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(code).toProperty("code")
            .map(mnemonic).toProperty("mnemonic")
            .map(master).toProperty("master")
            .map(taxNumber).toProperty("taxNumber")
            .map(faxNumber).toProperty("faxNumber")
            .map(telNumber).toProperty("telNumber")
            .map(address).toProperty("address")
            .map(email).toProperty("email")
            .map(website).toProperty("website")
            .map(zoneId).toProperty("zoneId")
            .map(parentId).toProperty("parentId")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Unit record) {
        return MyBatis3Utils.insert(this::insert, record, unit, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(code).toPropertyWhenPresent("code", record::getCode)
            .map(mnemonic).toPropertyWhenPresent("mnemonic", record::getMnemonic)
            .map(master).toPropertyWhenPresent("master", record::getMaster)
            .map(taxNumber).toPropertyWhenPresent("taxNumber", record::getTaxNumber)
            .map(faxNumber).toPropertyWhenPresent("faxNumber", record::getFaxNumber)
            .map(telNumber).toPropertyWhenPresent("telNumber", record::getTelNumber)
            .map(address).toPropertyWhenPresent("address", record::getAddress)
            .map(email).toPropertyWhenPresent("email", record::getEmail)
            .map(website).toPropertyWhenPresent("website", record::getWebsite)
            .map(zoneId).toPropertyWhenPresent("zoneId", record::getZoneId)
            .map(parentId).toPropertyWhenPresent("parentId", record::getParentId)
            .map(version).toPropertyWhenPresent("version", record::getVersion)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Unit> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, unit, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Unit> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, unit, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Unit> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, unit, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Unit> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, unit, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Unit record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(name).equalTo(record::getName)
                .set(code).equalTo(record::getCode)
                .set(mnemonic).equalTo(record::getMnemonic)
                .set(master).equalTo(record::getMaster)
                .set(taxNumber).equalTo(record::getTaxNumber)
                .set(faxNumber).equalTo(record::getFaxNumber)
                .set(telNumber).equalTo(record::getTelNumber)
                .set(address).equalTo(record::getAddress)
                .set(email).equalTo(record::getEmail)
                .set(website).equalTo(record::getWebsite)
                .set(zoneId).equalTo(record::getZoneId)
                .set(parentId).equalTo(record::getParentId)
                .set(version).equalTo(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Unit record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(name).equalToWhenPresent(record::getName)
                .set(code).equalToWhenPresent(record::getCode)
                .set(mnemonic).equalToWhenPresent(record::getMnemonic)
                .set(master).equalToWhenPresent(record::getMaster)
                .set(taxNumber).equalToWhenPresent(record::getTaxNumber)
                .set(faxNumber).equalToWhenPresent(record::getFaxNumber)
                .set(telNumber).equalToWhenPresent(record::getTelNumber)
                .set(address).equalToWhenPresent(record::getAddress)
                .set(email).equalToWhenPresent(record::getEmail)
                .set(website).equalToWhenPresent(record::getWebsite)
                .set(zoneId).equalToWhenPresent(record::getZoneId)
                .set(parentId).equalToWhenPresent(record::getParentId)
                .set(version).equalToWhenPresent(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Unit record) {
        return update(c ->
            c.set(name).equalTo(record::getName)
            .set(code).equalTo(record::getCode)
            .set(mnemonic).equalTo(record::getMnemonic)
            .set(master).equalTo(record::getMaster)
            .set(taxNumber).equalTo(record::getTaxNumber)
            .set(faxNumber).equalTo(record::getFaxNumber)
            .set(telNumber).equalTo(record::getTelNumber)
            .set(address).equalTo(record::getAddress)
            .set(email).equalTo(record::getEmail)
            .set(website).equalTo(record::getWebsite)
            .set(zoneId).equalTo(record::getZoneId)
            .set(parentId).equalTo(record::getParentId)
            .set(version).equalTo(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Unit record) {
        return update(c ->
            c.set(name).equalToWhenPresent(record::getName)
            .set(code).equalToWhenPresent(record::getCode)
            .set(mnemonic).equalToWhenPresent(record::getMnemonic)
            .set(master).equalToWhenPresent(record::getMaster)
            .set(taxNumber).equalToWhenPresent(record::getTaxNumber)
            .set(faxNumber).equalToWhenPresent(record::getFaxNumber)
            .set(telNumber).equalToWhenPresent(record::getTelNumber)
            .set(address).equalToWhenPresent(record::getAddress)
            .set(email).equalToWhenPresent(record::getEmail)
            .set(website).equalToWhenPresent(record::getWebsite)
            .set(zoneId).equalToWhenPresent(record::getZoneId)
            .set(parentId).equalToWhenPresent(record::getParentId)
            .set(version).equalToWhenPresent(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }
}