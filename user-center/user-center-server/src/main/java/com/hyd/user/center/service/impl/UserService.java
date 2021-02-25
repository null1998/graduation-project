package com.hyd.user.center.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hyd.basedata.entity.Unit;
import com.hyd.basedata.service.IUnitService;
import com.hyd.common.core.exception.BusinessException;
import com.hyd.common.core.exception.code.BusinessErrorCode;
import com.hyd.common.util.BeanUtil;
import com.hyd.common.util.IdGenerator;
import com.hyd.common.util.TokenUtil;
import com.hyd.user.center.dao.UserMapper;
import com.hyd.user.center.entity.Role;
import com.hyd.user.center.entity.User;
import com.hyd.user.center.entity.UserRole;
import com.hyd.user.center.entity.vo.UserVO;
import com.hyd.user.center.service.IRoleService;
import com.hyd.user.center.service.IUserRoleService;
import com.hyd.user.center.service.IUserService;
import com.hyd.user.center.util.PBKDF2Util;
import com.hyd.user.center.web.dto.UserDTO;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
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
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IUnitService unitService;
    @Autowired
    private IUserService userService;
    @Caching(evict = {@CacheEvict(value = {"UserService::listAll"}, allEntries = true)})
    @Override
    public Long save(UserDTO userDTO) throws InvalidKeySpecException, NoSuchAlgorithmException {
        if (userDTO == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("用户为空"));
        }
        Optional<User> optional = userMapper.getByUsername(userDTO.getUsername());
        if (!optional.isPresent()) {
            // 用户名必须唯一
            long id = idGenerator.snowflakeId();
            ArrayList<Long> roleIdList = userDTO.getRoleIdList();
            User user = BeanUtil.copy(userDTO, User.class);
            user.setId(id);
            // 使用pbkdf2加密
            String encryptedPassword = PBKDF2Util.getEncryptedPassword(user.getPassword());
            user.setPassword(encryptedPassword);
            userMapper.insertSelective(user);
            if (roleIdList != null && !roleIdList.isEmpty()) {
                List<UserRole> userRoleList = new ArrayList<>();
                for (Long roleId : roleIdList) {
                    UserRole userRole = new UserRole();
                    userRole.setUserId(id);
                    userRole.setRoleId(roleId);
                    userRoleList.add(userRole);
                }
                userRoleService.saveList(userRoleList);
            }

            return id;
        }
        return null;
    }

    @Transactional
    @Caching(evict = {@CacheEvict(value = {"UserService::getById"}, key = "#id"),
            @CacheEvict(value = {"UserService::getByUsername","UserService::getUserInfo","UserService::listAll"}, allEntries = true)})
    @Override
    public Boolean remove(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        // 删除该用户与所有角色关系
        userRoleService.removeByUserId(id);
        return userMapper.deleteByPrimaryKey(id) == 1;
    }

    @Caching(evict = {@CacheEvict(value = {"UserService::getById"}, key = "#user.id"),
            @CacheEvict(value = {"UserService::getByUsername"}, key = "#user.username"),
            @CacheEvict(value = {"UserService::getUserInfo","UserService::listAll"},allEntries = true)})
    @Override
    public Integer update(User user) throws InvalidKeySpecException, NoSuchAlgorithmException {
        if (user == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("用户为空"));
        }
        if (user.getPassword() != null) {
            // 密码必须加密
            user.setPassword(PBKDF2Util.getEncryptedPassword(user.getPassword()));
        }
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Cacheable(value = {"UserService::getById"}, key = "#id")
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

    @Cacheable(value = {"UserService::getByUsername"}, key = "#username")
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
    public UserDTO login(String username, String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
        if (username == null || password == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("账号密码为空"));
        }
        User user = userService.getByUsername(username);
        // 将待验证密码加密后与数据库已加密密码比较
        if (Boolean.TRUE.equals(PBKDF2Util.authenticate(password, user.getPassword()))) {
            // 校验通过，获取用户角色列表
            List<UserRole> userRoleList = userRoleService.listByUserId(user.getId());
            ArrayList<Long> roleIdList = new ArrayList<>();
            ArrayList<String> roleNameList = new ArrayList<>();
            for (UserRole userRole : userRoleList) {
                roleIdList.add(userRole.getRoleId());
                Role role = roleService.getBydId(userRole.getRoleId());
                roleNameList.add(role.getName());
            }
            UserDTO userDTO = BeanUtil.copy(user, UserDTO.class);
            userDTO.setRoleIdList(roleIdList);
            userDTO.setRoleNameList(roleNameList);
            return userDTO;
        }
        return new UserDTO();
    }
    @Cacheable(value = {"UserService::getUserInfo"}, key = "#token")
    @Override
    public UserDTO getUserInfo(String token) {
        Long id = getIdFromToken(token);
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        User user = userService.getById(id);
        if (user == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_OTHER_EXCEPTION, new Exception("未查询到相应的用户记录"));
        }
        List<UserRole> userRoleList = userRoleService.listByUserId(id);
        ArrayList<String> roleNameList = new ArrayList<>();
        for (UserRole userRole : userRoleList) {
            Role role = roleService.getBydId(userRole.getRoleId());
            roleNameList.add(role.getName());
        }
        UserDTO userDTO = BeanUtil.copy(user, UserDTO.class);
        userDTO.setRoleNameList(roleNameList);
        return userDTO;
    }
    @Cacheable(value = {"UserService::listAll"})
    @Override
    public List<UserDTO> listAll() {
        List<User> userList = userMapper.select(QueryExpressionDSL::where);
        List<UserDTO> userDTOList = BeanUtil.copyList(userList, UserDTO.class);
        for (UserDTO userDTO : userDTOList) {
            if (userDTO.getUnitId()!=null) {
                Unit unit = unitService.getUnitById(userDTO.getUnitId());
                userDTO.setUnitName(unit.getName());
            }

        }
        return userDTOList;
    }

    private Long getIdFromToken(String token) {
        if (token == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("token为空"));
        }
        if (TokenUtil.tokenValid(token)) {
            List<String> list = TokenUtil.decryptToken(token);
            if (list != null && list.size() == 3) {
                String payload = list.get(1);
                JSONObject jsonObject = JSON.parseObject(payload);
                return jsonObject.getLong("userId");
            }
        }
        return null;
    }
}
