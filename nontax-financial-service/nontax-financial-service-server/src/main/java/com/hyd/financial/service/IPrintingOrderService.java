package com.hyd.financial.service;

import com.hyd.financial.entity.PrintingOrder;
import com.hyd.financial.web.dto.PrintingOrderDTO;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/3/18 18:43
 */
public interface IPrintingOrderService {
    /**
     * 保存
     * @param printingOrder 印制订单
     * @return
     */
    Long save(PrintingOrder printingOrder);

    /**
     * 删除
     * @param id
     * @return 是否删除成功
     */
    Boolean remove(Long id);

    /**
     * 更新
     * @param printingOrder 印制订单
     * @return 更新行数
     */
    Integer update(PrintingOrder printingOrder);

    /**
     * 通过id查询
     * @param id
     * @return
     */
    PrintingOrderDTO getById(Long id);
    /**
     * 通用查询，支持id，unitId，printUnitId，status字段
     * @param printingOrder
     * @return
     */
    List<PrintingOrder> commonQuery(PrintingOrder printingOrder);
}
