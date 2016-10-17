package com.hunt.service;

import com.hunt.model.dto.PageInfo;
import com.hunt.model.entity.SysUser;

/**
 * @Author: ouyangan
 * @Date : 2016/10/7
 */
public interface SysUserService {

    long insertUser(SysUser user, String jobIds, String permissionIds);

    boolean isExistLoginName(String loginName);

    void deleteById(long id);

    SysUser selectById(long id);

    boolean isExistLoginNameExlcudeId(long id, String loginName);

    void updateUser(SysUser user, String jobIds, String permissionIds);

    PageInfo selectPage(int page, int rows);

    void updateUser(SysUser user);
}
