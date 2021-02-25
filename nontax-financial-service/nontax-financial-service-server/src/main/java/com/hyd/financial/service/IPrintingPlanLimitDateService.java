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
     * @param printingPlanLimitDate 印制计划限制日期
     * @return 生成的ID
     */
    Long save(PrintingPlanLimitDate printingPlanLimitDate);

    /**
     * 删除
     * @param id ID
     * @return 是否删除成功
     */
    Boolean remove(Long id);

    /**
     * 根据单位ID查询历年印制计划时间限制
     * @param unitId 单位ID
     * @return 历年印制计划时间限制
     */
    List<PrintingPlanLimitDate> listByUnitId(Long unitId);

    /**
     * 根据下级单位ID查询其对应省级单位最新印制计划时间限制
     * @param childUnitId 下级单位ID
     * @return
     */
    PrintingPlanLimitDate listByChildUnitId(Long childUnitId);

    /**
     * 根据单位ID查询该单位是否在提交印制计划的时间范围内
     * @param unitId 单位ID
     * @return 是否在时间范围内
     */
    Boolean inRangeOfLimitDate(Long unitId);
}
