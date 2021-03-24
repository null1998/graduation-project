package com.hyd.financial.web;

import com.hyd.common.core.annotation.ApiLog;
import com.hyd.common.util.BeanUtil;
import com.hyd.financial.entity.TicketStoreRecordTicket;
import com.hyd.financial.entity.vo.TicketStoreRecordTicketVO;
import com.hyd.financial.service.ITicketStoreRecordTicketService;
import com.hyd.financial.web.dto.TicketStoreRecordTicketDTO;
import com.hyd.financial.web.qo.TicketStoreRecordTicketQO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 票据入库记录票据
 * @author huangyanduo
 * @date 2021-03-24
 */
@CrossOrigin
@RestController
@RequestMapping("/ticket/store/record/ticket")
public class TicketStoreRecordTicketController {

    @Autowired
    private ITicketStoreRecordTicketService ticketStoreRecordTicketService;

	/**
     * 保存票据入库记录票据
     * @param ticketStoreRecordTicketDTO 票据入库记录票据
     * @return id
     */
    @ApiLog
    @PostMapping
    public Long save(@RequestBody TicketStoreRecordTicketDTO ticketStoreRecordTicketDTO) {
        TicketStoreRecordTicket ticketStoreRecordTicket = BeanUtil.copy(ticketStoreRecordTicketDTO, TicketStoreRecordTicket.class);
        return ticketStoreRecordTicketService.save(ticketStoreRecordTicket);
    }

	/**
     * 删除票据入库记录票据
     * @param id
     * @return 是否删除成功
     */
    @ApiLog
    @DeleteMapping("/{id}")
    public Boolean remove(@PathVariable("id") Long id) {
        return ticketStoreRecordTicketService.remove(id);
    }

	/**
     * 更新票据入库记录票据
     * @param ticketStoreRecordTicketDTO 票据入库记录票据
     * @return 更新的行数
     */
    @ApiLog
    @PutMapping
    public Integer update(@RequestBody TicketStoreRecordTicketDTO ticketStoreRecordTicketDTO) {
        TicketStoreRecordTicket ticketStoreRecordTicket = BeanUtil.copy(ticketStoreRecordTicketDTO, TicketStoreRecordTicket.class);
        return ticketStoreRecordTicketService.update(ticketStoreRecordTicket);
    }

	/**
     * 根据id查询票据入库记录票据
     * @param id
     * @return 票据入库记录票据
     */
	@ApiLog
    @GetMapping("/{id}")
    public TicketStoreRecordTicketVO getById(@PathVariable("id") Long id) {
        TicketStoreRecordTicket ticketStoreRecordTicket = ticketStoreRecordTicketService.getById(id);
        return BeanUtil.copy(ticketStoreRecordTicket, TicketStoreRecordTicketVO.class);
    }

    /**
     * 通用查询，支持字段id,ticketStoreRecordId
     * @param ticketStoreRecordTicketQO 票据入库记录票据
     * @return 票据入库记录票据列表
     */
    @ApiLog
    @GetMapping("/common/query")
    public List<TicketStoreRecordTicketVO> commonQuery(TicketStoreRecordTicketQO ticketStoreRecordTicketQO) {
        TicketStoreRecordTicket ticketStoreRecordTicket = BeanUtil.copy(ticketStoreRecordTicketQO, TicketStoreRecordTicket.class);
        List<TicketStoreRecordTicketDTO> ticketStoreRecordTicketDTOList = ticketStoreRecordTicketService.commonQuery(ticketStoreRecordTicket);
        return BeanUtil.copyList(ticketStoreRecordTicketDTOList, TicketStoreRecordTicketVO.class);
    }

}
