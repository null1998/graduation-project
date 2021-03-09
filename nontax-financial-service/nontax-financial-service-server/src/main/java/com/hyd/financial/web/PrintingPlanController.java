package com.hyd.financial.web;

import com.hyd.common.core.annotation.ApiLog;
import com.hyd.common.util.BeanUtil;
import com.hyd.financial.entity.PrintingPlan;
import com.hyd.financial.entity.vo.PrintingPlanVO;
import com.hyd.financial.service.IPrintingPlanService;
import com.hyd.financial.web.dto.PrintingPlanDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/25 10:50
 */
@CrossOrigin
@RestController
@RequestMapping("/printing/plan")
public class PrintingPlanController {
    @Autowired
    IPrintingPlanService printingPlanService;
    /**
     * 保存
     * @param printingPlanDTO 印制计划
     * @return 生成的ID
     */
    @ApiLog
    @PostMapping
    public Long save(@RequestBody PrintingPlanDTO printingPlanDTO){
        PrintingPlan printingPlan = BeanUtil.copy(printingPlanDTO, PrintingPlan.class);
        return printingPlanService.save(printingPlan);
    }
    /**
     * 根据ID删除
     * @param id ID
     * @return 是否删除成功
     */
    @ApiLog
    @DeleteMapping("/{id}")
    public Boolean removeById(@PathVariable("id") Long id) {
        return printingPlanService.removeById(id);
    }
    /**
     * 更新
     * @param printingPlanDTO 印制计划
     * @return 更新行数
     */
    @ApiLog
    @PutMapping
    public Integer update(@RequestBody PrintingPlanDTO printingPlanDTO) {
        PrintingPlan printingPlan = BeanUtil.copy(printingPlanDTO, PrintingPlan.class);
        return printingPlanService.update(printingPlan);
    }

    /**
     * 审核
     * @param printingPlanDTO 印制计划
     * @return 更新行数
     */
    @ApiLog
    @PutMapping("/review")
    public Integer review(@RequestBody PrintingPlanDTO printingPlanDTO) {
        PrintingPlan printingPlan = BeanUtil.copy(printingPlanDTO, PrintingPlan.class);
        return printingPlanService.update(printingPlan);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ApiLog
    @GetMapping("/{id}")
    public PrintingPlanVO getById(@PathVariable("id") Long id) {
        PrintingPlan printingPlan = printingPlanService.getById(id);
        return BeanUtil.copy(printingPlan, PrintingPlanVO.class);
    }
    /**
     * 根据父单位ID,印制计划状态,年度，查询子单位的印制计划列表
     * @param parentUnitId 父单位ID
     * @param printingPlanStatus 印制计划状态
     * @param year 年度
     * @return 印制计划列表
     */
    @ApiLog
    @GetMapping("/list")
    public List<PrintingPlanVO> listByParentUnitIdAndStatusAndYear(@RequestParam Long parentUnitId, @RequestParam Integer printingPlanStatus, @RequestParam Integer year) {
        List<PrintingPlan> printingPlanList = printingPlanService.listByParentUnitIdAndStatusAndYear(parentUnitId, printingPlanStatus, year);
        return BeanUtil.copyList(printingPlanList, PrintingPlanVO.class);
    }
    /**
     * 根据单位ID查询历年印制计划列表
     * @param unitId 单位ID
     * @return 印制计划列表
     */
    @ApiLog
    @GetMapping("/list/{unitId}")
    public List<PrintingPlanVO> listByUnitId(@PathVariable("unitId") Long unitId) {
        List<PrintingPlan> printingPlanList = printingPlanService.listByUnitId(unitId);
        return BeanUtil.copyList(printingPlanList, PrintingPlanVO.class);
    }

    /**
     * 根据单位ID查询该单位是否已提交本年度印制计划
     * @param unitId 单位ID
     * @return 是否已提交本年度印制计划
     */
    @ApiLog
    @GetMapping("/submitted/status/{unitId}")
    public Boolean getSubmitStatus(@PathVariable("unitId")Long unitId) {
        return printingPlanService.getSubmitStatus(unitId);
    }
}
