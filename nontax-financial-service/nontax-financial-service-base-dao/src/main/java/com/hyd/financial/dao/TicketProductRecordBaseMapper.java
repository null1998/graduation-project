package com.hyd.financial.dao;

import static com.hyd.financial.dao.TicketProductRecordDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.hyd.financial.entity.TicketProductRecord;
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
public interface TicketProductRecordBaseMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, orderNumber, printUnitId, ticketId, number, startNumber, endNumber, printOrderNumber, version, createdDate);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<TicketProductRecord> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<TicketProductRecord> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TicketProductRecordResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_number", property="orderNumber", jdbcType=JdbcType.BIGINT),
        @Result(column="print_unit_id", property="printUnitId", jdbcType=JdbcType.BIGINT),
        @Result(column="ticket_id", property="ticketId", jdbcType=JdbcType.BIGINT),
        @Result(column="number", property="number", jdbcType=JdbcType.INTEGER),
        @Result(column="start_number", property="startNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="end_number", property="endNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="print_order_number", property="printOrderNumber", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.BIGINT),
        @Result(column="created_date", property="createdDate", jdbcType=JdbcType.VARCHAR)
    })
    List<TicketProductRecord> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TicketProductRecordResult")
    Optional<TicketProductRecord> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, ticketProductRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, ticketProductRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(TicketProductRecord record) {
        return MyBatis3Utils.insert(this::insert, record, ticketProductRecord, c ->
            c.map(id).toProperty("id")
            .map(orderNumber).toProperty("orderNumber")
            .map(printUnitId).toProperty("printUnitId")
            .map(ticketId).toProperty("ticketId")
            .map(number).toProperty("number")
            .map(startNumber).toProperty("startNumber")
            .map(endNumber).toProperty("endNumber")
            .map(printOrderNumber).toProperty("printOrderNumber")
            .map(version).toProperty("version")
            .map(createdDate).toProperty("createdDate")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<TicketProductRecord> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, ticketProductRecord, c ->
            c.map(id).toProperty("id")
            .map(orderNumber).toProperty("orderNumber")
            .map(printUnitId).toProperty("printUnitId")
            .map(ticketId).toProperty("ticketId")
            .map(number).toProperty("number")
            .map(startNumber).toProperty("startNumber")
            .map(endNumber).toProperty("endNumber")
            .map(printOrderNumber).toProperty("printOrderNumber")
            .map(version).toProperty("version")
            .map(createdDate).toProperty("createdDate")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(TicketProductRecord record) {
        return MyBatis3Utils.insert(this::insert, record, ticketProductRecord, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(orderNumber).toPropertyWhenPresent("orderNumber", record::getOrderNumber)
            .map(printUnitId).toPropertyWhenPresent("printUnitId", record::getPrintUnitId)
            .map(ticketId).toPropertyWhenPresent("ticketId", record::getTicketId)
            .map(number).toPropertyWhenPresent("number", record::getNumber)
            .map(startNumber).toPropertyWhenPresent("startNumber", record::getStartNumber)
            .map(endNumber).toPropertyWhenPresent("endNumber", record::getEndNumber)
            .map(printOrderNumber).toPropertyWhenPresent("printOrderNumber", record::getPrintOrderNumber)
            .map(version).toPropertyWhenPresent("version", record::getVersion)
            .map(createdDate).toPropertyWhenPresent("createdDate", record::getCreatedDate)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<TicketProductRecord> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, ticketProductRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<TicketProductRecord> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, ticketProductRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<TicketProductRecord> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, ticketProductRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<TicketProductRecord> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, ticketProductRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(TicketProductRecord record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(orderNumber).equalTo(record::getOrderNumber)
                .set(printUnitId).equalTo(record::getPrintUnitId)
                .set(ticketId).equalTo(record::getTicketId)
                .set(number).equalTo(record::getNumber)
                .set(startNumber).equalTo(record::getStartNumber)
                .set(endNumber).equalTo(record::getEndNumber)
                .set(printOrderNumber).equalTo(record::getPrintOrderNumber)
                .set(version).equalTo(record::getVersion)
                .set(createdDate).equalTo(record::getCreatedDate);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(TicketProductRecord record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(orderNumber).equalToWhenPresent(record::getOrderNumber)
                .set(printUnitId).equalToWhenPresent(record::getPrintUnitId)
                .set(ticketId).equalToWhenPresent(record::getTicketId)
                .set(number).equalToWhenPresent(record::getNumber)
                .set(startNumber).equalToWhenPresent(record::getStartNumber)
                .set(endNumber).equalToWhenPresent(record::getEndNumber)
                .set(printOrderNumber).equalToWhenPresent(record::getPrintOrderNumber)
                .set(version).equalToWhenPresent(record::getVersion)
                .set(createdDate).equalToWhenPresent(record::getCreatedDate);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(TicketProductRecord record) {
        return update(c ->
            c.set(orderNumber).equalTo(record::getOrderNumber)
            .set(printUnitId).equalTo(record::getPrintUnitId)
            .set(ticketId).equalTo(record::getTicketId)
            .set(number).equalTo(record::getNumber)
            .set(startNumber).equalTo(record::getStartNumber)
            .set(endNumber).equalTo(record::getEndNumber)
            .set(printOrderNumber).equalTo(record::getPrintOrderNumber)
            .set(version).equalTo(record::getVersion)
            .set(createdDate).equalTo(record::getCreatedDate)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(TicketProductRecord record) {
        return update(c ->
            c.set(orderNumber).equalToWhenPresent(record::getOrderNumber)
            .set(printUnitId).equalToWhenPresent(record::getPrintUnitId)
            .set(ticketId).equalToWhenPresent(record::getTicketId)
            .set(number).equalToWhenPresent(record::getNumber)
            .set(startNumber).equalToWhenPresent(record::getStartNumber)
            .set(endNumber).equalToWhenPresent(record::getEndNumber)
            .set(printOrderNumber).equalToWhenPresent(record::getPrintOrderNumber)
            .set(version).equalToWhenPresent(record::getVersion)
            .set(createdDate).equalToWhenPresent(record::getCreatedDate)
            .where(id, isEqualTo(record::getId))
        );
    }
}