package com.hunt.dao;

import com.hunt.model.entity.SysPermissionGroup;
import org.apache.ibatis.annotations.Param;
import java.util.List;
/**
* @Author: ouyangan
* @Date: 2016-10-10 09:38
* @Description:
*/
public interface SysPermissionGroupMapper  {
    //新增
    public Long insertSysPermissionGroup(SysPermissionGroup SysPermissionGroup);
    //更新
    public int updateSysPermissionGroup(SysPermissionGroup SysPermissionGroup);
    //通过对象进行查询
    public SysPermissionGroup select(SysPermissionGroup SysPermissionGroup);
    //通过id进行查询
    public SysPermissionGroup selectById(@Param("id") Long id);
    //查询全部
    public List<SysPermissionGroup > selectAll();
}