package com.hyd.financial.web;
import java.util.List;

import com.hyd.common.core.annotation.ApiLog;
import com.hyd.common.util.BeanUtil;
import com.hyd.financial.entity.TicketClaimTicket;
import com.hyd.financial.entity.vo.TicketClaimTicketVO;
import com.hyd.financial.service.ITicketClaimTicketService;
import com.hyd.financial.web.dto.TicketClaimTicketDTO;
import com.hyd.financial.web.qo.TicketClaimTicketQO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 票据申领票据
 * @author huangyanduo
 * @date 2021-03-26
 */
@CrossOrigin
@RestController
@RequestMapping("/ticket/claim/ticket")
public class TicketClaimTicketController {

    @Autowired
    private ITicketClaimTicketService ticketClaimTicketService;

	/**
     * 保存票据申领票据
     * @param ticketClaimTicketDTO 票据申领票据
     * @return id
     */
    @ApiLog
    @PostMapping
    public Long save(@RequestBody TicketClaimTicketDTO ticketClaimTicketDTO) {
        TicketClaimTicket ticketClaimTicket = BeanUtil.copy(ticketClaimTicketDTO, TicketClaimTicket.class);
        return ticketClaimTicketService.save(ticketClaimTicket);
    }

	/**
     * 删除票据申领票据
     * @param id
     * @return 是否删除成功
     */
    @ApiLog
    @DeleteMapping("/{id}")
    public Boolean remove(@PathVariable("id") Long id) {
        return ticketClaimTicketService.remove(id);
    }

	/**
     * 更新票据申领票据
     * @param ticketClaimTicketDTO 票据申领票据
     * @return 更新的行数
     */
    @ApiLog
    @PutMapping
    public Integer update(@RequestBody TicketClaimTicketDTO ticketClaimTicketDTO) {
        TicketClaimTicket ticketClaimTicket = BeanUtil.copy(ticketClaimTicketDTO, TicketClaimTicket.class);
        return ticketClaimTicketService.update(ticketClaimTicket);
    }

	/**
     * 根据id查询票据申领票据
     * @param id
     * @return 票据申领票据
     */
	@ApiLog
    @GetMapping("/{id}")
    public TicketClaimTicketVO getById(@PathVariable("id") Long id) {
        TicketClaimTicketDTO ticketClaimTicketDTO = ticketClaimTicketService.getById(id);
        return BeanUtil.copy(ticketClaimTicketDTO, TicketClaimTicketVO.class);
    }

    /**
     * 通用查询，支持字段id,ticketClaimId
     * @param ticketClaimTicketQO 票据申领票据
     * @return 票据申领票据列表
     */
    @ApiLog
    @GetMapping("/common/query")
    public List<TicketClaimTicketVO> commonQuery(TicketClaimTicketQO ticketClaimTicketQO) {
        TicketClaimTicket ticketClaimTicket = BeanUtil.copy(ticketClaimTicketQO, TicketClaimTicket.class);
        List<TicketClaimTicketDTO> ticketClaimTicketDTOList = ticketClaimTicketService.commonQuery(ticketClaimTicket);
        return BeanUtil.copyList(ticketClaimTicketDTOList, TicketClaimTicketVO.class);
    }

}
