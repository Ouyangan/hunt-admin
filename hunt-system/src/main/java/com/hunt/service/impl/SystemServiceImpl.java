package com.hunt.service.impl;

import com.github.pagehelper.PageHelper;
import com.hunt.dao.SysLoginStatusMapper;
import com.hunt.dao.SysRoleOrganizationMapper;
import com.hunt.dao.SysUserMapper;
import com.hunt.dao.SysUserRoleOrganizationMapper;
import com.hunt.model.dto.PageInfo;
import com.hunt.model.entity.SysLoginStatus;
import com.hunt.model.entity.SysUser;
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
        log.debug("clear authorization info cache by roleId: {}",roleId);
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
}
