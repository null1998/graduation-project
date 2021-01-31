package com.hyd.basedata.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.annotation.Generated;

public class Unit implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long parentUnit;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String code;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String unitSort;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String parentDepartment;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String unitType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Byte printStatus;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String mnemonicCode;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String master;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String tax;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String fax;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String tel;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String address;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String email;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String website;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String remark;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long tenantId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long zoneId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long createdBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String creator;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDateTime createdTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long updatedBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String modifier;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDateTime updatedTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Byte status;

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
    public Long getParentUnit() {
        return parentUnit;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setParentUnit(Long parentUnit) {
        this.parentUnit = parentUnit;
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
    public String getUnitSort() {
        return unitSort;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUnitSort(String unitSort) {
        this.unitSort = unitSort;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getParentDepartment() {
        return parentDepartment;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setParentDepartment(String parentDepartment) {
        this.parentDepartment = parentDepartment;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUnitType() {
        return unitType;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Byte getPrintStatus() {
        return printStatus;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPrintStatus(Byte printStatus) {
        this.printStatus = printStatus;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getMnemonicCode() {
        return mnemonicCode;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setMnemonicCode(String mnemonicCode) {
        this.mnemonicCode = mnemonicCode;
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
    public String getTax() {
        return tax;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTax(String tax) {
        this.tax = tax;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getFax() {
        return fax;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setFax(String fax) {
        this.fax = fax;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getTel() {
        return tel;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTel(String tel) {
        this.tel = tel;
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
    public String getRemark() {
        return remark;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getTenantId() {
        return tenantId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
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
    public Long getCreatedBy() {
        return createdBy;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getCreator() {
        return creator;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getUpdatedBy() {
        return updatedBy;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getModifier() {
        return modifier;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Byte getStatus() {
        return status;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setStatus(Byte status) {
        this.status = status;
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
        Unit other = (Unit) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getParentUnit() == null ? other.getParentUnit() == null : this.getParentUnit().equals(other.getParentUnit()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getUnitSort() == null ? other.getUnitSort() == null : this.getUnitSort().equals(other.getUnitSort()))
            && (this.getParentDepartment() == null ? other.getParentDepartment() == null : this.getParentDepartment().equals(other.getParentDepartment()))
            && (this.getUnitType() == null ? other.getUnitType() == null : this.getUnitType().equals(other.getUnitType()))
            && (this.getPrintStatus() == null ? other.getPrintStatus() == null : this.getPrintStatus().equals(other.getPrintStatus()))
            && (this.getMnemonicCode() == null ? other.getMnemonicCode() == null : this.getMnemonicCode().equals(other.getMnemonicCode()))
            && (this.getMaster() == null ? other.getMaster() == null : this.getMaster().equals(other.getMaster()))
            && (this.getTax() == null ? other.getTax() == null : this.getTax().equals(other.getTax()))
            && (this.getFax() == null ? other.getFax() == null : this.getFax().equals(other.getFax()))
            && (this.getTel() == null ? other.getTel() == null : this.getTel().equals(other.getTel()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getWebsite() == null ? other.getWebsite() == null : this.getWebsite().equals(other.getWebsite()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getTenantId() == null ? other.getTenantId() == null : this.getTenantId().equals(other.getTenantId()))
            && (this.getZoneId() == null ? other.getZoneId() == null : this.getZoneId().equals(other.getZoneId()))
            && (this.getCreatedBy() == null ? other.getCreatedBy() == null : this.getCreatedBy().equals(other.getCreatedBy()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getUpdatedBy() == null ? other.getUpdatedBy() == null : this.getUpdatedBy().equals(other.getUpdatedBy()))
            && (this.getModifier() == null ? other.getModifier() == null : this.getModifier().equals(other.getModifier()))
            && (this.getUpdatedTime() == null ? other.getUpdatedTime() == null : this.getUpdatedTime().equals(other.getUpdatedTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()));
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getParentUnit() == null) ? 0 : getParentUnit().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getUnitSort() == null) ? 0 : getUnitSort().hashCode());
        result = prime * result + ((getParentDepartment() == null) ? 0 : getParentDepartment().hashCode());
        result = prime * result + ((getUnitType() == null) ? 0 : getUnitType().hashCode());
        result = prime * result + ((getPrintStatus() == null) ? 0 : getPrintStatus().hashCode());
        result = prime * result + ((getMnemonicCode() == null) ? 0 : getMnemonicCode().hashCode());
        result = prime * result + ((getMaster() == null) ? 0 : getMaster().hashCode());
        result = prime * result + ((getTax() == null) ? 0 : getTax().hashCode());
        result = prime * result + ((getFax() == null) ? 0 : getFax().hashCode());
        result = prime * result + ((getTel() == null) ? 0 : getTel().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getWebsite() == null) ? 0 : getWebsite().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getTenantId() == null) ? 0 : getTenantId().hashCode());
        result = prime * result + ((getZoneId() == null) ? 0 : getZoneId().hashCode());
        result = prime * result + ((getCreatedBy() == null) ? 0 : getCreatedBy().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getUpdatedBy() == null) ? 0 : getUpdatedBy().hashCode());
        result = prime * result + ((getModifier() == null) ? 0 : getModifier().hashCode());
        result = prime * result + ((getUpdatedTime() == null) ? 0 : getUpdatedTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        return result;
    }
}