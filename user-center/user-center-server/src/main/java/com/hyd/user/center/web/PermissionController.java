package com.hyd.user.center.web;


import com.hyd.common.core.annotation.ApiLog;
import com.hyd.common.core.annotation.PageHelper;
import com.hyd.common.util.BeanUtil;
import com.hyd.user.center.entity.Permission;
import com.hyd.user.center.entity.vo.PermissionVO;
import com.hyd.user.center.service.IPermissionService;
import com.hyd.user.center.web.dto.PermissionDTO;
import com.hyd.user.center.web.qo.PermissionQO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/4 11:09
 */
@CrossOrigin
@RequestMapping("/permission")
@RestController
public class PermissionController{
    @Autowired
    private IPermissionService permissionService;
    /**
     * 保存
     * @param permissionDTO 权限
     * @return 权限ID
     */
    @ApiLog
    @PostMapping
    public Long save(@RequestBody PermissionDTO permissionDTO) {
        Permission permission = BeanUtil.copy(permissionDTO, Permission.class);
        return permissionService.save(permission);
    }
    /**
     * 删除
     * @param id
     * @return 是否删除成功
     */
    @ApiLog
    @DeleteMapping(value = "/{id}")
    public Boolean remove(@PathVariable("id") Long id) {
        return permissionService.remove(id);
    }
    /**
     * 更新
     * @param permissionDTO 权限
     * @return 更新行数
     */
    @ApiLog
    @PutMapping
    public Integer update(@RequestBody PermissionDTO permissionDTO) {
        Permission permission = BeanUtil.copy(permissionDTO, Permission.class);
        return permissionService.update(permission);
    }
    /**
     * 根据资源名查询
     * @param name 资源名
     * @return 权限列表
     */
    @ApiLog
    @GetMapping(value = "/list/name")
    public List<PermissionVO> listByName(@RequestParam String name) {
        List<Permission> permissionList = permissionService.listByName(name);
        return BeanUtil.copyList(permissionList, PermissionVO.class);
    }
    /**
     * 根据条件（资源名，动作）查询权限列表
     * @param permissionQO 条件
     * @return 权限列表
     */
    @ApiLog
    @PageHelper
    @GetMapping(value = "/list")
    public List<PermissionVO> listPermission(PermissionQO permissionQO) {
        List<Permission> permissionList = permissionService.listPermission(permissionQO);
        return BeanUtil.copyList(permissionList, PermissionVO.class);
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @ApiLog
    @GetMapping(value = "/{id}")
    public PermissionVO getById(@PathVariable("id") Long id) {
        Permission permission = permissionService.getById(id);
        return BeanUtil.copy(permission, PermissionVO.class);
    }
}
