package com.hyd.financial.service;

import com.hyd.financial.entity.TicketProductRecord;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/3/21 15:57
 */
public interface ITicketProductRecordService {
    /**
     * 保存
     * @param ticketProductRecord
     * @return
     */
    Long save(TicketProductRecord ticketProductRecord);

    /**
     * 删除
     * @param id
     * @return
     */
    Boolean remove(Long id);

    /**
     * 更新
     * @param ticketProductRecord
     * @return
     */
    Integer update(TicketProductRecord ticketProductRecord);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    TicketProductRecord getById(Long id);
    /**
     * 通用查询，支持字段id，ticketId，printOrderNumber，printUnitId
     * @param ticketProductRecord
     * @return
     */
    List<TicketProductRecord> commonQuery(TicketProductRecord ticketProductRecord);

}
