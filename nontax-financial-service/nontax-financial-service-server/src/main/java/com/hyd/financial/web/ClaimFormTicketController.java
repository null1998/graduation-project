package com.hyd.financial.web;

import com.hyd.financial.entity.ClaimFormTicket;
import com.hyd.financial.entity.vo.ClaimFormTicketVO;
import com.hyd.financial.service.IClaimFormTicketService;
import com.hyd.financial.web.dto.ClaimFormTicketDTO;
import com.sd365.common.log.api.annotation.ApiLog;
import com.sd365.common.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/3 10:32
 */
@CrossOrigin
@RestController
@RequestMapping("/claim/form/ticket")
public class ClaimFormTicketController {
    @Autowired
    private IClaimFormTicketService claimFormTicketService;
    /**
     * 保存
     * @param claimFormTicketDTO 申领单票据
     * @return 申领单票据ID
     */
    @ApiLog
    @PostMapping
    public Long save(@RequestBody ClaimFormTicketDTO claimFormTicketDTO) {
        ClaimFormTicket claimFormTicket = BeanUtil.copy(claimFormTicketDTO, ClaimFormTicket.class);
        return claimFormTicketService.save(claimFormTicket);
    }
    /**
     * 删除
     * @param id
     * @return 是否删除成功
     */
    @ApiLog
    @DeleteMapping("/{id}")
    public Boolean remove(@PathVariable("id") Long id) {
        return claimFormTicketService.remove(id);
    }
    /**
     * 更新
     * @param claimFormTicketDTO 申领单票据
     * @return 更新行数
     */
    @ApiLog
    @PutMapping
    public Integer update(@RequestBody ClaimFormTicketDTO claimFormTicketDTO) {
        ClaimFormTicket claimFormTicket = BeanUtil.copy(claimFormTicketDTO, ClaimFormTicket.class);
        return claimFormTicketService.update(claimFormTicket);
    }
    /**
     * 通过申领单ID查询票据列表
     * @param claimFormId 申领单ID
     * @return 票据列表
     */
    @ApiLog
    @GetMapping(value = "/list/{claimFormId}")
    public List<ClaimFormTicketVO> listByClaimFormId(@PathVariable("claimFormId") Long claimFormId) {
        List<ClaimFormTicket> claimFormTicketList = claimFormTicketService.listByClaimFormId(claimFormId);
        return BeanUtil.copyList(claimFormTicketList, ClaimFormTicketVO.class);
    }
}
