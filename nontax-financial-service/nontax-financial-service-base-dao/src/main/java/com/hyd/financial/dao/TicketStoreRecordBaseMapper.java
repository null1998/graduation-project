package com.hyd.financial.dao;

import static com.hyd.financial.dao.TicketStoreRecordDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.hyd.financial.entity.TicketStoreRecord;
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
public interface TicketStoreRecordBaseMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, orderNumber, sourceOrderNumber, unitId, sourceUnitId, sourceWarehouseId, version);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<TicketStoreRecord> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<TicketStoreRecord> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TicketStoreRecordResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_number", property="orderNumber", jdbcType=JdbcType.BIGINT),
        @Result(column="source_order_number", property="sourceOrderNumber", jdbcType=JdbcType.BIGINT),
        @Result(column="unit_id", property="unitId", jdbcType=JdbcType.BIGINT),
        @Result(column="source_unit_id", property="sourceUnitId", jdbcType=JdbcType.BIGINT),
        @Result(column="source_warehouse_id", property="sourceWarehouseId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.BIGINT)
    })
    List<TicketStoreRecord> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TicketStoreRecordResult")
    Optional<TicketStoreRecord> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, ticketStoreRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, ticketStoreRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(TicketStoreRecord record) {
        return MyBatis3Utils.insert(this::insert, record, ticketStoreRecord, c ->
            c.map(id).toProperty("id")
            .map(orderNumber).toProperty("orderNumber")
            .map(sourceOrderNumber).toProperty("sourceOrderNumber")
            .map(unitId).toProperty("unitId")
            .map(sourceUnitId).toProperty("sourceUnitId")
            .map(sourceWarehouseId).toProperty("sourceWarehouseId")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<TicketStoreRecord> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, ticketStoreRecord, c ->
            c.map(id).toProperty("id")
            .map(orderNumber).toProperty("orderNumber")
            .map(sourceOrderNumber).toProperty("sourceOrderNumber")
            .map(unitId).toProperty("unitId")
            .map(sourceUnitId).toProperty("sourceUnitId")
            .map(sourceWarehouseId).toProperty("sourceWarehouseId")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(TicketStoreRecord record) {
        return MyBatis3Utils.insert(this::insert, record, ticketStoreRecord, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(orderNumber).toPropertyWhenPresent("orderNumber", record::getOrderNumber)
            .map(sourceOrderNumber).toPropertyWhenPresent("sourceOrderNumber", record::getSourceOrderNumber)
            .map(unitId).toPropertyWhenPresent("unitId", record::getUnitId)
            .map(sourceUnitId).toPropertyWhenPresent("sourceUnitId", record::getSourceUnitId)
            .map(sourceWarehouseId).toPropertyWhenPresent("sourceWarehouseId", record::getSourceWarehouseId)
            .map(version).toPropertyWhenPresent("version", record::getVersion)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<TicketStoreRecord> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, ticketStoreRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<TicketStoreRecord> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, ticketStoreRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<TicketStoreRecord> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, ticketStoreRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<TicketStoreRecord> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, ticketStoreRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(TicketStoreRecord record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(orderNumber).equalTo(record::getOrderNumber)
                .set(sourceOrderNumber).equalTo(record::getSourceOrderNumber)
                .set(unitId).equalTo(record::getUnitId)
                .set(sourceUnitId).equalTo(record::getSourceUnitId)
                .set(sourceWarehouseId).equalTo(record::getSourceWarehouseId)
                .set(version).equalTo(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(TicketStoreRecord record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(orderNumber).equalToWhenPresent(record::getOrderNumber)
                .set(sourceOrderNumber).equalToWhenPresent(record::getSourceOrderNumber)
                .set(unitId).equalToWhenPresent(record::getUnitId)
                .set(sourceUnitId).equalToWhenPresent(record::getSourceUnitId)
                .set(sourceWarehouseId).equalToWhenPresent(record::getSourceWarehouseId)
                .set(version).equalToWhenPresent(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(TicketStoreRecord record) {
        return update(c ->
            c.set(orderNumber).equalTo(record::getOrderNumber)
            .set(sourceOrderNumber).equalTo(record::getSourceOrderNumber)
            .set(unitId).equalTo(record::getUnitId)
            .set(sourceUnitId).equalTo(record::getSourceUnitId)
            .set(sourceWarehouseId).equalTo(record::getSourceWarehouseId)
            .set(version).equalTo(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(TicketStoreRecord record) {
        return update(c ->
            c.set(orderNumber).equalToWhenPresent(record::getOrderNumber)
            .set(sourceOrderNumber).equalToWhenPresent(record::getSourceOrderNumber)
            .set(unitId).equalToWhenPresent(record::getUnitId)
            .set(sourceUnitId).equalToWhenPresent(record::getSourceUnitId)
            .set(sourceWarehouseId).equalToWhenPresent(record::getSourceWarehouseId)
            .set(version).equalToWhenPresent(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }
}