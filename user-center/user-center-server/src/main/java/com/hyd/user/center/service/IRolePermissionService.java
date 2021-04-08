package com.hyd.user.center.service;

import com.hyd.user.center.entity.Permission;
import com.hyd.user.center.entity.RolePermission;

import java.util.List;
import java.util.Set;

/**
 * @author yanduohuang
 * @date 2021/2/4 13:58
 */
public interface IRolePermissionService {
    /**
     * 保存
     * @param rolePermission 角色权限
     * @return 角色权限ID
     */
    Long save(RolePermission rolePermission);

    /**
     * 批量保存
     * @param rolePermissionList 角色权限列表
     */
    void saveList(List<RolePermission> rolePermissionList);

    /**
     * 删除
     * @param id
     * @return 是否删除成功
     */
    Boolean remove(Long id);

    /**
     * 根据角色ID查询
     * @param roleId 角色ID
     * @return 角色权限列表
     */
    List<RolePermission> listByRoleId(Long roleId);

    /**
     * 根据角色ID列表查询
     * @param roleIdList 角色ID列表
     * @return 权限列表
     */
    List<Permission> listByRoleIdList(List<Long> roleIdList);

    /**
     * 根据角色ID删除
     * @param roleId 角色ID
     * @return 删除行数
     */
    Integer removeByRoleId(Long roleId);

    /**
     * 根据权限ID删除
     * @param permissionId 权限ID
     * @return 删除行数
     */
    Integer removeByPermissionId(Long permissionId);

    /**
     * 查询该角色id下的所有子角色id
     * @param roleId
     * @return
     */
    Set<Long> listBaseRoleId(Long roleId);
}
