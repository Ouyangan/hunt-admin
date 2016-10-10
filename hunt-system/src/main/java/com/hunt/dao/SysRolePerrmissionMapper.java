package com.hunt.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.hunt.model.entity.SysRolePerrmission;

public interface SysRolePerrmissionMapper {
    //新增
    public Long insertSysRolePerrmission(SysRolePerrmission SysRolePerrmission);

    //更新
    public void updateSysRolePerrmission(SysRolePerrmission SysRolePerrmission);

    //通过对象进行查询
    public SysRolePerrmission selectSysRolePerrmission(SysRolePerrmission SysRolePerrmission);

    //通过id进行查询
    public SysRolePerrmission selectSysRolePerrmissionById(@Param("id") Long id);

    //查询全部
    public List<SysRolePerrmission> selectSysRolePerrmissionAll();
}