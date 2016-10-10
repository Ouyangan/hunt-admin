package com.hunt.service;

import com.hunt.model.entity.SysOrganization;

/**
 * @Author: ouyangan
 * @Date : 2016/10/10
 */
public interface SystemOrganizationService {
    Long insertOrganization(SysOrganization sysOrganization);

    int deleteOrganization(long id);

    int updateOrganization(SysOrganization organization);
}
