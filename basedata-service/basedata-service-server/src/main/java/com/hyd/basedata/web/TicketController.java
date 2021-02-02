package com.hyd.basedata.web;

import com.hyd.basedata.entity.Ticket;
import com.hyd.basedata.entity.vo.TicketVO;
import com.hyd.basedata.service.ITicketService;
import com.hyd.basedata.web.dto.TicketDTO;
import com.sd365.common.log.api.annotation.ApiLog;
import com.sd365.common.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yanduohuang
 * @date 2021/2/1 15:58
 */
@RestController
@RequestMapping(value = "/ticket")
public class TicketController {
    @Autowired
    private ITicketService ticketService;

    /**
     * 保存票据
     * @param ticketDTO 票据
     * @return 票据ID
     */
    @ApiLog
    @PostMapping
    public Long save(@RequestBody TicketDTO ticketDTO) {
        Ticket ticket = BeanUtil.copy(ticketDTO, Ticket.class);
        return ticketService.save(ticket);
    }

    /**
     * 删除
     * @param id
     * @return 是否删除成功
     */
    @ApiLog
    @DeleteMapping(value = "/{id}")
    public Boolean removeById(@PathVariable(name = "id") Long id) {
        return ticketService.remove(id);
    }

    /**
     * 更新
     * @param ticketDTO 票据
     * @return 更新行数
     */
    @ApiLog
    @PutMapping
    public Integer update(@RequestBody TicketDTO ticketDTO) {
        Ticket ticket = BeanUtil.copy(ticketDTO, Ticket.class);
        return ticketService.update(ticket);
    }

    /**
     * 根据ID查询票据
     * @param id
     * @return 票据
     */
    @ApiLog
    @GetMapping(value = "/{id}")
    public TicketVO getTicketById(@PathVariable(name = "id") Long id) {
        Ticket ticket = ticketService.getTicketById(id);
        return BeanUtil.copy(ticket, TicketVO.class);
    }
}
