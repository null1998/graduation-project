package com.hyd.financial.service;

import com.hyd.financial.entity.PrintingPlan;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/20 16:29
 */
public interface IPrintingPlanService {
    /**
     * 保存
     * @param printingPlan 印制计划
     * @return 生成的ID
     */
    Long save(PrintingPlan printingPlan);

    /**
     * 根据ID删除
     * @param id ID
     * @return 是否删除成功
     */
    Boolean removeById(Long id);

    /**
     * 更新
     * @param printingPlan 印制计划
     * @return 更新行数
     */
    Integer update(PrintingPlan printingPlan);

    /**
     * 根据父单位ID,印制计划状态,年度，查询子单位的印制计划列表
     * @param parentUnitId 父单位ID
     * @param printingPlanStatus 印制计划状态
     * @param year 年度
     * @return 印制计划列表
     */
    List<PrintingPlan> listByParentUnitIdAndStatusAndYear(Long parentUnitId, Integer printingPlanStatus, Integer year);

    /**
     * 根据单位ID查询历年印制计划列表
     * @param unitId 单位ID
     * @return 印制计划列表
     */
    List<PrintingPlan> listByUnitId(Long unitId);

    /**
     * 根据单位ID查询该单位是否已提交本年度印制计划
     * @param unitId 单位ID
     * @return 是否已提交本年度印制计划
     */
    Boolean getSubmitStatus(Long unitId);

}
