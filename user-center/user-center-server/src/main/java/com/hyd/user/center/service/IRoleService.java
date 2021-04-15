package com.hyd.user.center.service;

import com.hyd.user.center.entity.Role;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/4 12:01
 */
public interface IRoleService {
    /**
     * 保存
     * @param role juese
     * @return 角色ID
     */
    Long save(Role role);

    /**
     * 删除
     * @param id
     * @return 是否删除成功
     */
    Boolean remove(Long id);

    /**
     * 更新
     * @param role juese
     * @return 更新行数
     */
    Integer update(Role role);

    /**
     * 根据角色名查询
     * @param name 角色名
     * @return 角色列表
     */
    List<Role> listByName(String name);

    /**
     * 根据条件（角色名，角色类型）查询角色列表
     * @param role 角色
     * @return 角色列表
     */
    List<Role> listRole(Role role);

    /**
     * 根据ID查询角色
     * @param id
     * @return 角色
     */
    Role getBydId(Long id);

}
