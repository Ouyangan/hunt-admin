package com.hunt.service.impl;

import com.google.gson.Gson;
import com.hunt.model.dto.PageInfo;
import com.hunt.model.dto.SysOrganizationTree;
import com.hunt.model.entity.SysOrganization;
import com.hunt.service.SysOrganizationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class SysOrganizationServiceImplTest {
    private static Logger log = LoggerFactory.getLogger(SysOrganizationServiceImplTest.class);
    @Autowired
    private SysOrganizationService service;

    @Test
    public void insertOrganization() throws Exception {
        SysOrganization o = new SysOrganization();
        o.setName("test name");
        o.setFullName("test full name");
        o.setDescription("test desc");
        o.setParentId(2L);
        o.setIsFinal(2);
        service.insertOrganization(o);
        log.debug(new Gson().toJson(o));
        assertTrue(o.getId() != null);

    }

    @Test
    public void deleteOrganization() throws Exception {
        SysOrganization o = new SysOrganization();
        o.setName("test name");
        o.setFullName("test full name");
        o.setDescription("test desc");
        o.setParentId(2L);
        o.setIsFinal(2);
        service.insertOrganization(o);
        assertTrue(o.getId() != null);
        service.deleteOrganization(o.getId());
        SysOrganization sysOrganization = service.selectOrganization(o.getId());
        assertTrue(sysOrganization == null);
    }

    @Test
    public void updateOrganization() throws Exception {
        SysOrganization o = new SysOrganization();
        o.setName("test name");
        o.setFullName("test full name");
        o.setDescription("test desc");
        o.setParentId(2L);
        o.setIsFinal(2);
        service.insertOrganization(o);
        assertTrue(o.getId() != null);
        o = service.selectOrganization(o.getId());
        o.setName("test update name");
        service.updateOrganization(o);
        SysOrganization sysOrganization = service.selectOrganization(o.getId());
        assertTrue(sysOrganization.getName().equals("test update name"));
    }

    @Test
    public void selectPage() throws Exception {
        SysOrganization o = new SysOrganization();
        o.setName("test name");
        o.setFullName("test full name");
        o.setDescription("test desc");
        o.setParentId(0L);
        o.setIsFinal(2);
        service.insertOrganization(o);
        for (int i = 0; i < 20; i++) {
            SysOrganization o1 = new SysOrganization();
            o1.setName("test name");
            o1.setFullName("test full name");
            o1.setDescription("test desc");
            o1.setParentId(o.getId());
            o1.setIsFinal(2);
            service.insertOrganization(o1);
        }
        PageInfo pageInfo = service.selectPage(1, 20, o.getId());
        List<SysOrganizationTree> list = (List<SysOrganizationTree>) pageInfo.getRows();
        assertTrue(list.get(0).getChildren().size() == 20);
    }

    @Test
    public void selectSysOrganizationTree() throws Exception {
        SysOrganization o = new SysOrganization();
        o.setName("test name");
        o.setFullName("test full name");
        o.setDescription("test desc");
        o.setParentId(0L);
        o.setIsFinal(2);
        service.insertOrganization(o);
        SysOrganization o1 = new SysOrganization();
        o1.setName("test o1 name");
        o1.setFullName("test full name");
        o1.setDescription("test desc");
        o1.setParentId(o.getId());
        o1.setIsFinal(2);
        service.insertOrganization(o1);
        SysOrganizationTree sysOrganizationTree = service.selectSysOrganizationTree(o.getId());
        assertTrue(sysOrganizationTree.getChildren().get(0).getName().equals("test o1 name"));
    }

    @Test
    public void selectChildrenTreeList() throws Exception {
        SysOrganization o = new SysOrganization();
        o.setName("test name");
        o.setFullName("test full name");
        o.setDescription("test desc");
        o.setParentId(0L);
        o.setIsFinal(2);
        service.insertOrganization(o);
        SysOrganization o1 = new SysOrganization();
        o1.setName("test o1 name");
        o1.setFullName("test full name");
        o1.setDescription("test desc");
        o1.setParentId(o.getId());
        o1.setIsFinal(2);
        service.insertOrganization(o1);
        List<SysOrganizationTree> list = service.selectChildrenTreeList(o.getId());
        assertTrue(list.get(0).getName().equals("test o1 name"));
    }

    @Test
    public void isExistFullName() throws Exception {
        SysOrganization o = new SysOrganization();
        o.setName("test name");
        o.setFullName("test full name");
        o.setDescription("test desc");
        o.setParentId(2L);
        o.setIsFinal(2);
        service.insertOrganization(o);
        boolean existFullName = service.isExistFullName("test full name");
        boolean existFullName1 = service.isExistFullName("test full name1");
        assertTrue(existFullName);
        assertTrue(!existFullName1);

    }

    @Test
    public void selectOrganization() throws Exception {
        SysOrganization o = new SysOrganization();
        o.setName("test name");
        o.setFullName("test full name");
        o.setDescription("test desc");
        o.setParentId(2L);
        o.setIsFinal(2);
        service.insertOrganization(o);
        SysOrganization sysOrganization = service.selectOrganization(o.getId());
        assertTrue(sysOrganization.getName().equals("test name"));
    }

    @Test
    public void isExistFullNameExcludeId() throws Exception {
        SysOrganization o = new SysOrganization();
        o.setName("test name");
        o.setFullName("test full name");
        o.setDescription("test desc");
        o.setParentId(2L);
        o.setIsFinal(2);
        service.insertOrganization(o);
        boolean existFullName = service.isExistFullNameExcludeId(o.getId(), "test full name");
        boolean existFullName1 = service.isExistFullNameExcludeId(o.getId(), "test full name1");
        assertTrue(!existFullName);
        assertTrue(!existFullName1);
    }

}