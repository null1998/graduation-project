package com.hyd.basedata.web;

import com.hyd.basedata.entity.Unit;
import com.hyd.basedata.entity.vo.UnitVO;
import com.hyd.basedata.service.impl.UnitService;
import com.hyd.basedata.web.dto.UnitDTO;
import com.sd365.common.log.api.annotation.ApiLog;
import com.sd365.common.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/1/29 16:29
 */
@RestController
@RequestMapping(value = "/unit")
public class UnitController {
    @Autowired
    private UnitService unitService;
    @ApiLog
    @PostMapping
    public Long save(@RequestBody UnitDTO unitDTO) {
        Unit unit = BeanUtil.copy(unitDTO, Unit.class);
        return unitService.save(unit);
    }
    @ApiLog
    @GetMapping(value = "/{id}")
    public UnitVO getUnitById(@PathVariable(name = "id") Long id) {
        Unit unit = unitService.getUnitById(id);
        return BeanUtil.copy(unit, UnitVO.class);
    }
    @ApiLog
    @GetMapping(value = "/list/{parentUnitId}")
    public List<UnitVO> listUnit(@PathVariable(name = "parentUnitId") Long parentUnitId) {
        List<Unit> unitList = unitService.listUnit(parentUnitId);
        return BeanUtil.copyList(unitList, UnitVO.class);
    }
    @ApiLog
    @DeleteMapping(value = "/{id}")
    public Boolean removeById(@PathVariable(name = "id") Long id) {
        return unitService.remove(id);
    }
    @ApiLog
    @PutMapping
    public Integer update(@RequestBody UnitDTO unitDTO) {
        Unit unit = BeanUtil.copy(unitDTO, Unit.class);
        return unitService.update(unit);
    }
}
