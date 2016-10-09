package com.hunt.service.impl;

import com.hunt.dao.SysOrganizationMapper;
import com.hunt.model.entity.SysOrganization;
import com.hunt.service.SystemOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: ouyangan
 * @Date : 2016/10/10
 */
@Service
@Transactional
public class SystemOrganizationServiceImpl implements SystemOrganizationService {
    @Autowired
    private SysOrganizationMapper sysOrganizationMapper;

    @Override
    public int insertOrganization(SysOrganization sysOrganization) {
        int i = sysOrganizationMapper.insertSelective(sysOrganization);
        return i;
    }

    @Override
    public int deleteOrganization(long id) {
        SysOrganization sysOrganization = sysOrganizationMapper.selectById(id);
        if (sysOrganization.getIsFinal() == 2) {
            return 2;
        }
        int i = sysOrganizationMapper.deleteById(id);
        return i;
    }

    @Override
    public int updateOrganization(long id, String name, String description, long parentId) {
        return 0;
    }
}
