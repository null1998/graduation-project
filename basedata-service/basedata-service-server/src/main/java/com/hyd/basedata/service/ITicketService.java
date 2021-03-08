package com.hyd.basedata.service;

import com.hyd.basedata.entity.Ticket;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/1 15:12
 */
public interface ITicketService {
    /**
     * 保存票据
     * @param ticket 票据
     * @return 票据id
     */
    Long save(Ticket ticket);

    /**
     * 根据ID删除票据
     * @param id 票据ID
     * @return 是否删除成功
     */
    Boolean remove(Long id);

    /**
     * 更新
     * @param ticket 更新数据
     * @return 更新行数
     */
    Integer update(Ticket ticket);

    /**
     * 根据ID查询
     * @param id 票据ID
     * @return 票据
     */
    Ticket getTicketById(Long id);

    /**
     * 查询全部票据
     * @return
     */
    List<Ticket> listAll();
}
