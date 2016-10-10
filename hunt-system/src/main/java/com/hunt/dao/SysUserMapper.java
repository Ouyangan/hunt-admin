package com.hunt.dao;

import com.hunt.model.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @Author: ouyangan
* @Date: 2016-10-10 09:38
* @Description:
*/
public interface SysUserMapper  {
    //新增
    public Long insertSysUser(SysUser SysUser);
    //更新
    public int updateSysUser(SysUser SysUser);
    //通过对象进行查询
    public SysUser select(SysUser SysUser);
    //通过id进行查询
    public SysUser selectById(@Param("id") Long id);
    //查询全部
    public List<SysUser > selectAll();

    SysUser selectUserByLoginName(@Param("username") String username);
}