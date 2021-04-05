package com.hyd.financial.dao;

import static com.hyd.financial.dao.TicketOutRecordDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.hyd.financial.entity.TicketOutRecord;
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
public interface TicketOutRecordBaseMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, orderNumber, targetOrderNumber, unitId, targetUnitId, outType, outDate, version);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<TicketOutRecord> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<TicketOutRecord> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TicketOutRecordResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_number", property="orderNumber", jdbcType=JdbcType.BIGINT),
        @Result(column="target_order_number", property="targetOrderNumber", jdbcType=JdbcType.BIGINT),
        @Result(column="unit_id", property="unitId", jdbcType=JdbcType.BIGINT),
        @Result(column="target_unit_id", property="targetUnitId", jdbcType=JdbcType.BIGINT),
        @Result(column="out_type", property="outType", jdbcType=JdbcType.VARCHAR),
        @Result(column="out_date", property="outDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.BIGINT)
    })
    List<TicketOutRecord> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TicketOutRecordResult")
    Optional<TicketOutRecord> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, ticketOutRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, ticketOutRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(TicketOutRecord record) {
        return MyBatis3Utils.insert(this::insert, record, ticketOutRecord, c ->
            c.map(id).toProperty("id")
            .map(orderNumber).toProperty("orderNumber")
            .map(targetOrderNumber).toProperty("targetOrderNumber")
            .map(unitId).toProperty("unitId")
            .map(targetUnitId).toProperty("targetUnitId")
            .map(outType).toProperty("outType")
            .map(outDate).toProperty("outDate")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<TicketOutRecord> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, ticketOutRecord, c ->
            c.map(id).toProperty("id")
            .map(orderNumber).toProperty("orderNumber")
            .map(targetOrderNumber).toProperty("targetOrderNumber")
            .map(unitId).toProperty("unitId")
            .map(targetUnitId).toProperty("targetUnitId")
            .map(outType).toProperty("outType")
            .map(outDate).toProperty("outDate")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(TicketOutRecord record) {
        return MyBatis3Utils.insert(this::insert, record, ticketOutRecord, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(orderNumber).toPropertyWhenPresent("orderNumber", record::getOrderNumber)
            .map(targetOrderNumber).toPropertyWhenPresent("targetOrderNumber", record::getTargetOrderNumber)
            .map(unitId).toPropertyWhenPresent("unitId", record::getUnitId)
            .map(targetUnitId).toPropertyWhenPresent("targetUnitId", record::getTargetUnitId)
            .map(outType).toPropertyWhenPresent("outType", record::getOutType)
            .map(outDate).toPropertyWhenPresent("outDate", record::getOutDate)
            .map(version).toPropertyWhenPresent("version", record::getVersion)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<TicketOutRecord> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, ticketOutRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<TicketOutRecord> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, ticketOutRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<TicketOutRecord> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, ticketOutRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<TicketOutRecord> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, ticketOutRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(TicketOutRecord record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(orderNumber).equalTo(record::getOrderNumber)
                .set(targetOrderNumber).equalTo(record::getTargetOrderNumber)
                .set(unitId).equalTo(record::getUnitId)
                .set(targetUnitId).equalTo(record::getTargetUnitId)
                .set(outType).equalTo(record::getOutType)
                .set(outDate).equalTo(record::getOutDate)
                .set(version).equalTo(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(TicketOutRecord record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(orderNumber).equalToWhenPresent(record::getOrderNumber)
                .set(targetOrderNumber).equalToWhenPresent(record::getTargetOrderNumber)
                .set(unitId).equalToWhenPresent(record::getUnitId)
                .set(targetUnitId).equalToWhenPresent(record::getTargetUnitId)
                .set(outType).equalToWhenPresent(record::getOutType)
                .set(outDate).equalToWhenPresent(record::getOutDate)
                .set(version).equalToWhenPresent(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(TicketOutRecord record) {
        return update(c ->
            c.set(orderNumber).equalTo(record::getOrderNumber)
            .set(targetOrderNumber).equalTo(record::getTargetOrderNumber)
            .set(unitId).equalTo(record::getUnitId)
            .set(targetUnitId).equalTo(record::getTargetUnitId)
            .set(outType).equalTo(record::getOutType)
            .set(outDate).equalTo(record::getOutDate)
            .set(version).equalTo(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(TicketOutRecord record) {
        return update(c ->
            c.set(orderNumber).equalToWhenPresent(record::getOrderNumber)
            .set(targetOrderNumber).equalToWhenPresent(record::getTargetOrderNumber)
            .set(unitId).equalToWhenPresent(record::getUnitId)
            .set(targetUnitId).equalToWhenPresent(record::getTargetUnitId)
            .set(outType).equalToWhenPresent(record::getOutType)
            .set(outDate).equalToWhenPresent(record::getOutDate)
            .set(version).equalToWhenPresent(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }
}