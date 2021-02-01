package com.hyd.basedata.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hyd.basedata.dao.UnitBaseMapper;
import com.hyd.basedata.dao.UnitDynamicSqlSupport;
import com.hyd.basedata.dao.ZoneBaseMapper;
import com.hyd.basedata.dao.ZoneDynamicSqlSupport;
import com.hyd.basedata.entity.Unit;
import com.hyd.basedata.entity.Zone;
import com.hyd.basedata.service.IZoneService;
import com.sd365.common.core.annotation.stuffer.IdGenerator;
import com.sd365.common.core.common.exception.BusinessException;
import com.sd365.common.core.common.exception.code.BusinessErrorCode;
import lombok.extern.slf4j.Slf4j;
import net.sourceforge.pinyin4j.PinyinHelper;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Optional;

/**
 * @author yanduohuang
 * @date 2021/2/1 10:35
 */
@Slf4j
@Service
public class ZoneService implements IZoneService {
    @Autowired
    private ZoneBaseMapper zoneBaseMapper;
    @Autowired
    private UnitBaseMapper unitBaseMapper;
    @Autowired
    IdGenerator idGenerator;

    @Override
    public Zone getUnitById(Long id) {
        if (id == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("ID为空"));
        }
        Optional<Zone> optional = zoneBaseMapper.selectByPrimaryKey(id);
        if (!optional.isPresent()) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_OTHER_EXCEPTION, new Exception("未查询到相应的行政区划记录"));
        }
        return optional.get();
    }

    @Override
    public List<Zone> listZoneByParentId(Long parentId) {
        if (parentId == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("父行政区划ID为空"));
        }
        return zoneBaseMapper.select(c -> c.where(ZoneDynamicSqlSupport.parentId, SqlBuilder.isEqualTo(parentId)));
    }

    @Override
    public Long save(Zone zone) {
        if (zone == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("行政区划为空"));
        }
        long id = idGenerator.snowflakeId();
        zone.setId(id);
        zoneBaseMapper.insertSelective(zone);
        return id;
    }
    @Override
    public void importData() {
        File file = new File("C:\\Users\\test\\Desktop\\pcas-code.json");
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            JSONArray jsonArray = JSONObject.parseArray(stringBuilder.toString());
            recursion(jsonArray, null, null,1);
        }catch (Exception e) {
            log.info(e.getMessage());
        }

    }
    private void recursion(JSONArray jsonArray, Long parentZoneId, Long parentUnitId, Integer level) {
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            long zoneId = idGenerator.snowflakeId();
            Zone zone = new Zone();
            zone.setId(zoneId);
            zone.setCode(jsonObject.getString("code"));
            zone.setName(jsonObject.getString("name"));
            zone.setParentId(parentZoneId);
            zone.setHierarchy(level.toString());
            zoneBaseMapper.insertSelective(zone);

            long unitId = idGenerator.snowflakeId();
            Unit unit = new Unit();
            unit.setId(unitId);
            unit.setCode(jsonObject.getString("code")+"01");
            String unitName = jsonObject.getString("name")+"财政";
            unit.setName(unitName);
            unit.setZoneId(zoneId);
            unit.setParentId(parentUnitId);
            StringBuilder mnemonicBuilder = new StringBuilder();
            for (char c : unitName.toCharArray()) {
                String[] array = PinyinHelper.toHanyuPinyinStringArray(c);
                if (array != null) {
                    mnemonicBuilder.append(array[0].charAt(0));
                } else {
                    mnemonicBuilder.append(c);
                }
            }
            unit.setMnemonic(mnemonicBuilder.toString().toUpperCase());
            unitBaseMapper.insertSelective(unit);

            if (jsonObject.getJSONArray("children") != null) {
                recursion(jsonObject.getJSONArray("children"), zoneId, unitId,level+1);
            }
        }
    }
}
