package com.hunt.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.hunt.model.entity.SysUser;

public interface SysUserMapper {
    //新增
    public Long insert(SysUser SysUser);

    //更新
    public void update(SysUser SysUser);

    //通过对象进行查询
    public SysUser select(SysUser SysUser);

    //通过id进行查询
    public SysUser selectById(@Param("id") Long id);

    //查询全部
    public List<SysUser> selectAll();

    //查询数量
    public int selectCounts();

    SysUser selectByLoginName(@Param("username") String username);
}