package com.hyd.basedata.service;

import com.hyd.basedata.entity.Dictionary;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/1 15:02
 */
public interface IDictionaryService {
    /**
     * 保存字典
     * @param dictionaryCategory 字典
     * @return 字典id
     */
    Long save(Dictionary dictionaryCategory);

    /**
     * 保存字典列表
     * @param dictionaryList 字典列表
     */
    void saveList(List<Dictionary>dictionaryList);

    /**
     * 根据类别名查询
     * @param categoryName
     * @return
     */
    List<Dictionary> listByCategoryName(String categoryName);
}
