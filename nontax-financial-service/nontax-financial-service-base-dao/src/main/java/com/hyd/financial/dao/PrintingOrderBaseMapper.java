package com.hyd.financial.dao;

import static com.hyd.financial.dao.PrintingOrderDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.hyd.financial.entity.PrintingOrder;
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
public interface PrintingOrderBaseMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, orderNumber, start, end, unitId, printUnitId, warehouseId, person, tel, remark, status, version, payStatus);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<PrintingOrder> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<PrintingOrder> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PrintingOrderResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_number", property="orderNumber", jdbcType=JdbcType.BIGINT),
        @Result(column="start", property="start", jdbcType=JdbcType.VARCHAR),
        @Result(column="end", property="end", jdbcType=JdbcType.VARCHAR),
        @Result(column="unit_id", property="unitId", jdbcType=JdbcType.BIGINT),
        @Result(column="print_unit_id", property="printUnitId", jdbcType=JdbcType.BIGINT),
        @Result(column="warehouse_id", property="warehouseId", jdbcType=JdbcType.BIGINT),
        @Result(column="person", property="person", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.BIGINT),
        @Result(column="pay_status", property="payStatus", jdbcType=JdbcType.INTEGER)
    })
    List<PrintingOrder> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PrintingOrderResult")
    Optional<PrintingOrder> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, printingOrder, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, printingOrder, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(PrintingOrder record) {
        return MyBatis3Utils.insert(this::insert, record, printingOrder, c ->
            c.map(id).toProperty("id")
            .map(orderNumber).toProperty("orderNumber")
            .map(start).toProperty("start")
            .map(end).toProperty("end")
            .map(unitId).toProperty("unitId")
            .map(printUnitId).toProperty("printUnitId")
            .map(warehouseId).toProperty("warehouseId")
            .map(person).toProperty("person")
            .map(tel).toProperty("tel")
            .map(remark).toProperty("remark")
            .map(status).toProperty("status")
            .map(version).toProperty("version")
            .map(payStatus).toProperty("payStatus")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<PrintingOrder> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, printingOrder, c ->
            c.map(id).toProperty("id")
            .map(orderNumber).toProperty("orderNumber")
            .map(start).toProperty("start")
            .map(end).toProperty("end")
            .map(unitId).toProperty("unitId")
            .map(printUnitId).toProperty("printUnitId")
            .map(warehouseId).toProperty("warehouseId")
            .map(person).toProperty("person")
            .map(tel).toProperty("tel")
            .map(remark).toProperty("remark")
            .map(status).toProperty("status")
            .map(version).toProperty("version")
            .map(payStatus).toProperty("payStatus")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(PrintingOrder record) {
        return MyBatis3Utils.insert(this::insert, record, printingOrder, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(orderNumber).toPropertyWhenPresent("orderNumber", record::getOrderNumber)
            .map(start).toPropertyWhenPresent("start", record::getStart)
            .map(end).toPropertyWhenPresent("end", record::getEnd)
            .map(unitId).toPropertyWhenPresent("unitId", record::getUnitId)
            .map(printUnitId).toPropertyWhenPresent("printUnitId", record::getPrintUnitId)
            .map(warehouseId).toPropertyWhenPresent("warehouseId", record::getWarehouseId)
            .map(person).toPropertyWhenPresent("person", record::getPerson)
            .map(tel).toPropertyWhenPresent("tel", record::getTel)
            .map(remark).toPropertyWhenPresent("remark", record::getRemark)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
            .map(version).toPropertyWhenPresent("version", record::getVersion)
            .map(payStatus).toPropertyWhenPresent("payStatus", record::getPayStatus)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<PrintingOrder> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, printingOrder, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<PrintingOrder> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, printingOrder, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<PrintingOrder> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, printingOrder, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<PrintingOrder> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, printingOrder, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(PrintingOrder record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(orderNumber).equalTo(record::getOrderNumber)
                .set(start).equalTo(record::getStart)
                .set(end).equalTo(record::getEnd)
                .set(unitId).equalTo(record::getUnitId)
                .set(printUnitId).equalTo(record::getPrintUnitId)
                .set(warehouseId).equalTo(record::getWarehouseId)
                .set(person).equalTo(record::getPerson)
                .set(tel).equalTo(record::getTel)
                .set(remark).equalTo(record::getRemark)
                .set(status).equalTo(record::getStatus)
                .set(version).equalTo(record::getVersion)
                .set(payStatus).equalTo(record::getPayStatus);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(PrintingOrder record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(orderNumber).equalToWhenPresent(record::getOrderNumber)
                .set(start).equalToWhenPresent(record::getStart)
                .set(end).equalToWhenPresent(record::getEnd)
                .set(unitId).equalToWhenPresent(record::getUnitId)
                .set(printUnitId).equalToWhenPresent(record::getPrintUnitId)
                .set(warehouseId).equalToWhenPresent(record::getWarehouseId)
                .set(person).equalToWhenPresent(record::getPerson)
                .set(tel).equalToWhenPresent(record::getTel)
                .set(remark).equalToWhenPresent(record::getRemark)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(version).equalToWhenPresent(record::getVersion)
                .set(payStatus).equalToWhenPresent(record::getPayStatus);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(PrintingOrder record) {
        return update(c ->
            c.set(orderNumber).equalTo(record::getOrderNumber)
            .set(start).equalTo(record::getStart)
            .set(end).equalTo(record::getEnd)
            .set(unitId).equalTo(record::getUnitId)
            .set(printUnitId).equalTo(record::getPrintUnitId)
            .set(warehouseId).equalTo(record::getWarehouseId)
            .set(person).equalTo(record::getPerson)
            .set(tel).equalTo(record::getTel)
            .set(remark).equalTo(record::getRemark)
            .set(status).equalTo(record::getStatus)
            .set(version).equalTo(record::getVersion)
            .set(payStatus).equalTo(record::getPayStatus)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(PrintingOrder record) {
        return update(c ->
            c.set(orderNumber).equalToWhenPresent(record::getOrderNumber)
            .set(start).equalToWhenPresent(record::getStart)
            .set(end).equalToWhenPresent(record::getEnd)
            .set(unitId).equalToWhenPresent(record::getUnitId)
            .set(printUnitId).equalToWhenPresent(record::getPrintUnitId)
            .set(warehouseId).equalToWhenPresent(record::getWarehouseId)
            .set(person).equalToWhenPresent(record::getPerson)
            .set(tel).equalToWhenPresent(record::getTel)
            .set(remark).equalToWhenPresent(record::getRemark)
            .set(status).equalToWhenPresent(record::getStatus)
            .set(version).equalToWhenPresent(record::getVersion)
            .set(payStatus).equalToWhenPresent(record::getPayStatus)
            .where(id, isEqualTo(record::getId))
        );
    }
}