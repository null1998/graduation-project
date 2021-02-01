package com.hyd.basedata.service;

import com.hyd.basedata.entity.DictionaryCategory;

/**
 * @author yanduohuang
 * @date 2021/2/1 14:57
 */
public interface IDictionaryCategoryService {
    /**
     * 保存字典分类
     * @param dictionaryCategory 字典分类
     * @return 字典分类id
     */
    Long save(DictionaryCategory dictionaryCategory);
}
