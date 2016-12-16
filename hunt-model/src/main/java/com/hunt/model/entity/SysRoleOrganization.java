package com.hunt.model.entity;

/**
 * @Author: ouyangan
 * @Date: 2016-10-17 17:54
 * @Description:
 */
public class SysRoleOrganization {

    // id :
    private Long id;

    // sys_organization_id :组织id
    private Long sysOrganizationId;

    // sys_role_id :角色id
    private Long sysRoleId;

    // parent_id :父级id
    private Long parentId;

    // name :
    private String name;

    // full_name :
    private String fullName;

    // description :
    private String description;

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

    // status :数据状态,1:正常,2:删除
    private Integer status;

    // is_final :是否能修改
    private Integer isFinal;

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
     * get 组织id
     *
     * @return Long
     */
    public Long getSysOrganizationId() {
        return sysOrganizationId;
    }

    /**
     * set 组织id
     *
     * @param sysOrganizationId
     */
    public void setSysOrganizationId(Long sysOrganizationId) {
        this.sysOrganizationId = sysOrganizationId;
    }

    /**
     * get 角色id
     *
     * @return Long
     */
    public Long getSysRoleId() {
        return sysRoleId;
    }

    /**
     * set 角色id
     *
     * @param sysRoleId
     */
    public void setSysRoleId(Long sysRoleId) {
        this.sysRoleId = sysRoleId;
    }

    /**
     * get 父级id
     *
     * @return Long
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * set 父级id
     *
     * @param parentId
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
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
    public String getFullName() {
        return fullName;
    }

    /**
     * set
     *
     * @param fullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    @Override
    public String toString() {
        return "SysRoleOrganization{" +
                "id='" + id + '\'' +
                ", sysOrganizationId='" + sysOrganizationId + '\'' +
                ", sysRoleId='" + sysRoleId + '\'' +
                ", parentId='" + parentId + '\'' +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", description='" + description + '\'' +
                ", rank='" + rank + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", createBy='" + createBy + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", status='" + status + '\'' +
                ", isFinal=" + isFinal +
                '}';
    }
}
