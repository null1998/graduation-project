package com.hyd.basedata.entity.vo;


import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yanduohuang
 * @date 2021/2/1 14:01
 */
@Data
@NoArgsConstructor
public class ZoneVO {
    private Long id;

    private String name;

    private String code;

    private Long version;

    private Long parentId;

    private String parentZoneName;

    private String hierarchy;


}
