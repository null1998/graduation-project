package com.hyd.user.center.entity.vo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author yanduohuang
 * @date 2021/2/3 16:14
 */
public class UserVO {
    private Long id;

    private String username;
    private String nickname;
    private Long zoneId;
    private Long provinceZoneId;
    private String avatar;

    private Integer sex;

    private LocalDate birthday;

    private String tel;

    private String email;

    private Long unitId;

    private Long version;
    private ArrayList<Long> roleIdList;
    private ArrayList<String> roleNameList;
    private String unitName;

    public Long getProvinceZoneId() {
        return provinceZoneId;
    }

    public void setProvinceZoneId(Long provinceZoneId) {
        this.provinceZoneId = provinceZoneId;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", zoneId=" + zoneId +
                ", provinceZoneId=" + provinceZoneId +
                ", avatar='" + avatar + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", unitId=" + unitId +
                ", version=" + version +
                ", roleIdList=" + roleIdList +
                ", roleNameList=" + roleNameList +
                ", unitName='" + unitName + '\'' +
                '}';
    }
}
