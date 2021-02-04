package com.hyd.user.center.service.impl;

import com.hyd.user.center.dao.RolePermissionMapper;
import com.hyd.user.center.entity.RolePermission;
import com.hyd.user.center.service.IRolePermissionService;
import com.sd365.common.core.annotation.stuffer.IdGenerator;
import com.sd365.common.core.common.exception.BusinessException;
import com.sd365.common.core.common.exception.code.BusinessErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

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

    @Caching(evict = {@CacheEvict(value = {"RolePermissionService::listByRoleId"},allEntries = true)})
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
    @Caching(evict = {@CacheEvict(value = {"RolePermissionService::listByRoleId"},allEntries = true)})
    @Override
    public void saveList(List<RolePermission> rolePermissionList) {
        if (rolePermissionList == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("角色权限列表为空"));
        }
        for (RolePermission rolePermission : rolePermissionList) {
            long id = idGenerator.snowflakeId();
            rolePermission.setId(id);
        }
        rolePermissionMapper.saveList(rolePermissionList);
    }
    @Caching(evict = {@CacheEvict(value = {"RolePermissionService::listByRoleId"},allEntries = true)})
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

    @Override
    public Integer removeByRoleId(Long roleId) {
        if (roleId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("角色ID为空"));
        }
        return rolePermissionMapper.removeByRoleId(roleId);
    }
}
