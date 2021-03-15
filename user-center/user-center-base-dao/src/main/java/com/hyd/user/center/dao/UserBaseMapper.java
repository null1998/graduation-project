package com.hyd.user.center.dao;

import static com.hyd.user.center.dao.UserDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.hyd.user.center.entity.User;
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
public interface UserBaseMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, username, nickname, password, avatar, sex, birthday, tel, email, unitId, version);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<User> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<User> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UserResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.INTEGER),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.DATE),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="unit_id", property="unitId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.BIGINT)
    })
    List<User> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UserResult")
    Optional<User> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(User record) {
        return MyBatis3Utils.insert(this::insert, record, user, c ->
            c.map(id).toProperty("id")
            .map(username).toProperty("username")
            .map(nickname).toProperty("nickname")
            .map(password).toProperty("password")
            .map(avatar).toProperty("avatar")
            .map(sex).toProperty("sex")
            .map(birthday).toProperty("birthday")
            .map(tel).toProperty("tel")
            .map(email).toProperty("email")
            .map(unitId).toProperty("unitId")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<User> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, user, c ->
            c.map(id).toProperty("id")
            .map(username).toProperty("username")
            .map(nickname).toProperty("nickname")
            .map(password).toProperty("password")
            .map(avatar).toProperty("avatar")
            .map(sex).toProperty("sex")
            .map(birthday).toProperty("birthday")
            .map(tel).toProperty("tel")
            .map(email).toProperty("email")
            .map(unitId).toProperty("unitId")
            .map(version).toProperty("version")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(User record) {
        return MyBatis3Utils.insert(this::insert, record, user, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(username).toPropertyWhenPresent("username", record::getUsername)
            .map(nickname).toPropertyWhenPresent("nickname", record::getNickname)
            .map(password).toPropertyWhenPresent("password", record::getPassword)
            .map(avatar).toPropertyWhenPresent("avatar", record::getAvatar)
            .map(sex).toPropertyWhenPresent("sex", record::getSex)
            .map(birthday).toPropertyWhenPresent("birthday", record::getBirthday)
            .map(tel).toPropertyWhenPresent("tel", record::getTel)
            .map(email).toPropertyWhenPresent("email", record::getEmail)
            .map(unitId).toPropertyWhenPresent("unitId", record::getUnitId)
            .map(version).toPropertyWhenPresent("version", record::getVersion)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<User> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<User> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<User> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<User> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(User record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(username).equalTo(record::getUsername)
                .set(nickname).equalTo(record::getNickname)
                .set(password).equalTo(record::getPassword)
                .set(avatar).equalTo(record::getAvatar)
                .set(sex).equalTo(record::getSex)
                .set(birthday).equalTo(record::getBirthday)
                .set(tel).equalTo(record::getTel)
                .set(email).equalTo(record::getEmail)
                .set(unitId).equalTo(record::getUnitId)
                .set(version).equalTo(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(User record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(username).equalToWhenPresent(record::getUsername)
                .set(nickname).equalToWhenPresent(record::getNickname)
                .set(password).equalToWhenPresent(record::getPassword)
                .set(avatar).equalToWhenPresent(record::getAvatar)
                .set(sex).equalToWhenPresent(record::getSex)
                .set(birthday).equalToWhenPresent(record::getBirthday)
                .set(tel).equalToWhenPresent(record::getTel)
                .set(email).equalToWhenPresent(record::getEmail)
                .set(unitId).equalToWhenPresent(record::getUnitId)
                .set(version).equalToWhenPresent(record::getVersion);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(User record) {
        return update(c ->
            c.set(username).equalTo(record::getUsername)
            .set(nickname).equalTo(record::getNickname)
            .set(password).equalTo(record::getPassword)
            .set(avatar).equalTo(record::getAvatar)
            .set(sex).equalTo(record::getSex)
            .set(birthday).equalTo(record::getBirthday)
            .set(tel).equalTo(record::getTel)
            .set(email).equalTo(record::getEmail)
            .set(unitId).equalTo(record::getUnitId)
            .set(version).equalTo(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(User record) {
        return update(c ->
            c.set(username).equalToWhenPresent(record::getUsername)
            .set(nickname).equalToWhenPresent(record::getNickname)
            .set(password).equalToWhenPresent(record::getPassword)
            .set(avatar).equalToWhenPresent(record::getAvatar)
            .set(sex).equalToWhenPresent(record::getSex)
            .set(birthday).equalToWhenPresent(record::getBirthday)
            .set(tel).equalToWhenPresent(record::getTel)
            .set(email).equalToWhenPresent(record::getEmail)
            .set(unitId).equalToWhenPresent(record::getUnitId)
            .set(version).equalToWhenPresent(record::getVersion)
            .where(id, isEqualTo(record::getId))
        );
    }
}