package com.hyd.user.center.web;

import com.hyd.user.center.entity.RolePermission;
import com.hyd.user.center.entity.vo.RolePermissionVO;
import com.hyd.user.center.service.IRolePermissionService;
import com.hyd.user.center.web.dto.RolePermissionDTO;
import com.sd365.common.log.api.annotation.ApiLog;
import com.sd365.common.util.BeanUtil;
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
    List<RolePermissionVO> listByRoleId(@PathVariable("roleId") Long roleId) {
        List<RolePermission> rolePermissionList = rolePermissionService.listByRoleId(roleId);
        return BeanUtil.copyList(rolePermissionList, RolePermissionVO.class);
    }
}
