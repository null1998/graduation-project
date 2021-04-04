package com.hyd.financial.service;
import java.util.List;
import com.hyd.financial.entity.TicketStore;
import com.hyd.financial.web.dto.TicketStoreDTO;

/**
 * 票据库存
 * @author huangyanduo
 * @date 2021-03-25
 */
public interface ITicketStoreService {
    /**
     * 保存票据库存
     * @param ticketStore 票据库存
     * @return id
     */
    Long save(TicketStore ticketStore);

    /**
     * 删除票据库存
     * @param id
     * @return 是否删除成功
     */
    Boolean remove(Long id);

    /**
     * 更新票据库存
     * @param ticketStore 票据库存
     * @return 更新的行数
     */
    Integer update(TicketStore ticketStore);

    /**
     * 根据id查询票据库存
     * @param id
     * @return 票据库存
     */
    TicketStoreDTO getById(Long id);

    /**
     * 通用查询，支持字段id，unitId，ticketId
     * @param ticketStore 票据库存
     * @return 票据库存列表
     */
    List<TicketStoreDTO> commonQuery(TicketStore ticketStore);

    /**
     * 查询单位票据库存
     * @param unitId 单位id
     * @return 票据库存列表
     */
    List<TicketStoreDTO> getUnitStorage(Long unitId);
}
