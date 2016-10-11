package com.hunt.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.hunt.model.entity.SysUserPermission;
import tk.mybatis.mapper.common.BaseMapper;

public interface SysUserPermissionMapper   {
    //新增
    public Long insertSysUserPermission(SysUserPermission SysUserPermission);

    //更新
    public void updateSysUserPermission(SysUserPermission SysUserPermission);

    //通过对象进行查询
    public SysUserPermission selectSysUserPermission(SysUserPermission SysUserPermission);

    //通过id进行查询
    public SysUserPermission selectSysUserPermissionById(@Param("id") Long id);

    //查询全部
    public List<SysUserPermission> selectSysUserPermissionAll();
}