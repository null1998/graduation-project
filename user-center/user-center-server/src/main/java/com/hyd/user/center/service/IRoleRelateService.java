package com.hyd.user.center.service;

import com.hyd.user.center.entity.RoleRelate;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/4 14:35
 */
public interface IRoleRelateService {
    /**
     * 保存
     * @param roleRelate 角色关系
     * @return 角色关系ID
     */
    Long save(RoleRelate roleRelate);

    /**
     * 批量保存
     * @param roleRelateList 角色关系列表
     * @return 保存数目
     */
    Integer saveList(List<RoleRelate> roleRelateList);

    /**
     * 删除与该角色ID有关的所有关系
     * @param roleId
     * @return 删除行数
     */
    Integer removeByRoleId(Long roleId);

    /**
     * 根据父角色ID查询
     * @param parentRoleId 父角色ID
     * @return 角色关系列表
     */
    List<RoleRelate> listByParentRoleId(Long parentRoleId);
}
