package com.hunt.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.hunt.model.entity.SysPermission;
import tk.mybatis.mapper.common.BaseMapper;

public interface SysPermissionMapper  extends BaseMapper<SysPermission>{
    //新增
    public Long insertSysPermission(SysPermission SysPermission);

    //更新
    public void updateSysPermission(SysPermission SysPermission);

    //通过对象进行查询
    public SysPermission selectSysPermission(SysPermission SysPermission);

    //通过id进行查询
    public SysPermission selectSysPermissionById(@Param("id") Long id);

    //查询全部
    public List<SysPermission> selectSysPermissionAll();
}