package com.hyd.financial.web;

import com.hyd.common.core.annotation.ApiLog;
import com.hyd.common.util.BeanUtil;
import com.hyd.financial.entity.PrintingOrderTicket;
import com.hyd.financial.service.IPrintingOrderTicketService;
import com.hyd.financial.web.dto.PrintingOrderTicketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/3/18 19:43
 */
@CrossOrigin
@RestController
@RequestMapping("/printing/order/ticket")
public class PrintingOrderTicketController {
    @Autowired
    private IPrintingOrderTicketService printingOrderTicketService;
    @ApiLog
    @PostMapping
    public Long save(@RequestBody PrintingOrderTicketDTO printingOrderTicketDTO) {
        PrintingOrderTicket printingOrderTicket = BeanUtil.copy(printingOrderTicketDTO, PrintingOrderTicket.class);
        return printingOrderTicketService.save(printingOrderTicket);
    }
    @ApiLog
    @PostMapping("/list")
    public void saveList(@RequestBody List<PrintingOrderTicketDTO> printingOrderTicketDTOList) {
        List<PrintingOrderTicket> printingOrderTicketList = BeanUtil.copyList(printingOrderTicketDTOList, PrintingOrderTicket.class);
        printingOrderTicketService.saveList(printingOrderTicketList);
    }
    @ApiLog
    @DeleteMapping("/{id}")
    public Boolean remove(@PathVariable("id") Long id) {
        return printingOrderTicketService.remove(id);
    }
    @ApiLog
    @PutMapping
    public Integer update(@RequestBody PrintingOrderTicketDTO printingOrderTicketDTO) {
        PrintingOrderTicket printingOrderTicket = BeanUtil.copy(printingOrderTicketDTO, PrintingOrderTicket.class);
        return printingOrderTicketService.update(printingOrderTicket);
    }
    @ApiLog
    @GetMapping("/printing/order/{printingOrderId}")
    public List<PrintingOrderTicket> listByPrintingOrderId(@PathVariable("printingOrderId") Long printingOrderId) {
        return printingOrderTicketService.listByPrintingOrderId(printingOrderId);
    }
}
