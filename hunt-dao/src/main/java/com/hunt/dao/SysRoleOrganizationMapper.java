package com.hunt.dao;

import com.hunt.model.entity.SysRoleOrganization;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleOrganizationMapper {
    //新增
    public Long insert(SysRoleOrganization SysRoleOrganization);

    //更新
    public void update(SysRoleOrganization SysRoleOrganization);

    //通过对象进行查询
    public SysRoleOrganization select(SysRoleOrganization SysRoleOrganization);

    //通过id进行查询
    public SysRoleOrganization selectById(@Param("id") Long id);

    //查询全部
    public List<SysRoleOrganization> selectAll();

    //查询数量
    public int selectCounts();

    boolean isExistName(@Param("name") String name, @Param("parentId") long parentId);

    boolean isExistNameExcludeId(@Param("id") long id, @Param("name") String name, @Param("parentId") long parentId);

    List<SysRoleOrganization> selectChildren(@Param("parentId") long parentId);

    List<Long> selectByRoleId(@Param("roleId") long roleId);
}