package com.hyd.user.center.web;

import com.hyd.user.center.entity.UserRole;
import com.hyd.user.center.service.IUserRoleService;
import com.hyd.user.center.web.dto.UserRoleDTO;
import com.sd365.common.log.api.annotation.ApiLog;
import com.sd365.common.util.BeanUtil;
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
    @DeleteMapping(value = "{/userId}")
    public void removeByUserId(@PathVariable("userId") Long userId) {
        userRoleService.removeByUserId(userId);
    }
}
