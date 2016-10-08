package com.hunt.service.impl;

import com.hunt.dao.SysOrganizationMapper;
import com.hunt.dao.SysRoleMapper;
import com.hunt.dao.SysUserMapper;
import com.hunt.dao.SysUserRoleOrganizationMapper;
import com.hunt.model.dto.LoginUserInfo;
import com.hunt.model.dto.UserRoleOriganization;
import com.hunt.model.entity.SysOrganization;
import com.hunt.model.entity.SysRole;
import com.hunt.model.entity.SysUser;
import com.hunt.model.entity.SysUserRoleOrganization;
import com.hunt.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysOrganizationMapper sysOrganizationMapper;

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

    @Override
    public SysUser selectUserByLoginName(String username) {
        return sysUserMapper.selectUserByLoginName(username);
    }

    @Override
    public LoginUserInfo selectUserLoginInfo(Long id) {
        SysUser user = sysUserMapper.selectByPrimaryKey(id);
        List<SysUserRoleOrganization> list = sysUserRoleOrganizationMapper.selectByUserId(id);

        List<UserRoleOriganization> userRoleOriganizationList = new ArrayList<>();

        for (SysUserRoleOrganization sysUserRoleOrganization : list) {
            SysRole sysRole = sysRoleMapper.selectByPrimaryKey(sysUserRoleOrganization.getSysRoleId());
            SysOrganization sysOrganization = sysOrganizationMapper.selectByPrimaryKey(sysUserRoleOrganization.getSysOrganizationId());
            UserRoleOriganization userRoleOriganization = new UserRoleOriganization(sysRole, sysOrganization);
            userRoleOriganizationList.add(userRoleOriganization);
        }
        LoginUserInfo loginUserInfo = new LoginUserInfo();
        loginUserInfo.setUser(user);
        loginUserInfo.setUserRoleOriganizationList(userRoleOriganizationList);
        return loginUserInfo;
    }
}
