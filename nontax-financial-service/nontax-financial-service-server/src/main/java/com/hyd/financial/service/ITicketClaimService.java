package com.hyd.financial.service;
import java.util.List;
import com.hyd.financial.entity.TicketClaim;
import com.hyd.financial.web.dto.AutoStoreAndOutDTO;
import com.hyd.financial.web.dto.TicketClaimDTO;
import com.hyd.financial.web.qo.TicketClaimQO;

/**
 * 票据申领
 * @author huangyanduo
 * @date 2021-03-26
 */
public interface ITicketClaimService {
    /**
     * 保存票据申领
     * @param ticketClaim 票据申领
     * @return id
     */
    Long save(TicketClaim ticketClaim);

    /**
     * 删除票据申领
     * @param id
     * @return 是否删除成功
     */
    Boolean remove(Long id);

    /**
     * 更新票据申领
     * @param ticketClaim 票据申领
     * @return 更新的行数
     */
    Integer update(TicketClaim ticketClaim);

    /**
     * 根据id查询票据申领
     * @param id
     * @return 票据申领
     */
    TicketClaimDTO getById(Long id);

    /**
     * 通用查询，支持字段id,unitId,targetUnitId，status,targetUnitName
     * @param ticketClaim 票据申领
     * @return 票据申领列表
     */
    List<TicketClaimDTO> commonQuery(TicketClaimQO ticketClaim);

    /**
     * 自动减库存，生成出库记录，更新申领单
     * @param autoStoreAndOutDTOList
     */
    void autoOut(List<AutoStoreAndOutDTO> autoStoreAndOutDTOList);
    /**
     * 自动增库存，生成入库记录号段
     * @param autoStoreAndOutDTOList
     */
    void autoStore(List<AutoStoreAndOutDTO> autoStoreAndOutDTOList);
}
