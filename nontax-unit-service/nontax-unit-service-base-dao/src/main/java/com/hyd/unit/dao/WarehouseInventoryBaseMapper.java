package com.hyd.unit.dao;

import static com.hyd.unit.dao.WarehouseInventoryDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.hyd.unit.entity.WarehouseInventory;
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
public interface WarehouseInventoryBaseMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, warehouseId, ticketId, number, price, start, end, version, status);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<WarehouseInventory> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<WarehouseInventory> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="WarehouseInventoryResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="warehouse_id", property="warehouseId", jdbcType=JdbcType.BIGINT),
        @Result(column="ticket_id", property="ticketId", jdbcType=JdbcType.BIGINT),
        @Result(column="number", property="number", jdbcType=JdbcType.BIGINT),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="start", property="start", jdbcType=JdbcType.VARCHAR),
        @Result(column="end", property="end", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<WarehouseInventory> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("WarehouseInventoryResult")
    Optional<WarehouseInventory> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, warehouseInventory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, warehouseInventory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(WarehouseInventory record) {
        return MyBatis3Utils.insert(this::insert, record, warehouseInventory, c ->
            c.map(id).toProperty("id")
            .map(warehouseId).toProperty("warehouseId")
            .map(ticketId).toProperty("ticketId")
            .map(number).toProperty("number")
            .map(price).toProperty("price")
            .map(start).toProperty("start")
            .map(end).toProperty("end")
            .map(version).toProperty("version")
            .map(status).toProperty("status")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<WarehouseInventory> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, warehouseInventory, c ->
            c.map(id).toProperty("id")
            .map(warehouseId).toProperty("warehouseId")
            .map(ticketId).toProperty("ticketId")
            .map(number).toProperty("number")
            .map(price).toProperty("price")
            .map(start).toProperty("start")
            .map(end).toProperty("end")
            .map(version).toProperty("version")
            .map(status).toProperty("status")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(WarehouseInventory record) {
        return MyBatis3Utils.insert(this::insert, record, warehouseInventory, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(warehouseId).toPropertyWhenPresent("warehouseId", record::getWarehouseId)
            .map(ticketId).toPropertyWhenPresent("ticketId", record::getTicketId)
            .map(number).toPropertyWhenPresent("number", record::getNumber)
            .map(price).toPropertyWhenPresent("price", record::getPrice)
            .map(start).toPropertyWhenPresent("start", record::getStart)
            .map(end).toPropertyWhenPresent("end", record::getEnd)
            .map(version).toPropertyWhenPresent("version", record::getVersion)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<WarehouseInventory> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, warehouseInventory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<WarehouseInventory> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, warehouseInventory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<WarehouseInventory> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, warehouseInventory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<WarehouseInventory> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, warehouseInventory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(WarehouseInventory record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(warehouseId).equalTo(record::getWarehouseId)
                .set(ticketId).equalTo(record::getTicketId)
                .set(number).equalTo(record::getNumber)
                .set(price).equalTo(record::getPrice)
                .set(start).equalTo(record::getStart)
                .set(end).equalTo(record::getEnd)
                .set(version).equalTo(record::getVersion)
                .set(status).equalTo(record::getStatus);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(WarehouseInventory record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(warehouseId).equalToWhenPresent(record::getWarehouseId)
                .set(ticketId).equalToWhenPresent(record::getTicketId)
                .set(number).equalToWhenPresent(record::getNumber)
                .set(price).equalToWhenPresent(record::getPrice)
                .set(start).equalToWhenPresent(record::getStart)
                .set(end).equalToWhenPresent(record::getEnd)
                .set(version).equalToWhenPresent(record::getVersion)
                .set(status).equalToWhenPresent(record::getStatus);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(WarehouseInventory record) {
        return update(c ->
            c.set(warehouseId).equalTo(record::getWarehouseId)
            .set(ticketId).equalTo(record::getTicketId)
            .set(number).equalTo(record::getNumber)
            .set(price).equalTo(record::getPrice)
            .set(start).equalTo(record::getStart)
            .set(end).equalTo(record::getEnd)
            .set(version).equalTo(record::getVersion)
            .set(status).equalTo(record::getStatus)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(WarehouseInventory record) {
        return update(c ->
            c.set(warehouseId).equalToWhenPresent(record::getWarehouseId)
            .set(ticketId).equalToWhenPresent(record::getTicketId)
            .set(number).equalToWhenPresent(record::getNumber)
            .set(price).equalToWhenPresent(record::getPrice)
            .set(start).equalToWhenPresent(record::getStart)
            .set(end).equalToWhenPresent(record::getEnd)
            .set(version).equalToWhenPresent(record::getVersion)
            .set(status).equalToWhenPresent(record::getStatus)
            .where(id, isEqualTo(record::getId))
        );
    }
}