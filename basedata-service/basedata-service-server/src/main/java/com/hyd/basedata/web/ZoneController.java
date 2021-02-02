package com.hyd.basedata.web;

import com.hyd.basedata.entity.Zone;
import com.hyd.basedata.entity.vo.ZoneVO;
import com.hyd.basedata.service.IZoneService;
import com.sd365.common.log.api.annotation.ApiLog;
import com.sd365.common.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/1 10:51
 */
@RestController
@RequestMapping(value = "/zone")
public class ZoneController {
    @Autowired
    private IZoneService zoneService;

    /**
     * 根据ID查询行政区划
     * @param id
     * @return 行政区划
     */
    @ApiLog
    @GetMapping(value = "/{id}")
    public ZoneVO getZoneById(@PathVariable(name = "id") Long id) {
        Zone zone = zoneService.getZoneById(id);
        return BeanUtil.copy(zone, ZoneVO.class);
    }

    /**
     * 根据父级行政区划ID查询
     * @param parentUnitId 父级行政区划ID
     * @return 行政区划列表
     */
    @ApiLog
    @GetMapping(value = "/children/{parentUnitId}")
    public List<ZoneVO> listZoneByParentId(@PathVariable(name = "parentUnitId") Long parentUnitId) {
        List<Zone> zoneList = zoneService.listZoneByParentId(parentUnitId);
        return BeanUtil.copyList(zoneList, ZoneVO.class);
    }

    /**
     * 初始化数据
     */
    @PostMapping
    public void importData() {
        zoneService.importData();
    }
}
