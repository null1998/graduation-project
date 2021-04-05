package com.hyd.financial.service;
import java.util.List;
import com.hyd.financial.entity.TicketOutRecordTicket;
import com.hyd.financial.web.dto.TicketOutRecordTicketDTO;

/**
 * 票据出库记录票据
 * @author huangyanduo
 * @date 2021-04-05
 */
public interface ITicketOutRecordTicketService {
    /**
     * 保存票据出库记录票据
     * @param ticketOutRecordTicket 票据出库记录票据
     * @return id
     */
    Long save(TicketOutRecordTicket ticketOutRecordTicket);

    /**
     * 删除票据出库记录票据
     * @param id
     * @return 是否删除成功
     */
    Boolean remove(Long id);

    /**
     * 更新票据出库记录票据
     * @param ticketOutRecordTicket 票据出库记录票据
     * @return 更新的行数
     */
    Integer update(TicketOutRecordTicket ticketOutRecordTicket);

    /**
     * 根据id查询票据出库记录票据
     * @param id
     * @return 票据出库记录票据
     */
    TicketOutRecordTicketDTO getById(Long id);

    /**
     * 通用查询，支持字段id
     * @param ticketOutRecordTicket 票据出库记录票据
     * @return 票据出库记录票据列表
     */
    List<TicketOutRecordTicketDTO> commonQuery(TicketOutRecordTicket ticketOutRecordTicket);

}
