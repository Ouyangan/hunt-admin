package com.hunt.dao;

import com.hunt.model.entity.SysPermission;
import org.apache.ibatis.annotations.Param;
import java.util.List;
/**
* @Author: ouyangan
* @Date: 2016-10-10 09:38
* @Description:
*/
public interface SysPermissionMapper  {
    //新增
    public Long insertSysPermission(SysPermission SysPermission);
    //更新
    public int updateSysPermission(SysPermission SysPermission);
    //通过对象进行查询
    public SysPermission select(SysPermission SysPermission);
    //通过id进行查询
    public SysPermission selectById(@Param("id") Long id);
    //查询全部
    public List<SysPermission > selectAll();
}