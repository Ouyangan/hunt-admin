package com.hunt.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.hunt.model.entity.SysUserRoleOrganization;
import tk.mybatis.mapper.common.BaseMapper;

public interface SysUserRoleOrganizationMapper   {
    //新增
    public Long insertSysUserRoleOrganization(SysUserRoleOrganization SysUserRoleOrganization);

    //更新
    public void updateSysUserRoleOrganization(SysUserRoleOrganization SysUserRoleOrganization);

    //通过对象进行查询
    public SysUserRoleOrganization selectSysUserRoleOrganization(SysUserRoleOrganization SysUserRoleOrganization);

    //通过id进行查询
    public SysUserRoleOrganization selectSysUserRoleOrganizationById(@Param("id") Long id);

    //查询全部
    public List<SysUserRoleOrganization> selectSysUserRoleOrganizationAll();

    List<SysUserRoleOrganization> selectByUserId(@Param("userId") Long userId);
}