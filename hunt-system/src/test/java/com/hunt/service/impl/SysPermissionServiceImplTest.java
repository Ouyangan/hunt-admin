package com.hunt.service.impl;

import com.hunt.model.dto.PageInfo;
import com.hunt.model.entity.SysPermission;
import com.hunt.model.entity.SysPermissionGroup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.hunt.service.SysPermissionService;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @Author: ouyangan
 * @Date : 2016/10/26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml"})
@Transactional
public class SysPermissionServiceImplTest {
    @Autowired
    private SysPermissionService service;

    @Test
    public void isExistName() throws Exception {
        SysPermissionGroup pg = new SysPermissionGroup();
        pg.setName("test pg");
        pg.setDescription("desc");
        service.insertPermissionGroup(pg);
        SysPermission p = new SysPermission();
        p.setName("test");
        p.setSysPermissionGroupId(pg.getId());
        service.insertPermission(p);
        assertTrue(service.isExistName(pg.getId(), "test"));
        assertTrue(!service.isExistName(pg.getId(), "test1"));
    }

    @Test
    public void isExistCode() throws Exception {
        SysPermissionGroup pg = new SysPermissionGroup();
        pg.setName("test pg");
        pg.setDescription("desc");
        service.insertPermissionGroup(pg);
        SysPermission p = new SysPermission();
        p.setName("test");
        p.setCode("code");
        p.setSysPermissionGroupId(pg.getId());
        service.insertPermission(p);
        assertTrue(service.isExistCode(pg.getId(), "code"));
        assertTrue(!service.isExistCode(pg.getId(), "code1"));
    }

    @Test
    public void insertPermission() throws Exception {
        SysPermissionGroup pg = new SysPermissionGroup();
        pg.setName("test pg");
        pg.setDescription("desc");
        service.insertPermissionGroup(pg);
        SysPermission p = new SysPermission();
        p.setName("test");
        p.setCode("code");
        p.setSysPermissionGroupId(pg.getId());
        service.insertPermission(p);
    }

    @Test
    public void selectById() throws Exception {
        SysPermissionGroup pg = new SysPermissionGroup();
        pg.setName("test pg");
        pg.setDescription("desc");
        service.insertPermissionGroup(pg);
        SysPermission p = new SysPermission();
        p.setName("test");
        p.setCode("code");
        p.setSysPermissionGroupId(pg.getId());
        service.insertPermission(p);
        SysPermission sysPermission = service.selectById(p.getId());
        assertTrue(sysPermission.getName().equals("test"));
    }

    @Test
    public void update() throws Exception {
        SysPermissionGroup pg = new SysPermissionGroup();
        pg.setName("test pg");
        pg.setDescription("desc");
        service.insertPermissionGroup(pg);
        SysPermission p = new SysPermission();
        p.setName("test");
        p.setCode("code");
        p.setSysPermissionGroupId(pg.getId());
        service.insertPermission(p);
        p.setName("test update");
        service.update(p);
        SysPermission sysPermission = service.selectById(p.getId());
        assertTrue(sysPermission.getName().equals("test update"));
    }

    @Test
    public void isExistNameExcludeId() throws Exception {
        SysPermissionGroup pg = new SysPermissionGroup();
        pg.setName("test pg");
        pg.setDescription("desc");
        service.insertPermissionGroup(pg);
        SysPermission p = new SysPermission();
        p.setName("test");
        p.setSysPermissionGroupId(pg.getId());
        service.insertPermission(p);
        assertTrue(service.isExistNameExcludeId(pg.getId(), pg.getId(), "test"));
        assertTrue(!service.isExistNameExcludeId(pg.getId(), pg.getId(), "test1"));

    }

    @Test
    public void isExistCodeExcludeId() throws Exception {
        SysPermissionGroup pg = new SysPermissionGroup();
        pg.setName("test pg");
        pg.setDescription("desc");
        service.insertPermissionGroup(pg);
        SysPermission p = new SysPermission();
        p.setName("test");
        p.setCode("code");
        p.setSysPermissionGroupId(pg.getId());
        service.insertPermission(p);
        assertTrue(service.isExistCodeExcludeId(pg.getId(), pg.getId(), "code"));
        assertTrue(!service.isExistCodeExcludeId(pg.getId(), pg.getId(), "code1"));
    }

    @Test
    public void selectPage() throws Exception {
        SysPermissionGroup pg = new SysPermissionGroup();
        pg.setName("test pg");
        pg.setDescription("desc");
        service.insertPermissionGroup(pg);
        for (int i = 0; i < 30; i++) {
            SysPermission p = new SysPermission();
            p.setName("test");
            p.setCode("code");
            p.setSysPermissionGroupId(pg.getId());
            service.insertPermission(p);
        }
        PageInfo pageInfo = service.selectPage(1, 30);
        assertTrue(pageInfo.getTotal() >= 30);
    }

    @Test
    public void isExistGroupName() throws Exception {
        SysPermissionGroup pg = new SysPermissionGroup();
        pg.setName("test pg");
        pg.setDescription("desc");
        service.insertPermissionGroup(pg);
        assertTrue(service.isExistGroupName("test pg"));
    }

    @Test
    public void insertPermissionGroup() throws Exception {
        SysPermissionGroup pg = new SysPermissionGroup();
        pg.setName("test pg");
        pg.setDescription("desc");
        service.insertPermissionGroup(pg);
        assertTrue(pg.getId() != null);
    }

    @Test
    public void selectGroup() throws Exception {
        SysPermissionGroup pg = new SysPermissionGroup();
        pg.setName("test pg");
        pg.setDescription("desc");
        service.insertPermissionGroup(pg);
        List<SysPermissionGroup> sysPermissionGroups = service.selectGroup();
        assertTrue(sysPermissionGroups.size() >= 1);
    }

}