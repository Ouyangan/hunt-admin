package com.hunt.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.hunt.model.entity.SysDataGroup;
import tk.mybatis.mapper.common.BaseMapper;

public interface SysDataGroupMapper {
    //新增
    public Long insertSysDataGroup(SysDataGroup SysDataGroup);

    //更新
    public void updateSysDataGroup(SysDataGroup SysDataGroup);

    //通过对象进行查询
    public SysDataGroup selectSysDataGroup(SysDataGroup SysDataGroup);

    //通过id进行查询
    public SysDataGroup selectSysDataGroupById(@Param("id") Long id);

    //查询全部
    public List<SysDataGroup> selectSysDataGroupAll();
}