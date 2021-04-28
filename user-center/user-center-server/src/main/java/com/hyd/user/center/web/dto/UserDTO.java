package com.hyd.user.center.web.dto;

import com.hyd.user.center.entity.SimplePermission;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
@Data
@NoArgsConstructor
public class UserDTO implements Serializable {
    private Long id;

    private String username;

    private String nickname;

    private Long zoneId;

    private Long provinceZoneId;

    private String password;

    private String avatar;

    private Integer sex;

    private LocalDate birthday;

    private String tel;

    private String email;

    private Long unitId;

    private Long version;

    private List<Long> roleIdList;

    private List<String> roleNameList;

    private List<SimplePermission> permissionList;
    List<Long> permissionIdList;
    private String confirmPassword;
    private String unitName;
    private Integer unitLevel;

    public List<Long> getPermissionIdList() {
        return permissionIdList;
    }

    public void setPermissionIdList(List<Long> permissionIdList) {
        this.permissionIdList = permissionIdList;
    }

    public List<SimplePermission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<SimplePermission> permissionList) {
        this.permissionList = permissionList;
    }

    public Integer getUnitLevel() {
        return unitLevel;
    }

    public void setUnitLevel(Integer unitLevel) {
        this.unitLevel = unitLevel;
    }

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public List<String> getRoleNameList() {
        return roleNameList;
    }

    public void setRoleNameList(List<String> roleNameList) {
        this.roleNameList = roleNameList;
    }

    public List<Long> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<Long> roleIdList) {
        this.roleIdList = roleIdList;
    }

    private static final long serialVersionUID = 1L;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", zoneId=" + zoneId +
                ", provinceZoneId=" + provinceZoneId +
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
                ", permissionList=" + permissionList +
                ", permissionIdList=" + permissionIdList +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", unitName='" + unitName + '\'' +
                ", unitLevel=" + unitLevel +
                '}';
    }
}
