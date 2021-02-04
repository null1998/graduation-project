package com.hyd.user.center.service.impl;

import com.hyd.user.center.dao.RoleMapper;
import com.hyd.user.center.entity.Role;
import com.hyd.user.center.service.IRolePermissionService;
import com.hyd.user.center.service.IRoleRelateService;
import com.hyd.user.center.service.IRoleService;
import com.sd365.common.core.annotation.stuffer.IdGenerator;
import com.sd365.common.core.common.exception.BusinessException;
import com.sd365.common.core.common.exception.code.BusinessErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/4 12:06
 */
@Service
public class RoleService implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private IdGenerator idGenerator;
    @Autowired
    private IRolePermissionService rolePermissionService;
    @Autowired
    private IRoleRelateService roleRelateService;
    @Caching(evict = {@CacheEvict(value = {"RoleService::listByName"},allEntries = true)})
    @Override
    public Long save(Role role) {
        if (role == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("角色为空"));
        }
        long id = idGenerator.snowflakeId();
        role.setId(id);
        roleMapper.insertSelective(role);
        return id;
    }
    @Transactional
    @Caching(evict = {@CacheEvict(value = {"RoleService::listByName"},allEntries = true)})
    @Override
    public Boolean remove(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        // 解除角色拥有的权限
        rolePermissionService.removeByRoleId(id);
        // 解除该角色与其它角色的关系
        roleRelateService.removeByRoleId(id);
        // 删除角色
        return roleMapper.deleteByPrimaryKey(id) == 1;
    }
    @Caching(evict = {@CacheEvict(value = {"RoleService::listByName"},allEntries = true)})
    @Override
    public Integer update(Role role) {
        if (role == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("角色为空"));
        }
        return roleMapper.updateByPrimaryKeySelective(role);
    }
    @Cacheable(value = {"RoleService::listByName"},key = "#name")
    @Override
    public List<Role> listByName(String name) {
        if (name == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("角色名为空"));
        }
        return roleMapper.listByName(name);
    }
}
