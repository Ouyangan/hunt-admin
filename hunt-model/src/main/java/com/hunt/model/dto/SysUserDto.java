package com.hunt.model.dto;

import com.hunt.model.entity.SysUserRoleOrganization;
import com.hunt.model.entity.SysPermission;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ouyangan
 * @Date: 2016-10-17 16:52
 * @Description:
 */
public class SysUserDto {

    // id :
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

    // password :密码
    private String password;

    // password_salt :密码盐
    private String passwordSalt;

    // rank :排序
    private Long rank;

    // create_time :创建时间
    private java.util.Date createTime;

    // update_time :更新时间
    private java.util.Date updateTime;

    // create_by :创建人
    private Long createBy;

    // update_by :更热人
    private Long updateBy;

    // status :数据状态,1:正常,2:删除,3:禁用账号
    private Integer status;

    // is_final :是否能修改
    private Integer isFinal;

    private List<SysPermission> permissions = new ArrayList<>();
    private List<SysUserRoleOrganization> userRoleOrganizations = new ArrayList<>();

    @Override
    public String toString() {
        return "SysUserDto{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", zhName='" + zhName + '\'' +
                ", enName='" + enName + '\'' +
                ", sex=" + sex +
                ", birth='" + birth + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", passwordSalt='" + passwordSalt + '\'' +
                ", rank=" + rank +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                ", status=" + status +
                ", isFinal=" + isFinal +
                ", permissions=" + permissions +
                ", userRoleOrganizations=" + userRoleOrganizations +
                '}';
    }

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }

    public List<SysUserRoleOrganization> getUserRoleOrganizations() {
        return userRoleOrganizations;
    }

    public void setUserRoleOrganizations(List<SysUserRoleOrganization> userRoleOrganizations) {
        this.userRoleOrganizations = userRoleOrganizations;
    }

    /**
     * get
     *
     * @return Long
     */
    public Long getId() {
        return id;
    }

    /**
     * set
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * get 登陆名
     *
     * @return String
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * set 登陆名
     *
     * @param loginName
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * get 中文名
     *
     * @return String
     */
    public String getZhName() {
        return zhName;
    }

    /**
     * set 中文名
     *
     * @param zhName
     */
    public void setZhName(String zhName) {
        this.zhName = zhName;
    }

    /**
     * get 英文名
     *
     * @return String
     */
    public String getEnName() {
        return enName;
    }

    /**
     * set 英文名
     *
     * @param enName
     */
    public void setEnName(String enName) {
        this.enName = enName;
    }

    /**
     * get 性别
     *
     * @return Integer
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * set 性别
     *
     * @param sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * get 生日
     *
     * @return String
     */
    public String getBirth() {
        return birth;
    }

    /**
     * set 生日
     *
     * @param birth
     */
    public void setBirth(String birth) {
        this.birth = birth;
    }

    /**
     * get 邮箱
     *
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * set 邮箱
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * get 电话
     *
     * @return String
     */
    public String getPhone() {
        return phone;
    }

    /**
     * set 电话
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * get 地址
     *
     * @return String
     */
    public String getAddress() {
        return address;
    }

    /**
     * set 地址
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * get 密码
     *
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     * set 密码
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * get 密码盐
     *
     * @return String
     */
    public String getPasswordSalt() {
        return passwordSalt;
    }

    /**
     * set 密码盐
     *
     * @param passwordSalt
     */
    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    /**
     * get 排序
     *
     * @return Long
     */
    public Long getRank() {
        return rank;
    }

    /**
     * set 排序
     *
     * @param rank
     */
    public void setRank(Long rank) {
        this.rank = rank;
    }

    /**
     * get 创建时间
     *
     * @return java.util.Date
     */
    public java.util.Date getCreateTime() {
        return createTime;
    }

    /**
     * set 创建时间
     *
     * @param createTime
     */
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    /**
     * get 更新时间
     *
     * @return java.util.Date
     */
    public java.util.Date getUpdateTime() {
        return updateTime;
    }

    /**
     * set 更新时间
     *
     * @param updateTime
     */
    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * get 创建人
     *
     * @return Long
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * set 创建人
     *
     * @param createBy
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     * get 更热人
     *
     * @return Long
     */
    public Long getUpdateBy() {
        return updateBy;
    }

    /**
     * set 更热人
     *
     * @param updateBy
     */
    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * get 数据状态,1:正常,2:删除,3:禁用账号
     *
     * @return Integer
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * set 数据状态,1:正常,2:删除,3:禁用账号
     *
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * get 是否能修改
     *
     * @return Integer
     */
    public Integer getIsFinal() {
        return isFinal;
    }

    /**
     * set 是否能修改
     *
     * @param isFinal
     */
    public void setIsFinal(Integer isFinal) {
        this.isFinal = isFinal;
    }

}
