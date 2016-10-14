package com.hunt.service.impl;

import com.github.pagehelper.PageHelper;
import com.hunt.dao.SysRoleMapper;
import com.hunt.model.dto.PageInfo;
import com.hunt.model.entity.SysRole;
import com.hunt.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author ouyangan
 * @Date 2016/10/14/14:53
 * @Description
 */
@Service
@Transactional
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public boolean isExsitRoleName(String name) {
        return sysRoleMapper.isExsitName(name);
    }

    @Override
    public long insertRole(SysRole sysRole) {
        sysRoleMapper.insert(sysRole);
        return sysRole.getId();
    }

    @Override
    public boolean isExsitRoleNameExcludeId(long id, String name) {
        return sysRoleMapper.isExsitNameExcludeId(id, name);
    }

    @Override
    public SysRole selectById(long id) {
        return sysRoleMapper.selectById(id);
    }

    @Override
    public PageInfo selectPage(int page, int row) {
        int i = sysRoleMapper.selectCounts();
        PageHelper.startPage(page, row);
        List<SysRole> sysRoles = sysRoleMapper.selectAll();
        PageInfo pageInfo = new PageInfo(i, sysRoles);
        return pageInfo;
    }

    @Override
    public void updateRole(SysRole sysRole) {
        sysRoleMapper.update(sysRole);
    }
}
