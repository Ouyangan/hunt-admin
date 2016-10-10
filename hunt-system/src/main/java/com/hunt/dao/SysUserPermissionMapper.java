package com.hunt.dao;

import com.hunt.model.entity.SysUserPermission;
import org.apache.ibatis.annotations.Param;
import java.util.List;
/**
* @Author: ouyangan
* @Date: 2016-10-10 09:38
* @Description:
*/
public interface SysUserPermissionMapper  {
    //新增
    public Long insertSysUserPermission(SysUserPermission SysUserPermission);
    //更新
    public int updateSysUserPermission(SysUserPermission SysUserPermission);
    //通过对象进行查询
    public SysUserPermission select(SysUserPermission SysUserPermission);
    //通过id进行查询
    public SysUserPermission selectById(@Param("id") Long id);
    //查询全部
    public List<SysUserPermission > selectAll();
}