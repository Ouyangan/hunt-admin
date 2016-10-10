package com.hunt.dao;

import com.hunt.model.entity.SysDataItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.List;
/**
 * @Author: ouyangan
 * @Date: 2016-10-10 09:38
 * @Description:
 */
public interface SysDataItemMapper {
    //新增
    public Long insertSysDataItem(SysDataItem SysDataItem);

    //更新
    public int updateSysDataItem(SysDataItem SysDataItem);

    //通过对象进行查询
    public SysDataItem select(SysDataItem SysDataItem);

    //通过id进行查询
    public SysDataItem selectById(@Param("id") Long id);

    //查询全部
    public List<SysDataItem> selectAll();
}