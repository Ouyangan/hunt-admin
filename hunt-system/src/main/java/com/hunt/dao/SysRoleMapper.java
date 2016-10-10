package com.hunt.dao;

import com.hunt.model.entity.SysRole;
import org.apache.ibatis.annotations.Param;
import java.util.List;
/**
* @Author: ouyangan
* @Date: 2016-10-10 09:38
* @Description:
*/
public interface SysRoleMapper  {
    //新增
    public Long insertSysRole(SysRole SysRole);
    //更新
    public int updateSysRole(SysRole SysRole);
    //通过对象进行查询
    public SysRole select(SysRole SysRole);
    //通过id进行查询
    public SysRole selectById(@Param("id") Long id);
    //查询全部
    public List<SysRole > selectAll();
}