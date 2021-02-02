package com.hyd.financial.entity.vo;

import java.time.LocalDateTime;

/**
 * @author yanduohuang
 * @date 2021/2/2 11:09
 */
public class ClaimFormVO {
    private Long orderNumber;

    private LocalDateTime claimDate;

    private Long claimUnitId;

    private String claimPerson;

    private Long claimWarehouseId;

    private String remark;

    private String checkOpinion;

    private LocalDateTime successDate;

    private Integer status;

}
