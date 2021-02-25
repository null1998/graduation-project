package com.hyd.unit.dao;

import static com.hyd.unit.dao.SettlementDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.hyd.unit.entity.Settlement;
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
public interface SettlementBaseMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, bussinessDictionaryId, bussinessOrderNumber, settlementDate, settlementUnit, settlementTypeDictionaryId, unitId, status, version);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Settlement> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Settlement> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="SettlementResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="bussiness_dictionary_id", property="bussinessDictionaryId", jdbcType=JdbcType.BIGINT),
        @Result(column="bussiness_order_number", property="bussinessOrderNumber", jdbcType=JdbcType.BIGINT),
        @Result(column="settlement_date", property="settlementDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="settlement_unit", property="settlementUnit", jdbcType=JdbcType.BIGINT),
        @Result(column="settlement_type_dictionary_id", property="settlementTypeDictionaryId", jdbcType=JdbcType.BIGINT),
        @Result(column="unit_id", property="unitId", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.BIGINT)
    })
    List<Settlement> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("SettlementResult")
    Optional<Settlement> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, settlement, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, settlement, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Settlement record) {
        return MyBatis3Utils.insert(this::insert, record, settlement, c ->
            c.map(id).toProperty("id")
            .map(bussinessDictionaryId).toProperty("bussinessDictionaryId")
            .map(bussinessOrderNumber).toProperty("bussinessOrderNumber")
            .map(settlementDate).toProperty("settlementDate")
            .map(settlementUnit).toProperty("settlementUnit")
            .map(settlementTypeDictionaryId).toProperty("settlementTypeDictionaryId")
            .map(unitId).toProperty("unitId")
            .map(status).toProperty("status")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Settlement> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, settlement, c ->
            c.map(id).toProperty("id")
            .map(bussinessDictionaryId).toProperty("bussinessDictionaryId")
            .map(bussinessOrderNumber).toProperty("bussinessOrderNumber")
            .map(settlementDate).toProperty("settlementDate")
            .map(settlementUnit).toProperty("settlementUnit")
            .map(settlementTypeDictionaryId).toProperty("settlementTypeDictionaryId")
            .map(unitId).toProperty("unitId")
            .map(status).toProperty("status")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Settlement record) {
        return MyBatis3Utils.insert(this::insert, record, settlement, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(bussinessDictionaryId).toPropertyWhenPresent("bussinessDictionaryId", record::getBussinessDictionaryId)
            .map(bussinessOrderNumber).toPropertyWhenPresent("bussinessOrderNumber", record::getBussinessOrderNumber)
            .map(settlementDate).toPropertyWhenPresent("settlementDate", record::getSettlementDate)
            .map(settlementUnit).toPropertyWhenPresent("settlementUnit", record::getSettlementUnit)
            .map(settlementTypeDictionaryId).toPropertyWhenPresent("settlementTypeDictionaryId", record::getSettlementTypeDictionaryId)
            .map(unitId).toPropertyWhenPresent("unitId", record::getUnitId)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
            .map(version).toPropertyWhenPresent("version", record::getVersion)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Settlement> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, settlement, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Settlement> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, settlement, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Settlement> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, settlement, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Settlement> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, settlement, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Settlement record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(bussinessDictionaryId).equalTo(record::getBussinessDictionaryId)
                .set(bussinessOrderNumber).equalTo(record::getBussinessOrderNumber)
                .set(settlementDate).equalTo(record::getSettlementDate)
                .set(settlementUnit).equalTo(record::getSettlementUnit)
                .set(settlementTypeDictionaryId).equalTo(record::getSettlementTypeDictionaryId)
                .set(unitId).equalTo(record::getUnitId)
                .set(status).equalTo(record::getStatus)
                .set(version).equalTo(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Settlement record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(bussinessDictionaryId).equalToWhenPresent(record::getBussinessDictionaryId)
                .set(bussinessOrderNumber).equalToWhenPresent(record::getBussinessOrderNumber)
                .set(settlementDate).equalToWhenPresent(record::getSettlementDate)
                .set(settlementUnit).equalToWhenPresent(record::getSettlementUnit)
                .set(settlementTypeDictionaryId).equalToWhenPresent(record::getSettlementTypeDictionaryId)
                .set(unitId).equalToWhenPresent(record::getUnitId)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(version).equalToWhenPresent(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Settlement record) {
        return update(c ->
            c.set(bussinessDictionaryId).equalTo(record::getBussinessDictionaryId)
            .set(bussinessOrderNumber).equalTo(record::getBussinessOrderNumber)
            .set(settlementDate).equalTo(record::getSettlementDate)
            .set(settlementUnit).equalTo(record::getSettlementUnit)
            .set(settlementTypeDictionaryId).equalTo(record::getSettlementTypeDictionaryId)
            .set(unitId).equalTo(record::getUnitId)
            .set(status).equalTo(record::getStatus)
            .set(version).equalTo(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Settlement record) {
        return update(c ->
            c.set(bussinessDictionaryId).equalToWhenPresent(record::getBussinessDictionaryId)
            .set(bussinessOrderNumber).equalToWhenPresent(record::getBussinessOrderNumber)
            .set(settlementDate).equalToWhenPresent(record::getSettlementDate)
            .set(settlementUnit).equalToWhenPresent(record::getSettlementUnit)
            .set(settlementTypeDictionaryId).equalToWhenPresent(record::getSettlementTypeDictionaryId)
            .set(unitId).equalToWhenPresent(record::getUnitId)
            .set(status).equalToWhenPresent(record::getStatus)
            .set(version).equalToWhenPresent(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }
}