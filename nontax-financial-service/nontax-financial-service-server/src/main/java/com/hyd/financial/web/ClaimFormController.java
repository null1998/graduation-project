package com.hyd.financial.web;

import com.hyd.financial.entity.ClaimForm;
import com.hyd.financial.service.IClaimFormService;
import com.hyd.financial.web.dto.ClaimFormDTO;
import com.sd365.common.log.api.annotation.ApiLog;
import com.sd365.common.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/2 11:53
 */
@RestController
@RequestMapping("/claim/form")
public class ClaimFormController {
    @Autowired
    private IClaimFormService claimFormService;
    /**
     * 保存
     * @param claimFormDTO 申领单
     * @return 申领单ID
     */
    @ApiLog
    @PostMapping
    public Long save(@RequestBody ClaimFormDTO claimFormDTO) {
        ClaimForm claimForm = BeanUtil.copy(claimFormDTO, ClaimForm.class);
        return claimFormService.save(claimForm);
    }
    /**
     * 删除
     * @param id
     * @return 是否删除成功
     */
    @ApiLog
    @DeleteMapping("/{id}")
    public Boolean remove(@PathVariable("id") Long id) {
        return claimFormService.remove(id);
    }
    /**
     * 更新
     * @param claimFormDTO 申领单
     * @return 更新行数
     */
    @ApiLog
    @PutMapping
    public Integer update(@RequestBody ClaimFormDTO claimFormDTO) {
        ClaimForm claimForm = BeanUtil.copy(claimFormDTO, ClaimForm.class);
        return claimFormService.update(claimForm);
    }
    /**
     * 根据申领单位ID查询
     * @param claimUnitId 申领单位ID
     * @return 申领单列表
     */
    @ApiLog
    @GetMapping(value = "/list/{claimUnitId}")
    public List<ClaimForm> listByClaimUnitId(@PathVariable("claimUnitId") Long claimUnitId) {
        return claimFormService.listByClaimUnitId(claimUnitId);
    }
    /**
     * 根据父单位ID查询下级单位申领单
     * @param parentUnitId 父单位ID
     * @return 申领单列表
     */
    @ApiLog
    @GetMapping(value = "/list/child/{claimUnitId}")
    public List<ClaimForm> listChildClaimFormByParentUnitId(Long parentUnitId) {
        return claimFormService.listChildClaimFormByParentUnitId(parentUnitId);
    }
}
