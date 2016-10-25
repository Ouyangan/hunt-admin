package com.hunt.service.impl;

import com.github.pagehelper.PageHelper;
import com.hunt.dao.*;
import com.hunt.model.dto.PageInfo;
import com.hunt.model.entity.*;
import com.hunt.service.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.SystemConstant;

import java.util.List;
import java.util.Set;

/**
 * @Author: ouyangan
 * @Date : 2016/10/21
 */
@Service
@Transactional
public class SystemServiceImpl implements SystemService {
    private static final Logger log = LoggerFactory.getLogger(SystemServiceImpl.class);

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserRoleOrganizationMapper sysUserRoleOrganizationMapper;
    @Autowired
    private SysLoginStatusMapper sysLoginStatusMapper;
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;
    @Autowired
    private SysRoleOrganizationMapper sysRoleOrganizationMapper;
    @Autowired
    private SysLogMapper sysLogMapper;
    @Autowired
    private SysDataGroupMapper sysDataGroupMapper;
    @Autowired
    private SysDataItemMapper sysDataItemMapper;

    @Override
    public void forceLogout(long userId) {
        List<SysLoginStatus> list = sysLoginStatusMapper.selectByUserId(userId);
        for (int i = 0; i < list.size(); i++) {
            SysLoginStatus sysLoginStatus = list.get(i);
            sysLoginStatus.setStatus(2);
            sysLoginStatusMapper.update(sysLoginStatus);
            //delete session
            redisTemplate.opsForValue().getOperations().delete(sysLoginStatus.getSessionId());
            //delete authrization cache
            redisTemplate.opsForValue().getOperations().delete(SystemConstant.shiro_cache_prefix + sysLoginStatus.getSysUserLoginName());
        }
        log.debug("force logout userId : {}", userId);
    }

    @Override
    public void clearAuthorizationInfoCacheByUserId(long userId) {
        SysUser sysUser = sysUserMapper.selectById(userId);
        if (sysUser != null) {
            redisTemplate.opsForValue().getOperations().delete(SystemConstant.shiro_cache_prefix + sysUser.getLoginName());
        }
        log.debug("clear authorization info cache userId : {}", userId);
    }

    @Override
    public void clearAuthorizationInfoALL() {
        Set<Object> keys = redisTemplate.keys(SystemConstant.shiro_cache_prefix_keys);
        if (keys.size() > 0) {
            redisTemplate.opsForValue().getOperations().delete(keys);
            log.debug("clear authorization info cache key : {}", keys.toArray());
        }
    }

    @Override
    public void clearAuthorizationInfoByRoleId(long roleId) {
        log.debug("clear authorization info cache by roleId: {}", roleId);
        List<Long> list = sysRoleOrganizationMapper.selectByRoleId(roleId);
        if (list.size() > 0) {
            for (long id : list) {
                List<Long> userIds = sysUserRoleOrganizationMapper.selectByRoleOrganizationId(id);
                if (userIds.size() > 0) {
                    for (Long userId : userIds) {
                        SysUser sysUser = sysUserMapper.selectById(userId);
                        if (sysUser != null) {
                            redisTemplate.opsForValue().getOperations().delete(SystemConstant.shiro_cache_prefix + sysUser.getLoginName());
                        }
                    }
                }
            }
        }
    }

    @Override
    public PageInfo selectLogStatus(int page, int rows) {
        int counts = sysLoginStatusMapper.selectCounts();
        PageHelper.startPage(page, rows);
        List<SysLoginStatus> sysLoginStatuses = sysLoginStatusMapper.selectAll();
        return new PageInfo(counts, sysLoginStatuses);
    }

    @Override
    public PageInfo selectLog(int page, int rows, String sort, String order, String method, String url, String param, String result) {
        int counts = sysLogMapper.selectCounts();
        PageHelper.startPage(page, rows);
        List<SysLog> list = sysLogMapper.selectLog(sort, order, method, url, param, result);
        log.debug(list.toString());
        return new PageInfo(counts, list);
    }

    @Override
    public void insertSysControllerLog(SysLog runningLog) {
        sysLogMapper.insert(runningLog);
    }

    @Override
    public Long insertSysDataGroup(SysDataGroup sysDataGroup) {
        sysDataGroupMapper.insert(sysDataGroup);
        return sysDataGroup.getId();
    }

    @Override
    public boolean isExistDataGroupName(String name) {
        return sysDataGroupMapper.isExistName(name);
    }

    @Override
    public List<SysDataGroup> selectDataGroupList() {
        return sysDataGroupMapper.selectAll();
    }

    @Override
    public long insertSysDataItem(SysDataItem sysDataItem) {
        sysDataItemMapper.insert(sysDataItem);
        return sysDataItem.getId();
    }

    @Override
    public boolean isExistDataItemKeyName(String key, long groupId) {
        return sysDataItemMapper.isExistName(key, groupId);
    }

    @Override
    public void deleteDataItemById(Long id) {
        sysDataItemMapper.deleteById(id);
    }

    @Override
    public boolean isExistDataItemNameExcludeId(Long id, String key, long groupId) {

        return sysDataItemMapper.isExistDataItemNameExcludeId(id, key, groupId);
    }

    @Override
    public void updateDateItem(SysDataItem sysDataItem) {
        sysDataItemMapper.update(sysDataItem);
    }

}
