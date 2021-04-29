
package com.hyd.financial.service.impl;

import com.hyd.common.core.exception.BusinessException;
import com.hyd.common.core.exception.code.BusinessErrorCode;
import com.hyd.common.util.BeanUtil;
import com.hyd.common.util.IdGenerator;
import com.hyd.financial.dao.InvoiceMapper;
import com.hyd.financial.entity.Invoice;
import com.hyd.financial.entity.TicketStore;
import com.hyd.financial.service.IInvoiceService;
import com.hyd.financial.service.ITicketStoreService;
import com.hyd.financial.web.dto.InvoiceDTO;
import com.hyd.financial.web.dto.TicketStoreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * 开票管理
 * @author huangyanduo
 * @date 2021-04-22
 */
@Service
public class InvoiceService implements IInvoiceService {

    @Autowired
    private IdGenerator idGenerator;

    @Autowired
    private InvoiceMapper invoiceMapper;

    @Autowired
    private ITicketStoreService ticketStoreService;

	/**
     * 保存开票管理
     * @param invoice 开票管理
     * @return id
     */
    @Caching(evict = {@CacheEvict(value = {"InvoiceService::commonQuery"},allEntries = true)})
    @Override
    public Long save(Invoice invoice) {
        if (invoice == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("开票管理为空"));
        }
        long id = idGenerator.snowflakeId();
        invoice.setId(id);
        long orderNumber = idGenerator.snowflakeId();
        invoice.setOrderNumber(orderNumber);
        // 查询本单位对应票据库存
        TicketStore ticketStore = new TicketStore();
        ticketStore.setTicketId(invoice.getTicketId());
        ticketStore.setUnitId(invoice.getUnitId());
        List<TicketStoreDTO> ticketStoreDTOList = ticketStoreService.commonQuery(ticketStore);
        for (TicketStoreDTO ticketStoreDTO : ticketStoreDTOList) {
            if (ticketStoreDTO.getNumber() > 0) {
                String startNumber = ticketStoreDTO.getStartNumber();
                ticketStoreDTO.setStartNumber(startNumber+1);
                ticketStoreDTO.setNumber(ticketStoreDTO.getNumber()-1);
                ticketStoreDTO.setOperateDate(LocalDate.now());
                ticketStoreDTO.setUserId(invoice.getUserId());
                // 更新库存的起始号,数量，时间，操作人员
                Integer update = ticketStoreService.update(BeanUtil.copy(ticketStoreDTO, TicketStore.class));
                if (update == 1) {
                    // 更新成功
                    invoice.setTicketNumber(startNumber);
                    break;
                }
            }
        }
        if (invoice.getTicketNumber() == null) {
            // 开票失败
            throw new BusinessException(BusinessErrorCode.SYSTEM_DB_OTHER_EXCEPTION, new Exception("开票失败"));
        }
        invoiceMapper.insertSelective(invoice);
        return id;
    }

	/**
     * 删除开票管理
     * @param id
     * @return 是否删除成功
     */
    @Caching(evict = {@CacheEvict(value = {"InvoiceService::commonQuery"},allEntries = true),
            @CacheEvict(value = {"InvoiceService::getById"},key = "#id")})
    @Override
    public Boolean remove(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        return invoiceMapper.deleteByPrimaryKey(id) == 1;
    }

	/**
     * 更新开票管理
     * @param invoice 开票管理
     * @return 更新的行数
     */
    @Caching(evict = {@CacheEvict(value = {"InvoiceService::commonQuery"},allEntries = true),
    @CacheEvict(value = {"InvoiceService::getById"},key = "#invoice.id")})
    @Override
    public Integer update(Invoice invoice) {
        if (invoice == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("开票管理为空"));
        }
        return invoiceMapper.updateByPrimaryKeySelective(invoice);
    }

	/**
     * 根据id查询开票管理
     * @param id
     * @return 开票管理
     */
    @Cacheable(value = "InvoiceService::getById",key = "#id")
    @Override
    public InvoiceDTO getById(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        Optional<Invoice> optional = invoiceMapper.selectByPrimaryKey(id);
		if (optional.isPresent()){
			Invoice invoice = optional.get();
			InvoiceDTO invoiceDTO = BeanUtil.copy(invoice,InvoiceDTO.class);
			setProperties(invoiceDTO);
			return invoiceDTO;
		}
        return new InvoiceDTO();
    }

	/**
     * 通用查询，支持字段id
     * @param invoice 开票管理
     * @return 开票管理列表
     */
	@Cacheable(value = "InvoiceService::commonQuery",key = "#invoice.toString()")
    @Override
    public List<InvoiceDTO> commonQuery(Invoice invoice) {
        if (invoice == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("开票管理为空"));
        }
        List<Invoice> invoiceList = invoiceMapper.commonQuery(invoice);
		List<InvoiceDTO> invoiceDTOList = BeanUtil.copyList(invoiceList, InvoiceDTO.class);
		batchSetProperties(invoiceDTOList);
		return invoiceDTOList;
    }
	/**
	 * 补充一些字段的值
	 * @param invoiceDTO 开票管理
	 */
	private void setProperties(InvoiceDTO invoiceDTO) {
		if (invoiceDTO != null){
		}
	}
	/**
	 * 补充一些字段的值
	 * @param invoiceDTOList 开票管理列表
	 */
	private void batchSetProperties(List<InvoiceDTO> invoiceDTOList) {
		if (invoiceDTOList != null){
		}
	}
}
