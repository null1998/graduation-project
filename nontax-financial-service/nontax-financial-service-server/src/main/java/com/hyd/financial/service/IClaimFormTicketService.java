package com.hyd.financial.service;

import com.hyd.financial.entity.ClaimFormTicket;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/3 9:35
 */
public interface IClaimFormTicketService {
    /**
     * 保存
     * @param claimFormTicket 申领单票据
     * @return 申领单票据ID
     */
    Long save(ClaimFormTicket claimFormTicket);

    /**
     * 删除
     * @param id
     * @return 是否删除成功
     */
    Boolean remove(Long id);

    /**
     * 更新
     * @param claimFormTicket 申领单票据
     * @return 更新行数
     */
    Integer update(ClaimFormTicket claimFormTicket);

    /**
     * 通过申领单ID查询票据列表
     * @param claimFormId 申领单ID
     * @return 票据列表
     */
    List<ClaimFormTicket> listByClaimFormId(Long claimFormId);
}
