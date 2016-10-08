package com.hunt.dao;

import com.hunt.model.entity.SysUserRoleOrganization;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysUserRoleOrganizationMapper extends Mapper<SysUserRoleOrganization> {

    List<SysUserRoleOrganization> selectByUserId(@Param("userId") Long id);
}