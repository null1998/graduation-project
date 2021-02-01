package com.hyd.basedata.service.impl;

import com.hyd.basedata.dao.DictionaryBaseMapper;
import com.hyd.basedata.entity.Dictionary;
import com.hyd.basedata.service.IDictionaryService;
import com.sd365.common.core.annotation.stuffer.IdGenerator;
import com.sd365.common.core.common.exception.BusinessException;
import com.sd365.common.core.common.exception.code.BusinessErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/2/1 15:03
 */
@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    private DictionaryBaseMapper dictionaryBaseMapper;
    @Autowired
    private IdGenerator idGenerator;
    @Override
    public Long save(Dictionary dictionary) {
        if (dictionary == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("字典为空"));
        }
        long id = idGenerator.snowflakeId();
        dictionary.setId(id);
        dictionaryBaseMapper.insertSelective(dictionary);
        return id;
    }

    @Override
    public void saveList(List<Dictionary> dictionaryList) {
        if (dictionaryList == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("字典列表为空"));
        }
        for (Dictionary dictionary : dictionaryList) {
            dictionary.setId(idGenerator.snowflakeId());
            dictionary.setVersion(0L);
        }
        dictionaryBaseMapper.insertMultiple(dictionaryList);
    }
}
