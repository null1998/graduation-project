package com.hyd.financial.service.impl;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
        payment.setOrderDate(LocalDate.now());
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
    @Override
    public Integer removeAll(List<Long> idList) {
        if (idList == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("参数为空"));
        }

        Integer deleteAll = paymentMapper.deleteAll(idList);
        if (deleteAll != idList.size()) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_DB_OTHER_EXCEPTION, new Exception("删除失败"));
        }
        return deleteAll;
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
        payment.setPayDate(LocalDate.now());
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
     * 通用查询，支持字段id,srcUnitId
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
		batchSetProperties(paymentDTOList);
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

    /**
     * 批量设置字段
     * @param paymentDTOList
     */
	private void batchSetProperties(List<PaymentDTO> paymentDTOList) {
        if (paymentDTOList != null) {
            List<Long> srcUnitIdList = paymentDTOList.stream().map(PaymentDTO::getSrcUnitId).collect(Collectors.toList());
            List<Long> desUnitIdList = paymentDTOList.stream().map(PaymentDTO::getDesUnitId).collect(Collectors.toList());
            Map<Long, String> srcUnitMap = unitService.listByUnitIdList(srcUnitIdList).stream().collect(Collectors.toMap(Unit::getId,Unit::getName));
            Map<Long, String> desUnitMap = unitService.listByUnitIdList(desUnitIdList).stream().collect(Collectors.toMap(Unit::getId,Unit::getName));
            paymentDTOList.forEach(e->{
                e.setSrcUnitName(srcUnitMap.get(e.getSrcUnitId()));
                e.setDesUnitName(desUnitMap.get(e.getDesUnitId()));
            });
        }
    }
}
