
package com.hyd.financial.service.impl;

import com.hyd.basedata.entity.Ticket;
import com.hyd.basedata.service.ITicketService;
import com.hyd.common.core.exception.BusinessException;
import com.hyd.common.core.exception.code.BusinessErrorCode;
import com.hyd.common.util.BeanUtil;
import com.hyd.common.util.IdGenerator;
import com.hyd.financial.dao.InvoiceMapper;
import com.hyd.financial.entity.Invoice;
import com.hyd.financial.entity.TicketStore;
import com.hyd.financial.service.IInvoiceService;
import com.hyd.financial.service.ITicketStoreService;
import com.hyd.financial.util.TicketCodeConvertUtil;
import com.hyd.financial.web.dto.InvoiceDTO;
import com.hyd.financial.web.dto.InvoicePieDTO;
import com.hyd.financial.web.dto.TicketStoreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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

    @Resource
    private IInvoiceService invoiceService;

    @Resource
    private ITicketService ticketService;

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
                Long l = TicketCodeConvertUtil.stringConvertLong(startNumber)+1;
                ticketStoreDTO.setStartNumber(TicketCodeConvertUtil.longConvertString(l));
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
     * 通用查询，支持字段id,unitId
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

    @Override
    public List<InvoicePieDTO> analysisTicketNumber(Long unitId) {
        if (unitId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("单位ID为空"));
        }
        Invoice query = new Invoice();
        query.setUnitId(unitId);
        // 查询本单位的开票信息
        List<InvoiceDTO> invoiceDTOList = invoiceService.commonQuery(query);
        // 统计每个ticketId对应的number
        Map<Long, Long> collect = invoiceDTOList.stream().collect(Collectors.groupingBy(InvoiceDTO::getTicketId, Collectors.counting()));
        // 批量获取票据名
        Map<Long, String> ticketNameMap = ticketService.listByTicketIdList(new ArrayList<>(collect.keySet())).stream().collect(Collectors.toMap(Ticket::getId, Ticket::getName));
        List<InvoicePieDTO> result = new ArrayList<>();
        collect.forEach((k,v)->{
            // 赋值
            InvoicePieDTO invoicePieDTO = new InvoicePieDTO();
            invoicePieDTO.setTicketName(ticketNameMap.get(k));
            invoicePieDTO.setNumber(v);
            result.add(invoicePieDTO);
        });
        return result;
    }

    @Override
    public List<InvoicePieDTO> analysisTicketPrice(Long unitId) {
        if (unitId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("单位ID为空"));
        }
        Invoice query = new Invoice();
        query.setUnitId(unitId);
        // 查询本单位的开票信息
        List<InvoiceDTO> invoiceDTOList = invoiceService.commonQuery(query);
        // 统计每个ticketId对应的总金额
        Map<Long, BigDecimal> collect = new HashMap<>();
        for (InvoiceDTO invoiceDTO : invoiceDTOList) {
            if (invoiceDTO.getTicketId() != null) {
                if (collect.get(invoiceDTO.getTicketId()) != null) {
                    collect.put(invoiceDTO.getTicketId(), collect.get(invoiceDTO.getTicketId()).add(invoiceDTO.getPrice()));
                } else {
                    collect.put(invoiceDTO.getTicketId(), invoiceDTO.getPrice());

                }
            }

        }
        // 批量获取票据名
        Map<Long, String> ticketNameMap = ticketService.listByTicketIdList(new ArrayList<>(collect.keySet())).stream().collect(Collectors.toMap(Ticket::getId, Ticket::getName));
        List<InvoicePieDTO> result = new ArrayList<>();
        collect.forEach((k,v)->{
            // 赋值
            InvoicePieDTO invoicePieDTO = new InvoicePieDTO();
            invoicePieDTO.setTicketName(ticketNameMap.get(k));
            invoicePieDTO.setPrice(v);
            result.add(invoicePieDTO);
        });
        return result;
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
