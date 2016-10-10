package com.hunt.dao;

import com.hunt.model.entity.SysDataGroup;
import org.apache.ibatis.annotations.Param;
import java.util.List;
/**
* @Author: ouyangan
* @Date: 2016-10-10 09:38
* @Description:
*/
public interface SysDataGroupMapper  {
    //新增
    public Long insertSysDataGroup(SysDataGroup SysDataGroup);
    //更新
    public int updateSysDataGroup(SysDataGroup SysDataGroup);
    //通过对象进行查询
    public SysDataGroup select(SysDataGroup SysDataGroup);
    //通过id进行查询
    public SysDataGroup selectById(@Param("id") Long id);
    //查询全部
    public List<SysDataGroup > selectAll();
}