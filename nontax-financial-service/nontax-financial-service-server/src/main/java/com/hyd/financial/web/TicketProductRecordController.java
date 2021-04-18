package com.hyd.financial.web;

import com.hyd.common.core.annotation.ApiLog;
import com.hyd.common.util.BeanUtil;
import com.hyd.financial.entity.TicketProductRecord;
import com.hyd.financial.entity.vo.TicketProductRecordVO;
import com.hyd.financial.service.ITicketProductRecordService;
import com.hyd.financial.web.dto.TicketProductRecordDTO;
import com.hyd.financial.web.qo.TicketProductRecordQO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/3/21 16:24
 */
@CrossOrigin
@RestController
@RequestMapping("/ticket/product/record")
public class TicketProductRecordController {
    @Autowired
    private ITicketProductRecordService ticketProductRecordService;
    @ApiLog
    @PostMapping
    public Long save(@RequestBody TicketProductRecordDTO ticketProductRecordDTO) {
        TicketProductRecord ticketProductRecord = BeanUtil.copy(ticketProductRecordDTO, TicketProductRecord.class);
        return ticketProductRecordService.save(ticketProductRecord);
    }
    @ApiLog
    @DeleteMapping("/{id}")
    public Boolean remove(@PathVariable("id") Long id) {
        return ticketProductRecordService.remove(id);
    }
    @ApiLog
    @PutMapping
    public Integer update(@RequestBody TicketProductRecordDTO ticketProductRecordDTO) {
        TicketProductRecord ticketProductRecord = BeanUtil.copy(ticketProductRecordDTO, TicketProductRecord.class);
        return ticketProductRecordService.update(ticketProductRecord);
    }

    /**
     * 通用查询，支持字段id，ticketId，printOrderNumber，printUnitId
     * @param ticketProductRecordQO
     * @return
     */
    @ApiLog
    @GetMapping("/common/query")
    public List<TicketProductRecordVO> commonQuery(TicketProductRecordQO ticketProductRecordQO) {
        TicketProductRecord ticketProductRecord = BeanUtil.copy(ticketProductRecordQO, TicketProductRecord.class);
        List<TicketProductRecordDTO> ticketProductRecordDTOList = ticketProductRecordService.commonQuery(ticketProductRecord);
        return BeanUtil.copyList(ticketProductRecordDTOList, TicketProductRecordVO.class);
    }
    @ApiLog
    @GetMapping("/{id}")
    public TicketProductRecordVO getById(@PathVariable("id") Long id) {
        TicketProductRecord ticketProductRecord = ticketProductRecordService.getById(id);
        return BeanUtil.copy(ticketProductRecord, TicketProductRecordVO.class);
    }
    @ApiLog
    @GetMapping("/sum")
    public List<TicketProductRecordVO> sum(TicketProductRecordQO ticketProductRecordQO) {
        TicketProductRecord ticketProductRecord = BeanUtil.copy(ticketProductRecordQO, TicketProductRecord.class);
        List<TicketProductRecordDTO> ticketProductRecordDTOList = ticketProductRecordService.sum(ticketProductRecord);
        return BeanUtil.copyList(ticketProductRecordDTOList, TicketProductRecordVO.class);
    }
}
