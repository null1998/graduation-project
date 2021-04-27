package com.hyd.basedata.service;

import com.hyd.basedata.entity.Zone;
import com.hyd.basedata.entity.vo.ZoneVO;

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
    Zone getZoneById(Long id);

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
     * 删除
     * @param id
     * @return 是否删除成功
     */
    Boolean remove(Long id);

    /**
     * 更新
     * @param zone 行政区划
     * @return 更新行数
     */
    Integer update(Zone zone);
    /**
     * 初始化数据
     */
    void init();

    /**
     * 查询省级行政区划
     * @return
     */
    List<Zone> listProvinceZone();

    /**
     * 通用查询，支持字段id
     * @param zone
     * @return
     */
    List<ZoneVO> commonQuery(Zone zone);

    /**
     * 批量查询
     * @param zoneIdList
     * @return
     */
    List<Zone> listByIdList(List<Long> zoneIdList);

}
