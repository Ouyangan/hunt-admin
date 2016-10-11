package com.hunt.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.hunt.model.entity.SysDataItem;

public interface SysDataItemMapper {
    //新增
    public Long insert(SysDataItem SysDataItem);

    //更新
    public void update(SysDataItem SysDataItem);

    //通过对象进行查询
    public SysDataItem select(SysDataItem SysDataItem);

    //通过id进行查询
    public SysDataItem selectById(@Param("id") Long id);

    //查询全部
    public List<SysDataItem> selectAll();

    //查询数量
    public int selectCounts();
}