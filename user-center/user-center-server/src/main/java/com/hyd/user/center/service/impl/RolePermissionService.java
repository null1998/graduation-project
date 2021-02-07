package com.hyd.user.center.service.impl;

import com.hyd.user.center.dao.RolePermissionMapper;
import com.hyd.user.center.entity.Role;
import com.hyd.user.center.entity.RolePermission;
import com.hyd.user.center.service.IRolePermissionService;
import com.hyd.user.center.service.IRoleService;
import com.sd365.common.core.annotation.stuffer.IdGenerator;
import com.sd365.common.core.common.exception.BusinessException;
import com.sd365.common.core.common.exception.code.BusinessErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/4 14:03
 */
@Service
public class RolePermissionService implements IRolePermissionService {
    @Autowired
    private IdGenerator idGenerator;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Autowired
    private IRoleService roleService;

    @Caching(evict = {@CacheEvict(value = {"RolePermissionService::listByRoleId","RolePermissionService::listByRoleIdList"},allEntries = true)})
    @Override
    public Long save(RolePermission rolePermission) {
        if (rolePermission == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("角色权限为空"));
        }
        long id = idGenerator.snowflakeId();
        rolePermission.setId(id);
        rolePermissionMapper.insertSelective(rolePermission);
        return id;
    }
    @Caching(evict = {@CacheEvict(value = {"RolePermissionService::listByRoleId","RolePermissionService::listByRoleIdList"},allEntries = true)})
    @Override
    public void saveList(List<RolePermission> rolePermissionList) {
        if (rolePermissionList == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("角色权限列表为空"));
        }
        for (RolePermission rolePermission : rolePermissionList) {
            long id = idGenerator.snowflakeId();
            rolePermission.setId(id);
            rolePermission.setVersion(0L);
        }
        rolePermissionMapper.saveList(rolePermissionList);
    }
    @Caching(evict = {@CacheEvict(value = {"RolePermissionService::listByRoleId","RolePermissionService::listByRoleIdList"},allEntries = true)})
    @Override
    public Boolean remove(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        return rolePermissionMapper.deleteByPrimaryKey(id) == 1;
    }
    @Cacheable(value = {"RolePermissionService::listByRoleId"},key = "#roleId")
    @Override
    public List<RolePermission> listByRoleId(Long roleId) {
        if (roleId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("角色ID为空"));
        }
        return rolePermissionMapper.listByRoleId(roleId);
    }
    @Cacheable(value = {"RolePermissionService::listByRoleIdList"},key = "#roleIdList.toString()")
    @Override
    public List<RolePermission> listByRoleIdList(List<Long> roleIdList) {
        if (roleIdList == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("角色ID列表为空"));
        }
        // 基础角色ID列表
        ArrayList<Long> baseRoleIds = new ArrayList<>();
        // 高级角色ID列表
        ArrayList<Long> advancedRoleIds = new ArrayList<>();
        for (Long roleId : roleIdList) {
            Role role = roleService.getBydId(roleId);
            if (role.getType().equals("高级角色")) {
                advancedRoleIds.add(roleId);
            } else if (role.getType().equals("基础角色")) {
                baseRoleIds.add(roleId);
            }
        }
        // 基础角色可以直接查询出拥有的权限
        List<RolePermission> rolePermissions = rolePermissionMapper.listByRoleIdList(baseRoleIds);
        // 高级角色递归查询
        rolePermissions.addAll(listByRoleIdList(advancedRoleIds));
        return rolePermissions;
    }

    @Caching(evict = {@CacheEvict(value = {"RolePermissionService::listByRoleId"},key = "#roleId"),
            @CacheEvict(value = {"RolePermissionService::listByRoleIdList"},allEntries = true)})
    @Override
    public Integer removeByRoleId(Long roleId) {
        if (roleId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("角色ID为空"));
        }
        return rolePermissionMapper.removeByRoleId(roleId);
    }
    @Caching(evict = {@CacheEvict(value = {"RolePermissionService::listByRoleId","RolePermissionService::listByRoleIdList"},allEntries = true)})
    @Override
    public Integer removeByPermissionId(Long permissionId) {
        if (permissionId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("权限ID为空"));
        }
        return rolePermissionMapper.removeByPermissionId(permissionId);
    }
}
