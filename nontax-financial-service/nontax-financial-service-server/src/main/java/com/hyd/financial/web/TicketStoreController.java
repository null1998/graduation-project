package com.hyd.financial.web;
import java.util.List;

import com.hyd.common.core.annotation.ApiLog;
import com.hyd.common.util.BeanUtil;
import com.hyd.financial.entity.TicketStore;
import com.hyd.financial.entity.vo.TicketStoreVO;
import com.hyd.financial.service.ITicketStoreService;
import com.hyd.financial.web.dto.TicketStoreDTO;
import com.hyd.financial.web.qo.TicketStoreQO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 票据库存
 * @author huangyanduo
 * @date 2021-03-25
 */
@CrossOrigin
@RestController
@RequestMapping("/ticket/store")
public class TicketStoreController {

    @Autowired
    private ITicketStoreService ticketStoreService;

	/**
     * 保存票据库存
     * @param ticketStoreDTO 票据库存
     * @return id
     */
    @ApiLog
    @PostMapping
    public Long save(@RequestBody TicketStoreDTO ticketStoreDTO) {
        TicketStore ticketStore = BeanUtil.copy(ticketStoreDTO, TicketStore.class);
        return ticketStoreService.save(ticketStore);
    }

	/**
     * 删除票据库存
     * @param id
     * @return 是否删除成功
     */
    @ApiLog
    @DeleteMapping("/{id}")
    public Boolean remove(@PathVariable("id") Long id) {
        return ticketStoreService.remove(id);
    }

	/**
     * 更新票据库存
     * @param ticketStoreDTO 票据库存
     * @return 更新的行数
     */
    @ApiLog
    @PutMapping
    public Integer update(@RequestBody TicketStoreDTO ticketStoreDTO) {
        TicketStore ticketStore = BeanUtil.copy(ticketStoreDTO, TicketStore.class);
        return ticketStoreService.update(ticketStore);
    }

	/**
     * 根据id查询票据库存
     * @param id
     * @return 票据库存
     */
	@ApiLog
    @GetMapping("/{id}")
    public TicketStoreVO getById(@PathVariable("id") Long id) {
        TicketStoreDTO ticketStoreDTO = ticketStoreService.getById(id);
        return BeanUtil.copy(ticketStoreDTO, TicketStoreVO.class);
    }

    /**
     * 通用查询，支持字段id，unitId，ticketId
     * @param ticketStoreQO 票据库存
     * @return 票据库存列表
     */
    @ApiLog
    @GetMapping("/common/query")
    public List<TicketStoreVO> commonQuery(TicketStoreQO ticketStoreQO) {
        TicketStore ticketStore = BeanUtil.copy(ticketStoreQO, TicketStore.class);
        List<TicketStoreDTO> ticketStoreDTOList = ticketStoreService.commonQuery(ticketStore);
        return BeanUtil.copyList(ticketStoreDTOList, TicketStoreVO.class);
    }

    /**
     * 查询单位票据库存
     * @param unitId 单位id
     * @return 票据库存列表
     */
    @ApiLog
    @GetMapping("/number/{unitId}")
    public List<TicketStoreVO> getUnitStorage(@PathVariable("unitId") Long unitId) {
        List<TicketStoreDTO> unitStorage = ticketStoreService.getUnitStorage(unitId);
        return BeanUtil.copyList(unitStorage, TicketStoreVO.class);
    }
}
