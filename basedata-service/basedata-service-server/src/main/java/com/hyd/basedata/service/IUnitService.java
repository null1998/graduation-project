package com.hyd.basedata.service;


import com.hyd.basedata.entity.Unit;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/1/29 16:26
 */
public interface IUnitService {
    /**
     * 保存单位
     * @param unit 单位
     * @return 单位id
     */
    Long save(Unit unit);

    /**
     * 根据ID查询
     * @param id 单位ID
     * @return 单位
     */
    Unit getUnitById(Long id);

    /**
     * 根据父单位ID查询
     * @param parentId 父单位ID
     * @return 单位列表
     */
    List<Unit> listUnitByParentId(Long parentId);

    /**
     * 根据ID删除
     * @param id 单位ID
     * @return 是否删除成功
     */
    Boolean remove(Long id);

    /**
     * 更新
     * @param unit 更新数据
     * @return 更新行数
     */
    Integer update(Unit unit);

    /**
     * 查询全部
     * @return 单位列表
     */
    List<Unit> listAll();

}
