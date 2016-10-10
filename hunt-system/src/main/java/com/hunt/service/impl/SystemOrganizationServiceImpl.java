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
    public Long insertOrganization(SysOrganization sysOrganization) {
        Long i = sysOrganizationMapper.insertSysOrganization(sysOrganization);
        return i;
    }

    @Override
    public int deleteOrganization(long id) {
        SysOrganization sysOrganization = sysOrganizationMapper.selectSysOrganizationById(id);
        if (sysOrganization.getIsFinal() == 2) {
            return 2;
        }
        sysOrganization.setState(2);
        sysOrganizationMapper.updateSysOrganization(sysOrganization);
        return 1;
    }

    @Override
    public int updateOrganization(SysOrganization organization) {
        return 0;
    }

}
