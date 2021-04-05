package com.hyd.financial.web;
import java.util.List;

import com.hyd.common.core.annotation.ApiLog;
import com.hyd.common.util.BeanUtil;
import com.hyd.financial.entity.TicketOutRecordTicket;
import com.hyd.financial.entity.vo.TicketOutRecordTicketVO;
import com.hyd.financial.service.ITicketOutRecordTicketService;
import com.hyd.financial.web.dto.TicketOutRecordTicketDTO;
import com.hyd.financial.web.qo.TicketOutRecordTicketQO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 票据出库记录票据
 * @author huangyanduo
 * @date 2021-04-05
 */
@CrossOrigin
@RestController
@RequestMapping("/ticket/out/record/ticket")
public class TicketOutRecordTicketController {

    @Autowired
    private ITicketOutRecordTicketService ticketOutRecordTicketService;

	/**
     * 保存票据出库记录票据
     * @param ticketOutRecordTicketDTO 票据出库记录票据
     * @return id
     */
    @ApiLog
    @PostMapping
    public Long save(@RequestBody TicketOutRecordTicketDTO ticketOutRecordTicketDTO) {
        TicketOutRecordTicket ticketOutRecordTicket = BeanUtil.copy(ticketOutRecordTicketDTO, TicketOutRecordTicket.class);
        return ticketOutRecordTicketService.save(ticketOutRecordTicket);
    }

	/**
     * 删除票据出库记录票据
     * @param id
     * @return 是否删除成功
     */
    @ApiLog
    @DeleteMapping("/{id}")
    public Boolean remove(@PathVariable("id") Long id) {
        return ticketOutRecordTicketService.remove(id);
    }

	/**
     * 更新票据出库记录票据
     * @param ticketOutRecordTicketDTO 票据出库记录票据
     * @return 更新的行数
     */
    @ApiLog
    @PutMapping
    public Integer update(@RequestBody TicketOutRecordTicketDTO ticketOutRecordTicketDTO) {
        TicketOutRecordTicket ticketOutRecordTicket = BeanUtil.copy(ticketOutRecordTicketDTO, TicketOutRecordTicket.class);
        return ticketOutRecordTicketService.update(ticketOutRecordTicket);
    }

	/**
     * 根据id查询票据出库记录票据
     * @param id
     * @return 票据出库记录票据
     */
	@ApiLog
    @GetMapping("/{id}")
    public TicketOutRecordTicketVO getById(@PathVariable("id") Long id) {
        TicketOutRecordTicketDTO ticketOutRecordTicketDTO = ticketOutRecordTicketService.getById(id);
        return BeanUtil.copy(ticketOutRecordTicketDTO, TicketOutRecordTicketVO.class);
    }

    /**
     * 通用查询，支持字段id
     * @param ticketOutRecordTicketQO 票据出库记录票据
     * @return 票据出库记录票据列表
     */
    @ApiLog
    @GetMapping("/common/query")
    public List<TicketOutRecordTicketVO> commonQuery(TicketOutRecordTicketQO ticketOutRecordTicketQO) {
        TicketOutRecordTicket ticketOutRecordTicket = BeanUtil.copy(ticketOutRecordTicketQO, TicketOutRecordTicket.class);
        List<TicketOutRecordTicketDTO> ticketOutRecordTicketDTOList = ticketOutRecordTicketService.commonQuery(ticketOutRecordTicket);
        return BeanUtil.copyList(ticketOutRecordTicketDTOList, TicketOutRecordTicketVO.class);
    }

}
