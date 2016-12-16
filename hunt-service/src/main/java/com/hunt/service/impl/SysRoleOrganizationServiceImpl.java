package com.hunt.service.impl;

import com.hunt.dao.SysOrganizationMapper;
import com.hunt.dao.SysRoleMapper;
import com.hunt.dao.SysRoleOrganizationMapper;
import com.hunt.model.dto.PageInfo;
import com.hunt.model.dto.SysRoleOrganizationTree;
import com.hunt.model.entity.SysOrganization;
import com.hunt.model.entity.SysRole;
import com.hunt.model.entity.SysRoleOrganization;
import com.hunt.service.SysRoleOrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ouyangan
 * @Date 2016/10/17/16:30
 * @Description
 */
@Service
@Transactional
public class SysRoleOrganizationServiceImpl implements SysRoleOrganizationService {
    private static Logger log = LoggerFactory.getLogger(SysRoleOrganizationServiceImpl.class);
    @Autowired
    private SysRoleOrganizationMapper roleOrganizationMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysOrganizationMapper sysOrganizationMapper;

    @Override
    public boolean isExistName(String name, long parentId) {
        return roleOrganizationMapper.isExistName(name, parentId);
    }

    @Override
    public long insertRoleOrganization(SysRoleOrganization roleOrganization) {
        Long id = roleOrganizationMapper.insert(roleOrganization);
        return id;
    }

    @Override
    public boolean isExistNameExcludeId(long id, String name, long parentId) {
        return roleOrganizationMapper.isExistNameExcludeId(id, name, parentId);
    }

    @Override
    public void updateRoleOrganization(SysRoleOrganization roleOrganization) {
        roleOrganizationMapper.update(roleOrganization);
    }

    @Override
    public SysRoleOrganization selectRoleOrganizationById(long id) {
        return roleOrganizationMapper.selectById(id);
    }

    @Override
    public PageInfo selectPage(int page, int rows, long id) {
        int counts = roleOrganizationMapper.selectCounts();
        SysRoleOrganizationTree tree = selectSysRoleOrganizationTree(id);
        List<SysRoleOrganizationTree> list = new ArrayList<>();
        list.add(tree);
        return new PageInfo(counts, list);
    }

    //查询职位树形结构
    @Override
    public SysRoleOrganizationTree selectSysRoleOrganizationTree(long id) {
        SysRoleOrganizationTree tree = new SysRoleOrganizationTree();
        SysRoleOrganization roleOrganization = roleOrganizationMapper.selectById(id);
        log.debug("roleOrganization :{}", roleOrganization);
        BeanUtils.copyProperties(roleOrganization, tree);
        if (roleOrganization == null) {
            return null;
        }
        SysRole role = sysRoleMapper.selectById(roleOrganization.getSysRoleId());
        log.debug("role :{}", role);
        if (role != null) {
            tree.setSysRoleName(role.getName());
        }
        SysOrganization organization = sysOrganizationMapper.selectById(roleOrganization.getSysOrganizationId());
        if (organization != null) {
            tree.setSysOrganizationName(organization.getName());
        }
        List<SysRoleOrganizationTree> childrenList = selectSysRoleOrganizationTreeChildrenList(id);
        tree.setChildren(childrenList);
        for (int i = 0; i < childrenList.size(); i++) {
            tree.getChildren().set(i, selectSysRoleOrganizationTree(childrenList.get(i).getId()));
        }
        return tree;
    }

    //查询子目录
    @Override
    public List<SysRoleOrganizationTree> selectSysRoleOrganizationTreeChildrenList(long id) {
        List<SysRoleOrganization> childrenList = roleOrganizationMapper.selectChildren(id);
        List<SysRoleOrganizationTree> childrenTreeList = new ArrayList<>();
        for (SysRoleOrganization s : childrenList) {
            SysRoleOrganizationTree sysOrganizationTree = new SysRoleOrganizationTree();
            BeanUtils.copyProperties(s, sysOrganizationTree);
            childrenTreeList.add(sysOrganizationTree);
        }
        return childrenTreeList;
    }

}
