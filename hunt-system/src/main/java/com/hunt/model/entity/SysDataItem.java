package com.hunt.model.entity;

/**
 * @Author: ouyangan
 * @Date: 2016-10-07 21:40
 * @Description:
 */
public class SysDataItem {

    // id :
    private Long id;

    // sys_data_group_id :组id
    private Long sysDataGroupId;

    // key_value :值
    private String keyValue;

    // key_name :名称
    private String keyName;

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

    // state :数据状态,1:正常,2:删除,3:禁用账号
    private Integer state;

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
     * get 组id
     *
     * @return Long
     */
    public Long getSysDataGroupId() {
        return sysDataGroupId;
    }

    /**
     * set 组id
     *
     * @param sysDataGroupId
     */
    public void setSysDataGroupId(Long sysDataGroupId) {
        this.sysDataGroupId = sysDataGroupId;
    }

    /**
     * get 值
     *
     * @return String
     */
    public String getKeyValue() {
        return keyValue;
    }

    /**
     * set 值
     *
     * @param keyValue
     */
    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    /**
     * get 名称
     *
     * @return String
     */
    public String getKeyName() {
        return keyName;
    }

    /**
     * set 名称
     *
     * @param keyName
     */
    public void setKeyName(String keyName) {
        this.keyName = keyName;
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
    public Integer getState() {
        return state;
    }

    /**
     * set 数据状态,1:正常,2:删除,3:禁用账号
     *
     * @param state
     */
    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "SysDataItem{" +
                "id='" + id + '\'' +
                ", sysDataGroupId='" + sysDataGroupId + '\'' +
                ", keyValue='" + keyValue + '\'' +
                ", keyName='" + keyName + '\'' +
                ", rank='" + rank + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", createBy='" + createBy + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", state=" + state +
                '}';
    }
}
