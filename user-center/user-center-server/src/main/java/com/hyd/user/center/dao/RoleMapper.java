package com.hyd.user.center.dao;

import com.hyd.user.center.entity.Role;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.dynamic.sql.SqlBuilder;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/4 12:06
 */
public interface RoleMapper extends RoleBaseMapper{
    /**
     * 根据角色名查询
     * @param name 角色名
     * @return 角色列表
     */
    default List<Role> listByName(String name) {
        String wrap = StringUtils.wrap(name, "%");
        return this.select(c -> c.where(RoleDynamicSqlSupport.name, SqlBuilder.isLikeWhenPresent(wrap)));
    }
}
