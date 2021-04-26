package com.hyd.financial.web;
import java.util.List;

import com.hyd.common.core.annotation.ApiLog;
import com.hyd.common.core.annotation.PageHelper;
import com.hyd.common.util.BeanUtil;
import com.hyd.financial.entity.TicketOutRecord;
import com.hyd.financial.entity.vo.TicketOutRecordVO;
import com.hyd.financial.service.ITicketOutRecordService;
import com.hyd.financial.web.dto.LineChartDTO;
import com.hyd.financial.web.dto.TicketOutRecordDTO;
import com.hyd.financial.web.qo.TicketOutRecordQO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 票据出库记录
 * @author huangyanduo
 * @date 2021-04-05
 */
@CrossOrigin
@RestController
@RequestMapping("/ticket/out/record")
public class TicketOutRecordController {

    @Autowired
    private ITicketOutRecordService ticketOutRecordService;

	/**
     * 保存票据出库记录
     * @param ticketOutRecordDTO 票据出库记录
     * @return id
     */
    @ApiLog
    @PostMapping
    public Long save(@RequestBody TicketOutRecordDTO ticketOutRecordDTO) {
        TicketOutRecord ticketOutRecord = BeanUtil.copy(ticketOutRecordDTO, TicketOutRecord.class);
        return ticketOutRecordService.save(ticketOutRecord);
    }

	/**
     * 删除票据出库记录
     * @param id
     * @return 是否删除成功
     */
    @ApiLog
    @DeleteMapping("/{id}")
    public Boolean remove(@PathVariable("id") Long id) {
        return ticketOutRecordService.remove(id);
    }

	/**
     * 更新票据出库记录
     * @param ticketOutRecordDTO 票据出库记录
     * @return 更新的行数
     */
    @ApiLog
    @PutMapping
    public Integer update(@RequestBody TicketOutRecordDTO ticketOutRecordDTO) {
        TicketOutRecord ticketOutRecord = BeanUtil.copy(ticketOutRecordDTO, TicketOutRecord.class);
        return ticketOutRecordService.update(ticketOutRecord);
    }

	/**
     * 根据id查询票据出库记录
     * @param id
     * @return 票据出库记录
     */
	@ApiLog
    @GetMapping("/{id}")
    public TicketOutRecordVO getById(@PathVariable("id") Long id) {
        TicketOutRecordDTO ticketOutRecordDTO = ticketOutRecordService.getById(id);
        return BeanUtil.copy(ticketOutRecordDTO, TicketOutRecordVO.class);
    }

    /**
     * 通用查询，支持字段id,ticketOutRecordId,targetUnitName
     * @param ticketOutRecordQO 票据出库记录
     * @return 票据出库记录列表
     */
    @PageHelper
    @ApiLog
    @GetMapping("/common/query")
    public List<TicketOutRecordVO> commonQuery(TicketOutRecordQO ticketOutRecordQO) {
        List<TicketOutRecordDTO> ticketOutRecordDTOList = ticketOutRecordService.commonQuery(ticketOutRecordQO);
        return BeanUtil.copyList(ticketOutRecordDTOList, TicketOutRecordVO.class);
    }
    /**
     * 某单位最近一周出库记录折线图
     * @param unitId
     * @return
     */
    @ApiLog
    @GetMapping("/recent/{unitId}")
    public LineChartDTO recent(@PathVariable("unitId") Long unitId) {
        return ticketOutRecordService.recent(unitId);
    }

}
