package com.hyd.financial.service;
import java.util.List;
import com.hyd.financial.entity.TicketOutRecord;
import com.hyd.financial.web.dto.LineChartDTO;
import com.hyd.financial.web.dto.TicketOutRecordDTO;

/**
 * 票据出库记录
 * @author huangyanduo
 * @date 2021-04-05
 */
public interface ITicketOutRecordService {
    /**
     * 保存票据出库记录
     * @param ticketOutRecord 票据出库记录
     * @return id
     */
    Long save(TicketOutRecord ticketOutRecord);

    /**
     * 删除票据出库记录
     * @param id
     * @return 是否删除成功
     */
    Boolean remove(Long id);

    /**
     * 更新票据出库记录
     * @param ticketOutRecord 票据出库记录
     * @return 更新的行数
     */
    Integer update(TicketOutRecord ticketOutRecord);

    /**
     * 根据id查询票据出库记录
     * @param id
     * @return 票据出库记录
     */
    TicketOutRecordDTO getById(Long id);

    /**
     * 通用查询，支持字段id
     * @param ticketOutRecord 票据出库记录
     * @return 票据出库记录列表
     */
    List<TicketOutRecordDTO> commonQuery(TicketOutRecord ticketOutRecord);
    /**
     * 某单位最近一周出库记录折线图
     * @param unitId
     * @return
     */
    LineChartDTO recent(Long unitId);
}
