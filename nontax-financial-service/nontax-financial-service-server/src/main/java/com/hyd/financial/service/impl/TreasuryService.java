
package com.hyd.financial.service.impl;
import com.hyd.common.core.exception.BusinessException;
import com.hyd.common.core.exception.code.BusinessErrorCode;
import com.hyd.common.util.BeanUtil;
import com.hyd.common.util.IdGenerator;
import com.hyd.financial.dao.TreasuryMapper;
import com.hyd.financial.entity.Treasury;
import com.hyd.financial.service.ITreasuryService;
import com.hyd.financial.web.dto.TreasuryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 财政金库
 * @author huangyanduo
 * @date 2021-04-22
 */
@Service
public class TreasuryService implements ITreasuryService {

    @Autowired
    private IdGenerator idGenerator;

    @Autowired
    private TreasuryMapper treasuryMapper;

	/**
     * 保存财政金库
     * @param treasury 财政金库
     * @return id
     */
    @Caching(evict = {@CacheEvict(value = {"TreasuryService::commonQuery"},allEntries = true)})
    @Override
    public Long save(Treasury treasury) {
        if (treasury == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("财政金库为空"));
        }
        long id = idGenerator.snowflakeId();
        treasury.setId(id);
        treasuryMapper.insertSelective(treasury);
        return id;
    }

	/**
     * 删除财政金库
     * @param id
     * @return 是否删除成功
     */
    @Caching(evict = {@CacheEvict(value = {"TreasuryService::commonQuery"},allEntries = true),
            @CacheEvict(value = {"TreasuryService::getById"},key = "#id")})
    @Override
    public Boolean remove(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        return treasuryMapper.deleteByPrimaryKey(id) == 1;
    }

	/**
     * 更新财政金库
     * @param treasury 财政金库
     * @return 更新的行数
     */
    @Caching(evict = {@CacheEvict(value = {"TreasuryService::commonQuery"},allEntries = true),
    @CacheEvict(value = {"TreasuryService::getById"},key = "#treasury.id")})
    @Override
    public Integer update(Treasury treasury) {
        if (treasury == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("财政金库为空"));
        }
        return treasuryMapper.updateByPrimaryKeySelective(treasury);
    }

	/**
     * 根据id查询财政金库
     * @param id
     * @return 财政金库
     */
    @Cacheable(value = "TreasuryService::getById",key = "#id")
    @Override
    public TreasuryDTO getById(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        Optional<Treasury> optional = treasuryMapper.selectByPrimaryKey(id);
		if (optional.isPresent()){
			Treasury treasury = optional.get();
			TreasuryDTO treasuryDTO = BeanUtil.copy(treasury,TreasuryDTO.class);
			setProperties(treasuryDTO);
			return treasuryDTO;
		}
        return new TreasuryDTO();
    }

	/**
     * 通用查询，支持字段id
     * @param treasury 财政金库
     * @return 财政金库列表
     */
	@Cacheable(value = "TreasuryService::commonQuery",key = "#treasury.toString()")
    @Override
    public List<TreasuryDTO> commonQuery(Treasury treasury) {
        if (treasury == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("财政金库为空"));
        }
        List<Treasury> treasuryList = treasuryMapper.commonQuery(treasury);
		List<TreasuryDTO> treasuryDTOList = BeanUtil.copyList(treasuryList, TreasuryDTO.class);
		batchSetProperties(treasuryDTOList);
		return treasuryDTOList;
    }

	/**
	 * 补充一些字段的值
	 * @param treasuryDTO 财政金库
	 */
	private void setProperties(TreasuryDTO treasuryDTO) {
		if (treasuryDTO != null){
		}
	}
	/**
	 * 补充一些字段的值
	 * @param treasuryDTOList 财政金库列表
	 */
	private void batchSetProperties(List<TreasuryDTO> treasuryDTOList) {
		if (treasuryDTOList != null){
		}
	}
}
