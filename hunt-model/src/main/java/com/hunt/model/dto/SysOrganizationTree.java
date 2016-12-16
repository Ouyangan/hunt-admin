package com.hunt.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author ouyangan
 * @Date 2016/10/12/9:13
 * @Description
 */
public class SysOrganizationTree {
    // id :
    private Long id;

    // name :名称
    private String name;

    // fullName :全称
    private String fullName;

    // description :描述
    private String description;

    // is_final :是否可删除
    private Integer isFinal;

    // parent_id :
    private Long parentId;

    // rank :排序
    private Long rank;

    // create_time :创建时间
    private Date createTime;

    // update_time :更新时间
    private Date updateTime;

    // create_by :创建人id
    private Long createBy;

    // update_by :更新人id
    private Long updateBy;

    // state :数据状态,1:正常,2:删除
    private Integer status;

    private List<SysOrganizationTree> children = new ArrayList<>();

    @Override
    public String toString() {
        return "SysOrganizationTree{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", description='" + description + '\'' +
                ", isFinal=" + isFinal +
                ", parentId=" + parentId +
                ", rank=" + rank +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                ", status=" + status +
                ", children=" + children +
                '}';
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsFinal() {
        return isFinal;
    }

    public void setIsFinal(Integer isFinal) {
        this.isFinal = isFinal;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<SysOrganizationTree> getChildren() {
        return children;
    }

    public void setChildren(List<SysOrganizationTree> children) {
        this.children = children;
    }
}
