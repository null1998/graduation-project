package com.hyd.user.center.service.impl;

import com.hyd.user.center.dao.RoleRelateMapper;
import com.hyd.user.center.entity.RoleRelate;
import com.hyd.user.center.service.IRoleRelateService;
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
 * @date 2021/2/4 14:55
 */
@Service
public class RoleRelateService implements IRoleRelateService {
    @Autowired
    private RoleRelateMapper roleRelateMapper;
    @Autowired
    private IdGenerator idGenerator;
    @Caching(evict = {@CacheEvict(value = {"RoleRelateService::listByParentRoleId"},allEntries = true)})
    @Override
    public Long save(RoleRelate roleRelate) {
        if (roleRelate == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("角色关系为空"));
        }
        long id = idGenerator.snowflakeId();
        roleRelate.setId(id);
        roleRelateMapper.insertSelective(roleRelate);
        return id;
    }
    @Caching(evict = {@CacheEvict(value = {"RoleRelateService::listByParentRoleId"},allEntries = true)})
    @Override
    public Integer saveList(List<RoleRelate> roleRelateList) {
        if (roleRelateList == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("角色关系列表为空"));
        }
        for (RoleRelate roleRelate : roleRelateList) {
            long id = idGenerator.snowflakeId();
            roleRelate.setId(id);
            roleRelate.setVersion(0L);
        }
        return roleRelateMapper.saveList(roleRelateList);
    }
    @Caching(evict = {@CacheEvict(value = {"RoleRelateService::listByParentRoleId"},key = "#roleId")})
    @Override
    public Integer removeByRoleId(Long roleId) {
        if (roleId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("角色ID为空"));
        }
        return roleRelateMapper.removeByRoleId(roleId);
    }
    @Cacheable(value = {"RoleRelateService::listByParentRoleId"},key = "#parentRoleId")
    @Override
    public List<RoleRelate> listByParentRoleId(Long parentRoleId) {
        if (parentRoleId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("父角色ID为空"));
        }
        return roleRelateMapper.listByParentRoleId(parentRoleId);
    }
}
