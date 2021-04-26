package com.hyd.financial.web;
import java.util.List;

import com.hyd.common.core.annotation.ApiLog;
import com.hyd.common.util.BeanUtil;
import com.hyd.financial.entity.Treasury;
import com.hyd.financial.entity.vo.TreasuryVO;
import com.hyd.financial.service.ITreasuryService;
import com.hyd.financial.web.dto.TreasuryDTO;
import com.hyd.financial.web.qo.TreasuryQO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 财政金库
 * @author huangyanduo
 * @date 2021-04-22
 */
@CrossOrigin
@RestController
@RequestMapping("/treasury")
public class TreasuryController {

    @Autowired
    private ITreasuryService treasuryService;

	/**
     * 保存财政金库
     * @param treasuryDTO 财政金库
     * @return id
     */
    @ApiLog
    @PostMapping
    public Long save(@RequestBody TreasuryDTO treasuryDTO) {
        Treasury treasury = BeanUtil.copy(treasuryDTO, Treasury.class);
        return treasuryService.save(treasury);
    }

	/**
     * 删除财政金库
     * @param id
     * @return 是否删除成功
     */
    @ApiLog
    @DeleteMapping("/{id}")
    public Boolean remove(@PathVariable("id") Long id) {
        return treasuryService.remove(id);
    }

	/**
     * 更新财政金库
     * @param treasuryDTO 财政金库
     * @return 更新的行数
     */
    @ApiLog
    @PutMapping
    public Integer update(@RequestBody TreasuryDTO treasuryDTO) {
        Treasury treasury = BeanUtil.copy(treasuryDTO, Treasury.class);
        return treasuryService.update(treasury);
    }

	/**
     * 根据id查询财政金库
     * @param id
     * @return 财政金库
     */
	@ApiLog
    @GetMapping("/{id}")
    public TreasuryVO getById(@PathVariable("id") Long id) {
        TreasuryDTO treasuryDTO = treasuryService.getById(id);
        return BeanUtil.copy(treasuryDTO, TreasuryVO.class);
    }

    /**
     * 通用查询，支持字段id
     * @param treasuryQO 财政金库
     * @return 财政金库列表
     */
    @ApiLog
    @GetMapping("/common/query")
    public List<TreasuryVO> commonQuery(TreasuryQO treasuryQO) {
        Treasury treasury = BeanUtil.copy(treasuryQO, Treasury.class);
        List<TreasuryDTO> treasuryDTOList = treasuryService.commonQuery(treasury);
        return BeanUtil.copyList(treasuryDTOList, TreasuryVO.class);
    }

}
