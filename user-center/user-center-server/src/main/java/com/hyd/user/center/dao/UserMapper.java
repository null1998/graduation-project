package com.hyd.user.center.dao;

import com.hyd.user.center.entity.User;
import org.mybatis.dynamic.sql.SqlBuilder;

import java.util.Optional;

/**
 * @author yanduohuang
 * @date 2021/2/3 17:05
 */
public interface UserMapper extends UserBaseMapper {
    default Optional<User> getByUsername(String username) {
        return this.selectOne(c -> c.where(UserDynamicSqlSupport.username, SqlBuilder.isEqualTo(username)));
    }
}
