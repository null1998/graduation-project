package com.hyd.financial.service;

import com.hyd.financial.entity.PrintingPlan;
import com.hyd.financial.entity.PrintingPlanTicket;
import com.hyd.financial.web.dto.PrintingPlanTicketDTO;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/25 9:17
 */
public interface IPrintingPlanTicketService {
    /**
     * 保存
     * @param printingPlanTicket 印制计划票据
     * @return 生成的ID
     */
    Long save(PrintingPlanTicket printingPlanTicket);

    /**
     * 批量保存
     * @param printingPlanTicketList
     * @return
     */
    Integer saveList(List<PrintingPlanTicket> printingPlanTicketList);

    /**
     * 根据子单位的印制计划列表汇总生成本单位的印制计划列表
     * @param printingPlanList 子单位的印制计划列表
     * @return 生成的ID
     */
    Long saveByChildUnitPrintingPlanList(List<PrintingPlan> printingPlanList);

    /**
     * 根据ID删除
     * @param id
     * @return 是否删除成功
     */
    Boolean removeById(Long id);

    /**
     * 更新
     * @param printingPlanTicket 印制计划票据
     * @return
     */
    Integer update(PrintingPlanTicket printingPlanTicket);
    /**
     * 根据印制计划ID查询印制计划票据列表
     * @param printingPlanId 印制计划ID
     * @return 印制计划票据列表
     */
    List<PrintingPlanTicketDTO> listByPrintingPlanId(Long printingPlanId);


}
