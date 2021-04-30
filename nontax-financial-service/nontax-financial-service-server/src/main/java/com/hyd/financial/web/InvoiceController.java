package com.hyd.financial.web;

import com.hyd.common.core.annotation.ApiLog;
import com.hyd.common.util.BeanUtil;
import com.hyd.financial.entity.Invoice;
import com.hyd.financial.entity.vo.InvoiceVO;
import com.hyd.financial.service.IInvoiceService;
import com.hyd.financial.web.dto.InvoiceDTO;
import com.hyd.financial.web.dto.InvoicePieDTO;
import com.hyd.financial.web.qo.InvoiceQO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 开票管理
 * @author huangyanduo
 * @date 2021-04-22
 */
@CrossOrigin
@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private IInvoiceService invoiceService;

	/**
     * 保存开票管理
     * @param invoiceDTO 开票管理
     * @return id
     */
    @ApiLog
    @PostMapping
    public Long save(@RequestBody InvoiceDTO invoiceDTO) {
        Invoice invoice = BeanUtil.copy(invoiceDTO, Invoice.class);
        return invoiceService.save(invoice);
    }

	/**
     * 删除开票管理
     * @param id
     * @return 是否删除成功
     */
    @ApiLog
    @DeleteMapping("/{id}")
    public Boolean remove(@PathVariable("id") Long id) {
        return invoiceService.remove(id);
    }

	/**
     * 更新开票管理
     * @param invoiceDTO 开票管理
     * @return 更新的行数
     */
    @ApiLog
    @PutMapping
    public Integer update(@RequestBody InvoiceDTO invoiceDTO) {
        Invoice invoice = BeanUtil.copy(invoiceDTO, Invoice.class);
        return invoiceService.update(invoice);
    }

	/**
     * 根据id查询开票管理
     * @param id
     * @return 开票管理
     */
	@ApiLog
    @GetMapping("/{id}")
    public InvoiceVO getById(@PathVariable("id") Long id) {
        InvoiceDTO invoiceDTO = invoiceService.getById(id);
        return BeanUtil.copy(invoiceDTO, InvoiceVO.class);
    }

    /**
     * 通用查询，支持字段id,unitId
     * @param invoiceQO 开票管理
     * @return 开票管理列表
     */
    @ApiLog
    @GetMapping("/common/query")
    public List<InvoiceVO> commonQuery(InvoiceQO invoiceQO) {
        Invoice invoice = BeanUtil.copy(invoiceQO, Invoice.class);
        List<InvoiceDTO> invoiceDTOList = invoiceService.commonQuery(invoice);
        return BeanUtil.copyList(invoiceDTOList, InvoiceVO.class);
    }
    /**
     * 分析某单位每种票据开票数量
     * @param unitId
     * @return
     */
    @ApiLog
    @GetMapping("/analysis/number/{unitId}")
    public List<InvoicePieDTO> analysisTicketNumber(@PathVariable("unitId") Long unitId) {
        return invoiceService.analysisTicketNumber(unitId);
    }
    /**
     * 分析某单位每种票据开票总金额
     * @param unitId
     * @return
     */
    @ApiLog
    @GetMapping("/analysis/price/{unitId}")
    public List<InvoicePieDTO> analysisTicketPrice(@PathVariable("unitId") Long unitId) {
        return invoiceService.analysisTicketPrice(unitId);
    }

}
