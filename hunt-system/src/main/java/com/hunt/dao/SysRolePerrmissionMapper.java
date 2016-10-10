package com.hunt.dao;

import com.hunt.model.entity.SysRolePerrmission;
import org.apache.ibatis.annotations.Param;
import java.util.List;
/**
* @Author: ouyangan
* @Date: 2016-10-10 09:38
* @Description:
*/
public interface SysRolePerrmissionMapper  {
    //新增
    public Long insertSysRolePerrmission(SysRolePerrmission SysRolePerrmission);
    //更新
    public int updateSysRolePerrmission(SysRolePerrmission SysRolePerrmission);
    //通过对象进行查询
    public SysRolePerrmission select(SysRolePerrmission SysRolePerrmission);
    //通过id进行查询
    public SysRolePerrmission selectById(@Param("id") Long id);
    //查询全部
    public List<SysRolePerrmission > selectAll();
}