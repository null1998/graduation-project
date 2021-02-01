package com.hyd.basedata.dao;

import static com.hyd.basedata.dao.TicketDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.hyd.basedata.entity.Ticket;
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
public interface TicketBaseMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, name, zoneId, dictionaryId, year, code, mnemonic, price, unitOfMeasurement, version);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Ticket> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Ticket> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TicketResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="zone_id", property="zoneId", jdbcType=JdbcType.BIGINT),
        @Result(column="dictionary_id", property="dictionaryId", jdbcType=JdbcType.BIGINT),
        @Result(column="year", property="year", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="mnemonic", property="mnemonic", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="unit_of_measurement", property="unitOfMeasurement", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.BIGINT)
    })
    List<Ticket> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TicketResult")
    Optional<Ticket> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, ticket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, ticket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Ticket record) {
        return MyBatis3Utils.insert(this::insert, record, ticket, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(zoneId).toProperty("zoneId")
            .map(dictionaryId).toProperty("dictionaryId")
            .map(year).toProperty("year")
            .map(code).toProperty("code")
            .map(mnemonic).toProperty("mnemonic")
            .map(price).toProperty("price")
            .map(unitOfMeasurement).toProperty("unitOfMeasurement")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Ticket> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, ticket, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(zoneId).toProperty("zoneId")
            .map(dictionaryId).toProperty("dictionaryId")
            .map(year).toProperty("year")
            .map(code).toProperty("code")
            .map(mnemonic).toProperty("mnemonic")
            .map(price).toProperty("price")
            .map(unitOfMeasurement).toProperty("unitOfMeasurement")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Ticket record) {
        return MyBatis3Utils.insert(this::insert, record, ticket, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(zoneId).toPropertyWhenPresent("zoneId", record::getZoneId)
            .map(dictionaryId).toPropertyWhenPresent("dictionaryId", record::getDictionaryId)
            .map(year).toPropertyWhenPresent("year", record::getYear)
            .map(code).toPropertyWhenPresent("code", record::getCode)
            .map(mnemonic).toPropertyWhenPresent("mnemonic", record::getMnemonic)
            .map(price).toPropertyWhenPresent("price", record::getPrice)
            .map(unitOfMeasurement).toPropertyWhenPresent("unitOfMeasurement", record::getUnitOfMeasurement)
            .map(version).toPropertyWhenPresent("version", record::getVersion)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Ticket> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, ticket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Ticket> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, ticket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Ticket> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, ticket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Ticket> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, ticket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Ticket record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(name).equalTo(record::getName)
                .set(zoneId).equalTo(record::getZoneId)
                .set(dictionaryId).equalTo(record::getDictionaryId)
                .set(year).equalTo(record::getYear)
                .set(code).equalTo(record::getCode)
                .set(mnemonic).equalTo(record::getMnemonic)
                .set(price).equalTo(record::getPrice)
                .set(unitOfMeasurement).equalTo(record::getUnitOfMeasurement)
                .set(version).equalTo(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Ticket record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(name).equalToWhenPresent(record::getName)
                .set(zoneId).equalToWhenPresent(record::getZoneId)
                .set(dictionaryId).equalToWhenPresent(record::getDictionaryId)
                .set(year).equalToWhenPresent(record::getYear)
                .set(code).equalToWhenPresent(record::getCode)
                .set(mnemonic).equalToWhenPresent(record::getMnemonic)
                .set(price).equalToWhenPresent(record::getPrice)
                .set(unitOfMeasurement).equalToWhenPresent(record::getUnitOfMeasurement)
                .set(version).equalToWhenPresent(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Ticket record) {
        return update(c ->
            c.set(name).equalTo(record::getName)
            .set(zoneId).equalTo(record::getZoneId)
            .set(dictionaryId).equalTo(record::getDictionaryId)
            .set(year).equalTo(record::getYear)
            .set(code).equalTo(record::getCode)
            .set(mnemonic).equalTo(record::getMnemonic)
            .set(price).equalTo(record::getPrice)
            .set(unitOfMeasurement).equalTo(record::getUnitOfMeasurement)
            .set(version).equalTo(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Ticket record) {
        return update(c ->
            c.set(name).equalToWhenPresent(record::getName)
            .set(zoneId).equalToWhenPresent(record::getZoneId)
            .set(dictionaryId).equalToWhenPresent(record::getDictionaryId)
            .set(year).equalToWhenPresent(record::getYear)
            .set(code).equalToWhenPresent(record::getCode)
            .set(mnemonic).equalToWhenPresent(record::getMnemonic)
            .set(price).equalToWhenPresent(record::getPrice)
            .set(unitOfMeasurement).equalToWhenPresent(record::getUnitOfMeasurement)
            .set(version).equalToWhenPresent(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }
}