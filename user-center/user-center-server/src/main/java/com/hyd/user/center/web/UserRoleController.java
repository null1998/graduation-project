package com.hyd.user.center.web;

import com.hyd.common.core.annotation.ApiLog;
import com.hyd.common.core.annotation.PageHelper;
import com.hyd.common.util.BeanUtil;
import com.hyd.user.center.entity.User;
import com.hyd.user.center.entity.UserRole;
import com.hyd.user.center.entity.vo.UserVO;
import com.hyd.user.center.service.IUserRoleService;
import com.hyd.user.center.web.dto.UserRoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/3 17:51
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/user/role")
public class UserRoleController {
    @Autowired
    private IUserRoleService userRoleService;
    /**
     * 保存用户角色关系
     * @param userRoleDTO 用户角色关系
     * @return 用户角色关系ID
     */
    @ApiLog
    @PostMapping
    public Long save(@RequestBody UserRoleDTO userRoleDTO) {
        UserRole userRole = BeanUtil.copy(userRoleDTO, UserRole.class);
        return userRoleService.save(userRole);
    }
    /**
     * 批量保存用户角色关系
     * @param userRoleDTOList 用户角色关系
     */
    @ApiLog
    @PostMapping(value = "/list")
    public void saveList(@RequestBody List<UserRoleDTO> userRoleDTOList) {
        List<UserRole> userRoleList = BeanUtil.copyList(userRoleDTOList, UserRole.class);
        userRoleService.saveList(userRoleList);
    }
    /**
     * 根据用户ID删除用户角色关系
     * @param userId 用户ID
     */
    @ApiLog
    @DeleteMapping(value = "/user/id/{userId}")
    public void removeByUserId(@PathVariable("userId") Long userId) {
        userRoleService.removeByUserId(userId);
    }

    @ApiLog
    @DeleteMapping("/{id}")
    public void removeById(@PathVariable("id") Long id) {
        userRoleService.removeById(id);
    }
}
