package com.hyd.basedata.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.annotation.Generated;

public class Ticket implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long zoneId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long dictionaryId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String year;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String code;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String mnemonic;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private BigDecimal price;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String unitOfMeasurement;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long version;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private static final long serialVersionUID = 1L;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getName() {
        return name;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setName(String name) {
        this.name = name;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getZoneId() {
        return zoneId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getDictionaryId() {
        return dictionaryId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setDictionaryId(Long dictionaryId) {
        this.dictionaryId = dictionaryId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getYear() {
        return year;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setYear(String year) {
        this.year = year;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getCode() {
        return code;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCode(String code) {
        this.code = code;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getMnemonic() {
        return mnemonic;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public BigDecimal getPrice() {
        return price;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getVersion() {
        return version;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Ticket other = (Ticket) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getZoneId() == null ? other.getZoneId() == null : this.getZoneId().equals(other.getZoneId()))
            && (this.getDictionaryId() == null ? other.getDictionaryId() == null : this.getDictionaryId().equals(other.getDictionaryId()))
            && (this.getYear() == null ? other.getYear() == null : this.getYear().equals(other.getYear()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getMnemonic() == null ? other.getMnemonic() == null : this.getMnemonic().equals(other.getMnemonic()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getUnitOfMeasurement() == null ? other.getUnitOfMeasurement() == null : this.getUnitOfMeasurement().equals(other.getUnitOfMeasurement()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()));
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getZoneId() == null) ? 0 : getZoneId().hashCode());
        result = prime * result + ((getDictionaryId() == null) ? 0 : getDictionaryId().hashCode());
        result = prime * result + ((getYear() == null) ? 0 : getYear().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getMnemonic() == null) ? 0 : getMnemonic().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getUnitOfMeasurement() == null) ? 0 : getUnitOfMeasurement().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", zoneId=" + zoneId +
                ", dictionaryId=" + dictionaryId +
                ", year='" + year + '\'' +
                ", code='" + code + '\'' +
                ", mnemonic='" + mnemonic + '\'' +
                ", price=" + price +
                ", unitOfMeasurement='" + unitOfMeasurement + '\'' +
                ", version=" + version +
                '}';
    }
}
