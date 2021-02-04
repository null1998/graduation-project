package com.hyd.user.center.dao;

import com.hyd.user.center.entity.RoleRelate;
import org.mybatis.dynamic.sql.SqlBuilder;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/4 14:52
 */
public interface RoleRelateMapper extends RoleRelateBaseMapper {
    /**
     * 批量保存
     * @param roleRelateList 角色关系列表
     * @return 保存数目
     */
    default Integer saveList(List<RoleRelate> roleRelateList) {
        return this.insertMultiple(roleRelateList);
    }
    /**
     * 删除与该角色ID有关的所有关系
     * @param roleId
     * @return
     */
    default Integer removeByRoleId(Long roleId) {
        return this.delete(c -> c.where(RoleRelateDynamicSqlSupport.parentRoleId, SqlBuilder.isEqualTo(roleId))
                .or(RoleRelateDynamicSqlSupport.childRoleId, SqlBuilder.isEqualTo(roleId)));
    }
    /**
     * 根据父角色ID查询
     * @param parentRoleId 父角色ID
     * @return 角色关系列表
     */
    default List<RoleRelate> listByParentRoleId(Long parentRoleId) {
        return this.select(c -> c.where(RoleRelateDynamicSqlSupport.parentRoleId, SqlBuilder.isEqualTo(parentRoleId)));
    }
}
