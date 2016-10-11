package com.hunt.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.hunt.model.entity.SysUser;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

public interface SysUserMapper extends BaseMapper<SysUser> {
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