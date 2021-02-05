package com.hyd.user.center.dao;

import com.hyd.user.center.entity.Permission;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.dynamic.sql.SqlBuilder;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/4 11:01
 */
public interface PermissionMapper extends PermissionBaseMapper{
    /**
     * 根据权限名查询
     * @param name 资源名
     * @return 权限列表
     */
    default List<Permission> listByName(String name) {
        String wrap = StringUtils.wrap(name, "%");
        return this.select(c->c.where(PermissionDynamicSqlSupport.name, SqlBuilder.isLikeWhenPresent(wrap)));
    }
    /**
     * 根据条件（资源名，动作）查询权限列表
     * @param permission 条件
     * @return 权限列表
     */
    default List<Permission> listPermission(Permission permission) {
        String wrap = StringUtils.isEmpty(permission.getName()) ? null : StringUtils.wrap(permission.getName(), "%");
        String action = StringUtils.isEmpty(permission.getAction()) ? null : permission.getAction();
        return this.select(c -> c.where(PermissionDynamicSqlSupport.name, SqlBuilder.isLikeWhenPresent(wrap))
                .and(PermissionDynamicSqlSupport.action, SqlBuilder.isEqualToWhenPresent(action)));
    }
}
