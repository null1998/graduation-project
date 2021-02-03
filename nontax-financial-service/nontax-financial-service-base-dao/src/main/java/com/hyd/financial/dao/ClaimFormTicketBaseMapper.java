package com.hyd.financial.dao;

import static com.hyd.financial.dao.ClaimFormTicketDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.hyd.financial.entity.ClaimFormTicket;
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
public interface ClaimFormTicketBaseMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, claimFormId, ticketId, number, price, start, end, version, warehouseInventoryId);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<ClaimFormTicket> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<ClaimFormTicket> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ClaimFormTicketResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="claim_form_id", property="claimFormId", jdbcType=JdbcType.BIGINT),
        @Result(column="ticket_id", property="ticketId", jdbcType=JdbcType.BIGINT),
        @Result(column="number", property="number", jdbcType=JdbcType.BIGINT),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="start", property="start", jdbcType=JdbcType.VARCHAR),
        @Result(column="end", property="end", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.BIGINT),
        @Result(column="warehouse_inventory_id", property="warehouseInventoryId", jdbcType=JdbcType.BIGINT)
    })
    List<ClaimFormTicket> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ClaimFormTicketResult")
    Optional<ClaimFormTicket> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, claimFormTicket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, claimFormTicket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(ClaimFormTicket record) {
        return MyBatis3Utils.insert(this::insert, record, claimFormTicket, c ->
            c.map(id).toProperty("id")
            .map(claimFormId).toProperty("claimFormId")
            .map(ticketId).toProperty("ticketId")
            .map(number).toProperty("number")
            .map(price).toProperty("price")
            .map(start).toProperty("start")
            .map(end).toProperty("end")
            .map(version).toProperty("version")
            .map(warehouseInventoryId).toProperty("warehouseInventoryId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<ClaimFormTicket> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, claimFormTicket, c ->
            c.map(id).toProperty("id")
            .map(claimFormId).toProperty("claimFormId")
            .map(ticketId).toProperty("ticketId")
            .map(number).toProperty("number")
            .map(price).toProperty("price")
            .map(start).toProperty("start")
            .map(end).toProperty("end")
            .map(version).toProperty("version")
            .map(warehouseInventoryId).toProperty("warehouseInventoryId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(ClaimFormTicket record) {
        return MyBatis3Utils.insert(this::insert, record, claimFormTicket, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(claimFormId).toPropertyWhenPresent("claimFormId", record::getClaimFormId)
            .map(ticketId).toPropertyWhenPresent("ticketId", record::getTicketId)
            .map(number).toPropertyWhenPresent("number", record::getNumber)
            .map(price).toPropertyWhenPresent("price", record::getPrice)
            .map(start).toPropertyWhenPresent("start", record::getStart)
            .map(end).toPropertyWhenPresent("end", record::getEnd)
            .map(version).toPropertyWhenPresent("version", record::getVersion)
            .map(warehouseInventoryId).toPropertyWhenPresent("warehouseInventoryId", record::getWarehouseInventoryId)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ClaimFormTicket> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, claimFormTicket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ClaimFormTicket> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, claimFormTicket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ClaimFormTicket> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, claimFormTicket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ClaimFormTicket> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, claimFormTicket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(ClaimFormTicket record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(claimFormId).equalTo(record::getClaimFormId)
                .set(ticketId).equalTo(record::getTicketId)
                .set(number).equalTo(record::getNumber)
                .set(price).equalTo(record::getPrice)
                .set(start).equalTo(record::getStart)
                .set(end).equalTo(record::getEnd)
                .set(version).equalTo(record::getVersion)
                .set(warehouseInventoryId).equalTo(record::getWarehouseInventoryId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ClaimFormTicket record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(claimFormId).equalToWhenPresent(record::getClaimFormId)
                .set(ticketId).equalToWhenPresent(record::getTicketId)
                .set(number).equalToWhenPresent(record::getNumber)
                .set(price).equalToWhenPresent(record::getPrice)
                .set(start).equalToWhenPresent(record::getStart)
                .set(end).equalToWhenPresent(record::getEnd)
                .set(version).equalToWhenPresent(record::getVersion)
                .set(warehouseInventoryId).equalToWhenPresent(record::getWarehouseInventoryId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(ClaimFormTicket record) {
        return update(c ->
            c.set(claimFormId).equalTo(record::getClaimFormId)
            .set(ticketId).equalTo(record::getTicketId)
            .set(number).equalTo(record::getNumber)
            .set(price).equalTo(record::getPrice)
            .set(start).equalTo(record::getStart)
            .set(end).equalTo(record::getEnd)
            .set(version).equalTo(record::getVersion)
            .set(warehouseInventoryId).equalTo(record::getWarehouseInventoryId)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(ClaimFormTicket record) {
        return update(c ->
            c.set(claimFormId).equalToWhenPresent(record::getClaimFormId)
            .set(ticketId).equalToWhenPresent(record::getTicketId)
            .set(number).equalToWhenPresent(record::getNumber)
            .set(price).equalToWhenPresent(record::getPrice)
            .set(start).equalToWhenPresent(record::getStart)
            .set(end).equalToWhenPresent(record::getEnd)
            .set(version).equalToWhenPresent(record::getVersion)
            .set(warehouseInventoryId).equalToWhenPresent(record::getWarehouseInventoryId)
            .where(id, isEqualTo(record::getId))
        );
    }
}