package com.hunt.service;

import com.hunt.model.dto.LoginUserInfo;
import com.hunt.model.entity.SysUser;
import com.hunt.model.entity.SysUserRoleOrganization;

import java.util.List;

/**
 * @Author: ouyangan
 * @Date : 2016/10/7
 */
public interface SysUserService {
    long insertUser(SysUser sysUser, List<SysUserRoleOrganization> sysUserRoleOrganization);

    SysUser selectUserByLoginName(String username);

    LoginUserInfo selectUserLoginInfo(Long id);
}
