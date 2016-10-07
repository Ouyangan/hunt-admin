package com.hunt.model.entity;

/**
 * @Author: ouyangan
 * @Date: 2016-10-07 21:40
 * @Description:
 */
public class SysOrganization {

    // id :
    private Long id;

    // name :
    private String name;

    // description :
    private String description;

    // parent_id :
    private Long parentId;

    // rank :排序
    private Long rank;

    // create_time :创建时间
    private java.util.Date createTime;

    // update_time :更新时间
    private java.util.Date updateTime;

    // create_by :创建人id
    private Long createBy;

    // update_by :更新人id
    private Long updateBy;

    // state :数据状态,1:正常,2:删除
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
     * get
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * set
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get
     *
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * set
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get
     *
     * @return Long
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * set
     *
     * @param parentId
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
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
     * get 创建人id
     *
     * @return Long
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * set 创建人id
     *
     * @param createBy
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     * get 更新人id
     *
     * @return Long
     */
    public Long getUpdateBy() {
        return updateBy;
    }

    /**
     * set 更新人id
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
    public Integer getState() {
        return state;
    }

    /**
     * set 数据状态,1:正常,2:删除
     *
     * @param state
     */
    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "SysOrganization{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", parentId='" + parentId + '\'' +
                ", rank='" + rank + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", createBy='" + createBy + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", state=" + state +
                '}';
    }
}
