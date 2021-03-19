package com.hyd.basedata.web;

import com.hyd.basedata.entity.Warehouse;
import com.hyd.basedata.entity.vo.WarehouseVO;
import com.hyd.basedata.service.IWarehouseService;
import com.hyd.basedata.web.dto.WarehouseDTO;
import com.hyd.common.core.annotation.ApiLog;
import com.hyd.common.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/1 16:56
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/warehouse")
public class WarehouseController {
    @Autowired
    private IWarehouseService warehouseService;

    /**
     * 保存仓库
     * @param warehouseDTO 仓库
     * @return 仓库ID
     */
    @ApiLog
    @PostMapping
    Long save(WarehouseDTO warehouseDTO) {
        Warehouse warehouse = BeanUtil.copy(warehouseDTO, Warehouse.class);
        return warehouseService.save(warehouse);
    }

    /**
     * 删除
     * @param id
     * @return 是否删除成功
     */
    @ApiLog
    @DeleteMapping(value = "/{id}")
    public Boolean removeById(@PathVariable(name = "id") Long id) {
        return warehouseService.remove(id);
    }

    /**
     * 更新
     * @param warehouseDTO 仓库
     * @return 更新行数
     */
    @ApiLog
    @PutMapping
    public Integer update(@RequestBody WarehouseDTO warehouseDTO) {
        Warehouse warehouse = BeanUtil.copy(warehouseDTO, Warehouse.class);
        return warehouseService.update(warehouse);
    }

    /**
     * 根据ID查询仓库
     * @param id
     * @return 仓库
     */
    @ApiLog
    @GetMapping(value = "/{id}")
    public WarehouseVO getWarehouseById(@PathVariable(name = "id") Long id) {
        Warehouse warehouse = warehouseService.getWarehouseById(id);
        return BeanUtil.copy(warehouse, WarehouseVO.class);
    }

    /**
     * 根据仓库所属单位查询
     * @param unitId
     * @return
     */
    @ApiLog
    @GetMapping("/unit/{unitId}")
    public List<WarehouseVO> listByUnitId(@PathVariable("unitId") Long unitId) {
        List<Warehouse> warehouseList = warehouseService.listByUnitId(unitId);
        return BeanUtil.copyList(warehouseList, WarehouseVO.class);
    }
    /**
     * 初始化数据
     */
    @ApiLog
    @PostMapping(value = "/init")
    public void init() {
        warehouseService.init();
    }
}
