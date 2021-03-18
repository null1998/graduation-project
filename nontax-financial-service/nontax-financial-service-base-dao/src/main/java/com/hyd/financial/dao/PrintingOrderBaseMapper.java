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
    BasicColumn[] selectList = BasicColumn.columnList(id, ordernumber, start, end, unitId, printUnitId, warehouseId, version, status);

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
        @Result(column="orderNumber", property="ordernumber", jdbcType=JdbcType.BIGINT),
        @Result(column="start", property="start", jdbcType=JdbcType.VARCHAR),
        @Result(column="end", property="end", jdbcType=JdbcType.VARCHAR),
        @Result(column="unit_id", property="unitId", jdbcType=JdbcType.BIGINT),
        @Result(column="print_unit_id", property="printUnitId", jdbcType=JdbcType.BIGINT),
        @Result(column="warehouse_id", property="warehouseId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
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
            .map(ordernumber).toProperty("ordernumber")
            .map(start).toProperty("start")
            .map(end).toProperty("end")
            .map(unitId).toProperty("unitId")
            .map(printUnitId).toProperty("printUnitId")
            .map(warehouseId).toProperty("warehouseId")
            .map(version).toProperty("version")
            .map(status).toProperty("status")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<PrintingOrder> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, printingOrder, c ->
            c.map(id).toProperty("id")
            .map(ordernumber).toProperty("ordernumber")
            .map(start).toProperty("start")
            .map(end).toProperty("end")
            .map(unitId).toProperty("unitId")
            .map(printUnitId).toProperty("printUnitId")
            .map(warehouseId).toProperty("warehouseId")
            .map(version).toProperty("version")
            .map(status).toProperty("status")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(PrintingOrder record) {
        return MyBatis3Utils.insert(this::insert, record, printingOrder, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(ordernumber).toPropertyWhenPresent("ordernumber", record::getOrdernumber)
            .map(start).toPropertyWhenPresent("start", record::getStart)
            .map(end).toPropertyWhenPresent("end", record::getEnd)
            .map(unitId).toPropertyWhenPresent("unitId", record::getUnitId)
            .map(printUnitId).toPropertyWhenPresent("printUnitId", record::getPrintUnitId)
            .map(warehouseId).toPropertyWhenPresent("warehouseId", record::getWarehouseId)
            .map(version).toPropertyWhenPresent("version", record::getVersion)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
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
                .set(ordernumber).equalTo(record::getOrdernumber)
                .set(start).equalTo(record::getStart)
                .set(end).equalTo(record::getEnd)
                .set(unitId).equalTo(record::getUnitId)
                .set(printUnitId).equalTo(record::getPrintUnitId)
                .set(warehouseId).equalTo(record::getWarehouseId)
                .set(version).equalTo(record::getVersion)
                .set(status).equalTo(record::getStatus);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(PrintingOrder record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(ordernumber).equalToWhenPresent(record::getOrdernumber)
                .set(start).equalToWhenPresent(record::getStart)
                .set(end).equalToWhenPresent(record::getEnd)
                .set(unitId).equalToWhenPresent(record::getUnitId)
                .set(printUnitId).equalToWhenPresent(record::getPrintUnitId)
                .set(warehouseId).equalToWhenPresent(record::getWarehouseId)
                .set(version).equalToWhenPresent(record::getVersion)
                .set(status).equalToWhenPresent(record::getStatus);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(PrintingOrder record) {
        return update(c ->
            c.set(ordernumber).equalTo(record::getOrdernumber)
            .set(start).equalTo(record::getStart)
            .set(end).equalTo(record::getEnd)
            .set(unitId).equalTo(record::getUnitId)
            .set(printUnitId).equalTo(record::getPrintUnitId)
            .set(warehouseId).equalTo(record::getWarehouseId)
            .set(version).equalTo(record::getVersion)
            .set(status).equalTo(record::getStatus)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(PrintingOrder record) {
        return update(c ->
            c.set(ordernumber).equalToWhenPresent(record::getOrdernumber)
            .set(start).equalToWhenPresent(record::getStart)
            .set(end).equalToWhenPresent(record::getEnd)
            .set(unitId).equalToWhenPresent(record::getUnitId)
            .set(printUnitId).equalToWhenPresent(record::getPrintUnitId)
            .set(warehouseId).equalToWhenPresent(record::getWarehouseId)
            .set(version).equalToWhenPresent(record::getVersion)
            .set(status).equalToWhenPresent(record::getStatus)
            .where(id, isEqualTo(record::getId))
        );
    }
}