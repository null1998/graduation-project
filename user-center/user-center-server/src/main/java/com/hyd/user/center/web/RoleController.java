package com.hyd.user.center.web;

import com.hyd.user.center.entity.Role;
import com.hyd.user.center.entity.vo.RoleVO;
import com.hyd.user.center.service.IRoleService;
import com.hyd.user.center.web.dto.RoleDTO;
import com.sd365.common.log.api.annotation.ApiLog;
import com.sd365.common.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/4 13:43
 */
@CrossOrigin
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;
    /**
     * 保存
     * @param roleDTO juese
     * @return 角色ID
     */
    @ApiLog
    @PostMapping
    public Long save(@RequestBody RoleDTO roleDTO) {
        Role role = BeanUtil.copy(roleDTO, Role.class);
        return roleService.save(role);
    }
    /**
     * 删除
     * @param id
     * @return 是否删除成功
     */
    @ApiLog
    @DeleteMapping("/{id}")
    public Boolean remove(@PathVariable("id") Long id) {
        return roleService.remove(id);
    }
    /**
     * 更新
     * @param roleDTO juese
     * @return 更新行数
     */
    @ApiLog
    @PutMapping
    public Integer update(@RequestBody RoleDTO roleDTO) {
        Role role = BeanUtil.copy(roleDTO, Role.class);
        return roleService.update(role);
    }
    /**
     * 根据角色名查询
     * @param name 角色名
     * @return 角色列表
     */
    @ApiLog
    @GetMapping(value = "/list/{name}")
    public List<RoleVO> listByName(@PathVariable("name") String name) {
        List<Role> roleList = roleService.listByName(name);
        return BeanUtil.copyList(roleList, RoleVO.class);
    }
}
