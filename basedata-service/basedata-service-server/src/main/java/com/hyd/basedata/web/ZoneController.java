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
    @ApiLog
    @GetMapping(value = "/{id}")
    public ZoneVO getZoneById(@PathVariable(name = "id") Long id) {
        Zone zone = zoneService.getUnitById(id);
        return BeanUtil.copy(zone, ZoneVO.class);
    }
    @ApiLog
    @GetMapping(value = "/children/{parentUnitId}")
    public List<ZoneVO> listZoneByParentId(@PathVariable(name = "parentUnitId") Long parentUnitId) {
        List<Zone> zoneList = zoneService.listZoneByParentId(parentUnitId);
        return BeanUtil.copyList(zoneList, ZoneVO.class);
    }
    @PostMapping
    public void importData() {
        zoneService.importData();
    }
}
