package com.hyd.basedata.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;



/**
 * @author yanduohuang
 * @date 2021/1/29 16:41
 */
@Data
@NoArgsConstructor
public class UnitVO {
    private Long id;

    private String name;

    private String code;

    private String mnemonic;

    private String zoneName;

    private String parentUnitName;

    private String master;

    private String taxNumber;

    private String faxNumber;

    private String telNumber;

    private String address;

    private String email;

    private String website;

    private Long parentId;

    private Long zoneId;

    private Long version;

    private Long dictionaryId;


}
