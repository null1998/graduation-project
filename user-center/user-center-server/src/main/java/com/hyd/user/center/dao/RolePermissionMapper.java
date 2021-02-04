package com.hyd.user.center.dao;

import com.hyd.user.center.entity.RolePermission;
import org.mybatis.dynamic.sql.SqlBuilder;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/4 14:04
 */
public interface RolePermissionMapper extends RolePermissionBaseMapper{
    /**
     * 批量保存
     * @param rolePermissionList 角色权限列表
     */
    default int saveList(List<RolePermission> rolePermissionList) {
        return this.insertMultiple(rolePermissionList);
    }
    /**
     * 根据角色ID查询
     * @param roleId 角色ID
     * @return 角色权限列表
     */
    default List<RolePermission> listByRoleId(Long roleId) {
        return this.select(c -> c.where(RolePermissionDynamicSqlSupport.roleId, SqlBuilder.isEqualTo(roleId)));
    }

    /**
     * 根据角色ID删除
     * @param roleId 角色ID
     * @return 删除行数
     */
    default int removeByRoleId(Long roleId) {
        return this.delete(c -> c.where(RolePermissionDynamicSqlSupport.roleId, SqlBuilder.isEqualTo(roleId)));
    }
}
