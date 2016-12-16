package com.hunt.service;


import com.hunt.model.dto.PageInfo;
import com.hunt.model.entity.SysPermission;
import com.hunt.model.entity.SysPermissionGroup;

import java.util.List;

/**
 * @Author: ouyangan
 * @Date : 2016/10/15
 */
public interface SysPermissionService {
    boolean isExistName(long groupId, String name);

    boolean isExistCode(long groupId, String code);

    long insertPermission(SysPermission sysPermission);

    SysPermission selectById(long id);

    void update(SysPermission sysPermission);

    boolean isExistNameExcludeId(long id, long groupId, String name);

    boolean isExistCodeExcludeId(long id, long groupId, String code);

    PageInfo selectPage(int page, int rows);

    boolean isExistGroupName(String name);

    long insertPermissionGroup(SysPermissionGroup sysPermissionGroup);

    List<SysPermissionGroup> selectGroup();
}
