package com.hyd.basedata.entity.vo;


import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yanduohuang
 * @date 2021/2/1 16:56
 */
@Data
@NoArgsConstructor
public class WarehouseVO {
    private Long id;

    private String name;

    private String code;

    private String mnemonic;

    private String address;

    private Long version;

    private Long unitId;

    private String unitName;


}
