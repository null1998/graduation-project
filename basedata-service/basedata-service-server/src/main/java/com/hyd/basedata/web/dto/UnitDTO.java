package com.hyd.basedata.web.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import java.io.Serializable;
@Data
@NoArgsConstructor
public class UnitDTO implements Serializable {
    private Long id;

    private String name;

    private String code;

    private String mnemonic;

    private String master;

    private String taxNumber;

    private String faxNumber;

    private String telNumber;

    private String address;

    private String email;

    private String website;

    private Long zoneId;

    private Long parentId;

    private Long version;

    private static final long serialVersionUID = 1L;

    private Long dictionaryId;

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

    public Long getDictionaryId() {
        return dictionaryId;
    }

    public void setDictionaryId(Long dictionaryId) {
        this.dictionaryId = dictionaryId;
    }


}
