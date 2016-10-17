package com.hunt.service.impl;

import com.hunt.dao.SysRoleOrganizationMapper;
import com.hunt.model.entity.SysRoleOrganization;
import com.hunt.service.SysRoleOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author ouyangan
 * @Date 2016/10/17/16:30
 * @Description
 */
@Service
@Transactional
public class SysRoleOrganizationServiceImpl implements SysRoleOrganizationService {
    @Autowired
    private SysRoleOrganizationMapper roleOrganizationMapper;

    @Override
    public boolean isExistName(String name, long parentId) {
        return roleOrganizationMapper.isExistName(name, parentId);
    }

    @Override
    public long insertRoleOrganization(SysRoleOrganization roleOrganization) {
        Long id = roleOrganizationMapper.insert(roleOrganization);
        return id;
    }

    @Override
    public boolean isExistNameExcludeId(long id, String name, long parentId) {
        return roleOrganizationMapper.isExistNameExcludeId(id, name, parentId);
    }

    @Override
    public void updateRoleOrganization(SysRoleOrganization roleOrganization) {
        roleOrganizationMapper.update(roleOrganization);
    }
}
