package com.hunt.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.hunt.model.entity.SysPermissionGroup;
import tk.mybatis.mapper.common.BaseMapper;

public interface SysPermissionGroupMapper extends BaseMapper<SysPermissionGroup> {
    //新增
    public Long insertSysPermissionGroup(SysPermissionGroup SysPermissionGroup);

    //更新
    public void updateSysPermissionGroup(SysPermissionGroup SysPermissionGroup);

    //通过对象进行查询
    public SysPermissionGroup selectSysPermissionGroup(SysPermissionGroup SysPermissionGroup);

    //通过id进行查询
    public SysPermissionGroup selectSysPermissionGroupById(@Param("id") Long id);

    //查询全部
    public List<SysPermissionGroup> selectSysPermissionGroupAll();
}