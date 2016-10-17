package com.hunt.service.impl;

import com.hunt.dao.SysOrganizationMapper;
import com.hunt.dao.SysRoleMapper;
import com.hunt.dao.SysUserMapper;
import com.hunt.model.entity.SysOrganization;
import com.hunt.model.entity.SysRole;
import com.hunt.model.entity.SysUser;
import com.hunt.model.entity.SysUserRoleOrganization;
import com.hunt.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import system.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author: ouyangan
 * @Date : 2016/10/7
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring.xml")
//@Transactional
public class SysUserServiceImplTest {
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysOrganizationMapper organizationMapper;

    @Autowired
    private SysRoleMapper roleMapper;
    @Autowired
    private SysUserMapper userMapper;

    @Test
    public void insertUser() throws Exception {
        SysUser sysUser = new SysUser();
        sysUser.setAddress("广东省,深圳市,南山区");
        sysUser.setBirth("2016-10-7 00:00");
        sysUser.setEmail("981017952@qq.com");
        sysUser.setPhone("18218933076");
        sysUser.setLoginName("an");
        sysUser.setSex(1);
        sysUser.setZhName("欧阳安");
        sysUser.setEnName("an.ouyang");
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        sysUser.setPasswordSalt(uuid);
        sysUser.setPassword(StringUtil.createPassword("ananan", uuid, 2));

        SysOrganization organization = new SysOrganization();
        organization.setName("总公司");
        organization.setParentId(0L);
        organization.setDescription("");
        Long i = organizationMapper.insert(organization);

        SysRole role = new SysRole();
        role.setName("超级管理员");
        role.setDescription("拥有系统全部操作权限");
        Long i1 = roleMapper.insert(role);

        SysUserRoleOrganization sysUserRoleOrganization = new SysUserRoleOrganization();
//        sysUserRoleOrganization.setSysOrganizationId(i);
//        sysUserRoleOrganization.setSysOrganizationId(i1);
        List<SysUserRoleOrganization> list = new ArrayList<>();
        list.add(sysUserRoleOrganization);
        long l = sysUserService.insertUser(sysUser, list);
        System.out.println(l);
    }

    @Test
    public void testDemo() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String password = StringUtil.createPassword("ananan", uuid, 2);
        System.out.println(uuid);
        System.out.println(password);
    }


}