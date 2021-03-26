package com.hyd.financial.dao;

import static com.hyd.financial.dao.TicketClaimTicketDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.hyd.financial.entity.TicketClaimTicket;
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
public interface TicketClaimTicketBaseMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, ticketClaimId, ticketId, number, price, version);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<TicketClaimTicket> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<TicketClaimTicket> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TicketClaimTicketResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="ticket_claim_id", property="ticketClaimId", jdbcType=JdbcType.BIGINT),
        @Result(column="ticket_id", property="ticketId", jdbcType=JdbcType.BIGINT),
        @Result(column="number", property="number", jdbcType=JdbcType.BIGINT),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="version", property="version", jdbcType=JdbcType.BIGINT)
    })
    List<TicketClaimTicket> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TicketClaimTicketResult")
    Optional<TicketClaimTicket> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, ticketClaimTicket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, ticketClaimTicket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(TicketClaimTicket record) {
        return MyBatis3Utils.insert(this::insert, record, ticketClaimTicket, c ->
            c.map(id).toProperty("id")
            .map(ticketClaimId).toProperty("ticketClaimId")
            .map(ticketId).toProperty("ticketId")
            .map(number).toProperty("number")
            .map(price).toProperty("price")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<TicketClaimTicket> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, ticketClaimTicket, c ->
            c.map(id).toProperty("id")
            .map(ticketClaimId).toProperty("ticketClaimId")
            .map(ticketId).toProperty("ticketId")
            .map(number).toProperty("number")
            .map(price).toProperty("price")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(TicketClaimTicket record) {
        return MyBatis3Utils.insert(this::insert, record, ticketClaimTicket, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(ticketClaimId).toPropertyWhenPresent("ticketClaimId", record::getTicketClaimId)
            .map(ticketId).toPropertyWhenPresent("ticketId", record::getTicketId)
            .map(number).toPropertyWhenPresent("number", record::getNumber)
            .map(price).toPropertyWhenPresent("price", record::getPrice)
            .map(version).toPropertyWhenPresent("version", record::getVersion)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<TicketClaimTicket> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, ticketClaimTicket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<TicketClaimTicket> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, ticketClaimTicket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<TicketClaimTicket> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, ticketClaimTicket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<TicketClaimTicket> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, ticketClaimTicket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(TicketClaimTicket record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(ticketClaimId).equalTo(record::getTicketClaimId)
                .set(ticketId).equalTo(record::getTicketId)
                .set(number).equalTo(record::getNumber)
                .set(price).equalTo(record::getPrice)
                .set(version).equalTo(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(TicketClaimTicket record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(ticketClaimId).equalToWhenPresent(record::getTicketClaimId)
                .set(ticketId).equalToWhenPresent(record::getTicketId)
                .set(number).equalToWhenPresent(record::getNumber)
                .set(price).equalToWhenPresent(record::getPrice)
                .set(version).equalToWhenPresent(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(TicketClaimTicket record) {
        return update(c ->
            c.set(ticketClaimId).equalTo(record::getTicketClaimId)
            .set(ticketId).equalTo(record::getTicketId)
            .set(number).equalTo(record::getNumber)
            .set(price).equalTo(record::getPrice)
            .set(version).equalTo(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(TicketClaimTicket record) {
        return update(c ->
            c.set(ticketClaimId).equalToWhenPresent(record::getTicketClaimId)
            .set(ticketId).equalToWhenPresent(record::getTicketId)
            .set(number).equalToWhenPresent(record::getNumber)
            .set(price).equalToWhenPresent(record::getPrice)
            .set(version).equalToWhenPresent(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }
}