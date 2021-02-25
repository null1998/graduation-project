package com.hyd.financial.web;

import com.hyd.common.core.annotation.ApiLog;
import com.hyd.common.util.BeanUtil;
import com.hyd.financial.entity.PrintingPlanLimitDate;
import com.hyd.financial.entity.vo.PrintingPlanLimitDateVO;
import com.hyd.financial.service.IPrintingPlanLimitDateService;
import com.hyd.financial.web.dto.PrintingPlanLimitDateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/20 16:53
 */
@CrossOrigin
@RestController
@RequestMapping("/printing/plan/limit/date")
public class PrintingPlanLimitDateController {
    @Autowired
    IPrintingPlanLimitDateService printingPlanLimitDateService;
    /**
     * 保存
     * @param printingPlanLimitDateDTO
     * @return 生成的ID
     */
    @ApiLog
    @PostMapping
    public Long save(@RequestBody PrintingPlanLimitDateDTO printingPlanLimitDateDTO){
        PrintingPlanLimitDate printingPlanLimitDate = BeanUtil.copy(printingPlanLimitDateDTO, PrintingPlanLimitDate.class);
        return printingPlanLimitDateService.save(printingPlanLimitDate);
    }
    /**
     * 删除
     * @param id
     * @return 是否删除成功
     */
    @ApiLog
    @DeleteMapping("/{id}")
    public Boolean remove(@PathVariable("id") Long id) {
        return printingPlanLimitDateService.remove(id);
    }

    /**
     * 根据单位ID查询历年印制计划时间限制
     * @param unitId 单位ID
     * @return 历年印制计划时间限制
     */
    @ApiLog
    @GetMapping("/{unitId}")
    public List<PrintingPlanLimitDateVO> listByUnitId(@PathVariable("unitId") Long unitId) {
        List<PrintingPlanLimitDate> printingPlanLimitDateList = printingPlanLimitDateService.listByUnitId(unitId);
        return BeanUtil.copyList(printingPlanLimitDateList, PrintingPlanLimitDateVO.class);
    }
    /**
     * 根据单位ID查询该单位是否在提交印制计划的时间范围内
     * @param unitId 单位ID
     * @return 是否在时间范围内
     */
    @ApiLog
    @GetMapping("/in/range/{unitId}")
    public Boolean inRangeOfLimitDate(@PathVariable("unitId")Long unitId) {
        return printingPlanLimitDateService.inRangeOfLimitDate(unitId);
    }
}
