package com.hyd.financial.entity.vo;

import javax.annotation.Generated;
import java.io.Serializable;

public class PrintingPlanVO implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long orderNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer year;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long unitId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String person;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String tel;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String remark;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer status;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long version;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private static final long serialVersionUID = 1L;
    private String unitName;
    private String submitDate;

    public String getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(String submitDate) {
        this.submitDate = submitDate;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getOrderNumber() {
        return orderNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getYear() {
        return year;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setYear(Integer year) {
        this.year = year;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getUnitId() {
        return unitId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getPerson() {
        return person;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPerson(String person) {
        this.person = person;
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
    public String getRemark() {
        return remark;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getStatus() {
        return status;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setStatus(Integer status) {
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
    public String toString() {
        return "PrintingPlanVO{" +
                "id=" + id +
                ", orderNumber=" + orderNumber +
                ", year=" + year +
                ", unitId=" + unitId +
                ", person='" + person + '\'' +
                ", tel='" + tel + '\'' +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                ", version=" + version +
                ", unitName='" + unitName + '\'' +
                ", submitDate='" + submitDate + '\'' +
                '}';
    }
}
