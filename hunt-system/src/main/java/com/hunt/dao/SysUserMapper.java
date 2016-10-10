package com.hunt.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.hunt.model.entity.SysUser;

public interface SysUserMapper {
    //新增
    public Long insertSysUser(SysUser SysUser);

    //更新
    public void updateSysUser(SysUser SysUser);

    //通过对象进行查询
    public SysUser selectSysUser(SysUser SysUser);

    //通过id进行查询
    public SysUser selectSysUserById(@Param("id") Long id);

    //查询全部
    public List<SysUser> selectSysUserAll();

    SysUser selectUserByLoginName(@Param("username") String username);
}