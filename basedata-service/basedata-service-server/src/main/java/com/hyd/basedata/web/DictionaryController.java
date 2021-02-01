package com.hyd.basedata.web;

import com.hyd.basedata.entity.Dictionary;
import com.hyd.basedata.service.IDictionaryService;
import com.hyd.basedata.web.dto.DictionaryDTO;
import com.sd365.common.log.api.annotation.ApiLog;
import com.sd365.common.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/1 15:06
 */
@RestController
@RequestMapping(value = "/dictionary")
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;
    @ApiLog
    @PostMapping
    public Long save(@RequestBody DictionaryDTO dictionaryDTO) {
        Dictionary dictionary = BeanUtil.copy(dictionaryDTO, Dictionary.class);
        return dictionaryService.save(dictionary);
    }
    @ApiLog
    @PostMapping(value = "/list")
    public void saveList(@RequestBody List<DictionaryDTO> dictionaryDTOList) {
        List<Dictionary> dictionaryList = BeanUtil.copyList(dictionaryDTOList, Dictionary.class);
        dictionaryService.saveList(dictionaryList);
    }

}
