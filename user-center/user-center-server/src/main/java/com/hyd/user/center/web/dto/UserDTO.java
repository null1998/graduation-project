package com.hyd.user.center.web.dto;

import javax.annotation.Generated;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class UserDTO implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String username;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String password;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String avatar;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer sex;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDate birthday;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String tel;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String email;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long unitId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long version;

    private ArrayList<Long> roleIdList;

    private ArrayList<String> roleNameList;

    public ArrayList<String> getRoleNameList() {
        return roleNameList;
    }

    public void setRoleNameList(ArrayList<String> roleNameList) {
        this.roleNameList = roleNameList;
    }

    public ArrayList<Long> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(ArrayList<Long> roleIdList) {
        this.roleIdList = roleIdList;
    }

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
    public String getUsername() {
        return username;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUsername(String username) {
        this.username = username;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getPassword() {
        return password;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPassword(String password) {
        this.password = password;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getAvatar() {
        return avatar;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getSex() {
        return sex;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LocalDate getBirthday() {
        return birthday;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
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
    public String getEmail() {
        return email;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setEmail(String email) {
        this.email = email;
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
    public Long getVersion() {
        return version;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(id, userDTO.id) &&
                Objects.equals(username, userDTO.username) &&
                Objects.equals(password, userDTO.password) &&
                Objects.equals(avatar, userDTO.avatar) &&
                Objects.equals(sex, userDTO.sex) &&
                Objects.equals(birthday, userDTO.birthday) &&
                Objects.equals(tel, userDTO.tel) &&
                Objects.equals(email, userDTO.email) &&
                Objects.equals(unitId, userDTO.unitId) &&
                Objects.equals(version, userDTO.version) &&
                Objects.equals(roleIdList, userDTO.roleIdList) &&
                Objects.equals(roleNameList, userDTO.roleNameList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, avatar, sex, birthday, tel, email, unitId, version, roleIdList, roleNameList);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", unitId=" + unitId +
                ", version=" + version +
                ", roleIdList=" + roleIdList +
                ", roleNameList=" + roleNameList +
                '}';
    }
}
