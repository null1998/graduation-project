package com.hyd.basedata.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author yanduohuang
 * @date 2021/2/1 16:02
 */
@Data
@NoArgsConstructor
public class TicketVO {
    private Long id;

    private String name;

    private String year;

    private String code;

    private String mnemonic;

    private BigDecimal price;

    private String unitOfMeasurement;

    private Long version;
    private Long zoneId;

    private Long dictionaryId;

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public Long getDictionaryId() {
        return dictionaryId;
    }

    public void setDictionaryId(Long dictionaryId) {
        this.dictionaryId = dictionaryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "TicketVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", code='" + code + '\'' +
                ", mnemonic='" + mnemonic + '\'' +
                ", price=" + price +
                ", unitOfMeasurement='" + unitOfMeasurement + '\'' +
                ", version=" + version +
                ", zoneId=" + zoneId +
                ", dictionaryId=" + dictionaryId +
                '}';
    }
}
