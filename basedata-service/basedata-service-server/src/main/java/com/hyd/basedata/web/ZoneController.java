package com.hyd.basedata.web;

import com.hyd.basedata.entity.Zone;
import com.hyd.basedata.entity.vo.ZoneVO;
import com.hyd.basedata.service.IZoneService;
import com.hyd.basedata.web.dto.ZoneDTO;
import com.hyd.basedata.web.qo.ZoneQO;
import com.hyd.common.core.annotation.ApiLog;
import com.hyd.common.core.annotation.PageHelper;
import com.hyd.common.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/1 10:51
 */
@CrossOrigin
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
    @ApiLog
    @GetMapping("/list/province")
    public List<ZoneVO> listProvinceZone(){
        List<Zone> zoneList = zoneService.listProvinceZone();
        return BeanUtil.copyList(zoneList, ZoneVO.class);
    }
    @ApiLog
    @PostMapping
    public Long save(ZoneDTO zoneDTO) {
        Zone zone = BeanUtil.copy(zoneDTO, Zone.class);
        return zoneService.save(zone);
    }
    @ApiLog
    @DeleteMapping
    public Boolean remove(Long id) {
        return zoneService.remove(id);
    }
    @ApiLog
    @PutMapping
    public Integer update(ZoneDTO zoneDTO) {
        Zone zone = BeanUtil.copy(zoneDTO, Zone.class);
        return zoneService.update(zone);
    }
    @ApiLog
    @GetMapping("/common/query")
    @PageHelper
    public List<ZoneVO> commonQuery(ZoneQO zoneQO) {
        Zone zone = BeanUtil.copy(zoneQO, Zone.class);
        return zoneService.commonQuery(zone);
    }
    /**
     * 初始化数据
     */
    @PostMapping("/init")
    public void init() {
        zoneService.init();
    }
}
