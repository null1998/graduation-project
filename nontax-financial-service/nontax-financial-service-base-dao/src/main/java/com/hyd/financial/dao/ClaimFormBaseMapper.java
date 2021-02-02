package com.hyd.financial.dao;

import static com.hyd.financial.dao.ClaimFormDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.hyd.financial.entity.ClaimForm;
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
public interface ClaimFormBaseMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, orderNumber, claimDate, claimUnitId, claimPerson, claimWarehouseId, remark, checkOpinion, successDate, status, version);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<ClaimForm> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<ClaimForm> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ClaimFormResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_number", property="orderNumber", jdbcType=JdbcType.BIGINT),
        @Result(column="claim_date", property="claimDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="claim_unit_id", property="claimUnitId", jdbcType=JdbcType.BIGINT),
        @Result(column="claim_person", property="claimPerson", jdbcType=JdbcType.VARCHAR),
        @Result(column="claim_warehouse_id", property="claimWarehouseId", jdbcType=JdbcType.BIGINT),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="check_opinion", property="checkOpinion", jdbcType=JdbcType.VARCHAR),
        @Result(column="success_date", property="successDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.BIGINT)
    })
    List<ClaimForm> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ClaimFormResult")
    Optional<ClaimForm> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, claimForm, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, claimForm, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(ClaimForm record) {
        return MyBatis3Utils.insert(this::insert, record, claimForm, c ->
            c.map(id).toProperty("id")
            .map(orderNumber).toProperty("orderNumber")
            .map(claimDate).toProperty("claimDate")
            .map(claimUnitId).toProperty("claimUnitId")
            .map(claimPerson).toProperty("claimPerson")
            .map(claimWarehouseId).toProperty("claimWarehouseId")
            .map(remark).toProperty("remark")
            .map(checkOpinion).toProperty("checkOpinion")
            .map(successDate).toProperty("successDate")
            .map(status).toProperty("status")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<ClaimForm> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, claimForm, c ->
            c.map(id).toProperty("id")
            .map(orderNumber).toProperty("orderNumber")
            .map(claimDate).toProperty("claimDate")
            .map(claimUnitId).toProperty("claimUnitId")
            .map(claimPerson).toProperty("claimPerson")
            .map(claimWarehouseId).toProperty("claimWarehouseId")
            .map(remark).toProperty("remark")
            .map(checkOpinion).toProperty("checkOpinion")
            .map(successDate).toProperty("successDate")
            .map(status).toProperty("status")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(ClaimForm record) {
        return MyBatis3Utils.insert(this::insert, record, claimForm, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(orderNumber).toPropertyWhenPresent("orderNumber", record::getOrderNumber)
            .map(claimDate).toPropertyWhenPresent("claimDate", record::getClaimDate)
            .map(claimUnitId).toPropertyWhenPresent("claimUnitId", record::getClaimUnitId)
            .map(claimPerson).toPropertyWhenPresent("claimPerson", record::getClaimPerson)
            .map(claimWarehouseId).toPropertyWhenPresent("claimWarehouseId", record::getClaimWarehouseId)
            .map(remark).toPropertyWhenPresent("remark", record::getRemark)
            .map(checkOpinion).toPropertyWhenPresent("checkOpinion", record::getCheckOpinion)
            .map(successDate).toPropertyWhenPresent("successDate", record::getSuccessDate)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
            .map(version).toPropertyWhenPresent("version", record::getVersion)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ClaimForm> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, claimForm, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ClaimForm> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, claimForm, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ClaimForm> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, claimForm, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ClaimForm> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, claimForm, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(ClaimForm record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(orderNumber).equalTo(record::getOrderNumber)
                .set(claimDate).equalTo(record::getClaimDate)
                .set(claimUnitId).equalTo(record::getClaimUnitId)
                .set(claimPerson).equalTo(record::getClaimPerson)
                .set(claimWarehouseId).equalTo(record::getClaimWarehouseId)
                .set(remark).equalTo(record::getRemark)
                .set(checkOpinion).equalTo(record::getCheckOpinion)
                .set(successDate).equalTo(record::getSuccessDate)
                .set(status).equalTo(record::getStatus)
                .set(version).equalTo(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ClaimForm record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(orderNumber).equalToWhenPresent(record::getOrderNumber)
                .set(claimDate).equalToWhenPresent(record::getClaimDate)
                .set(claimUnitId).equalToWhenPresent(record::getClaimUnitId)
                .set(claimPerson).equalToWhenPresent(record::getClaimPerson)
                .set(claimWarehouseId).equalToWhenPresent(record::getClaimWarehouseId)
                .set(remark).equalToWhenPresent(record::getRemark)
                .set(checkOpinion).equalToWhenPresent(record::getCheckOpinion)
                .set(successDate).equalToWhenPresent(record::getSuccessDate)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(version).equalToWhenPresent(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(ClaimForm record) {
        return update(c ->
            c.set(orderNumber).equalTo(record::getOrderNumber)
            .set(claimDate).equalTo(record::getClaimDate)
            .set(claimUnitId).equalTo(record::getClaimUnitId)
            .set(claimPerson).equalTo(record::getClaimPerson)
            .set(claimWarehouseId).equalTo(record::getClaimWarehouseId)
            .set(remark).equalTo(record::getRemark)
            .set(checkOpinion).equalTo(record::getCheckOpinion)
            .set(successDate).equalTo(record::getSuccessDate)
            .set(status).equalTo(record::getStatus)
            .set(version).equalTo(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(ClaimForm record) {
        return update(c ->
            c.set(orderNumber).equalToWhenPresent(record::getOrderNumber)
            .set(claimDate).equalToWhenPresent(record::getClaimDate)
            .set(claimUnitId).equalToWhenPresent(record::getClaimUnitId)
            .set(claimPerson).equalToWhenPresent(record::getClaimPerson)
            .set(claimWarehouseId).equalToWhenPresent(record::getClaimWarehouseId)
            .set(remark).equalToWhenPresent(record::getRemark)
            .set(checkOpinion).equalToWhenPresent(record::getCheckOpinion)
            .set(successDate).equalToWhenPresent(record::getSuccessDate)
            .set(status).equalToWhenPresent(record::getStatus)
            .set(version).equalToWhenPresent(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }
}