package com.hunt.dao;


import com.hunt.model.entity.SysIpForbidden;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysIpForbiddenMapper {
    //新增
    public Long insert(SysIpForbidden SysIpForbidden);

    //更新
    public void update(SysIpForbidden SysIpForbidden);

    //通过对象进行查询
    public SysIpForbidden select(SysIpForbidden SysIpForbidden);

    //通过id进行查询
    public SysIpForbidden selectById(@Param("id") Long id);

    //查询全部
    public List<SysIpForbidden> selectAll();

    //查询数量
    public int selectCounts();

    void deleteById(@Param("id") long id);

    boolean isExistIp(String ip);

    boolean isExistIpExcludeId(@Param("ip") String ip, @Param("id") long id);
}