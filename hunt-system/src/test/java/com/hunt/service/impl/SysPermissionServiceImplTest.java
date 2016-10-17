package com.hunt.service.impl;

import com.google.gson.Gson;
import com.hunt.model.dto.PageInfo;
import com.hunt.model.entity.SysPermission;
import com.hunt.model.entity.SysPermissionGroup;
import com.hunt.service.SysPermissionService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import system.StringUtil;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @Author: ouyangan
 * @Date : 2016/10/15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring.xml")
//@Transactional
public class SysPermissionServiceImplTest {
    private static Logger log = LoggerFactory.getLogger(SysPermissionServiceImplTest.class);
    @Autowired
    private SysPermissionService service;

    @Test
    public void isExistName() throws Exception {
        SysPermission permission = new SysPermission();
        permission.setCode("testCode");
        permission.setName("testName");
        permission.setDescription("testDescription");
        permission.setSysPermissionGroupId(1L);
        service.insertPermission(permission);
        log.info("permission : {}", permission);
        Assert.assertTrue(service.isExistName(1L, "testName"));
    }

    @Test
    public void isExistCode() throws Exception {
        SysPermission permission = new SysPermission();
        permission.setCode("testCode");
        permission.setName("testName");
        permission.setDescription("testDescription");
        permission.setSysPermissionGroupId(1L);
        service.insertPermission(permission);
        log.info("permission : {}", permission);
        Assert.assertTrue(service.isExistCode(1L, "testCode"));
    }

    @Test
    public void insertPermission() throws Exception {
        SysPermission permission = new SysPermission();
        permission.setCode("testCode");
        permission.setName("testName");
        permission.setDescription("testDescription");
        permission.setSysPermissionGroupId(1L);
        service.insertPermission(permission);
        log.info("permission : {}", permission);
        Assert.assertTrue(permission.getId() != null);
    }

    @Test
    public void selectById() throws Exception {
        SysPermission permission = new SysPermission();
        permission.setCode("testCode");
        permission.setName("testName");
        permission.setDescription("testDescription");
        permission.setSysPermissionGroupId(1L);
        service.insertPermission(permission);
        log.info("permission : {}", permission);
        SysPermission sysPermission = service.selectById(permission.getId());
        Assert.assertTrue(sysPermission != null);
    }

    @Test
    public void update() throws Exception {
        SysPermission permission = new SysPermission();
        permission.setCode("testCode");
        permission.setName("testName");
        permission.setDescription("testDescription");
        permission.setSysPermissionGroupId(1L);
        service.insertPermission(permission);
        log.info("permission : {}", permission);
        permission.setCode("testUpdateCode");
        service.update(permission);
        SysPermission sysPermission = service.selectById(permission.getId());
        assertTrue(sysPermission.getCode().equals("testUpdateCode"));
    }

    @Test
    public void isExistNameExcludeId() throws Exception {
        SysPermission permission = new SysPermission();
        permission.setCode("testCode");
        permission.setName("testName");
        permission.setDescription("testDescription");
        permission.setSysPermissionGroupId(1L);
        service.insertPermission(permission);
        log.info("permission : {}", permission);
        boolean testCode = service.isExistNameExcludeId(permission.getId(), 1L, "testCode");
        assertTrue(!testCode);
    }

    @Test
    public void isExistCodeExcludeId() throws Exception {
        SysPermission permission = new SysPermission();
        permission.setCode("testCode");
        permission.setName("testName");
        permission.setDescription("testDescription");
        permission.setSysPermissionGroupId(1L);
        service.insertPermission(permission);
        log.info("permission : {}", permission);
        boolean testCode = service.isExistCodeExcludeId(permission.getId(), 1L, "testCode");
        assertTrue(!testCode);
    }

    @Test
    public void isExistGroupName() throws Exception {

    }

    @Test
    public void selectPage() throws Exception {
        for (int i = 1; i < 6; i++) {
            SysPermissionGroup group = new SysPermissionGroup();
            group.setName("group-" + i);
            group.setDescription("group description-" + i);
            group.setParentId(0L);
            group.setIsFinal(2);
            long groupId = service.insertPermissionGroup(group);
            for (int j = 1; j < 11; j++) {
                SysPermission permission = new SysPermission();
                permission.setIsFinal(1);
                permission.setCode("group" + i + "code-" + j);
                permission.setName("group" + i + "-name-" + j);
                permission.setDescription("group" + i + "description-" + j);
                permission.setSysPermissionGroupId(group.getId());
                service.insertPermission(permission);
            }
        }
        PageInfo pageInfo = service.selectPage(1, 15);
        log.info("json string is : {}", StringUtil.formatJson(new Gson().toJson(pageInfo)));
    }

    @Test
    public void insertPermissionGroup() throws Exception {

    }

    @Test
    public void selectGroup() throws Exception {
        List<SysPermissionGroup> sysPermissionGroups = service.selectGroup();
        System.out.println(StringUtil.formatJson(new Gson().toJson(sysPermissionGroups)));
    }

}