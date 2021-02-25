package com.hyd.unit.dao;

import static com.hyd.unit.dao.PrintingPlanTicketDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.hyd.unit.entity.PrintingPlanTicket;
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
public interface PrintingPlanTicketBaseMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, printingPlanId, ticketId, theFirstSeason, theSecondSeason, theThirdSeason, theFourthSeason, lastYear, version);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<PrintingPlanTicket> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<PrintingPlanTicket> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PrintingPlanTicketResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="printing_plan_id", property="printingPlanId", jdbcType=JdbcType.BIGINT),
        @Result(column="ticket_id", property="ticketId", jdbcType=JdbcType.BIGINT),
        @Result(column="the_first_season", property="theFirstSeason", jdbcType=JdbcType.BIGINT),
        @Result(column="the_second_season", property="theSecondSeason", jdbcType=JdbcType.BIGINT),
        @Result(column="the_third_season", property="theThirdSeason", jdbcType=JdbcType.BIGINT),
        @Result(column="the_fourth_season", property="theFourthSeason", jdbcType=JdbcType.BIGINT),
        @Result(column="last_year", property="lastYear", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.BIGINT)
    })
    List<PrintingPlanTicket> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PrintingPlanTicketResult")
    Optional<PrintingPlanTicket> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, printingPlanTicket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, printingPlanTicket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(PrintingPlanTicket record) {
        return MyBatis3Utils.insert(this::insert, record, printingPlanTicket, c ->
            c.map(id).toProperty("id")
            .map(printingPlanId).toProperty("printingPlanId")
            .map(ticketId).toProperty("ticketId")
            .map(theFirstSeason).toProperty("theFirstSeason")
            .map(theSecondSeason).toProperty("theSecondSeason")
            .map(theThirdSeason).toProperty("theThirdSeason")
            .map(theFourthSeason).toProperty("theFourthSeason")
            .map(lastYear).toProperty("lastYear")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<PrintingPlanTicket> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, printingPlanTicket, c ->
            c.map(id).toProperty("id")
            .map(printingPlanId).toProperty("printingPlanId")
            .map(ticketId).toProperty("ticketId")
            .map(theFirstSeason).toProperty("theFirstSeason")
            .map(theSecondSeason).toProperty("theSecondSeason")
            .map(theThirdSeason).toProperty("theThirdSeason")
            .map(theFourthSeason).toProperty("theFourthSeason")
            .map(lastYear).toProperty("lastYear")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(PrintingPlanTicket record) {
        return MyBatis3Utils.insert(this::insert, record, printingPlanTicket, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(printingPlanId).toPropertyWhenPresent("printingPlanId", record::getPrintingPlanId)
            .map(ticketId).toPropertyWhenPresent("ticketId", record::getTicketId)
            .map(theFirstSeason).toPropertyWhenPresent("theFirstSeason", record::getTheFirstSeason)
            .map(theSecondSeason).toPropertyWhenPresent("theSecondSeason", record::getTheSecondSeason)
            .map(theThirdSeason).toPropertyWhenPresent("theThirdSeason", record::getTheThirdSeason)
            .map(theFourthSeason).toPropertyWhenPresent("theFourthSeason", record::getTheFourthSeason)
            .map(lastYear).toPropertyWhenPresent("lastYear", record::getLastYear)
            .map(version).toPropertyWhenPresent("version", record::getVersion)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<PrintingPlanTicket> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, printingPlanTicket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<PrintingPlanTicket> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, printingPlanTicket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<PrintingPlanTicket> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, printingPlanTicket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<PrintingPlanTicket> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, printingPlanTicket, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(PrintingPlanTicket record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(printingPlanId).equalTo(record::getPrintingPlanId)
                .set(ticketId).equalTo(record::getTicketId)
                .set(theFirstSeason).equalTo(record::getTheFirstSeason)
                .set(theSecondSeason).equalTo(record::getTheSecondSeason)
                .set(theThirdSeason).equalTo(record::getTheThirdSeason)
                .set(theFourthSeason).equalTo(record::getTheFourthSeason)
                .set(lastYear).equalTo(record::getLastYear)
                .set(version).equalTo(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(PrintingPlanTicket record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(printingPlanId).equalToWhenPresent(record::getPrintingPlanId)
                .set(ticketId).equalToWhenPresent(record::getTicketId)
                .set(theFirstSeason).equalToWhenPresent(record::getTheFirstSeason)
                .set(theSecondSeason).equalToWhenPresent(record::getTheSecondSeason)
                .set(theThirdSeason).equalToWhenPresent(record::getTheThirdSeason)
                .set(theFourthSeason).equalToWhenPresent(record::getTheFourthSeason)
                .set(lastYear).equalToWhenPresent(record::getLastYear)
                .set(version).equalToWhenPresent(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(PrintingPlanTicket record) {
        return update(c ->
            c.set(printingPlanId).equalTo(record::getPrintingPlanId)
            .set(ticketId).equalTo(record::getTicketId)
            .set(theFirstSeason).equalTo(record::getTheFirstSeason)
            .set(theSecondSeason).equalTo(record::getTheSecondSeason)
            .set(theThirdSeason).equalTo(record::getTheThirdSeason)
            .set(theFourthSeason).equalTo(record::getTheFourthSeason)
            .set(lastYear).equalTo(record::getLastYear)
            .set(version).equalTo(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(PrintingPlanTicket record) {
        return update(c ->
            c.set(printingPlanId).equalToWhenPresent(record::getPrintingPlanId)
            .set(ticketId).equalToWhenPresent(record::getTicketId)
            .set(theFirstSeason).equalToWhenPresent(record::getTheFirstSeason)
            .set(theSecondSeason).equalToWhenPresent(record::getTheSecondSeason)
            .set(theThirdSeason).equalToWhenPresent(record::getTheThirdSeason)
            .set(theFourthSeason).equalToWhenPresent(record::getTheFourthSeason)
            .set(lastYear).equalToWhenPresent(record::getLastYear)
            .set(version).equalToWhenPresent(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }
}