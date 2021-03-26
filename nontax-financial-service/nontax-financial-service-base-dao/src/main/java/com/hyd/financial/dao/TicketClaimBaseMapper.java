package com.hyd.financial.dao;

import static com.hyd.financial.dao.TicketClaimDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.hyd.financial.entity.TicketClaim;
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
public interface TicketClaimBaseMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, orderNumber, userId, unitId, warehouseId, targetUnitId, date, totalPrice, opinion, status, version);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<TicketClaim> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<TicketClaim> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TicketClaimResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_number", property="orderNumber", jdbcType=JdbcType.BIGINT),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="unit_id", property="unitId", jdbcType=JdbcType.BIGINT),
        @Result(column="warehouse_id", property="warehouseId", jdbcType=JdbcType.BIGINT),
        @Result(column="target_unit_id", property="targetUnitId", jdbcType=JdbcType.BIGINT),
        @Result(column="date", property="date", jdbcType=JdbcType.VARCHAR),
        @Result(column="total_price", property="totalPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="opinion", property="opinion", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.BIGINT)
    })
    List<TicketClaim> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TicketClaimResult")
    Optional<TicketClaim> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, ticketClaim, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, ticketClaim, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(TicketClaim record) {
        return MyBatis3Utils.insert(this::insert, record, ticketClaim, c ->
            c.map(id).toProperty("id")
            .map(orderNumber).toProperty("orderNumber")
            .map(userId).toProperty("userId")
            .map(unitId).toProperty("unitId")
            .map(warehouseId).toProperty("warehouseId")
            .map(targetUnitId).toProperty("targetUnitId")
            .map(date).toProperty("date")
            .map(totalPrice).toProperty("totalPrice")
            .map(opinion).toProperty("opinion")
            .map(status).toProperty("status")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<TicketClaim> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, ticketClaim, c ->
            c.map(id).toProperty("id")
            .map(orderNumber).toProperty("orderNumber")
            .map(userId).toProperty("userId")
            .map(unitId).toProperty("unitId")
            .map(warehouseId).toProperty("warehouseId")
            .map(targetUnitId).toProperty("targetUnitId")
            .map(date).toProperty("date")
            .map(totalPrice).toProperty("totalPrice")
            .map(opinion).toProperty("opinion")
            .map(status).toProperty("status")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(TicketClaim record) {
        return MyBatis3Utils.insert(this::insert, record, ticketClaim, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(orderNumber).toPropertyWhenPresent("orderNumber", record::getOrderNumber)
            .map(userId).toPropertyWhenPresent("userId", record::getUserId)
            .map(unitId).toPropertyWhenPresent("unitId", record::getUnitId)
            .map(warehouseId).toPropertyWhenPresent("warehouseId", record::getWarehouseId)
            .map(targetUnitId).toPropertyWhenPresent("targetUnitId", record::getTargetUnitId)
            .map(date).toPropertyWhenPresent("date", record::getDate)
            .map(totalPrice).toPropertyWhenPresent("totalPrice", record::getTotalPrice)
            .map(opinion).toPropertyWhenPresent("opinion", record::getOpinion)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
            .map(version).toPropertyWhenPresent("version", record::getVersion)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<TicketClaim> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, ticketClaim, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<TicketClaim> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, ticketClaim, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<TicketClaim> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, ticketClaim, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<TicketClaim> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, ticketClaim, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(TicketClaim record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(orderNumber).equalTo(record::getOrderNumber)
                .set(userId).equalTo(record::getUserId)
                .set(unitId).equalTo(record::getUnitId)
                .set(warehouseId).equalTo(record::getWarehouseId)
                .set(targetUnitId).equalTo(record::getTargetUnitId)
                .set(date).equalTo(record::getDate)
                .set(totalPrice).equalTo(record::getTotalPrice)
                .set(opinion).equalTo(record::getOpinion)
                .set(status).equalTo(record::getStatus)
                .set(version).equalTo(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(TicketClaim record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(orderNumber).equalToWhenPresent(record::getOrderNumber)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(unitId).equalToWhenPresent(record::getUnitId)
                .set(warehouseId).equalToWhenPresent(record::getWarehouseId)
                .set(targetUnitId).equalToWhenPresent(record::getTargetUnitId)
                .set(date).equalToWhenPresent(record::getDate)
                .set(totalPrice).equalToWhenPresent(record::getTotalPrice)
                .set(opinion).equalToWhenPresent(record::getOpinion)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(version).equalToWhenPresent(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(TicketClaim record) {
        return update(c ->
            c.set(orderNumber).equalTo(record::getOrderNumber)
            .set(userId).equalTo(record::getUserId)
            .set(unitId).equalTo(record::getUnitId)
            .set(warehouseId).equalTo(record::getWarehouseId)
            .set(targetUnitId).equalTo(record::getTargetUnitId)
            .set(date).equalTo(record::getDate)
            .set(totalPrice).equalTo(record::getTotalPrice)
            .set(opinion).equalTo(record::getOpinion)
            .set(status).equalTo(record::getStatus)
            .set(version).equalTo(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(TicketClaim record) {
        return update(c ->
            c.set(orderNumber).equalToWhenPresent(record::getOrderNumber)
            .set(userId).equalToWhenPresent(record::getUserId)
            .set(unitId).equalToWhenPresent(record::getUnitId)
            .set(warehouseId).equalToWhenPresent(record::getWarehouseId)
            .set(targetUnitId).equalToWhenPresent(record::getTargetUnitId)
            .set(date).equalToWhenPresent(record::getDate)
            .set(totalPrice).equalToWhenPresent(record::getTotalPrice)
            .set(opinion).equalToWhenPresent(record::getOpinion)
            .set(status).equalToWhenPresent(record::getStatus)
            .set(version).equalToWhenPresent(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }
}