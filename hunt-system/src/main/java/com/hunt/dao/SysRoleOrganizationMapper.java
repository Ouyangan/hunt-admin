package com.hunt.dao;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.hunt.model.entity.SysRoleOrganization;

public interface SysRoleOrganizationMapper  {
    //新增
    public Long insert(SysRoleOrganization SysRoleOrganization);
    //更新
    public void update(SysRoleOrganization SysRoleOrganization);
    //通过对象进行查询
    public SysRoleOrganization select(SysRoleOrganization SysRoleOrganization);
    //通过id进行查询
    public SysRoleOrganization selectById(@Param("id") Long id);
    //查询全部
    public List<SysRoleOrganization > selectAll();

    //查询数量
    public int selectCounts();
}