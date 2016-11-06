package com.hunt.service.impl;

import com.hunt.dao.SysPermissionGroupMapper;
import com.hunt.dao.SysPermissionMapper;
import com.hunt.model.dto.PageInfo;
import com.hunt.model.dto.SysPermissionDto;
import com.hunt.model.entity.SysPermission;
import com.hunt.model.entity.SysPermissionGroup;
import com.hunt.service.SysPermissionService;
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
 * @Date : 2016/10/15
 */
@Transactional
@Service
public class SysPermissionServiceImpl implements SysPermissionService {
    private static Logger log = LoggerFactory.getLogger(SysPermissionServiceImpl.class);
    @Autowired
    private SysPermissionMapper sysPermissionMapper;
    @Autowired
    private SysPermissionGroupMapper sysPermissionGroupMapper;

    @Override
    public boolean isExistName(long groupId, String name) {
        return sysPermissionMapper.isExistName(groupId, name);
    }

    @Override
    public boolean isExistCode(long groupId, String code) {
        return sysPermissionMapper.isExistCode(groupId, code);
    }

    @Override
    public long insertPermission(SysPermission sysPermission) {
        Long id = sysPermissionMapper.insert(sysPermission);
        return id;
    }

    @Override
    public SysPermission selectById(long id) {
        return sysPermissionMapper.selectById(id);
    }

    @Override
    public void update(SysPermission sysPermission) {
        sysPermissionMapper.update(sysPermission);
    }

    @Override
    public boolean isExistNameExcludeId(long id, long groupId, String name) {
        return sysPermissionMapper.isExistNameExcludeId(id, groupId, name);
    }

    @Override
    public boolean isExistCodeExcludeId(long id, long groupId, String code) {
        return sysPermissionMapper.isExistCodeExcludeId(id, groupId, code);
    }

    @Override
    public PageInfo selectPage(int page, int rows) {
        int count = sysPermissionMapper.selectCounts();
//        PageHelper.startPage(page, rows);
        List<SysPermission> list = sysPermissionMapper.selectAll();
        List<SysPermissionDto> listResult = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            SysPermissionDto sysPermissionDto = new SysPermissionDto();
            BeanUtils.copyProperties(list.get(i), sysPermissionDto);
            long groupId = sysPermissionDto.getSysPermissionGroupId();
            SysPermissionGroup sysPermissionGroup = sysPermissionGroupMapper.selectById(groupId);
            sysPermissionDto.setSysPermissionGroupName(sysPermissionGroup != null ? sysPermissionGroup.getName() : "");
            listResult.add(sysPermissionDto);
        }
        return new PageInfo(count, listResult);
    }

    @Override
    public boolean isExistGroupName(String name) {
        return sysPermissionGroupMapper.isExistGroupName(name);
    }

    @Override
    public long insertPermissionGroup(SysPermissionGroup sysPermissionGroup) {
        Long id = sysPermissionGroupMapper.insert(sysPermissionGroup);
        return id;
    }

    @Override
    public List<SysPermissionGroup> selectGroup() {
        List<SysPermissionGroup> sysPermissionGroups = sysPermissionGroupMapper.selectAll();
        return sysPermissionGroups;
    }
}
