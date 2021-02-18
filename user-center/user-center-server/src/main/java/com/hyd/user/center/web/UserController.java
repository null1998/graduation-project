package com.hyd.user.center.web;

import com.hyd.user.center.entity.User;
import com.hyd.user.center.entity.vo.UserVO;
import com.hyd.user.center.service.IUserRoleService;
import com.hyd.user.center.service.IUserService;
import com.hyd.user.center.web.dto.UserDTO;
import com.sd365.common.log.api.annotation.ApiLog;
import com.sd365.common.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * @author yanduohuang
 * @date 2021/2/3 16:12
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IUserRoleService userRoleService;
    /**
     * 保存
     * @param userDTO 用户
     * @return 用户ID
     */
    @ApiLog
    @PostMapping
    public Long save(@RequestBody UserDTO userDTO) throws InvalidKeySpecException, NoSuchAlgorithmException {
        User user = BeanUtil.copy(userDTO, User.class);
        return userService.save(user);
    }
    /**
     * 删除
     * @param id
     * @return 是否删除成功
     */
    @ApiLog
    @DeleteMapping("/{id}")
    public Boolean remove(@PathVariable("id") Long id) {
        return userService.remove(id);
    }
    /**
     * 更新
     * @param userDTO 用户
     * @return 更新行数
     */
    @ApiLog
    @PutMapping
    public Integer update(@RequestBody UserDTO userDTO) throws InvalidKeySpecException, NoSuchAlgorithmException {
        User user = BeanUtil.copy(userDTO, User.class);
        return userService.update(user);
    }
    /**
     * 根据用户ID查询
     * @param id 用户ID
     * @return 用户
     */
    @ApiLog
    @GetMapping(value = "/{id}")
    public UserVO getById(@PathVariable("id") Long id) {
        User user = userService.getById(id);
        return BeanUtil.copy(user, UserVO.class);
    }

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return 结果
     * @throws InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     */
    @ApiLog
    @GetMapping(value = "/login")
    public UserVO login(@RequestParam String username,@RequestParam String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
        UserDTO userDTO = userService.login(username, password);
        return BeanUtil.copy(userDTO, UserVO.class);
    }

    /**
     * 获取用户信息，包含角色名列表
     * @param token
     * @return
     */
    @ApiLog
    @GetMapping(value = "/info")
    public UserVO getUserInfo(@RequestHeader("accessToken") String token) {
        UserDTO userDTO = userService.getUserInfo(token);
        return BeanUtil.copy(userDTO, UserVO.class);
    }
}
