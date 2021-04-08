package com.hyd.financial.web;
import java.util.List;

import com.hyd.common.core.annotation.ApiLog;
import com.hyd.common.util.BeanUtil;
import com.hyd.financial.entity.Payment;
import com.hyd.financial.entity.vo.PaymentVO;
import com.hyd.financial.service.IPaymentService;
import com.hyd.financial.web.dto.PaymentDTO;
import com.hyd.financial.web.qo.PaymentQO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 票据结算
 * @author huangyanduo
 * @date 2021-03-26
 */
@CrossOrigin
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;

	/**
     * 保存票据结算
     * @param paymentDTO 票据结算
     * @return id
     */
    @ApiLog
    @PostMapping
    public Long save(@RequestBody PaymentDTO paymentDTO) {
        Payment payment = BeanUtil.copy(paymentDTO, Payment.class);
        return paymentService.save(payment);
    }

	/**
     * 删除票据结算
     * @param id
     * @return 是否删除成功
     */
    @ApiLog
    @DeleteMapping("/{id}")
    public Boolean remove(@PathVariable("id") Long id) {
        return paymentService.remove(id);
    }

	/**
     * 更新票据结算
     * @param paymentDTO 票据结算
     * @return 更新的行数
     */
    @ApiLog
    @PutMapping
    public Integer update(@RequestBody PaymentDTO paymentDTO) {
        Payment payment = BeanUtil.copy(paymentDTO, Payment.class);
        return paymentService.update(payment);
    }

	/**
     * 根据id查询票据结算
     * @param id
     * @return 票据结算
     */
	@ApiLog
    @GetMapping("/{id}")
    public PaymentVO getById(@PathVariable("id") Long id) {
        PaymentDTO paymentDTO = paymentService.getById(id);
        return BeanUtil.copy(paymentDTO, PaymentVO.class);
    }

    /**
     * 通用查询，支持字段id,srcUnitId
     * @param paymentQO 票据结算
     * @return 票据结算列表
     */
    @ApiLog
    @GetMapping("/common/query")
    public List<PaymentVO> commonQuery(PaymentQO paymentQO) {
        Payment payment = BeanUtil.copy(paymentQO, Payment.class);
        List<PaymentDTO> paymentDTOList = paymentService.commonQuery(payment);
        return BeanUtil.copyList(paymentDTOList, PaymentVO.class);
    }

}
