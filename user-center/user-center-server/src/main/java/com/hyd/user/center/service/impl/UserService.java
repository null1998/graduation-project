package com.hyd.user.center.service.impl;

import com.hyd.user.center.dao.UserMapper;
import com.hyd.user.center.entity.User;
import com.hyd.user.center.service.IUserRoleService;
import com.hyd.user.center.service.IUserService;
import com.hyd.user.center.util.PBKDF2Util;
import com.sd365.common.core.annotation.stuffer.IdGenerator;
import com.sd365.common.core.common.exception.BusinessException;
import com.sd365.common.core.common.exception.code.BusinessErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Optional;

/**
 * @author yanduohuang
 * @date 2021/2/3 15:57
 */
@Service
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IdGenerator idGenerator;
    @Autowired
    private IUserRoleService userRoleService;
    @Override
    public Long save(User user) throws InvalidKeySpecException, NoSuchAlgorithmException {
        if (user == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("用户为空"));
        }
        Optional<User> optional = userMapper.getByUsername(user.getUsername());
        if (!optional.isPresent()) {
            // 用户名必须唯一
            long id = idGenerator.snowflakeId();
            user.setId(id);
            // 使用pbkdf2加密
            String encryptedPassword = PBKDF2Util.getEncryptedPassword(user.getPassword());
            user.setPassword(encryptedPassword);
            userMapper.insertSelective(user);
            return id;
        }
        return null;
    }
    @Transactional
    @Caching(evict = {@CacheEvict(value = {"UserService::getById"},key = "#user.id"),
            @CacheEvict(value = {"UserService::getByUsername"},allEntries = true)})
    @Override
    public Boolean remove(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        // 删除该用户与所有角色关系
        userRoleService.removeByUserId(id);
        return userMapper.deleteByPrimaryKey(id) == 1;
    }
    @Caching(evict = {@CacheEvict(value = {"UserService::getById"},key = "#user.id"),
            @CacheEvict(value = {"UserService::getByUsername"},key = "#user.username")})
    @Override
    public Integer update(User user) {
        if (user == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("用户为空"));
        }
        return userMapper.updateByPrimaryKeySelective(user);
    }
    @Cacheable(value = {"UserService::getById"},key = "#id")
    @Override
    public User getById(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        Optional<User> optional = userMapper.selectByPrimaryKey(id);
        if (!optional.isPresent()) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_OTHER_EXCEPTION, new Exception("未查询到相应的用户记录"));
        }
        return optional.get();
    }
    @Cacheable(value = {"UserService::getByUsername"},key = "#username")
    @Override
    public User getByUsername(String username) {
        if (username == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("用户名为空"));
        }
        Optional<User> optional = userMapper.getByUsername(username);
        if (!optional.isPresent()) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_OTHER_EXCEPTION, new Exception("未查询到相应的用户记录"));
        }
        return optional.get();
    }

    @Override
    public Boolean login(String username,String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
        if (username == null || password == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("账号密码为空"));
        }
        User user = getByUsername(username);
        // 将待验证密码加密后与数据库已加密密码比较
        return PBKDF2Util.authenticate(password, user.getPassword());
    }
}
