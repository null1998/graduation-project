package com.hyd.financial.web;

import com.hyd.common.core.annotation.ApiLog;
import com.hyd.common.util.BeanUtil;
import com.hyd.financial.entity.TicketStoreRecord;
import com.hyd.financial.entity.vo.TicketStoreRecordVO;
import com.hyd.financial.service.ITicketStoreRecordService;
import com.hyd.financial.web.dto.TicketStoreRecordDTO;
import com.hyd.financial.web.qo.TicketStoreRecordQO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 票据入库记录
 * @author huangyanduo
 * @date 2021-03-23
 */
@CrossOrigin
@RestController
@RequestMapping("/ticket/store/record")
public class TicketStoreRecordController {

    @Autowired
    private ITicketStoreRecordService ticketStoreRecordService;

	/**
     * 保存票据入库记录
     * @param ticketStoreRecordDTO
     * @return id
     */
    @ApiLog
    @PostMapping
    public Long save(@RequestBody TicketStoreRecordDTO ticketStoreRecordDTO) {
        TicketStoreRecord ticketStoreRecord = BeanUtil.copy(ticketStoreRecordDTO, TicketStoreRecord.class);
        return ticketStoreRecordService.save(ticketStoreRecord);
    }

	/**
     * 删除票据入库记录
     * @param id
     * @return 是否删除成功
     */
    @ApiLog
    @DeleteMapping("/{id}")
    public Boolean remove(@PathVariable("id") Long id) {
        return ticketStoreRecordService.remove(id);
    }

	/**
     * 更新票据入库记录
     * @param ticketStoreRecordDTO 票据入库记录
     * @return 更新的行数
     */
    @ApiLog
    @PutMapping
    public Integer update(@RequestBody TicketStoreRecordDTO ticketStoreRecordDTO) {
        TicketStoreRecord ticketStoreRecord = BeanUtil.copy(ticketStoreRecordDTO, TicketStoreRecord.class);
        return ticketStoreRecordService.update(ticketStoreRecord);
    }

	/**
     * 根据id查询票据入库记录
     * @param id
     * @return 票据入库记录
     */
	@ApiLog
    @GetMapping("/{id}")
    public TicketStoreRecordVO getById(@PathVariable("id") Long id) {
        TicketStoreRecord ticketStoreRecord = ticketStoreRecordService.getById(id);
        return BeanUtil.copy(ticketStoreRecord, TicketStoreRecordVO.class);
    }

    /**
     * 通用查询，支持字段id
     * @param ticketStoreRecordQO 票据入库记录
     * @return 票据入库记录列表
     */
    @ApiLog
    @GetMapping("/common/query")
    public List<TicketStoreRecordVO> commonQuery(TicketStoreRecordQO ticketStoreRecordQO) {
        TicketStoreRecord ticketStoreRecord = BeanUtil.copy(ticketStoreRecordQO, TicketStoreRecord.class);
        List<TicketStoreRecord> ticketStoreRecordList = ticketStoreRecordService.commonQuery(ticketStoreRecord);
        return BeanUtil.copyList(ticketStoreRecordList, TicketStoreRecordVO.class);
    }

}
