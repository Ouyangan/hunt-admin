package com.hunt.service.impl;

import com.google.gson.Gson;
import com.hunt.dao.SysOrganizationMapper;
import com.hunt.model.dto.SysOrganizationTree;
import com.hunt.model.entity.SysOrganization;
import com.hunt.service.SystemOrganizationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: ouyangan
 * @Date : 2016/10/11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring.xml")
//@Transactional
public class SystemOrganizationServiceImplTest {
    int count = 0;
    @Autowired
    private SysOrganizationMapper sysOrganizationMapper;
    @Autowired
    private SystemOrganizationService systemOrganizationService;

    public SysOrganizationTree selectSysOrganizationTree(long id) {
        SysOrganizationTree sysOrganizationTree = new SysOrganizationTree();
        SysOrganization sysOrganization = sysOrganizationMapper.selectById(id);
        BeanUtils.copyProperties(sysOrganization, sysOrganizationTree);
        List<SysOrganizationTree> treeList = selectChildrenTreeList(id);
        sysOrganizationTree.setChildren(treeList);
        for (int i = 0; i < treeList.size(); i++) {
            selectSysOrganizationTree(treeList.get(i).getId());
        }
        return sysOrganizationTree;
    }

    public List<SysOrganizationTree> selectChildrenTreeList(long id) {
        List<SysOrganization> childrenList = sysOrganizationMapper.selectChildren(id);
        List<SysOrganizationTree> childrenTreeList = new ArrayList<>();
        for (SysOrganization s : childrenList) {
            SysOrganizationTree sysOrganizationTree = new SysOrganizationTree();
            BeanUtils.copyProperties(s, sysOrganizationTree);
            childrenTreeList.add(sysOrganizationTree);
        }
        if (childrenList.size() == 0) {
            return Collections.emptyList();
        }
        return childrenTreeList;
    }

    @Test
    public void selectChildren() throws Exception {
        SysOrganizationTree tree = selectSysOrganizationTree(1L);
        System.out.println("--------------json----------");
        System.out.println(new Gson().toJson(tree));
        System.out.println("--------------json----------");

    }

    @Test
    public void insertOrganization() throws Exception {
//        SysOrganization sysOrganization = new SysOrganization();
//        sysOrganization.setName("深圳xx软件公司");
//        sysOrganization.setDescription("总部");
//        sysOrganization.setIsFinal(2);
//        sysOrganization.setParentId(0L);
//        sysOrganizationMapper.insert(sysOrganization);
//        System.out.println(sysOrganization);
        for (int i = 1; i < 20; i++) {
            SysOrganization sysOrganization1 = new SysOrganization();
            sysOrganization1.setName("深圳xx软件公司湖南分公司长沙分部岳麓区分公司-" + i);
            sysOrganization1.setDescription("湖南分公司长沙分部岳麓区分公司-" + i);
            sysOrganization1.setIsFinal(1);
            sysOrganization1.setParentId(40L);
            sysOrganizationMapper.insert(sysOrganization1);
            System.out.println(sysOrganization1);
        }
    }

    @Test
    public void deleteOrganization() throws Exception {

    }

    @Test
    public void updateOrganization() throws Exception {

    }

    @Test
    public void selectPage() throws Exception {

    }

}