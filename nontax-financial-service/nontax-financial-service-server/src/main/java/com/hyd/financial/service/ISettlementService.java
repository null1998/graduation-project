package com.hyd.financial.service;

import com.hyd.financial.entity.Settlement;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/3 11:21
 */
public interface ISettlementService {
    /**
     * 保存
     * @param settlement 结算单
     * @return 结算单ID
     */
    Long save(Settlement settlement);

    /**
     * 删除
     * @param id
     * @return 是否删除成功
     */
    Boolean remove(Long id);

    /**
     * 更新
     * @param settlement 结算单
     * @return 更新行数
     */
    Integer update(Settlement settlement);

    /**
     * 根据结算单位ID查询结算单列表
     * @param settlementUnitId 结算单位ID
     * @return 结算单列表
     */
    List<Settlement> listBySettlementUnitId(Long settlementUnitId);

    /**
     * 根据处理单位ID查询结算单列表
     * @param unitId 处理单位ID
     * @return 结算单列表
     */
    List<Settlement> listByUnitId(Long unitId);
}
