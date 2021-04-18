package com.hyd.financial.web;

import com.hyd.common.core.annotation.ApiLog;
import com.hyd.common.util.BeanUtil;
import com.hyd.financial.entity.PrintingOrder;
import com.hyd.financial.entity.vo.PrintingOrderVO;
import com.hyd.financial.service.IPrintingOrderService;
import com.hyd.financial.web.dto.AutoStoreAndOutDTO;
import com.hyd.financial.web.dto.PrintingOrderDTO;
import com.hyd.financial.web.qo.PrintingOrderQO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/3/18 19:00
 */
@CrossOrigin
@RestController
@RequestMapping("/printing/order")
public class PrintingOrderController {
    @Autowired
    IPrintingOrderService printingOrderService;
    @ApiLog
    @PostMapping
    public Long save(@RequestBody PrintingOrderDTO printingOrderDTO) {
        PrintingOrder printingOrder = BeanUtil.copy(printingOrderDTO, PrintingOrder.class);
        return printingOrderService.save(printingOrder);
    }
    @ApiLog
    @DeleteMapping("/{id}")
    public Boolean remove(@PathVariable("id") Long id) {

        return printingOrderService.remove(id);
    }
    @ApiLog
    @PutMapping
    public Integer update(@RequestBody PrintingOrderDTO printingOrderDTO) {
        PrintingOrder printingOrder = BeanUtil.copy(printingOrderDTO, PrintingOrder.class);
        return printingOrderService.update(printingOrder);
    }
    @ApiLog
    @GetMapping("/{id}")
    public PrintingOrderVO getById(@PathVariable("id") Long id) {
        PrintingOrderDTO printingOrderDTO = printingOrderService.getById(id);
        return BeanUtil.copy(printingOrderDTO, PrintingOrderVO.class);
    }
    /**
     * 通用查询，支持id，unitId，printUnitId，status字段
     * @param printingOrderQO
     * @return
     */
    @ApiLog
    @GetMapping("/common/query")
    public List<PrintingOrderVO> commonQuery(PrintingOrderQO printingOrderQO) {
        PrintingOrder printingOrder = BeanUtil.copy(printingOrderQO, PrintingOrder.class);
        List<PrintingOrderDTO> printingOrderDTOList = printingOrderService.commonQuery(printingOrder);
        return BeanUtil.copyList(printingOrderDTOList, PrintingOrderVO.class);
    }
    /**
     * 自动增库存，生成入库记录号段
     * @param autoStoreAndOutDTOList
     */
    @ApiLog
    @PostMapping("/auto/store")
    public void autoStore(@RequestBody List<AutoStoreAndOutDTO> autoStoreAndOutDTOList) {
        printingOrderService.autoStore(autoStoreAndOutDTOList);
    }

}
