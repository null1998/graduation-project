package com.hyd.financial.service.impl;
import java.util.List;
import java.util.Optional;

import com.hyd.basedata.entity.Unit;
import com.hyd.basedata.service.IUnitService;
import com.hyd.common.core.exception.BusinessException;
import com.hyd.common.core.exception.code.BusinessErrorCode;
import com.hyd.common.util.BeanUtil;
import com.hyd.common.util.IdGenerator;
import com.hyd.financial.dao.PaymentMapper;
import com.hyd.financial.entity.Payment;
import com.hyd.financial.service.IPaymentService;
import com.hyd.financial.web.dto.PaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

/**
 * 票据结算
 * @author huangyanduo
 * @date 2021-03-26
 */
@Service
public class PaymentService implements IPaymentService {

    @Autowired
    private IdGenerator idGenerator;

    @Autowired
    private PaymentMapper paymentMapper;

    @Autowired
    private IUnitService unitService;

	/**
     * 保存票据结算
     * @param payment 票据结算
     * @return id
     */
    @Caching(evict = {@CacheEvict(value = {"PaymentService::commonQuery"},allEntries = true)})
    @Override
    public Long save(Payment payment) {
        if (payment == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("票据结算为空"));
        }
        long id = idGenerator.snowflakeId();
        payment.setId(id);
        long orderNumber = idGenerator.snowflakeId();
        payment.setOrderNumber(orderNumber);
        paymentMapper.insertSelective(payment);
        return id;
    }

	/**
     * 删除票据结算
     * @param id
     * @return 是否删除成功
     */
    @Caching(evict = {@CacheEvict(value = {"PaymentService::commonQuery"},allEntries = true),
            @CacheEvict(value = {"PaymentService::getById"},key = "#id")})
    @Override
    public Boolean remove(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        return paymentMapper.deleteByPrimaryKey(id) == 1;
    }

	/**
     * 更新票据结算
     * @param payment 票据结算
     * @return 更新的行数
     */
    @Caching(evict = {@CacheEvict(value = {"PaymentService::commonQuery"},allEntries = true),
    @CacheEvict(value = {"PaymentService::getById"},key = "#payment.id")})
    @Override
    public Integer update(Payment payment) {
        if (payment == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("票据结算为空"));
        }
        return paymentMapper.updateByPrimaryKeySelective(payment);
    }

	/**
     * 根据id查询票据结算
     * @param id
     * @return 票据结算
     */
    @Cacheable(value = "PaymentService::getById",key = "#id")
    @Override
    public PaymentDTO getById(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        Optional<Payment> optional = paymentMapper.selectByPrimaryKey(id);
		if (optional.isPresent()){
			Payment payment = optional.get();
			PaymentDTO paymentDTO = BeanUtil.copy(payment,PaymentDTO.class);
			setProperties(paymentDTO);
			return paymentDTO;
		}
        return new PaymentDTO();
    }

	/**
     * 通用查询，支持字段id
     * @param payment 票据结算
     * @return 票据结算列表
     */
	@Cacheable(value = "PaymentService::commonQuery",key = "#payment.toString()")
    @Override
    public List<PaymentDTO> commonQuery(Payment payment) {
        if (payment == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("票据结算为空"));
        }
        List<Payment> paymentList = paymentMapper.commonQuery(payment);
		List<PaymentDTO> paymentDTOList = BeanUtil.copyList(paymentList, PaymentDTO.class);
		for (PaymentDTO paymentDTO : paymentDTOList) {
			setProperties(paymentDTO);
		}
		return paymentDTOList;
    }
	/**
	 * 补充一些字段的值
	 * @param paymentDTO 票据结算
	 */
	private void setProperties(PaymentDTO paymentDTO) {
		if (paymentDTO != null){
            if (paymentDTO.getSrcUnitId() != null) {
                Unit unit = unitService.getUnitById(paymentDTO.getSrcUnitId());
                paymentDTO.setSrcUnitName(unit.getName());
            }
            if (paymentDTO.getDesUnitId() != null) {
                Unit unit = unitService.getUnitById(paymentDTO.getDesUnitId());
                paymentDTO.setDesUnitName(unit.getName());
            }
		}
	}
}
