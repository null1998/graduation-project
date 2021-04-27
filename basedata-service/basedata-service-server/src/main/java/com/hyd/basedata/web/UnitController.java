package com.hyd.basedata.web;

import com.hyd.basedata.entity.Unit;
import com.hyd.basedata.entity.vo.UnitVO;
import com.hyd.basedata.service.IUnitService;
import com.hyd.basedata.web.dto.UnitDTO;
import com.hyd.basedata.web.qo.UnitQO;
import com.hyd.common.core.annotation.ApiLog;
import com.hyd.common.core.annotation.PageHelper;
import com.hyd.common.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/1/29 16:29
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/unit")
public class UnitController {
    @Autowired
    private IUnitService unitService;

    /**
     * 保存单位
     * @param unitDTO 单位
     * @return 单位ID
     */
    @ApiLog
    @PostMapping
    public Long save(@RequestBody UnitDTO unitDTO) {
        Unit unit = BeanUtil.copy(unitDTO, Unit.class);
        return unitService.save(unit);
    }

    /**
     * 根据ID查询单位
     * @param id
     * @return 单位
     */
    @ApiLog
    @GetMapping(value = "/{id}")
    public UnitVO getUnitById(@PathVariable(name = "id") Long id) {
        Unit unit = unitService.getUnitById(id);
        return BeanUtil.copy(unit, UnitVO.class);
    }

    /**
     * 根据父单位ID查询
     * @param parentUnitId 父单位ID
     * @return 单位列表
     */
    @ApiLog
    @GetMapping(value = "/children/{parentUnitId}")
    public List<UnitVO> listUnitByParentId(@PathVariable(name = "parentUnitId") Long parentUnitId) {
        List<Unit> unitList = unitService.listUnitByParentId(parentUnitId);
        return BeanUtil.copyList(unitList, UnitVO.class);
    }
    @ApiLog
    @GetMapping(value = "/all")
    public List<UnitVO> listAll() {
        List<Unit> unitList = unitService.listAll();
        return BeanUtil.copyList(unitList, UnitVO.class);
    }
    /**
     * 通用查询，根据字段id，zoneId，dictionaryId
     * @param unitQO
     * @return
     */
    @PageHelper
    @ApiLog
    @GetMapping("/common/query")
    public List<UnitVO> commonQuery(UnitQO unitQO) {
        Unit unit = BeanUtil.copy(unitQO, Unit.class);
        return unitService.commonQuery(unit);
    }

    /**
     * 删除
     * @param id
     * @return 是否删除成功
     */
    @ApiLog
    @DeleteMapping(value = "/{id}")
    public Boolean removeById(@PathVariable(name = "id") Long id) {
        return unitService.remove(id);
    }

    /**
     * 更新
     * @param unitDTO 单位
     * @return 更新行数
     */
    @ApiLog
    @PutMapping
    public Integer update(@RequestBody UnitDTO unitDTO) {
        Unit unit = BeanUtil.copy(unitDTO, Unit.class);
        return unitService.update(unit);
    }

    @ApiLog
    @GetMapping("/superior/{id}")
    public List<UnitVO> getSuperiorUnitList(@PathVariable("id") Long id) {
        List<Unit> superiorUnitList = unitService.getSuperiorUnitList(id);
        return BeanUtil.copyList(superiorUnitList, UnitVO.class);
    }
}
