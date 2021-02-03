package com.hyd.user.center.service;

import com.hyd.user.center.entity.User;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * @author yanduohuang
 * @date 2021/2/3 15:53
 */
public interface IUserService {
    /**
     * 保存
     * @param user 用户
     * @return 用户ID
     */
    Long save(User user) throws InvalidKeySpecException, NoSuchAlgorithmException;

    /**
     * 删除
     * @param id 用户ID
     * @return 是否删除成功
     */
    Boolean remove(Long id);

    /**
     * 更新
     * @param user 用户
     * @return 更新行数
     */
    Integer update(User user);

    /**
     * 根据用户ID查询
     * @param id 用户ID
     * @return 用户
     */
    User getById(Long id);

    User getByUsername(String username);

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return 结果
     */
    Boolean login(String username,String password) throws InvalidKeySpecException, NoSuchAlgorithmException;
}
