package com.hyd.financial.dao;

import static com.hyd.financial.dao.TicketStoreDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.hyd.financial.entity.TicketStore;
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
public interface TicketStoreBaseMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, ticketId, unitId, warehouseId, startNumber, endNumber, number, userId, operateDate, version);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<TicketStore> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<TicketStore> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TicketStoreResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="ticket_id", property="ticketId", jdbcType=JdbcType.BIGINT),
        @Result(column="unit_id", property="unitId", jdbcType=JdbcType.BIGINT),
        @Result(column="warehouse_id", property="warehouseId", jdbcType=JdbcType.BIGINT),
        @Result(column="start_number", property="startNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="end_number", property="endNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="number", property="number", jdbcType=JdbcType.BIGINT),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="operate_date", property="operateDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.BIGINT)
    })
    List<TicketStore> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TicketStoreResult")
    Optional<TicketStore> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, ticketStore, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, ticketStore, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(TicketStore record) {
        return MyBatis3Utils.insert(this::insert, record, ticketStore, c ->
            c.map(id).toProperty("id")
            .map(ticketId).toProperty("ticketId")
            .map(unitId).toProperty("unitId")
            .map(warehouseId).toProperty("warehouseId")
            .map(startNumber).toProperty("startNumber")
            .map(endNumber).toProperty("endNumber")
            .map(number).toProperty("number")
            .map(userId).toProperty("userId")
            .map(operateDate).toProperty("operateDate")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<TicketStore> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, ticketStore, c ->
            c.map(id).toProperty("id")
            .map(ticketId).toProperty("ticketId")
            .map(unitId).toProperty("unitId")
            .map(warehouseId).toProperty("warehouseId")
            .map(startNumber).toProperty("startNumber")
            .map(endNumber).toProperty("endNumber")
            .map(number).toProperty("number")
            .map(userId).toProperty("userId")
            .map(operateDate).toProperty("operateDate")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(TicketStore record) {
        return MyBatis3Utils.insert(this::insert, record, ticketStore, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(ticketId).toPropertyWhenPresent("ticketId", record::getTicketId)
            .map(unitId).toPropertyWhenPresent("unitId", record::getUnitId)
            .map(warehouseId).toPropertyWhenPresent("warehouseId", record::getWarehouseId)
            .map(startNumber).toPropertyWhenPresent("startNumber", record::getStartNumber)
            .map(endNumber).toPropertyWhenPresent("endNumber", record::getEndNumber)
            .map(number).toPropertyWhenPresent("number", record::getNumber)
            .map(userId).toPropertyWhenPresent("userId", record::getUserId)
            .map(operateDate).toPropertyWhenPresent("operateDate", record::getOperateDate)
            .map(version).toPropertyWhenPresent("version", record::getVersion)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<TicketStore> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, ticketStore, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<TicketStore> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, ticketStore, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<TicketStore> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, ticketStore, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<TicketStore> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, ticketStore, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(TicketStore record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(ticketId).equalTo(record::getTicketId)
                .set(unitId).equalTo(record::getUnitId)
                .set(warehouseId).equalTo(record::getWarehouseId)
                .set(startNumber).equalTo(record::getStartNumber)
                .set(endNumber).equalTo(record::getEndNumber)
                .set(number).equalTo(record::getNumber)
                .set(userId).equalTo(record::getUserId)
                .set(operateDate).equalTo(record::getOperateDate)
                .set(version).equalTo(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(TicketStore record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(ticketId).equalToWhenPresent(record::getTicketId)
                .set(unitId).equalToWhenPresent(record::getUnitId)
                .set(warehouseId).equalToWhenPresent(record::getWarehouseId)
                .set(startNumber).equalToWhenPresent(record::getStartNumber)
                .set(endNumber).equalToWhenPresent(record::getEndNumber)
                .set(number).equalToWhenPresent(record::getNumber)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(operateDate).equalToWhenPresent(record::getOperateDate)
                .set(version).equalToWhenPresent(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(TicketStore record) {
        return update(c ->
            c.set(ticketId).equalTo(record::getTicketId)
            .set(unitId).equalTo(record::getUnitId)
            .set(warehouseId).equalTo(record::getWarehouseId)
            .set(startNumber).equalTo(record::getStartNumber)
            .set(endNumber).equalTo(record::getEndNumber)
            .set(number).equalTo(record::getNumber)
            .set(userId).equalTo(record::getUserId)
            .set(operateDate).equalTo(record::getOperateDate)
            .set(version).equalTo(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(TicketStore record) {
        return update(c ->
            c.set(ticketId).equalToWhenPresent(record::getTicketId)
            .set(unitId).equalToWhenPresent(record::getUnitId)
            .set(warehouseId).equalToWhenPresent(record::getWarehouseId)
            .set(startNumber).equalToWhenPresent(record::getStartNumber)
            .set(endNumber).equalToWhenPresent(record::getEndNumber)
            .set(number).equalToWhenPresent(record::getNumber)
            .set(userId).equalToWhenPresent(record::getUserId)
            .set(operateDate).equalToWhenPresent(record::getOperateDate)
            .set(version).equalToWhenPresent(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }
}