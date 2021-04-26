package com.hyd.financial.dao;

import static com.hyd.financial.dao.InvoiceDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.hyd.financial.entity.Invoice;
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
public interface InvoiceBaseMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, orderNumber, unitId, ticketId, ticketNumber, price, invoicePeople, identityNumber, invoiceDate, userId, status, version);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Invoice> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Invoice> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="InvoiceResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_number", property="orderNumber", jdbcType=JdbcType.BIGINT),
        @Result(column="unit_id", property="unitId", jdbcType=JdbcType.BIGINT),
        @Result(column="ticket_id", property="ticketId", jdbcType=JdbcType.BIGINT),
        @Result(column="ticket_number", property="ticketNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="invoice_people", property="invoicePeople", jdbcType=JdbcType.VARCHAR),
        @Result(column="identity_number", property="identityNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="invoice_date", property="invoiceDate", jdbcType=JdbcType.DATE),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.BIGINT)
    })
    List<Invoice> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("InvoiceResult")
    Optional<Invoice> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, invoice, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, invoice, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Invoice record) {
        return MyBatis3Utils.insert(this::insert, record, invoice, c ->
            c.map(id).toProperty("id")
            .map(orderNumber).toProperty("orderNumber")
            .map(unitId).toProperty("unitId")
            .map(ticketId).toProperty("ticketId")
            .map(ticketNumber).toProperty("ticketNumber")
            .map(price).toProperty("price")
            .map(invoicePeople).toProperty("invoicePeople")
            .map(identityNumber).toProperty("identityNumber")
            .map(invoiceDate).toProperty("invoiceDate")
            .map(userId).toProperty("userId")
            .map(status).toProperty("status")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Invoice> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, invoice, c ->
            c.map(id).toProperty("id")
            .map(orderNumber).toProperty("orderNumber")
            .map(unitId).toProperty("unitId")
            .map(ticketId).toProperty("ticketId")
            .map(ticketNumber).toProperty("ticketNumber")
            .map(price).toProperty("price")
            .map(invoicePeople).toProperty("invoicePeople")
            .map(identityNumber).toProperty("identityNumber")
            .map(invoiceDate).toProperty("invoiceDate")
            .map(userId).toProperty("userId")
            .map(status).toProperty("status")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Invoice record) {
        return MyBatis3Utils.insert(this::insert, record, invoice, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(orderNumber).toPropertyWhenPresent("orderNumber", record::getOrderNumber)
            .map(unitId).toPropertyWhenPresent("unitId", record::getUnitId)
            .map(ticketId).toPropertyWhenPresent("ticketId", record::getTicketId)
            .map(ticketNumber).toPropertyWhenPresent("ticketNumber", record::getTicketNumber)
            .map(price).toPropertyWhenPresent("price", record::getPrice)
            .map(invoicePeople).toPropertyWhenPresent("invoicePeople", record::getInvoicePeople)
            .map(identityNumber).toPropertyWhenPresent("identityNumber", record::getIdentityNumber)
            .map(invoiceDate).toPropertyWhenPresent("invoiceDate", record::getInvoiceDate)
            .map(userId).toPropertyWhenPresent("userId", record::getUserId)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
            .map(version).toPropertyWhenPresent("version", record::getVersion)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Invoice> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, invoice, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Invoice> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, invoice, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Invoice> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, invoice, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Invoice> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, invoice, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Invoice record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(orderNumber).equalTo(record::getOrderNumber)
                .set(unitId).equalTo(record::getUnitId)
                .set(ticketId).equalTo(record::getTicketId)
                .set(ticketNumber).equalTo(record::getTicketNumber)
                .set(price).equalTo(record::getPrice)
                .set(invoicePeople).equalTo(record::getInvoicePeople)
                .set(identityNumber).equalTo(record::getIdentityNumber)
                .set(invoiceDate).equalTo(record::getInvoiceDate)
                .set(userId).equalTo(record::getUserId)
                .set(status).equalTo(record::getStatus)
                .set(version).equalTo(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Invoice record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(orderNumber).equalToWhenPresent(record::getOrderNumber)
                .set(unitId).equalToWhenPresent(record::getUnitId)
                .set(ticketId).equalToWhenPresent(record::getTicketId)
                .set(ticketNumber).equalToWhenPresent(record::getTicketNumber)
                .set(price).equalToWhenPresent(record::getPrice)
                .set(invoicePeople).equalToWhenPresent(record::getInvoicePeople)
                .set(identityNumber).equalToWhenPresent(record::getIdentityNumber)
                .set(invoiceDate).equalToWhenPresent(record::getInvoiceDate)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(version).equalToWhenPresent(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Invoice record) {
        return update(c ->
            c.set(orderNumber).equalTo(record::getOrderNumber)
            .set(unitId).equalTo(record::getUnitId)
            .set(ticketId).equalTo(record::getTicketId)
            .set(ticketNumber).equalTo(record::getTicketNumber)
            .set(price).equalTo(record::getPrice)
            .set(invoicePeople).equalTo(record::getInvoicePeople)
            .set(identityNumber).equalTo(record::getIdentityNumber)
            .set(invoiceDate).equalTo(record::getInvoiceDate)
            .set(userId).equalTo(record::getUserId)
            .set(status).equalTo(record::getStatus)
            .set(version).equalTo(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Invoice record) {
        return update(c ->
            c.set(orderNumber).equalToWhenPresent(record::getOrderNumber)
            .set(unitId).equalToWhenPresent(record::getUnitId)
            .set(ticketId).equalToWhenPresent(record::getTicketId)
            .set(ticketNumber).equalToWhenPresent(record::getTicketNumber)
            .set(price).equalToWhenPresent(record::getPrice)
            .set(invoicePeople).equalToWhenPresent(record::getInvoicePeople)
            .set(identityNumber).equalToWhenPresent(record::getIdentityNumber)
            .set(invoiceDate).equalToWhenPresent(record::getInvoiceDate)
            .set(userId).equalToWhenPresent(record::getUserId)
            .set(status).equalToWhenPresent(record::getStatus)
            .set(version).equalToWhenPresent(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }
}