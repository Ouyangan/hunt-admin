package com.hunt.dao;

import com.hunt.model.entity.SysRole;
import com.hunt.model.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface SysUserMapper  extends Mapper<SysUser> {

    SysUser selectUserByLoginName(@Param("username") String username);
}