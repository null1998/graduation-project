package com.hyd.user.center.web;

import com.hyd.common.core.annotation.ApiLog;
import com.hyd.common.util.BeanUtil;
import com.hyd.user.center.entity.Permission;
import com.hyd.user.center.entity.RolePermission;
import com.hyd.user.center.entity.vo.PermissionVO;
import com.hyd.user.center.entity.vo.RolePermissionVO;
import com.hyd.user.center.service.IRolePermissionService;
import com.hyd.user.center.web.dto.RolePermissionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/4 14:14
 */
@CrossOrigin
@RestController
@RequestMapping("/role/permission")
public class RolePermissionController {
    @Autowired
    private IRolePermissionService rolePermissionService;
    /**
     * 保存
     * @param rolePermissionDTO 角色权限
     * @return 角色权限ID
     */
    @ApiLog
    @PostMapping
    public Long save(@RequestBody RolePermissionDTO rolePermissionDTO) {
        RolePermission rolePermission = BeanUtil.copy(rolePermissionDTO, RolePermission.class);
        return rolePermissionService.save(rolePermission);
    }
    /**
     * 批量保存
     * @param rolePermissionDTOList 角色权限列表
     */
    @ApiLog
    @PostMapping("/list")
    public void saveList(@RequestBody List<RolePermissionDTO> rolePermissionDTOList) {
        List<RolePermission> rolePermissionList = BeanUtil.copyList(rolePermissionDTOList, RolePermission.class);
        rolePermissionService.saveList(rolePermissionList);
    }
    /**
     * 删除
     * @param id
     * @return 是否删除成功
     */
    @ApiLog
    @DeleteMapping("/{id}")
    public Boolean remove(@PathVariable("id") Long id) {
        return rolePermissionService.remove(id);
    }

    /**
     * 根据角色ID查询
     * @param roleId 角色ID
     * @return 角色权限列表
     */
    @ApiLog
    @GetMapping("/list/{roleId}")
    public List<RolePermissionVO> listByRoleId(@PathVariable("roleId") Long roleId) {
        List<RolePermission> rolePermissionList = rolePermissionService.listByRoleId(roleId);
        return BeanUtil.copyList(rolePermissionList, RolePermissionVO.class);
    }
    /**
     * 根据角色ID列表查询权限列表
     * @param roleIdList 角色ID列表
     * @return 权限列表
     */
    @ApiLog
    @PostMapping("/query/role/id/list")
    public List<PermissionVO> listByRoleIdList(@RequestBody List<Long> roleIdList) {
        List<Permission> permissionList = rolePermissionService.listByRoleIdList(roleIdList);
        return BeanUtil.copyList(permissionList, PermissionVO.class);
    }
}
