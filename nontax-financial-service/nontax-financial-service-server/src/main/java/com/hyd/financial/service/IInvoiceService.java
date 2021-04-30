package com.hyd.financial.service;
import com.hyd.financial.entity.Invoice;
import com.hyd.financial.web.dto.InvoiceDTO;
import com.hyd.financial.web.dto.InvoicePieDTO;

import java.util.List;

/**
 * 开票管理
 * @author huangyanduo
 * @date 2021-04-22
 */
public interface IInvoiceService {
    /**
     * 保存开票管理
     * @param invoice 开票管理
     * @return id
     */
    Long save(Invoice invoice);

    /**
     * 删除开票管理
     * @param id
     * @return 是否删除成功
     */
    Boolean remove(Long id);

    /**
     * 更新开票管理
     * @param invoice 开票管理
     * @return 更新的行数
     */
    Integer update(Invoice invoice);

    /**
     * 根据id查询开票管理
     * @param id
     * @return 开票管理
     */
    InvoiceDTO getById(Long id);

    /**
     * 通用查询，支持字段id
     * @param invoice 开票管理
     * @return 开票管理列表
     */
    List<InvoiceDTO> commonQuery(Invoice invoice);

    /**
     * 分析某单位每种票据开票数量
     * @param unitId
     * @return
     */
    List<InvoicePieDTO> analysisTicketNumber(Long unitId);

    /**
     * 分析某单位每种票据开票总金额
     * @param unitId
     * @return
     */
    List<InvoicePieDTO> analysisTicketPrice(Long unitId);
}
