package com.hyd.financial.dao;

import static com.hyd.financial.dao.TreasuryDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.hyd.financial.entity.Treasury;
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
public interface TreasuryBaseMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, unitId, orderNumber, invoiceOrderNumber, price, operateDate, version);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Treasury> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Treasury> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TreasuryResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="unit_id", property="unitId", jdbcType=JdbcType.BIGINT),
        @Result(column="order_number", property="orderNumber", jdbcType=JdbcType.BIGINT),
        @Result(column="invoice_order_number", property="invoiceOrderNumber", jdbcType=JdbcType.BIGINT),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="operate_date", property="operateDate", jdbcType=JdbcType.DATE),
        @Result(column="version", property="version", jdbcType=JdbcType.BIGINT)
    })
    List<Treasury> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TreasuryResult")
    Optional<Treasury> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, treasury, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, treasury, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Treasury record) {
        return MyBatis3Utils.insert(this::insert, record, treasury, c ->
            c.map(id).toProperty("id")
            .map(unitId).toProperty("unitId")
            .map(orderNumber).toProperty("orderNumber")
            .map(invoiceOrderNumber).toProperty("invoiceOrderNumber")
            .map(price).toProperty("price")
            .map(operateDate).toProperty("operateDate")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Treasury> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, treasury, c ->
            c.map(id).toProperty("id")
            .map(unitId).toProperty("unitId")
            .map(orderNumber).toProperty("orderNumber")
            .map(invoiceOrderNumber).toProperty("invoiceOrderNumber")
            .map(price).toProperty("price")
            .map(operateDate).toProperty("operateDate")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Treasury record) {
        return MyBatis3Utils.insert(this::insert, record, treasury, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(unitId).toPropertyWhenPresent("unitId", record::getUnitId)
            .map(orderNumber).toPropertyWhenPresent("orderNumber", record::getOrderNumber)
            .map(invoiceOrderNumber).toPropertyWhenPresent("invoiceOrderNumber", record::getInvoiceOrderNumber)
            .map(price).toPropertyWhenPresent("price", record::getPrice)
            .map(operateDate).toPropertyWhenPresent("operateDate", record::getOperateDate)
            .map(version).toPropertyWhenPresent("version", record::getVersion)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Treasury> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, treasury, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Treasury> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, treasury, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Treasury> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, treasury, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Treasury> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, treasury, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Treasury record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(unitId).equalTo(record::getUnitId)
                .set(orderNumber).equalTo(record::getOrderNumber)
                .set(invoiceOrderNumber).equalTo(record::getInvoiceOrderNumber)
                .set(price).equalTo(record::getPrice)
                .set(operateDate).equalTo(record::getOperateDate)
                .set(version).equalTo(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Treasury record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(unitId).equalToWhenPresent(record::getUnitId)
                .set(orderNumber).equalToWhenPresent(record::getOrderNumber)
                .set(invoiceOrderNumber).equalToWhenPresent(record::getInvoiceOrderNumber)
                .set(price).equalToWhenPresent(record::getPrice)
                .set(operateDate).equalToWhenPresent(record::getOperateDate)
                .set(version).equalToWhenPresent(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Treasury record) {
        return update(c ->
            c.set(unitId).equalTo(record::getUnitId)
            .set(orderNumber).equalTo(record::getOrderNumber)
            .set(invoiceOrderNumber).equalTo(record::getInvoiceOrderNumber)
            .set(price).equalTo(record::getPrice)
            .set(operateDate).equalTo(record::getOperateDate)
            .set(version).equalTo(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Treasury record) {
        return update(c ->
            c.set(unitId).equalToWhenPresent(record::getUnitId)
            .set(orderNumber).equalToWhenPresent(record::getOrderNumber)
            .set(invoiceOrderNumber).equalToWhenPresent(record::getInvoiceOrderNumber)
            .set(price).equalToWhenPresent(record::getPrice)
            .set(operateDate).equalToWhenPresent(record::getOperateDate)
            .set(version).equalToWhenPresent(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }
}