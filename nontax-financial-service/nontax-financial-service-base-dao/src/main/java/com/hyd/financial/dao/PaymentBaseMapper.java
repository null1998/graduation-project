package com.hyd.financial.dao;

import static com.hyd.financial.dao.PaymentDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.hyd.financial.entity.Payment;
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
public interface PaymentBaseMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, orderNumber, sourceOrderNumber, srcUnitId, desUnitId, totalPrice, orderType, date, payDate, status, version);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Payment> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Payment> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PaymentResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_number", property="orderNumber", jdbcType=JdbcType.BIGINT),
        @Result(column="source_order_number", property="sourceOrderNumber", jdbcType=JdbcType.BIGINT),
        @Result(column="src_unit_id", property="srcUnitId", jdbcType=JdbcType.BIGINT),
        @Result(column="des_unit_id", property="desUnitId", jdbcType=JdbcType.BIGINT),
        @Result(column="total_price", property="totalPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="order_type", property="orderType", jdbcType=JdbcType.VARCHAR),
        @Result(column="date", property="date", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_date", property="payDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.BIGINT)
    })
    List<Payment> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PaymentResult")
    Optional<Payment> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, payment, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, payment, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Payment record) {
        return MyBatis3Utils.insert(this::insert, record, payment, c ->
            c.map(id).toProperty("id")
            .map(orderNumber).toProperty("orderNumber")
            .map(sourceOrderNumber).toProperty("sourceOrderNumber")
            .map(srcUnitId).toProperty("srcUnitId")
            .map(desUnitId).toProperty("desUnitId")
            .map(totalPrice).toProperty("totalPrice")
            .map(orderType).toProperty("orderType")
            .map(date).toProperty("date")
            .map(payDate).toProperty("payDate")
            .map(status).toProperty("status")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Payment> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, payment, c ->
            c.map(id).toProperty("id")
            .map(orderNumber).toProperty("orderNumber")
            .map(sourceOrderNumber).toProperty("sourceOrderNumber")
            .map(srcUnitId).toProperty("srcUnitId")
            .map(desUnitId).toProperty("desUnitId")
            .map(totalPrice).toProperty("totalPrice")
            .map(orderType).toProperty("orderType")
            .map(date).toProperty("date")
            .map(payDate).toProperty("payDate")
            .map(status).toProperty("status")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Payment record) {
        return MyBatis3Utils.insert(this::insert, record, payment, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(orderNumber).toPropertyWhenPresent("orderNumber", record::getOrderNumber)
            .map(sourceOrderNumber).toPropertyWhenPresent("sourceOrderNumber", record::getSourceOrderNumber)
            .map(srcUnitId).toPropertyWhenPresent("srcUnitId", record::getSrcUnitId)
            .map(desUnitId).toPropertyWhenPresent("desUnitId", record::getDesUnitId)
            .map(totalPrice).toPropertyWhenPresent("totalPrice", record::getTotalPrice)
            .map(orderType).toPropertyWhenPresent("orderType", record::getOrderType)
            .map(date).toPropertyWhenPresent("date", record::getDate)
            .map(payDate).toPropertyWhenPresent("payDate", record::getPayDate)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
            .map(version).toPropertyWhenPresent("version", record::getVersion)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Payment> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, payment, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Payment> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, payment, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Payment> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, payment, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Payment> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, payment, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Payment record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(orderNumber).equalTo(record::getOrderNumber)
                .set(sourceOrderNumber).equalTo(record::getSourceOrderNumber)
                .set(srcUnitId).equalTo(record::getSrcUnitId)
                .set(desUnitId).equalTo(record::getDesUnitId)
                .set(totalPrice).equalTo(record::getTotalPrice)
                .set(orderType).equalTo(record::getOrderType)
                .set(date).equalTo(record::getDate)
                .set(payDate).equalTo(record::getPayDate)
                .set(status).equalTo(record::getStatus)
                .set(version).equalTo(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Payment record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(orderNumber).equalToWhenPresent(record::getOrderNumber)
                .set(sourceOrderNumber).equalToWhenPresent(record::getSourceOrderNumber)
                .set(srcUnitId).equalToWhenPresent(record::getSrcUnitId)
                .set(desUnitId).equalToWhenPresent(record::getDesUnitId)
                .set(totalPrice).equalToWhenPresent(record::getTotalPrice)
                .set(orderType).equalToWhenPresent(record::getOrderType)
                .set(date).equalToWhenPresent(record::getDate)
                .set(payDate).equalToWhenPresent(record::getPayDate)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(version).equalToWhenPresent(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Payment record) {
        return update(c ->
            c.set(orderNumber).equalTo(record::getOrderNumber)
            .set(sourceOrderNumber).equalTo(record::getSourceOrderNumber)
            .set(srcUnitId).equalTo(record::getSrcUnitId)
            .set(desUnitId).equalTo(record::getDesUnitId)
            .set(totalPrice).equalTo(record::getTotalPrice)
            .set(orderType).equalTo(record::getOrderType)
            .set(date).equalTo(record::getDate)
            .set(payDate).equalTo(record::getPayDate)
            .set(status).equalTo(record::getStatus)
            .set(version).equalTo(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Payment record) {
        return update(c ->
            c.set(orderNumber).equalToWhenPresent(record::getOrderNumber)
            .set(sourceOrderNumber).equalToWhenPresent(record::getSourceOrderNumber)
            .set(srcUnitId).equalToWhenPresent(record::getSrcUnitId)
            .set(desUnitId).equalToWhenPresent(record::getDesUnitId)
            .set(totalPrice).equalToWhenPresent(record::getTotalPrice)
            .set(orderType).equalToWhenPresent(record::getOrderType)
            .set(date).equalToWhenPresent(record::getDate)
            .set(payDate).equalToWhenPresent(record::getPayDate)
            .set(status).equalToWhenPresent(record::getStatus)
            .set(version).equalToWhenPresent(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }
}