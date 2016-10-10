package com.hunt.dao;

import com.hunt.model.entity.SysUserRoleOrganization;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @Author: ouyangan
* @Date: 2016-10-10 09:38
* @Description:
*/
public interface SysUserRoleOrganizationMapper  {
    //新增
    public Long insertSysUserRoleOrganization(SysUserRoleOrganization SysUserRoleOrganization);
    //更新
    public int updateSysUserRoleOrganization(SysUserRoleOrganization SysUserRoleOrganization);
    //通过对象进行查询
    public SysUserRoleOrganization select(SysUserRoleOrganization SysUserRoleOrganization);
    //通过id进行查询
    public SysUserRoleOrganization selectById(@Param("id") Long id);
    //查询全部
    public List<SysUserRoleOrganization > selectAll();

    List<SysUserRoleOrganization> selectByUserId(@Param("userId") Long userId);
}