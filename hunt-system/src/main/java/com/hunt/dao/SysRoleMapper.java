package com.hunt.dao;

import com.hunt.model.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMapper {
    //新增
    public Long insert(SysRole SysRole);

    //更新
    public void update(SysRole SysRole);

    //通过对象进行查询
    public SysRole select(SysRole SysRole);

    //通过id进行查询
    public SysRole selectById(@Param("id") Long id);

    //查询全部
    public List<SysRole> selectAll();

    //查询数量
    public int selectCounts();

    boolean isExsitName(@Param("name") String name);

    boolean isExsitNameExcludeId(@Param("id") long id, @Param("name") String name);
}