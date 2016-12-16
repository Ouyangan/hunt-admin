package com.hunt.model.dto;

import com.hunt.model.entity.SysUserRoleOrganization;
import com.hunt.model.entity.SysPermission;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ouyangan
 * @Date: 2016-10-17 16:52
 * @Description:
 */
public class LoginInfo implements Serializable {

    private Long id;

    // login_name :登陆名
    private String loginName;

    // zh_name :中文名
    private String zhName;

    // en_name :英文名
    private String enName;

    // sex :性别
    private Integer sex;

    // birth :生日
    private String birth;

    // email :邮箱
    private String email;

    // phone :电话
    private String phone;

    // address :地址
    private String address;

    private List<SysUserRoleOrganization> jobs = new ArrayList<>();

    private List<SysPermission> permissions = new ArrayList<>();

    @Override
    public String toString() {
        return "LoginInfo{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", zhName='" + zhName + '\'' +
                ", enName='" + enName + '\'' +
                ", sex=" + sex +
                ", birth='" + birth + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", jobs=" + jobs +
                ", permissions=" + permissions +
                '}';
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getZhName() {
        return zhName;
    }

    public void setZhName(String zhName) {
        this.zhName = zhName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<SysUserRoleOrganization> getJobs() {
        return jobs;
    }

    public void setJobs(List<SysUserRoleOrganization> jobs) {
        this.jobs = jobs;
    }

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }
}
