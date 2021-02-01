package com.hyd.basedata.entity.vo;

import java.math.BigDecimal;

/**
 * @author yanduohuang
 * @date 2021/2/1 16:02
 */
public class TicketVO {
    private String name;

    private String year;

    private String code;

    private String mnemonic;

    private BigDecimal price;

    private String unitOfMeasurement;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    @Override
    public String toString() {
        return "TicketVO{" +
                "name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", code='" + code + '\'' +
                ", mnemonic='" + mnemonic + '\'' +
                ", price=" + price +
                ", unitOfMeasurement='" + unitOfMeasurement + '\'' +
                '}';
    }
}
