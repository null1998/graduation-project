package com.hyd.user.center.service.impl;

import com.hyd.user.center.dao.PermissionMapper;
import com.hyd.user.center.entity.Permission;
import com.hyd.user.center.service.IPermissionService;
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
 * @date 2021/2/4 11:04
 */
@Service
public class PermissionService implements IPermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private IRolePermissionService rolePermissionService;
    @Autowired
    private IdGenerator idGenerator;
    @Caching(evict = {@CacheEvict(value = {"PermissionService::listByName","PermissionService::listPermission"},allEntries = true)})
    @Override
    public Long save(Permission permission) {
        if (permission == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("权限为空"));
        }
        long id = idGenerator.snowflakeId();
        permission.setId(id);
        permissionMapper.insertSelective(permission);
        return id;
    }
    @Caching(evict = {@CacheEvict(value = {"PermissionService::listByName","PermissionService::listPermission"},allEntries = true)})
    @Override
    public Boolean remove(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        // 删除角色权限表中与该权限相关的数据
        rolePermissionService.removeByPermissionId(id);
        // 删除该权限
        return permissionMapper.deleteByPrimaryKey(id) == 1;
    }
    @Caching(evict = {@CacheEvict(value = {"PermissionService::listByName","PermissionService::listPermission"},allEntries = true)})
    @Override
    public Integer update(Permission permission) {
        if (permission == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("权限为空"));
        }
        return permissionMapper.updateByPrimaryKeySelective(permission);
    }
    @Cacheable(value = {"PermissionService::listByName"},key = "#name")
    @Override
    public List<Permission> listByName(String name) {
        if (name == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("权限名为空"));
        }
        return permissionMapper.listByName(name);
    }
    @Cacheable(value = {"PermissionService::listPermission"},key = "#permission.toString()")
    @Override
    public List<Permission> listPermission(Permission permission) {
        if (permission == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("权限为空"));
        }
        return permissionMapper.listPermission(permission);
    }
}
