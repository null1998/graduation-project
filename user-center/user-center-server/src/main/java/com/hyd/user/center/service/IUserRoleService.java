package com.hyd.user.center.service;

import com.hyd.user.center.entity.UserRole;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/3 17:35
 */
public interface IUserRoleService {
    /**
     * 保存用户角色关系
     * @param userRole 用户角色关系
     * @return 用户角色关系ID
     */
    Long save(UserRole userRole);

    /**
     * 批量保存用户角色关系
     * @param userRoleList 用户角色关系
     */
    void saveList(List<UserRole> userRoleList);

    /**
     * 根据用户ID删除用户角色关系
     * @param userId 用户ID
     */
    void removeByUserId(Long userId);
}
