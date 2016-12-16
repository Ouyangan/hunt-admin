package com.hunt.service.impl;

import com.hunt.dao.SysOrganizationMapper;
import com.hunt.model.dto.PageInfo;
import com.hunt.model.dto.SysOrganizationTree;
import com.hunt.model.entity.SysOrganization;
import com.hunt.service.SysOrganizationService;
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
public class SysOrganizationServiceImpl implements SysOrganizationService {

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
        sysOrganization.setStatus(2);
        sysOrganizationMapper.update(sysOrganization);
        return 1;
    }

    @Override
    public void updateOrganization(SysOrganization organization) {
        sysOrganizationMapper.update(organization);
    }

    @Override
    public PageInfo selectPage(int page, int row, long id) {
        SysOrganizationTree sysOrganizationTree = selectSysOrganizationTree(id);
        List<SysOrganizationTree> list = new ArrayList<>();
        list.add(sysOrganizationTree);
        PageInfo pageInfo = new PageInfo(sysOrganizationMapper.selectCounts(), list);
        return pageInfo;
    }

    @Override
    public SysOrganizationTree selectSysOrganizationTree(long id) {
        SysOrganizationTree tree = new SysOrganizationTree();
        SysOrganization sysOrganization = sysOrganizationMapper.selectById(id);
        BeanUtils.copyProperties(sysOrganization, tree);
        List<SysOrganizationTree> treeList = selectChildrenTreeList(id);
        tree.setChildren(treeList);
        for (int i = 0; i < treeList.size(); i++) {
            tree.getChildren().set(i, selectSysOrganizationTree(treeList.get(i).getId()));
        }
        return tree;
    }

    @Override
    public List<SysOrganizationTree> selectChildrenTreeList(long id) {
        List<SysOrganization> childrenList = sysOrganizationMapper.selectChildren(id);
        List<SysOrganizationTree> childrenTreeList = new ArrayList<>();
        for (SysOrganization s : childrenList) {
            SysOrganizationTree sysOrganizationTree = new SysOrganizationTree();
            BeanUtils.copyProperties(s, sysOrganizationTree);
            childrenTreeList.add(sysOrganizationTree);
        }
        return childrenTreeList;
    }

    @Override
    public boolean isExistFullName(String fullName) {
        return sysOrganizationMapper.isExistFullName(fullName);
    }

    @Override
    public SysOrganization selectOrganization(long id) {
        SysOrganization sysOrganization = sysOrganizationMapper.selectById(id);
        return sysOrganization;
    }

    @Override
    public boolean isExistFullNameExcludeId(long id, String fullName) {

        return sysOrganizationMapper.isExistFullNameExcludeId(id, fullName);
    }
}


