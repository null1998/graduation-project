package com.hyd.financial.web;
import java.util.List;

import com.hyd.common.core.annotation.ApiLog;
import com.hyd.common.util.BeanUtil;
import com.hyd.financial.entity.TicketClaim;
import com.hyd.financial.entity.vo.TicketClaimVO;
import com.hyd.financial.service.ITicketClaimService;
import com.hyd.financial.web.dto.AutoStoreAndOutDTO;
import com.hyd.financial.web.dto.TicketClaimDTO;
import com.hyd.financial.web.qo.TicketClaimQO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 票据申领
 * @author huangyanduo
 * @date 2021-03-26
 */
@CrossOrigin
@RestController
@RequestMapping("/ticket/claim")
public class TicketClaimController {

    @Autowired
    private ITicketClaimService ticketClaimService;

	/**
     * 保存票据申领
     * @param ticketClaimDTO 票据申领
     * @return id
     */
    @ApiLog
    @PostMapping
    public Long save(@RequestBody TicketClaimDTO ticketClaimDTO) {
        TicketClaim ticketClaim = BeanUtil.copy(ticketClaimDTO, TicketClaim.class);
        return ticketClaimService.save(ticketClaim);
    }

	/**
     * 删除票据申领
     * @param id
     * @return 是否删除成功
     */
    @ApiLog
    @DeleteMapping("/{id}")
    public Boolean remove(@PathVariable("id") Long id) {
        return ticketClaimService.remove(id);
    }

	/**
     * 更新票据申领
     * @param ticketClaimDTO 票据申领
     * @return 更新的行数
     */
    @ApiLog
    @PutMapping
    public Integer update(@RequestBody TicketClaimDTO ticketClaimDTO) {
        TicketClaim ticketClaim = BeanUtil.copy(ticketClaimDTO, TicketClaim.class);
        return ticketClaimService.update(ticketClaim);
    }

	/**
     * 根据id查询票据申领
     * @param id
     * @return 票据申领
     */
	@ApiLog
    @GetMapping("/{id}")
    public TicketClaimVO getById(@PathVariable("id") Long id) {
        TicketClaimDTO ticketClaimDTO = ticketClaimService.getById(id);
        return BeanUtil.copy(ticketClaimDTO, TicketClaimVO.class);
    }

    /**
     * 通用查询，支持字段id,unitId,targetUnitId，status
     * @param ticketClaimQO 票据申领
     * @return 票据申领列表
     */
    @ApiLog
    @GetMapping("/common/query")
    public List<TicketClaimVO> commonQuery(TicketClaimQO ticketClaimQO) {
        TicketClaim ticketClaim = BeanUtil.copy(ticketClaimQO, TicketClaim.class);
        List<TicketClaimDTO> ticketClaimDTOList = ticketClaimService.commonQuery(ticketClaim);
        return BeanUtil.copyList(ticketClaimDTOList, TicketClaimVO.class);
    }

    /**
     * 自动减库存，生成出库记录号段，更新申领单
     * @param autoStoreAndOutDTOList
     */
    @ApiLog
    @PostMapping("/auto/out")
    public void autoOut(@RequestBody List<AutoStoreAndOutDTO> autoStoreAndOutDTOList) {
        ticketClaimService.autoOut(autoStoreAndOutDTOList);
    }
    /**
     * 自动增库存，生成入库记录号段
     * @param autoStoreAndOutDTOList
     */
    @ApiLog
    @PostMapping("/auto/store")
    public void autoStore(@RequestBody List<AutoStoreAndOutDTO> autoStoreAndOutDTOList) {
        ticketClaimService.autoStore(autoStoreAndOutDTOList);
    }
}
