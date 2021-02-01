package com.hyd.basedata.service.impl;

import com.hyd.basedata.dao.DictionaryCategoryBaseMapper;
import com.hyd.basedata.entity.DictionaryCategory;
import com.hyd.basedata.service.IDictionaryCategoryService;
import com.sd365.common.core.annotation.stuffer.IdGenerator;
import com.sd365.common.core.common.exception.BusinessException;
import com.sd365.common.core.common.exception.code.BusinessErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yanduohuang
 * @date 2021/2/1 14:58
 */
@Service
public class DictionaryCategoryService implements IDictionaryCategoryService {
    @Autowired
    private DictionaryCategoryBaseMapper dictionaryCategoryBaseMapper;
    @Autowired
    IdGenerator idGenerator;
    @Override
    public Long save(DictionaryCategory dictionaryCategory) {
        if (dictionaryCategory == null) {
            throw new BusinessException(BusinessErrorCode.SYSTEM_SERVICE_ARGUMENT_NOT_VALID, new Exception("字典分类为空"));
        }
        long id = idGenerator.snowflakeId();
        dictionaryCategory.setId(id);
        dictionaryCategoryBaseMapper.insertSelective(dictionaryCategory);
        return id;
    }
}
