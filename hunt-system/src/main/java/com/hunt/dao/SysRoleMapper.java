package com.hunt.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.hunt.model.entity.SysRole;
import tk.mybatis.mapper.common.BaseMapper;

public interface SysRoleMapper extends BaseMapper<SysRole> {
    //新增
    public Long insertSysRole(SysRole SysRole);

    //更新
    public void updateSysRole(SysRole SysRole);

    //通过对象进行查询
    public SysRole selectSysRole(SysRole SysRole);

    //通过id进行查询
    public SysRole selectSysRoleById(@Param("id") Long id);

    //查询全部
    public List<SysRole> selectSysRoleAll();
}