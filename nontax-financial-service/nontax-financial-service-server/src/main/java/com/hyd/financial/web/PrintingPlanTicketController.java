package com.hyd.financial.web;

import com.hyd.common.core.annotation.ApiLog;
import com.hyd.common.util.BeanUtil;
import com.hyd.financial.entity.PrintingPlan;
import com.hyd.financial.entity.PrintingPlanTicket;
import com.hyd.financial.entity.vo.PrintingPlanTicketVO;
import com.hyd.financial.service.IPrintingPlanTicketService;
import com.hyd.financial.web.dto.PrintingPlanDTO;
import com.hyd.financial.web.dto.PrintingPlanTicketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/25 10:50
 */
@CrossOrigin
@RestController
@RequestMapping("/printing/plan/ticket")
public class PrintingPlanTicketController {
    @Autowired
    private IPrintingPlanTicketService printingPlanTicketService;
    /**
     * 保存
     * @param printingPlanTicketDTO 印制计划票据
     * @return 生成的ID
     */
    @ApiLog
    @PostMapping
    public Long save(@RequestBody PrintingPlanTicketDTO printingPlanTicketDTO) {
        PrintingPlanTicket printingPlanTicket = BeanUtil.copy(printingPlanTicketDTO, PrintingPlanTicket.class);
        return printingPlanTicketService.save(printingPlanTicket);
    }

    /**
     * 批量保存
     * @param printingPlanTicketDTOList
     * @return
     */
    @ApiLog
    @PostMapping("/all")
    public Integer saveList(@RequestBody List<PrintingPlanTicketDTO> printingPlanTicketDTOList) {
        List<PrintingPlanTicket> printingPlanTicketList = BeanUtil.copyList(printingPlanTicketDTOList, PrintingPlanTicket.class);
        return printingPlanTicketService.saveList(printingPlanTicketList);
    }
    /**
     * 根据子单位的印制计划列表汇总生成本单位的印制计划列表
     * @param printingPlanDTOList 子单位的印制计划列表
     * @return 生成的ID
     */
    @ApiLog
    @PostMapping("/summary")
    public Long saveByChildUnitPrintingPlanList(@RequestBody List<PrintingPlanDTO> printingPlanDTOList){
        List<PrintingPlan> printingPlanList = BeanUtil.copyList(printingPlanDTOList, PrintingPlan.class);
        return printingPlanTicketService.saveByChildUnitPrintingPlanList(printingPlanList);
    }

    /**
     * 根据ID删除
     * @param id
     * @return 是否删除成功
     */
    @ApiLog
    @DeleteMapping("/{id}")
    public Boolean removeById(@PathVariable("id") Long id) {
        return printingPlanTicketService.removeById(id);
    }
    @ApiLog
    @PutMapping
    public Integer update(@RequestBody PrintingPlanTicket printingPlanTicket) {
        return printingPlanTicketService.update(printingPlanTicket);
    }
    /**
     * 根据印制计划ID查询印制计划票据列表
     * @param printingPlanId 印制计划ID
     * @return 印制计划票据列表
     */
    @ApiLog
    @GetMapping("/list/{printingPlanId}")
    public List<PrintingPlanTicketVO> listByPrintingPlanId(@PathVariable("printingPlanId") Long printingPlanId) {
        List<PrintingPlanTicketDTO> printingPlanTicketDTOList = printingPlanTicketService.listByPrintingPlanId(printingPlanId);
        return BeanUtil.copyList(printingPlanTicketDTOList, PrintingPlanTicketVO.class);
    }
}
