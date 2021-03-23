package com.hyd.financial.dao;

import static com.hyd.financial.dao.TicketStoreRecordTicketDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.hyd.financial.entity.TicketStoreRecordTicket;
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
public interface TicketStoreRecordTicketBaseMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, ticketStoreRecordId, ticketId, startNumber, endNumber, number, version);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<TicketStoreRecordTicket> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<TicketStoreRecordTicket> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TicketStoreRecordTicketResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="ticket_store_record_id", property="ticketStoreRecordId", jdbcType=JdbcType.BIGINT),
        @Result(column="ticket_id", property="ticketId", jdbcType=JdbcType.BIGINT),
        @Result(column="start_number", property="startNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="end_number", property="endNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="number", property="number", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.BIGINT)
    })
    List<TicketStoreRecordTicket> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TicketStoreRecordTicketResult")
    Optional<TicketStoreRecordTicket> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, ticketStoreRecordTicket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, ticketStoreRecordTicket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(TicketStoreRecordTicket record) {
        return MyBatis3Utils.insert(this::insert, record, ticketStoreRecordTicket, c ->
            c.map(id).toProperty("id")
            .map(ticketStoreRecordId).toProperty("ticketStoreRecordId")
            .map(ticketId).toProperty("ticketId")
            .map(startNumber).toProperty("startNumber")
            .map(endNumber).toProperty("endNumber")
            .map(number).toProperty("number")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<TicketStoreRecordTicket> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, ticketStoreRecordTicket, c ->
            c.map(id).toProperty("id")
            .map(ticketStoreRecordId).toProperty("ticketStoreRecordId")
            .map(ticketId).toProperty("ticketId")
            .map(startNumber).toProperty("startNumber")
            .map(endNumber).toProperty("endNumber")
            .map(number).toProperty("number")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(TicketStoreRecordTicket record) {
        return MyBatis3Utils.insert(this::insert, record, ticketStoreRecordTicket, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(ticketStoreRecordId).toPropertyWhenPresent("ticketStoreRecordId", record::getTicketStoreRecordId)
            .map(ticketId).toPropertyWhenPresent("ticketId", record::getTicketId)
            .map(startNumber).toPropertyWhenPresent("startNumber", record::getStartNumber)
            .map(endNumber).toPropertyWhenPresent("endNumber", record::getEndNumber)
            .map(number).toPropertyWhenPresent("number", record::getNumber)
            .map(version).toPropertyWhenPresent("version", record::getVersion)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<TicketStoreRecordTicket> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, ticketStoreRecordTicket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<TicketStoreRecordTicket> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, ticketStoreRecordTicket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<TicketStoreRecordTicket> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, ticketStoreRecordTicket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<TicketStoreRecordTicket> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, ticketStoreRecordTicket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(TicketStoreRecordTicket record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(ticketStoreRecordId).equalTo(record::getTicketStoreRecordId)
                .set(ticketId).equalTo(record::getTicketId)
                .set(startNumber).equalTo(record::getStartNumber)
                .set(endNumber).equalTo(record::getEndNumber)
                .set(number).equalTo(record::getNumber)
                .set(version).equalTo(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(TicketStoreRecordTicket record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(ticketStoreRecordId).equalToWhenPresent(record::getTicketStoreRecordId)
                .set(ticketId).equalToWhenPresent(record::getTicketId)
                .set(startNumber).equalToWhenPresent(record::getStartNumber)
                .set(endNumber).equalToWhenPresent(record::getEndNumber)
                .set(number).equalToWhenPresent(record::getNumber)
                .set(version).equalToWhenPresent(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(TicketStoreRecordTicket record) {
        return update(c ->
            c.set(ticketStoreRecordId).equalTo(record::getTicketStoreRecordId)
            .set(ticketId).equalTo(record::getTicketId)
            .set(startNumber).equalTo(record::getStartNumber)
            .set(endNumber).equalTo(record::getEndNumber)
            .set(number).equalTo(record::getNumber)
            .set(version).equalTo(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(TicketStoreRecordTicket record) {
        return update(c ->
            c.set(ticketStoreRecordId).equalToWhenPresent(record::getTicketStoreRecordId)
            .set(ticketId).equalToWhenPresent(record::getTicketId)
            .set(startNumber).equalToWhenPresent(record::getStartNumber)
            .set(endNumber).equalToWhenPresent(record::getEndNumber)
            .set(number).equalToWhenPresent(record::getNumber)
            .set(version).equalToWhenPresent(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }
}