package com.hunt.service.impl;

import com.hunt.model.dto.PageInfo;
import com.hunt.model.dto.SysRoleOrganizationTree;
import com.hunt.model.entity.SysRoleOrganization;
import com.hunt.service.SysRoleOrganizationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @Author: ouyangan
 * @Date : 2016/10/26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml"})
@Transactional
public class SysRoleOrganizationServiceImplTest {
    @Autowired
    private SysRoleOrganizationService service;

    @Test
    public void isExistName() throws Exception {
        SysRoleOrganization ro = new SysRoleOrganization();
        ro.setName("test");
        ro.setParentId(1L);
        service.insertRoleOrganization(ro);
        assertTrue(service.isExistName("test", 1L));
        assertTrue(!service.isExistName("test1", 1L));

    }

    @Test
    public void insertRoleOrganization() throws Exception {
        SysRoleOrganization ro = new SysRoleOrganization();
        ro.setName("test");
        ro.setParentId(1L);
        service.insertRoleOrganization(ro);
        assertTrue(ro.getId() != null);
    }

    @Test
    public void isExistNameExcludeId() throws Exception {
        SysRoleOrganization ro = new SysRoleOrganization();
        ro.setName("test");
        ro.setParentId(1L);
        service.insertRoleOrganization(ro);
        assertTrue(!service.isExistNameExcludeId(ro.getId(), "test", 1L));
    }

    @Test
    public void updateRoleOrganization() throws Exception {
        SysRoleOrganization ro = new SysRoleOrganization();
        ro.setName("test");
        ro.setParentId(1L);
        service.insertRoleOrganization(ro);
        ro.setName("test update");
        service.updateRoleOrganization(ro);
        SysRoleOrganization sysRoleOrganization = service.selectRoleOrganizationById(ro.getId());
        assertTrue(sysRoleOrganization.getName().equals("test update"));
    }

    @Test
    public void selectRoleOrganizationById() throws Exception {
        SysRoleOrganization ro = new SysRoleOrganization();
        ro.setName("test");
        ro.setParentId(1L);
        service.insertRoleOrganization(ro);
        SysRoleOrganization sysRoleOrganization = service.selectRoleOrganizationById(ro.getId());
        assertTrue(sysRoleOrganization.getId().equals(ro.getId()));
    }

    @Test
    public void selectPage() throws Exception {
        SysRoleOrganization ro = new SysRoleOrganization();
        ro.setName("test");
        ro.setParentId(1L);
        service.insertRoleOrganization(ro);
        for (int i = 0; i < 20; i++) {
            SysRoleOrganization ro1 = new SysRoleOrganization();
            ro1.setName("test");
            ro1.setParentId(ro.getId());
            service.insertRoleOrganization(ro1);
        }
        PageInfo pageInfo = service.selectPage(1, 20, ro.getId());
        assertTrue(pageInfo.getTotal() >= 20);
    }

    @Test
    public void selectSysRoleOrganizationTree() throws Exception {
        SysRoleOrganization ro = new SysRoleOrganization();
        ro.setName("test");
        ro.setParentId(1L);
        service.insertRoleOrganization(ro);
        for (int i = 0; i < 20; i++) {
            SysRoleOrganization ro1 = new SysRoleOrganization();
            ro1.setName("test");
            ro1.setParentId(ro.getId());
            service.insertRoleOrganization(ro1);
        }
        SysRoleOrganizationTree tree = service.selectSysRoleOrganizationTree(ro.getId());
        assertTrue(tree.getChildren().size() == 20);
    }

    @Test
    public void selectSysRoleOrganizationTreeChildrenList() throws Exception {
        SysRoleOrganization ro = new SysRoleOrganization();
        ro.setName("test");
        ro.setParentId(1L);
        service.insertRoleOrganization(ro);
        for (int i = 0; i < 20; i++) {
            SysRoleOrganization ro1 = new SysRoleOrganization();
            ro1.setName("test");
            ro1.setParentId(ro.getId());
            service.insertRoleOrganization(ro1);
        }
        List<SysRoleOrganizationTree> sysRoleOrganizationTrees = service.selectSysRoleOrganizationTreeChildrenList(ro.getId());
        assertTrue(sysRoleOrganizationTrees.size() == 20);
    }

}