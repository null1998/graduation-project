package com.hyd.user.center.service.impl;

import com.hyd.common.core.exception.BusinessException;
import com.hyd.common.core.exception.code.BusinessErrorCode;
import com.hyd.common.util.IdGenerator;
import com.hyd.user.center.dao.UserRoleMapper;
import com.hyd.user.center.entity.User;
import com.hyd.user.center.entity.UserRole;
import com.hyd.user.center.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/3 17:39
 */
@Service
public class UserRoleService implements IUserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private IdGenerator idGenerator;
    @Caching(evict = {@CacheEvict(value = {"UserRoleService::listByUserId"},allEntries = true)})
    @Override
    public Long save(UserRole userRole) {
        if (userRole == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("用户角色关系为空"));
        }
        long id = idGenerator.snowflakeId();
        userRole.setId(id);
        userRoleMapper.insertSelective(userRole);
        return id;
    }
    @Caching(evict = {@CacheEvict(value = {"UserRoleService::listByUserId"},allEntries = true)})
    @Override
    public void saveList(List<UserRole> userRoleList) {
        if (userRoleList == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("用户角色关系列表为空"));
        }
        for (UserRole userRole : userRoleList) {
            long id = idGenerator.snowflakeId();
            userRole.setId(id);
            userRole.setVersion(0L);
        }
        userRoleMapper.insertMultiple(userRoleList);
    }
    @Caching(evict = {@CacheEvict(value = {"UserRoleService::listByUserId"},key = "#userId")})
    @Override
    public void removeByUserId(Long userId) {
        if (userId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("用户ID为空"));
        }
        userRoleMapper.removeByUserId(userId);
    }
    @Caching(evict = {@CacheEvict(value = {"UserRoleService::listByUserId"},allEntries = true)})
    @Override
    public Integer removeByRoleId(Long roleId) {
        if (roleId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("角色ID为空"));
        }
        return userRoleMapper.removeByRoleId(roleId);
    }
    @Cacheable(value = "UserRoleService::listByUserId",key = "#userId")
    @Override
    public List<UserRole> listByUserId(Long userId) {
        if (userId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("用户ID为空"));
        }
        return userRoleMapper.listByUserId(userId);
    }


}
