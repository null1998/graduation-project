package com.hyd.basedata.web;

import com.hyd.basedata.entity.Dictionary;
import com.hyd.basedata.service.IDictionaryService;
import com.hyd.basedata.web.dto.DictionaryDTO;
import com.sd365.common.log.api.annotation.ApiLog;
import com.sd365.common.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/1 15:06
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/dictionary")
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;

    /**
     * 保存字典
     * @param dictionaryDTO 字典
     * @return 字典ID
     */
    @ApiLog
    @PostMapping
    public Long save(@RequestBody DictionaryDTO dictionaryDTO) {
        Dictionary dictionary = BeanUtil.copy(dictionaryDTO, Dictionary.class);
        return dictionaryService.save(dictionary);
    }

    /**
     * 批量保存字典
     * @param dictionaryDTOList 字典列表
     */
    @ApiLog
    @PostMapping(value = "/list")
    public void saveList(@RequestBody List<DictionaryDTO> dictionaryDTOList) {
        List<Dictionary> dictionaryList = BeanUtil.copyList(dictionaryDTOList, Dictionary.class);
        dictionaryService.saveList(dictionaryList);
    }

}
