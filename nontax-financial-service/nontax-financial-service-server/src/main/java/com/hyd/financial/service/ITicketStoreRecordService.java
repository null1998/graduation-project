package com.hyd.financial.service;

import com.hyd.financial.entity.TicketStoreRecord;

import java.util.List;

/**
 * 票据入库记录
 * @author huangyanduo
 * @date 2021-03-23
 */
public interface ITicketStoreRecordService {
    /**
     * 保存票据入库记录
     * @param ticketStoreRecord 票据入库记录
     * @return id
     */
    Long save(TicketStoreRecord ticketStoreRecord);

    /**
     * 删除票据入库记录
     * @param id
     * @return 是否删除成功
     */
    Boolean remove(Long id);

    /**
     * 更新票据入库记录
     * @param ticketStoreRecord 票据入库记录
     * @return 更新的行数
     */
    Integer update(TicketStoreRecord ticketStoreRecord);

    /**
     * 根据id查询票据入库记录
     * @param id
     * @return 票据入库记录
     */
    TicketStoreRecord getById(Long id);

    /**
     * 通用查询，支持字段id
     * @param ticketStoreRecord 票据入库记录
     * @return 票据入库记录列表
     */
    List<TicketStoreRecord> commonQuery(TicketStoreRecord ticketStoreRecord);

}
