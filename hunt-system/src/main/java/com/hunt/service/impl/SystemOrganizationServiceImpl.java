package com.hunt.service.impl;

import com.hunt.dao.SysOrganizationMapper;
import com.hunt.model.dto.PageInfo;
import com.hunt.model.dto.SysOrganizationTree;
import com.hunt.model.entity.SysOrganization;
import com.hunt.service.SystemOrganizationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
        Long i = sysOrganizationMapper.insert(sysOrganization);
        return i;
    }

    @Override
    public int deleteOrganization(long id) {
        SysOrganization sysOrganization = sysOrganizationMapper.selectById(id);
        if (sysOrganization.getIsFinal() == 2) {
            return 2;
        }
        sysOrganization.setStatus(2);
        sysOrganizationMapper.update(sysOrganization);
        return 1;
    }

    @Override
    public int updateOrganization(SysOrganization organization) {
        return 0;
    }

    @Override
    public PageInfo selectPage(int page, int row, long id) {
        int total = sysOrganizationMapper.selectCounts();
        SysOrganization sysOrganization = sysOrganizationMapper.selectById(id);
        List<SysOrganization> sysOrganizationList = sysOrganizationMapper.selectChildren(id);
        SysOrganizationTree sysOrganizationTree = new SysOrganizationTree();
        sysOrganizationTree.setChildren(sysOrganizationList);
        BeanUtils.copyProperties(sysOrganization, sysOrganizationTree);
        List<SysOrganizationTree> list = new ArrayList<>();
        list.add(sysOrganizationTree);
        PageInfo page1 = new PageInfo(total, list);
        return page1;
    }

}


