package com.hyd.financial.service;

import com.hyd.financial.entity.TicketStoreRecordTicket;
import com.hyd.financial.web.dto.TicketStoreRecordTicketDTO;

import java.util.List;

/**
 * 票据入库记录票据
 * @author huangyanduo
 * @date 2021-03-24
 */
public interface ITicketStoreRecordTicketService {
    /**
     * 保存票据入库记录票据
     * @param ticketStoreRecordTicket 票据入库记录票据
     * @return id
     */
    Long save(TicketStoreRecordTicket ticketStoreRecordTicket);

    /**
     * 删除票据入库记录票据
     * @param id
     * @return 是否删除成功
     */
    Boolean remove(Long id);

    /**
     * 更新票据入库记录票据
     * @param ticketStoreRecordTicket 票据入库记录票据
     * @return 更新的行数
     */
    Integer update(TicketStoreRecordTicket ticketStoreRecordTicket);

    /**
     * 根据id查询票据入库记录票据
     * @param id
     * @return 票据入库记录票据
     */
    TicketStoreRecordTicket getById(Long id);

    /**
     * 通用查询，支持字段id,ticketStoreRecordId
     * @param ticketStoreRecordTicket 票据入库记录票据
     * @return 票据入库记录票据列表
     */
    List<TicketStoreRecordTicketDTO> commonQuery(TicketStoreRecordTicket ticketStoreRecordTicket);

}
