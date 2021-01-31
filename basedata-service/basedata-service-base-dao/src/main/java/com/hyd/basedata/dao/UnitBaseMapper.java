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
    BasicColumn[] selectList = BasicColumn.columnList(id, parentUnit, name, code, unitSort, parentDepartment, unitType, printStatus, mnemonicCode, master, tax, fax, tel, address, email, website, remark, tenantId, zoneId, createdBy, creator, createdTime, updatedBy, modifier, updatedTime, status, version);

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
        @Result(column="parent_unit", property="parentUnit", jdbcType=JdbcType.BIGINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="unit_sort", property="unitSort", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_department", property="parentDepartment", jdbcType=JdbcType.VARCHAR),
        @Result(column="unit_type", property="unitType", jdbcType=JdbcType.VARCHAR),
        @Result(column="print_status", property="printStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="mnemonic_code", property="mnemonicCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="master", property="master", jdbcType=JdbcType.VARCHAR),
        @Result(column="tax", property="tax", jdbcType=JdbcType.VARCHAR),
        @Result(column="fax", property="fax", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="website", property="website", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="tenant_id", property="tenantId", jdbcType=JdbcType.BIGINT),
        @Result(column="zone_id", property="zoneId", jdbcType=JdbcType.BIGINT),
        @Result(column="created_by", property="createdBy", jdbcType=JdbcType.BIGINT),
        @Result(column="creator", property="creator", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updatedBy", jdbcType=JdbcType.BIGINT),
        @Result(column="modifier", property="modifier", jdbcType=JdbcType.VARCHAR),
        @Result(column="updated_time", property="updatedTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
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
            .map(parentUnit).toProperty("parentUnit")
            .map(name).toProperty("name")
            .map(code).toProperty("code")
            .map(unitSort).toProperty("unitSort")
            .map(parentDepartment).toProperty("parentDepartment")
            .map(unitType).toProperty("unitType")
            .map(printStatus).toProperty("printStatus")
            .map(mnemonicCode).toProperty("mnemonicCode")
            .map(master).toProperty("master")
            .map(tax).toProperty("tax")
            .map(fax).toProperty("fax")
            .map(tel).toProperty("tel")
            .map(address).toProperty("address")
            .map(email).toProperty("email")
            .map(website).toProperty("website")
            .map(remark).toProperty("remark")
            .map(tenantId).toProperty("tenantId")
            .map(zoneId).toProperty("zoneId")
            .map(createdBy).toProperty("createdBy")
            .map(creator).toProperty("creator")
            .map(createdTime).toProperty("createdTime")
            .map(updatedBy).toProperty("updatedBy")
            .map(modifier).toProperty("modifier")
            .map(updatedTime).toProperty("updatedTime")
            .map(status).toProperty("status")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Unit> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, unit, c ->
            c.map(id).toProperty("id")
            .map(parentUnit).toProperty("parentUnit")
            .map(name).toProperty("name")
            .map(code).toProperty("code")
            .map(unitSort).toProperty("unitSort")
            .map(parentDepartment).toProperty("parentDepartment")
            .map(unitType).toProperty("unitType")
            .map(printStatus).toProperty("printStatus")
            .map(mnemonicCode).toProperty("mnemonicCode")
            .map(master).toProperty("master")
            .map(tax).toProperty("tax")
            .map(fax).toProperty("fax")
            .map(tel).toProperty("tel")
            .map(address).toProperty("address")
            .map(email).toProperty("email")
            .map(website).toProperty("website")
            .map(remark).toProperty("remark")
            .map(tenantId).toProperty("tenantId")
            .map(zoneId).toProperty("zoneId")
            .map(createdBy).toProperty("createdBy")
            .map(creator).toProperty("creator")
            .map(createdTime).toProperty("createdTime")
            .map(updatedBy).toProperty("updatedBy")
            .map(modifier).toProperty("modifier")
            .map(updatedTime).toProperty("updatedTime")
            .map(status).toProperty("status")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Unit record) {
        return MyBatis3Utils.insert(this::insert, record, unit, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(parentUnit).toPropertyWhenPresent("parentUnit", record::getParentUnit)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(code).toPropertyWhenPresent("code", record::getCode)
            .map(unitSort).toPropertyWhenPresent("unitSort", record::getUnitSort)
            .map(parentDepartment).toPropertyWhenPresent("parentDepartment", record::getParentDepartment)
            .map(unitType).toPropertyWhenPresent("unitType", record::getUnitType)
            .map(printStatus).toPropertyWhenPresent("printStatus", record::getPrintStatus)
            .map(mnemonicCode).toPropertyWhenPresent("mnemonicCode", record::getMnemonicCode)
            .map(master).toPropertyWhenPresent("master", record::getMaster)
            .map(tax).toPropertyWhenPresent("tax", record::getTax)
            .map(fax).toPropertyWhenPresent("fax", record::getFax)
            .map(tel).toPropertyWhenPresent("tel", record::getTel)
            .map(address).toPropertyWhenPresent("address", record::getAddress)
            .map(email).toPropertyWhenPresent("email", record::getEmail)
            .map(website).toPropertyWhenPresent("website", record::getWebsite)
            .map(remark).toPropertyWhenPresent("remark", record::getRemark)
            .map(tenantId).toPropertyWhenPresent("tenantId", record::getTenantId)
            .map(zoneId).toPropertyWhenPresent("zoneId", record::getZoneId)
            .map(createdBy).toPropertyWhenPresent("createdBy", record::getCreatedBy)
            .map(creator).toPropertyWhenPresent("creator", record::getCreator)
            .map(createdTime).toPropertyWhenPresent("createdTime", record::getCreatedTime)
            .map(updatedBy).toPropertyWhenPresent("updatedBy", record::getUpdatedBy)
            .map(modifier).toPropertyWhenPresent("modifier", record::getModifier)
            .map(updatedTime).toPropertyWhenPresent("updatedTime", record::getUpdatedTime)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
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
                .set(parentUnit).equalTo(record::getParentUnit)
                .set(name).equalTo(record::getName)
                .set(code).equalTo(record::getCode)
                .set(unitSort).equalTo(record::getUnitSort)
                .set(parentDepartment).equalTo(record::getParentDepartment)
                .set(unitType).equalTo(record::getUnitType)
                .set(printStatus).equalTo(record::getPrintStatus)
                .set(mnemonicCode).equalTo(record::getMnemonicCode)
                .set(master).equalTo(record::getMaster)
                .set(tax).equalTo(record::getTax)
                .set(fax).equalTo(record::getFax)
                .set(tel).equalTo(record::getTel)
                .set(address).equalTo(record::getAddress)
                .set(email).equalTo(record::getEmail)
                .set(website).equalTo(record::getWebsite)
                .set(remark).equalTo(record::getRemark)
                .set(tenantId).equalTo(record::getTenantId)
                .set(zoneId).equalTo(record::getZoneId)
                .set(createdBy).equalTo(record::getCreatedBy)
                .set(creator).equalTo(record::getCreator)
                .set(createdTime).equalTo(record::getCreatedTime)
                .set(updatedBy).equalTo(record::getUpdatedBy)
                .set(modifier).equalTo(record::getModifier)
                .set(updatedTime).equalTo(record::getUpdatedTime)
                .set(status).equalTo(record::getStatus)
                .set(version).equalTo(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Unit record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(parentUnit).equalToWhenPresent(record::getParentUnit)
                .set(name).equalToWhenPresent(record::getName)
                .set(code).equalToWhenPresent(record::getCode)
                .set(unitSort).equalToWhenPresent(record::getUnitSort)
                .set(parentDepartment).equalToWhenPresent(record::getParentDepartment)
                .set(unitType).equalToWhenPresent(record::getUnitType)
                .set(printStatus).equalToWhenPresent(record::getPrintStatus)
                .set(mnemonicCode).equalToWhenPresent(record::getMnemonicCode)
                .set(master).equalToWhenPresent(record::getMaster)
                .set(tax).equalToWhenPresent(record::getTax)
                .set(fax).equalToWhenPresent(record::getFax)
                .set(tel).equalToWhenPresent(record::getTel)
                .set(address).equalToWhenPresent(record::getAddress)
                .set(email).equalToWhenPresent(record::getEmail)
                .set(website).equalToWhenPresent(record::getWebsite)
                .set(remark).equalToWhenPresent(record::getRemark)
                .set(tenantId).equalToWhenPresent(record::getTenantId)
                .set(zoneId).equalToWhenPresent(record::getZoneId)
                .set(createdBy).equalToWhenPresent(record::getCreatedBy)
                .set(creator).equalToWhenPresent(record::getCreator)
                .set(createdTime).equalToWhenPresent(record::getCreatedTime)
                .set(updatedBy).equalToWhenPresent(record::getUpdatedBy)
                .set(modifier).equalToWhenPresent(record::getModifier)
                .set(updatedTime).equalToWhenPresent(record::getUpdatedTime)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(version).equalToWhenPresent(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Unit record) {
        return update(c ->
            c.set(parentUnit).equalTo(record::getParentUnit)
            .set(name).equalTo(record::getName)
            .set(code).equalTo(record::getCode)
            .set(unitSort).equalTo(record::getUnitSort)
            .set(parentDepartment).equalTo(record::getParentDepartment)
            .set(unitType).equalTo(record::getUnitType)
            .set(printStatus).equalTo(record::getPrintStatus)
            .set(mnemonicCode).equalTo(record::getMnemonicCode)
            .set(master).equalTo(record::getMaster)
            .set(tax).equalTo(record::getTax)
            .set(fax).equalTo(record::getFax)
            .set(tel).equalTo(record::getTel)
            .set(address).equalTo(record::getAddress)
            .set(email).equalTo(record::getEmail)
            .set(website).equalTo(record::getWebsite)
            .set(remark).equalTo(record::getRemark)
            .set(tenantId).equalTo(record::getTenantId)
            .set(zoneId).equalTo(record::getZoneId)
            .set(createdBy).equalTo(record::getCreatedBy)
            .set(creator).equalTo(record::getCreator)
            .set(createdTime).equalTo(record::getCreatedTime)
            .set(updatedBy).equalTo(record::getUpdatedBy)
            .set(modifier).equalTo(record::getModifier)
            .set(updatedTime).equalTo(record::getUpdatedTime)
            .set(status).equalTo(record::getStatus)
            .set(version).equalTo(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Unit record) {
        return update(c ->
            c.set(parentUnit).equalToWhenPresent(record::getParentUnit)
            .set(name).equalToWhenPresent(record::getName)
            .set(code).equalToWhenPresent(record::getCode)
            .set(unitSort).equalToWhenPresent(record::getUnitSort)
            .set(parentDepartment).equalToWhenPresent(record::getParentDepartment)
            .set(unitType).equalToWhenPresent(record::getUnitType)
            .set(printStatus).equalToWhenPresent(record::getPrintStatus)
            .set(mnemonicCode).equalToWhenPresent(record::getMnemonicCode)
            .set(master).equalToWhenPresent(record::getMaster)
            .set(tax).equalToWhenPresent(record::getTax)
            .set(fax).equalToWhenPresent(record::getFax)
            .set(tel).equalToWhenPresent(record::getTel)
            .set(address).equalToWhenPresent(record::getAddress)
            .set(email).equalToWhenPresent(record::getEmail)
            .set(website).equalToWhenPresent(record::getWebsite)
            .set(remark).equalToWhenPresent(record::getRemark)
            .set(tenantId).equalToWhenPresent(record::getTenantId)
            .set(zoneId).equalToWhenPresent(record::getZoneId)
            .set(createdBy).equalToWhenPresent(record::getCreatedBy)
            .set(creator).equalToWhenPresent(record::getCreator)
            .set(createdTime).equalToWhenPresent(record::getCreatedTime)
            .set(updatedBy).equalToWhenPresent(record::getUpdatedBy)
            .set(modifier).equalToWhenPresent(record::getModifier)
            .set(updatedTime).equalToWhenPresent(record::getUpdatedTime)
            .set(status).equalToWhenPresent(record::getStatus)
            .set(version).equalToWhenPresent(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }
}