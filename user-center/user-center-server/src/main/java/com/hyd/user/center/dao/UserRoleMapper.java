package com.hyd.user.center.dao;

import org.mybatis.dynamic.sql.SqlBuilder;


/**
 * @author yanduohuang
 * @date 2021/2/3 17:40
 */
public interface UserRoleMapper extends UserRoleBaseMapper{
    /**
     * 根据用户ID删除
     * @param userId 用户ID
     * @return 删除行数
     */
    default int removeByUserId(Long userId) {
        return this.delete(c -> c.where(UserRoleDynamicSqlSupport.userId, SqlBuilder.isEqualTo(userId)));
    }
}
