package com.hyd.financial.web;

import com.hyd.common.core.annotation.ApiLog;
import com.hyd.common.util.BeanUtil;
import com.hyd.financial.entity.Settlement;
import com.hyd.financial.entity.vo.SettlementVO;
import com.hyd.financial.service.ISettlementService;
import com.hyd.financial.web.dto.SettlementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/3 11:31
 */
@CrossOrigin
@RestController
@RequestMapping("/settlement")
public class SettlementController {
    @Autowired
    private ISettlementService settlementService;
    /**
     * 保存
     * @param settlementDTO 结算单
     * @return 结算单ID
     */
    @ApiLog
    @PostMapping
    public Long save(@RequestBody SettlementDTO settlementDTO) {
        Settlement settlement = BeanUtil.copy(settlementDTO, Settlement.class);
        return settlementService.save(settlement);
    }
    /**
     * 删除
     * @param id
     * @return 是否删除成功
     */
    @ApiLog
    @DeleteMapping("/{id}")
    public Boolean remove(@PathVariable("id") Long id) {
        return settlementService.remove(id);
    }
    /**
     * 更新
     * @param settlementDTO 结算单
     * @return 更新行数
     */
    @ApiLog
    @PutMapping
    public Integer update(@RequestBody SettlementDTO settlementDTO) {
        Settlement settlement = BeanUtil.copy(settlementDTO, Settlement.class);
        return settlementService.update(settlement);
    }
    /**
     * 根据结算单位ID查询结算单列表
     * @param settlementUnitId 结算单位ID
     * @return 结算单列表
     */
    @ApiLog
    @GetMapping(value = "/list/{settlementUnitId}")
    public List<SettlementVO> listBySettlementUnitId(@PathVariable("settlementUnitId") Long settlementUnitId) {
        List<Settlement> settlementList = settlementService.listBySettlementUnitId(settlementUnitId);
        return BeanUtil.copyList(settlementList, SettlementVO.class);
    }
    /**
     * 根据处理单位ID查询结算单列表
     * @param unitId 处理单位ID
     * @return 结算单列表
     */
    @ApiLog
    @GetMapping(value = "/list/child/{unitId}")
    public List<SettlementVO> listByUnitId(@PathVariable("unitId") Long unitId) {
        List<Settlement> settlementList = settlementService.listByUnitId(unitId);
        return BeanUtil.copyList(settlementList, SettlementVO.class);
    }
}
