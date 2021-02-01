package com.hyd.basedata.web;

import com.hyd.basedata.entity.Warehouse;
import com.hyd.basedata.entity.vo.WarehouseVO;
import com.hyd.basedata.service.IWarehouseService;
import com.hyd.basedata.web.dto.WarehouseDTO;
import com.sd365.common.log.api.annotation.ApiLog;
import com.sd365.common.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yanduohuang
 * @date 2021/2/1 16:56
 */
@RestController
@RequestMapping(value = "/warehouse")
public class WarehouseController {
    @Autowired
    private IWarehouseService warehouseService;
    @ApiLog
    @PostMapping
    Long save(WarehouseDTO warehouseDTO) {
        Warehouse warehouse = BeanUtil.copy(warehouseDTO, Warehouse.class);
        return warehouseService.save(warehouse);
    }
    @ApiLog
    @DeleteMapping(value = "/{id}")
    public Boolean removeById(@PathVariable(name = "id") Long id) {
        return warehouseService.remove(id);
    }
    @ApiLog
    @PutMapping
    public Integer update(@RequestBody WarehouseDTO warehouseDTO) {
        Warehouse warehouse = BeanUtil.copy(warehouseDTO, Warehouse.class);
        return warehouseService.update(warehouse);
    }
    @ApiLog
    @GetMapping(value = "/{id}")
    public WarehouseVO getWarehouseById(@PathVariable(name = "id") Long id) {
        Warehouse warehouse = warehouseService.getWarehouseById(id);
        return BeanUtil.copy(warehouse, WarehouseVO.class);
    }
    @ApiLog
    @PostMapping(value = "/init")
    public void init() {
        warehouseService.init();
    }
}
