package com.hunt.dao;

import com.hunt.model.entity.SysOrganization;
import org.apache.ibatis.annotations.Param;
import java.util.List;
/**
* @Author: ouyangan
* @Date: 2016-10-10 09:38
* @Description:
*/
public interface SysOrganizationMapper  {
    //新增
    public Long insertSysOrganization(SysOrganization SysOrganization);
    //更新
    public int updateSysOrganization(SysOrganization SysOrganization);
    //通过对象进行查询
    public SysOrganization select(SysOrganization SysOrganization);
    //通过id进行查询
    public SysOrganization selectById(@Param("id") Long id);
    //查询全部
    public List<SysOrganization > selectAll();
}