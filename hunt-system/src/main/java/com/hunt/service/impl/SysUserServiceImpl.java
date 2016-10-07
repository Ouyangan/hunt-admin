package com.hunt.service.impl;

import com.hunt.dao.SysUserMapper;
import com.hunt.dao.SysUserRoleOrganizationMapper;
import com.hunt.model.entity.SysUser;
import com.hunt.model.entity.SysUserRoleOrganization;
import com.hunt.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: ouyangan
 * @Date : 2016/10/7
 */
@Service
@Transactional
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserRoleOrganizationMapper sysUserRoleOrganizationMapper;

    @Override
    public long insertUser(SysUser sysUser, List<SysUserRoleOrganization> sysUserRoleOrganizationList) {
        int i = sysUserMapper.insertSelective(sysUser);
        for (int j = 0; j < sysUserRoleOrganizationList.size(); j++) {
            SysUserRoleOrganization sysUserRoleOrganization = sysUserRoleOrganizationList.get(j);
            sysUserRoleOrganization.setSysUserId((long) i);
            sysUserRoleOrganizationMapper.insertSelective(sysUserRoleOrganization);
        }
        return i;
    }
}
