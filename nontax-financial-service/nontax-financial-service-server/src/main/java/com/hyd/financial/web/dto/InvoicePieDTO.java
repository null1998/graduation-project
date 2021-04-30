package com.hyd.financial.web.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author yanduohuang
 * @date 2021/4/30 20:48
 */
@Data
@NoArgsConstructor
public class InvoicePieDTO {
    private String ticketName;

    private Long number;

    private BigDecimal price;
}
