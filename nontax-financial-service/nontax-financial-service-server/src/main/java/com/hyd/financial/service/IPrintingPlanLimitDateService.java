package com.hyd.financial.service;

import com.hyd.financial.entity.PrintingPlanLimitDate;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/20 16:32
 */
public interface IPrintingPlanLimitDateService {
    /**
     * 保存
     * @param printingPlanLimitDate
     * @return 生成的ID
     */
    Long save(PrintingPlanLimitDate printingPlanLimitDate);

    /**
     * 删除
     * @param id
     * @return 是否删除成功
     */
    Boolean remove(Long id);

    /**
     * 根据单位ID查询历年印制计划时间限制
     * @param unitId 单位ID
     * @return 历年印制计划时间限制
     */
    List<PrintingPlanLimitDate> listByUnitId(Long unitId);

}
