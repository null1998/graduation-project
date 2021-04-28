package com.hyd.basedata.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
public class DictionaryVO implements Serializable {
    private Long id;

    private String value;

    private String remark;

    private Long categoryId;

    private Long version;

    private static final long serialVersionUID = 1L;

}
