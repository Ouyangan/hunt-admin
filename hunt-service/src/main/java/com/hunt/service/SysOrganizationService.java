package com.hunt.service;



import com.hunt.model.dto.PageInfo;
import com.hunt.model.dto.SysOrganizationTree;
import com.hunt.model.entity.SysOrganization;

import java.util.List;

/**
 * @Author: ouyangan
 * @Date : 2016/10/10
 */
public interface SysOrganizationService {
    Long insertOrganization(SysOrganization sysOrganization);

    int deleteOrganization(long id);

    void updateOrganization(SysOrganization organization);

    PageInfo selectPage(int page, int row, long id);

    public SysOrganizationTree selectSysOrganizationTree(long id);

    public List<SysOrganizationTree> selectChildrenTreeList(long id);

    boolean isExistFullName(String fullName);

    SysOrganization selectOrganization(long id);

    boolean isExistFullNameExcludeId(long id, String fullName);

}
