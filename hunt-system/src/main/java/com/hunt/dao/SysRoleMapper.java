package com.hunt.dao;

import com.hunt.model.entity.SysRole;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface SysRoleMapper  extends Mapper<SysRole> {

    SysRole selectById(@Param("id") Long id);
}