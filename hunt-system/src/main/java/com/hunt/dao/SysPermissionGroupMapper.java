package com.hunt.dao;

import com.hunt.model.entity.SysPermissionGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysPermissionGroupMapper {
    //新增
    public Long insert(SysPermissionGroup SysPermissionGroup);

    //更新
    public void update(SysPermissionGroup SysPermissionGroup);

    //通过对象进行查询
    public SysPermissionGroup select(SysPermissionGroup SysPermissionGroup);

    //通过id进行查询
    public SysPermissionGroup selectById(@Param("id") Long id);

    //查询全部
    public List<SysPermissionGroup> selectAll();

    //查询数量
    public int selectCounts();

    boolean isExistGroupName(@Param("name") String name);
}