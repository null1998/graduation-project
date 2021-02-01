package com.hyd.basedata.service;

import com.hyd.basedata.entity.Zone;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/1 10:33
 */
public interface IZoneService {
    /**
     * 根据ID查询
     * @param id 行政区划ID
     * @return 行政区划
     */
    Zone getUnitById(Long id);

    /**
     * 根据父行政区划ID查询
     * @param parentId 父行政区划ID
     * @return 行政区划列表
     */
    List<Zone> listZoneByParentId(Long parentId);

    /**
     * 保存行政区划
     * @param zone 行政区划
     * @return 行政区划ID
     */
    Long save(Zone zone);

    /**
     * 初始化数据
     */
    void importData();
}
