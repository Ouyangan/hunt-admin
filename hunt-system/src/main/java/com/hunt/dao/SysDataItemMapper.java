package com.hunt.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.hunt.model.entity.SysDataItem;

public interface SysDataItemMapper {
    //新增
    public Long insertSysDataItem(SysDataItem SysDataItem);

    //更新
    public void updateSysDataItem(SysDataItem SysDataItem);

    //通过对象进行查询
    public SysDataItem selectSysDataItem(SysDataItem SysDataItem);

    //通过id进行查询
    public SysDataItem selectSysDataItemById(@Param("id") Long id);

    //查询全部
    public List<SysDataItem> selectSysDataItemAll();
}