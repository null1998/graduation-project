package com.hyd.user.center.web;

import com.hyd.user.center.entity.RoleRelate;
import com.hyd.user.center.entity.vo.RoleRelateVO;
import com.hyd.user.center.service.IRoleRelateService;
import com.hyd.user.center.web.dto.RoleRelateDTO;
import com.sd365.common.log.api.annotation.ApiLog;
import com.sd365.common.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/4 15:07
 */
@CrossOrigin
@RestController
@RequestMapping("role/relate")
public class RoleRelateController {
    @Autowired
    private IRoleRelateService roleRelateService;
    /**
     * 保存
     * @param roleRelateDTO 角色关系
     * @return 角色关系ID
     */
    @ApiLog
    @PostMapping
    public Long save(@RequestBody RoleRelateDTO roleRelateDTO) {
        RoleRelate roleRelate = BeanUtil.copy(roleRelateDTO, RoleRelate.class);
        return roleRelateService.save(roleRelate);
    }
    /**
     * 批量保存
     * @param roleRelateDTOList 角色关系列表
     * @return 保存数目
     */
    @ApiLog
    @PostMapping("/list")
    public Integer saveList(@RequestBody List<RoleRelateDTO> roleRelateDTOList) {
        List<RoleRelate> roleRelateList = BeanUtil.copyList(roleRelateDTOList, RoleRelate.class);
        return roleRelateService.saveList(roleRelateList);
    }
    /**
     * 删除与该角色ID有关的所有关系
     * @param roleId
     * @return 删除行数
     */
    @ApiLog
    @DeleteMapping("/{roleId}")
    public Integer removeByRoleId(@PathVariable("roleId") Long roleId) {
        return roleRelateService.removeByRoleId(roleId);
    }
    /**
     * 根据父角色ID查询
     * @param parentRoleId 父角色ID
     * @return 角色关系列表
     */
    @ApiLog
    @GetMapping("/list/{parentRoleId}")
    List<RoleRelateVO> listByParentRoleId(Long parentRoleId) {
        List<RoleRelate> roleRelateList = roleRelateService.listByParentRoleId(parentRoleId);
        return BeanUtil.copyList(roleRelateList, RoleRelateVO.class);
    }
}
