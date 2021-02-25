package com.hyd.unit.dao;

import static com.hyd.unit.dao.PrintingPlanLimitDateDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.hyd.unit.entity.PrintingPlanLimitDate;
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
public interface PrintingPlanLimitDateBaseMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, year, startDate, endDate, unitId, version);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<PrintingPlanLimitDate> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<PrintingPlanLimitDate> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PrintingPlanLimitDateResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="year", property="year", jdbcType=JdbcType.INTEGER),
        @Result(column="start_date", property="startDate", jdbcType=JdbcType.DATE),
        @Result(column="end_date", property="endDate", jdbcType=JdbcType.DATE),
        @Result(column="unit_id", property="unitId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.BIGINT)
    })
    List<PrintingPlanLimitDate> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PrintingPlanLimitDateResult")
    Optional<PrintingPlanLimitDate> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, printingPlanLimitDate, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, printingPlanLimitDate, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(PrintingPlanLimitDate record) {
        return MyBatis3Utils.insert(this::insert, record, printingPlanLimitDate, c ->
            c.map(id).toProperty("id")
            .map(year).toProperty("year")
            .map(startDate).toProperty("startDate")
            .map(endDate).toProperty("endDate")
            .map(unitId).toProperty("unitId")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<PrintingPlanLimitDate> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, printingPlanLimitDate, c ->
            c.map(id).toProperty("id")
            .map(year).toProperty("year")
            .map(startDate).toProperty("startDate")
            .map(endDate).toProperty("endDate")
            .map(unitId).toProperty("unitId")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(PrintingPlanLimitDate record) {
        return MyBatis3Utils.insert(this::insert, record, printingPlanLimitDate, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(year).toPropertyWhenPresent("year", record::getYear)
            .map(startDate).toPropertyWhenPresent("startDate", record::getStartDate)
            .map(endDate).toPropertyWhenPresent("endDate", record::getEndDate)
            .map(unitId).toPropertyWhenPresent("unitId", record::getUnitId)
            .map(version).toPropertyWhenPresent("version", record::getVersion)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<PrintingPlanLimitDate> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, printingPlanLimitDate, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<PrintingPlanLimitDate> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, printingPlanLimitDate, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<PrintingPlanLimitDate> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, printingPlanLimitDate, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<PrintingPlanLimitDate> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, printingPlanLimitDate, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(PrintingPlanLimitDate record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(year).equalTo(record::getYear)
                .set(startDate).equalTo(record::getStartDate)
                .set(endDate).equalTo(record::getEndDate)
                .set(unitId).equalTo(record::getUnitId)
                .set(version).equalTo(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(PrintingPlanLimitDate record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(year).equalToWhenPresent(record::getYear)
                .set(startDate).equalToWhenPresent(record::getStartDate)
                .set(endDate).equalToWhenPresent(record::getEndDate)
                .set(unitId).equalToWhenPresent(record::getUnitId)
                .set(version).equalToWhenPresent(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(PrintingPlanLimitDate record) {
        return update(c ->
            c.set(year).equalTo(record::getYear)
            .set(startDate).equalTo(record::getStartDate)
            .set(endDate).equalTo(record::getEndDate)
            .set(unitId).equalTo(record::getUnitId)
            .set(version).equalTo(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(PrintingPlanLimitDate record) {
        return update(c ->
            c.set(year).equalToWhenPresent(record::getYear)
            .set(startDate).equalToWhenPresent(record::getStartDate)
            .set(endDate).equalToWhenPresent(record::getEndDate)
            .set(unitId).equalToWhenPresent(record::getUnitId)
            .set(version).equalToWhenPresent(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }
}