package com.hunt.service;

import com.hunt.model.dto.PageInfo;
import com.hunt.model.entity.SysRoleOrganization;

/**
 * @Author ouyangan
 * @Date 2016/10/17/16:30
 * @Description
 */
public interface SysRoleOrganizationService {
    boolean isExistName(String name, long parentId);

    long insertRoleOrganization(SysRoleOrganization roleOrganization);

    boolean isExistNameExcludeId(long id, String name, long parentId);

    void updateRoleOrganization(SysRoleOrganization roleOrganization);

    SysRoleOrganization selectRoleOrganizationById(long id);

    PageInfo selectPage(int page, int rows, long id);
}
