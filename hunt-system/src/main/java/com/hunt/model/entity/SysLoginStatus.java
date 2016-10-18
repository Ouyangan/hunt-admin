package com.hunt.model.entity;

/**
 * @Author: ouyangan
 * @Date: 2016-10-18 15:07
 * @Description:
 */
public class SysLoginStatus {

    // id :主键
    private Long id;

    // sys_user_id :用户id
    private Long sysUserId;

    // session_id :session id
    private String sessionId;

    // session_expires :session过期时间
    private java.util.Date sessionExpires;

    // sys_user_login_name :登录名
    private String sysUserLoginName;

    // sys_user_zh_name :中文名
    private String sysUserZhName;

    // last_login_time :上一次登录时间
    private java.util.Date lastLoginTime;

    // platform :登录平台 1:web 2:android 3:ios
    private Integer platform;

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

    // status :数据状态,1:正常,2:删除
    private Integer status;

    /**
     * get 主键
     *
     * @return Long
     */
    public Long getId() {
        return id;
    }

    /**
     * set 主键
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * get 用户id
     *
     * @return Long
     */
    public Long getSysUserId() {
        return sysUserId;
    }

    /**
     * set 用户id
     *
     * @param sysUserId
     */
    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }

    /**
     * get session id
     *
     * @return String
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * set session id
     *
     * @param sessionId
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * get session过期时间
     *
     * @return java.util.Date
     */
    public java.util.Date getSessionExpires() {
        return sessionExpires;
    }

    /**
     * set session过期时间
     *
     * @param sessionExpires
     */
    public void setSessionExpires(java.util.Date sessionExpires) {
        this.sessionExpires = sessionExpires;
    }

    /**
     * get 登录名
     *
     * @return String
     */
    public String getSysUserLoginName() {
        return sysUserLoginName;
    }

    /**
     * set 登录名
     *
     * @param sysUserLoginName
     */
    public void setSysUserLoginName(String sysUserLoginName) {
        this.sysUserLoginName = sysUserLoginName;
    }

    /**
     * get 中文名
     *
     * @return String
     */
    public String getSysUserZhName() {
        return sysUserZhName;
    }

    /**
     * set 中文名
     *
     * @param sysUserZhName
     */
    public void setSysUserZhName(String sysUserZhName) {
        this.sysUserZhName = sysUserZhName;
    }

    /**
     * get 上一次登录时间
     *
     * @return java.util.Date
     */
    public java.util.Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * set 上一次登录时间
     *
     * @param lastLoginTime
     */
    public void setLastLoginTime(java.util.Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * get 登录平台 1:web 2:android 3:ios
     *
     * @return Integer
     */
    public Integer getPlatform() {
        return platform;
    }

    /**
     * set 登录平台 1:web 2:android 3:ios
     *
     * @param platform
     */
    public void setPlatform(Integer platform) {
        this.platform = platform;
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
     * get 数据状态,1:正常,2:删除
     *
     * @return Integer
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * set 数据状态,1:正常,2:删除
     *
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SysLoginStatus{" +
                "id='" + id + '\'' +
                ", sysUserId='" + sysUserId + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", sessionExpires='" + sessionExpires + '\'' +
                ", sysUserLoginName='" + sysUserLoginName + '\'' +
                ", sysUserZhName='" + sysUserZhName + '\'' +
                ", lastLoginTime='" + lastLoginTime + '\'' +
                ", platform='" + platform + '\'' +
                ", rank='" + rank + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", createBy='" + createBy + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", status=" + status +
                '}';
    }
}
