package com.hyd.financial.dao;

import static com.hyd.financial.dao.TicketOutRecordTicketDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.hyd.financial.entity.TicketOutRecordTicket;
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
public interface TicketOutRecordTicketBaseMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, ticketOutRecordId, ticketId, startNumber, endNumber, number, version);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<TicketOutRecordTicket> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<TicketOutRecordTicket> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TicketOutRecordTicketResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="ticket_out_record_id", property="ticketOutRecordId", jdbcType=JdbcType.BIGINT),
        @Result(column="ticket_id", property="ticketId", jdbcType=JdbcType.BIGINT),
        @Result(column="start_number", property="startNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="end_number", property="endNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="number", property="number", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.BIGINT)
    })
    List<TicketOutRecordTicket> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TicketOutRecordTicketResult")
    Optional<TicketOutRecordTicket> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, ticketOutRecordTicket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, ticketOutRecordTicket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(TicketOutRecordTicket record) {
        return MyBatis3Utils.insert(this::insert, record, ticketOutRecordTicket, c ->
            c.map(id).toProperty("id")
            .map(ticketOutRecordId).toProperty("ticketOutRecordId")
            .map(ticketId).toProperty("ticketId")
            .map(startNumber).toProperty("startNumber")
            .map(endNumber).toProperty("endNumber")
            .map(number).toProperty("number")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<TicketOutRecordTicket> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, ticketOutRecordTicket, c ->
            c.map(id).toProperty("id")
            .map(ticketOutRecordId).toProperty("ticketOutRecordId")
            .map(ticketId).toProperty("ticketId")
            .map(startNumber).toProperty("startNumber")
            .map(endNumber).toProperty("endNumber")
            .map(number).toProperty("number")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(TicketOutRecordTicket record) {
        return MyBatis3Utils.insert(this::insert, record, ticketOutRecordTicket, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(ticketOutRecordId).toPropertyWhenPresent("ticketOutRecordId", record::getTicketOutRecordId)
            .map(ticketId).toPropertyWhenPresent("ticketId", record::getTicketId)
            .map(startNumber).toPropertyWhenPresent("startNumber", record::getStartNumber)
            .map(endNumber).toPropertyWhenPresent("endNumber", record::getEndNumber)
            .map(number).toPropertyWhenPresent("number", record::getNumber)
            .map(version).toPropertyWhenPresent("version", record::getVersion)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<TicketOutRecordTicket> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, ticketOutRecordTicket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<TicketOutRecordTicket> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, ticketOutRecordTicket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<TicketOutRecordTicket> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, ticketOutRecordTicket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<TicketOutRecordTicket> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, ticketOutRecordTicket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(TicketOutRecordTicket record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(ticketOutRecordId).equalTo(record::getTicketOutRecordId)
                .set(ticketId).equalTo(record::getTicketId)
                .set(startNumber).equalTo(record::getStartNumber)
                .set(endNumber).equalTo(record::getEndNumber)
                .set(number).equalTo(record::getNumber)
                .set(version).equalTo(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(TicketOutRecordTicket record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(ticketOutRecordId).equalToWhenPresent(record::getTicketOutRecordId)
                .set(ticketId).equalToWhenPresent(record::getTicketId)
                .set(startNumber).equalToWhenPresent(record::getStartNumber)
                .set(endNumber).equalToWhenPresent(record::getEndNumber)
                .set(number).equalToWhenPresent(record::getNumber)
                .set(version).equalToWhenPresent(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(TicketOutRecordTicket record) {
        return update(c ->
            c.set(ticketOutRecordId).equalTo(record::getTicketOutRecordId)
            .set(ticketId).equalTo(record::getTicketId)
            .set(startNumber).equalTo(record::getStartNumber)
            .set(endNumber).equalTo(record::getEndNumber)
            .set(number).equalTo(record::getNumber)
            .set(version).equalTo(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(TicketOutRecordTicket record) {
        return update(c ->
            c.set(ticketOutRecordId).equalToWhenPresent(record::getTicketOutRecordId)
            .set(ticketId).equalToWhenPresent(record::getTicketId)
            .set(startNumber).equalToWhenPresent(record::getStartNumber)
            .set(endNumber).equalToWhenPresent(record::getEndNumber)
            .set(number).equalToWhenPresent(record::getNumber)
            .set(version).equalToWhenPresent(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }
}