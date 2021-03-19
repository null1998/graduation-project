package com.hyd.basedata.entity;

import java.io.Serializable;
import javax.annotation.Generated;

public class Unit implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String code;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String mnemonic;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String master;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String taxNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String faxNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String telNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String address;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String email;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String website;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long zoneId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long parentId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long version;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long dictionaryId;

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
    public String getMaster() {
        return master;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setMaster(String master) {
        this.master = master;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getTaxNumber() {
        return taxNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getFaxNumber() {
        return faxNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getTelNumber() {
        return telNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getAddress() {
        return address;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setAddress(String address) {
        this.address = address;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getEmail() {
        return email;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setEmail(String email) {
        this.email = email;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getWebsite() {
        return website;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setWebsite(String website) {
        this.website = website;
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
    public Long getParentId() {
        return parentId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getVersion() {
        return version;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setVersion(Long version) {
        this.version = version;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getDictionaryId() {
        return dictionaryId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setDictionaryId(Long dictionaryId) {
        this.dictionaryId = dictionaryId;
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
        Unit other = (Unit) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getMnemonic() == null ? other.getMnemonic() == null : this.getMnemonic().equals(other.getMnemonic()))
            && (this.getMaster() == null ? other.getMaster() == null : this.getMaster().equals(other.getMaster()))
            && (this.getTaxNumber() == null ? other.getTaxNumber() == null : this.getTaxNumber().equals(other.getTaxNumber()))
            && (this.getFaxNumber() == null ? other.getFaxNumber() == null : this.getFaxNumber().equals(other.getFaxNumber()))
            && (this.getTelNumber() == null ? other.getTelNumber() == null : this.getTelNumber().equals(other.getTelNumber()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getWebsite() == null ? other.getWebsite() == null : this.getWebsite().equals(other.getWebsite()))
            && (this.getZoneId() == null ? other.getZoneId() == null : this.getZoneId().equals(other.getZoneId()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getDictionaryId() == null ? other.getDictionaryId() == null : this.getDictionaryId().equals(other.getDictionaryId()));
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getMnemonic() == null) ? 0 : getMnemonic().hashCode());
        result = prime * result + ((getMaster() == null) ? 0 : getMaster().hashCode());
        result = prime * result + ((getTaxNumber() == null) ? 0 : getTaxNumber().hashCode());
        result = prime * result + ((getFaxNumber() == null) ? 0 : getFaxNumber().hashCode());
        result = prime * result + ((getTelNumber() == null) ? 0 : getTelNumber().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getWebsite() == null) ? 0 : getWebsite().hashCode());
        result = prime * result + ((getZoneId() == null) ? 0 : getZoneId().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getDictionaryId() == null) ? 0 : getDictionaryId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", mnemonic='" + mnemonic + '\'' +
                ", master='" + master + '\'' +
                ", taxNumber='" + taxNumber + '\'' +
                ", faxNumber='" + faxNumber + '\'' +
                ", telNumber='" + telNumber + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", website='" + website + '\'' +
                ", zoneId=" + zoneId +
                ", parentId=" + parentId +
                ", version=" + version +
                ", dictionaryId=" + dictionaryId +
                '}';
    }
}
