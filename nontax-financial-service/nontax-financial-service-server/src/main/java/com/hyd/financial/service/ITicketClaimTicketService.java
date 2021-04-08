package com.hyd.financial.service;
import java.util.List;
import com.hyd.financial.entity.TicketClaimTicket;
import com.hyd.financial.web.dto.TicketClaimTicketDTO;

/**
 * 票据申领票据
 * @author huangyanduo
 * @date 2021-03-26
 */
public interface ITicketClaimTicketService {
    /**
     * 保存票据申领票据
     * @param ticketClaimTicket 票据申领票据
     * @return id
     */
    Long save(TicketClaimTicket ticketClaimTicket);

    /**
     * 删除票据申领票据
     * @param id
     * @return 是否删除成功
     */
    Boolean remove(Long id);

    /**
     * 更新票据申领票据
     * @param ticketClaimTicket 票据申领票据
     * @return 更新的行数
     */
    Integer update(TicketClaimTicket ticketClaimTicket);

    /**
     * 根据id查询票据申领票据
     * @param id
     * @return 票据申领票据
     */
    TicketClaimTicketDTO getById(Long id);

    /**
     * 通用查询，支持字段id,ticketClaimId
     * @param ticketClaimTicket 票据申领票据
     * @return 票据申领票据列表
     */
    List<TicketClaimTicketDTO> commonQuery(TicketClaimTicket ticketClaimTicket);

}
