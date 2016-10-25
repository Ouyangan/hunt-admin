package com.hunt.model.entity;

/**
 * @Author: ouyangan
 * @Date: 2016-10-25 16:08
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

    // is_final :是否可删除
    private Integer isFinal;

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

    // description :描述
    private String description;

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
     * get 是否可删除
     *
     * @return Integer
     */
    public Integer getIsFinal() {
        return isFinal;
    }

    /**
     * set 是否可删除
     *
     * @param isFinal
     */
    public void setIsFinal(Integer isFinal) {
        this.isFinal = isFinal;
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
     * set 数据状态,1:正常,2:删除
     *
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * get 描述
     *
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * set 描述
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SysDataItem{" +
                "id='" + id + '\'' +
                ", sysDataGroupId='" + sysDataGroupId + '\'' +
                ", keyValue='" + keyValue + '\'' +
                ", keyName='" + keyName + '\'' +
                ", isFinal='" + isFinal + '\'' +
                ", rank='" + rank + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", createBy='" + createBy + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", status='" + status + '\'' +
                ", description=" + description +
                '}';
    }
}
