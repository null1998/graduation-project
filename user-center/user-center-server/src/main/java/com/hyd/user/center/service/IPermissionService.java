package com.hyd.user.center.service;

import com.hyd.user.center.entity.Permission;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/4 10:56
 */
public interface IPermissionService {
    /**
     * 保存
     * @param permission 权限
     * @return 权限ID
     */
    Long save(Permission permission);

    /**
     * 删除
     * @param id
     * @return 是否删除成功
     */
    Boolean remove(Long id);

    /**
     * 更新
     * @param permission 权限
     * @return 更新行数
     */
    Integer update(Permission permission);

    /**
     * 根据权限名查询
     * @param name 权限名
     * @return 权限列表
     */
    List<Permission> listByName(String name);

    /**
     * 根据条件（权限名，动作）查询权限列表
     * @param permission 条件
     * @return 权限列表
     */
    List<Permission> listPermission(Permission permission);
}
