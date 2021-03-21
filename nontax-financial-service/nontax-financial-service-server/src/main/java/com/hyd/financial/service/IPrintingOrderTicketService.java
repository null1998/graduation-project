package com.hyd.financial.service;

import com.hyd.financial.entity.PrintingOrderTicket;
import com.hyd.financial.web.dto.PrintingOrderTicketDTO;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/3/18 19:17
 */
public interface IPrintingOrderTicketService {
    /**
     * 保存
     * @param printingOrderTicket 印制订单票据
     * @return
     */
    Long save(PrintingOrderTicket printingOrderTicket);
    /**
     * 批量保存
     * @param printingOrderTicketList 印制订单票据列表
     * @return
     */
    void saveList(List<PrintingOrderTicket> printingOrderTicketList);
    /**
     * 删除
     * @param id
     * @return 是否删除成功
     */
    Boolean remove(Long id);
    /**
     * 更新
     * @param printingOrderTicket 印制订单票据
     * @return 更新行数
     */
    Integer update(PrintingOrderTicket printingOrderTicket);

    /**
     * 根据印制订单id查询
     * @param printingOrderId 印制订单id
     * @return
     */
    List<PrintingOrderTicketDTO> listByPrintingOrderId(Long printingOrderId);
}
