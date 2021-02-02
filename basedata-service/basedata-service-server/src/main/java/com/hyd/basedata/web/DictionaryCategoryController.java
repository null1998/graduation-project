package com.hyd.basedata.web;

import com.hyd.basedata.entity.DictionaryCategory;
import com.hyd.basedata.service.IDictionaryCategoryService;
import com.hyd.basedata.web.dto.DictionaryCategoryDTO;
import com.sd365.common.log.api.annotation.ApiLog;
import com.sd365.common.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanduohuang
 * @date 2021/2/1 15:05
 */
@RestController
@RequestMapping(value = "/dictionary/category")
public class DictionaryCategoryController {
    @Autowired
    private IDictionaryCategoryService dictionaryCategoryService;

    /**
     * 保存字典分类
     * @param dictionaryCategoryDTO 字典分类
     * @return 字典分类ID
     */
    @ApiLog
    @PostMapping
    public Long save(@RequestBody  DictionaryCategoryDTO dictionaryCategoryDTO) {
        DictionaryCategory dictionaryCategory = BeanUtil.copy(dictionaryCategoryDTO, DictionaryCategory.class);
        return dictionaryCategoryService.save(dictionaryCategory);
    }
}
