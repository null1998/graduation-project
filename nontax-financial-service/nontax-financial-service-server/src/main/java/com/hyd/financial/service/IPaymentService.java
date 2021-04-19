package com.hyd.financial.service;
import java.util.List;
import com.hyd.financial.entity.Payment;
import com.hyd.financial.web.dto.PaymentDTO;

/**
 * 票据结算
 * @author huangyanduo
 * @date 2021-03-26
 */
public interface IPaymentService {
    /**
     * 保存票据结算
     * @param payment 票据结算
     * @return id
     */
    Long save(Payment payment);

    /**
     * 删除票据结算
     * @param id
     * @return 是否删除成功
     */
    Boolean remove(Long id);

    /**
     * 批量删除
     * @param idList
     * @return
     */
    Integer removeAll(List<Long> idList);
    /**
     * 更新票据结算
     * @param payment 票据结算
     * @return 更新的行数
     */
    Integer update(Payment payment);

    /**
     * 根据id查询票据结算
     * @param id
     * @return 票据结算
     */
    PaymentDTO getById(Long id);

    /**
     * 通用查询，支持字段id,srcUnitId
     * @param payment 票据结算
     * @return 票据结算列表
     */
    List<PaymentDTO> commonQuery(Payment payment);

}
