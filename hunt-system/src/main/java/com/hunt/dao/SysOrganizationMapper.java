package com.hunt.dao;

import com.hunt.model.entity.SysOrganization;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface SysOrganizationMapper  extends Mapper<SysOrganization> {

    SysOrganization selectById(@Param("id") Long id);

    int deleteById(@Param("id") long id);
}