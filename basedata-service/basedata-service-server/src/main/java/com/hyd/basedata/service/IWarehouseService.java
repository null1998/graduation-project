package com.hyd.basedata.service;

import com.hyd.basedata.entity.Warehouse;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/1 16:47
 */
public interface IWarehouseService {
    /**
     * 保存
     * @param warehouse 仓库
     * @return 仓库ID
     */
    Long save(Warehouse warehouse);

    /**
     * 删除
     * @param id 库存ID
     * @return 是否删除成功
     */
    Boolean remove(Long id);

    /**
     * 更新
     * @param warehouse 仓库
     * @return 更新行数
     */
    Integer update(Warehouse warehouse);

    /**
     * 根据ID获取仓库
     * @param id 仓库ID
     * @return 仓库
     */
    Warehouse getWarehouseById(Long id);
    /**
     * 通用查询，支持字段id，unitId
     * @param warehouse 仓库
     * @return 仓库列表
     */
    List<Warehouse> commonQuery(Warehouse warehouse);

    List<Warehouse> listByUnitId(Long unitId);
    void init();
}
