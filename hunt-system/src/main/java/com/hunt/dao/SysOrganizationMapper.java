package com.hunt.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.hunt.model.entity.SysOrganization;
import tk.mybatis.mapper.common.BaseMapper;

public interface SysOrganizationMapper extends BaseMapper<SysOrganization>{
    //新增
    public Long insertSysOrganization(SysOrganization SysOrganization);

    //更新
    public void updateSysOrganization(SysOrganization SysOrganization);

    //通过对象进行查询
    public SysOrganization selectSysOrganization(SysOrganization SysOrganization);

    //通过id进行查询
    public SysOrganization selectSysOrganizationById(@Param("id") Long id);

    //查询全部
    public List<SysOrganization> selectSysOrganizationAll();
}