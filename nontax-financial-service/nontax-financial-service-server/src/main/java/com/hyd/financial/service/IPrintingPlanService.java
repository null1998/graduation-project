package com.hyd.financial.service;

import com.hyd.financial.entity.PrintingPlan;

/**
 * @author yanduohuang
 * @date 2021/2/20 16:29
 */
public interface IPrintingPlanService {
    /**
     * 保存
     * @param printingPlan
     * @return
     */
    Long save(PrintingPlan printingPlan);

}
