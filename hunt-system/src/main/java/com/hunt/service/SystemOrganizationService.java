package com.hunt.service;

import com.hunt.model.entity.SysOrganization;

/**
 * @Author: ouyangan
 * @Date : 2016/10/10
 */
public interface SystemOrganizationService {
    int insertOrganization(SysOrganization sysOrganization);

    int deleteOrganization(long id);

    int updateOrganization(long id, String name, String description, long parentId);
}
