package com.hunt.service.impl;

import com.hunt.dao.SysOrganizationMapper;
import com.hunt.dao.SysRoleMapper;
import com.hunt.dao.SysRoleOrganizationMapper;
import com.hunt.model.dto.PageInfo;
import com.hunt.model.dto.SysRoleOrganizationTree;
import com.hunt.model.entity.SysRoleOrganization;
import com.hunt.service.SysRoleOrganizationService;
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
        return new PageInfo(counts, tree);
    }

    //查询职位树形结构
    public SysRoleOrganizationTree selectSysRoleOrganizationTree(long id) {
        SysRoleOrganizationTree tree = new SysRoleOrganizationTree();
        SysRoleOrganization roleOrganization = roleOrganizationMapper.selectById(id);
        tree.setSysRoleName(sysRoleMapper.selectById(tree.getSysRoleId()).getName());
        tree.setSysRoleName(sysOrganizationMapper.selectById(tree.getSysOrganizationId()).getName());
        BeanUtils.copyProperties(roleOrganization, tree);
        List<SysRoleOrganizationTree> childrenList = selectSysRoleOrganizationTreeChildrenList(id);
        tree.setChildren(childrenList);
        for (int i = 0; i < childrenList.size(); i++) {
            tree.getChildren().set(i, selectSysRoleOrganizationTree(childrenList.get(i).getId()));
        }
        return tree;
    }

    //查询子目录
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
