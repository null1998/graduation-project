package com.hyd.financial.service;
import java.util.List;
import com.hyd.financial.entity.Treasury;
import com.hyd.financial.web.dto.TreasuryDTO;

/**
 * 财政金库
 * @author huangyanduo
 * @date 2021-04-22
 */
public interface ITreasuryService {
    /**
     * 保存财政金库
     * @param treasury 财政金库
     * @return id
     */
    Long save(Treasury treasury);

    /**
     * 删除财政金库
     * @param id
     * @return 是否删除成功
     */
    Boolean remove(Long id);

    /**
     * 更新财政金库
     * @param treasury 财政金库
     * @return 更新的行数
     */
    Integer update(Treasury treasury);

    /**
     * 根据id查询财政金库
     * @param id
     * @return 财政金库
     */
    TreasuryDTO getById(Long id);

    /**
     * 通用查询，支持字段id
     * @param treasury 财政金库
     * @return 财政金库列表
     */
    List<TreasuryDTO> commonQuery(Treasury treasury);

}
