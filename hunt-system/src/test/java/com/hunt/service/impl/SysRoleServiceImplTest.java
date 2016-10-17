package com.hunt.service.impl;

import com.google.gson.Gson;
import com.hunt.model.dto.PageInfo;
import com.hunt.model.entity.SysRole;
import com.hunt.service.SysRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import system.StringUtil;

/**
 * @Author: ouyangan
 * @Date : 2016/10/15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring.xml")
public class SysRoleServiceImplTest {
    @Autowired
    private SysRoleService sysRoleService;

    @Test
    public void isExsitRoleName() throws Exception {

    }

    @Test
    public void insertRole() throws Exception {
        for (int i = 0; i < 35; i++) {
            SysRole role = new SysRole();
            role.setName("角色-" + i);
            role.setDescription("角色描述-" + i);
//            sysRoleService.insertRole(role, permissionIds);
        }
    }

    @Test
    public void isExsitRoleNameExcludeId() throws Exception {

    }

    @Test
    public void selectById() throws Exception {

    }

    @Test
    public void selectPage() throws Exception {
        PageInfo pageInfo = sysRoleService.selectPage(1, 30);
        System.out.println(StringUtil.formatJson(new Gson().toJson(pageInfo)));
    }

    @Test
    public void updateRole() throws Exception {

    }

}