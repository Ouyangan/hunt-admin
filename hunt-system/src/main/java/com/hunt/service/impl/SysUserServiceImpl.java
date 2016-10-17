package com.hunt.service.impl;

import com.github.pagehelper.PageHelper;
import com.hunt.dao.SysPermissionMapper;
import com.hunt.dao.SysUserMapper;
import com.hunt.dao.SysUserPermissionMapper;
import com.hunt.dao.SysUserRoleOrganizationMapper;
import com.hunt.model.dto.PageInfo;
import com.hunt.model.dto.SysUserDto;
import com.hunt.model.entity.SysPermission;
import com.hunt.model.entity.SysUser;
import com.hunt.model.entity.SysUserPermission;
import com.hunt.model.entity.SysUserRoleOrganization;
import com.hunt.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserRoleOrganizationMapper sysUserRoleOrganizationMapper;
    @Autowired
    private SysUserPermissionMapper sysUserPermissionMapper;
    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public long insertUser(SysUser user, String jobIds, String permissionIds) {
        sysUserMapper.insert(user);
        String[] jobIdArray = jobIds.split(",");
        String[] permissionIdArray = permissionIds.split(",");
        for (String jobid : jobIdArray) {
            SysUserRoleOrganization userRoleOrganization = new SysUserRoleOrganization();
            userRoleOrganization.setSysUserId(user.getId());
            userRoleOrganization.setSysRoleOrganizationId(Long.valueOf(jobid));
            userRoleOrganization.setIsFinal(1);
            sysUserRoleOrganizationMapper.insert(userRoleOrganization);
        }
        for (String permissionId : permissionIdArray) {
            SysUserPermission userPermission = new SysUserPermission();
            userPermission.setSysUserId(user.getId());
            userPermission.setSysPermissionId(Long.valueOf(permissionId));
            userPermission.setIsFinal(1);
            sysUserPermissionMapper.insert(userPermission);
        }
        return user.getId();
    }

    @Override
    public boolean isExistLoginName(String loginName) {
        return sysUserMapper.selectByLoginName(loginName);
    }

    @Override
    public SysUser selectById(long id) {
        return sysUserMapper.selectById(id);
    }

    @Override
    public void updateUser(SysUser user, String jobIds, String permissionIds) {
        sysUserMapper.update(user);
        sysUserPermissionMapper.deleteByUserId(user.getId());
        sysUserRoleOrganizationMapper.deleteUserId(user.getId());
        String[] jobIdArray = jobIds.split(",");
        String[] permissionIdArray = permissionIds.split(",");

        for (String jobid : jobIdArray) {
            SysUserRoleOrganization userRoleOrganization = new SysUserRoleOrganization();
            userRoleOrganization.setSysUserId(user.getId());
            userRoleOrganization.setSysRoleOrganizationId(Long.valueOf(jobid));
            userRoleOrganization.setIsFinal(1);
            sysUserRoleOrganizationMapper.insert(userRoleOrganization);
        }
        for (String permissionId : permissionIdArray) {
            SysUserPermission userPermission = new SysUserPermission();
            userPermission.setSysUserId(user.getId());
            userPermission.setSysPermissionId(Long.valueOf(permissionId));
            userPermission.setIsFinal(1);
            sysUserPermissionMapper.insert(userPermission);
        }
    }

    @Override
    public PageInfo selectPage(int page, int rows) {
        int counts = sysUserMapper.selectCounts();
        PageHelper.startPage(page, rows);
        List<SysUser> sysUsers = sysUserMapper.selectAll();
        List<SysUserDto> sysUserDtos = new ArrayList<>();
        for (SysUser user : sysUsers) {
            SysUserDto userDto = new SysUserDto();
            BeanUtils.copyProperties(user, userDto);
            List<SysUserPermission> userPermissions = sysUserPermissionMapper.selectByUserId(user.getId());
            List<SysPermission> permissions = new ArrayList<>();
            for (SysUserPermission userPermission : userPermissions) {
                SysPermission sysPermission = sysPermissionMapper.selectById(userPermission.getSysPermissionId());
                permissions.add(sysPermission);
            }
            List<SysUserRoleOrganization> userRoleOrganizations = sysUserRoleOrganizationMapper.selectByUserId(user.getId());
            userDto.setPermissions(permissions);
            userDto.setUserRoleOrganizations(userRoleOrganizations);
            sysUserDtos.add(userDto);
        }
        PageInfo pageInfo = new PageInfo(counts, sysUserDtos);
        return pageInfo;
    }

    @Override
    public void updateUser(SysUser user) {
        sysUserMapper.update(user);
    }

    @Override
    public boolean isExistLoginNameExlcudeId(long id, String loginName) {
        return sysUserMapper.isExistLoginNameExlcudeId(id, loginName);
    }

    @Override
    public void deleteById(long id) {
        sysUserMapper.deleteById(id);
        sysUserPermissionMapper.deleteByUserId(id);
        sysUserRoleOrganizationMapper.deleteUserId(id);
    }
}
