package com.hunt.service.impl;

import com.hunt.model.entity.SysRoleOrganization;
import com.hunt.service.SysRoleOrganizationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.ws.WebFault;

import static org.junit.Assert.*;

/**
 * @Author: ouyangan
 * @Date : 2016/10/17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring.xml")
//@Transactional
public class SysRoleOrganizationServiceImplTest {
    @Autowired
    private SysRoleOrganizationService service;

    @Test
    public void isExistName() throws Exception {

    }

    @Test
    public void insertRoleOrganization() throws Exception {
        SysRoleOrganization roleOrganization = new SysRoleOrganization();
        roleOrganization.setName("董事长");
        roleOrganization.setDescription("深圳xxx科技有限公司董事长");
        roleOrganization.setFullName("深圳xxx科技有限公司董事长");
        roleOrganization.setParentId(0L);
        roleOrganization.setSysRoleId(77L);
        roleOrganization.setSysOrganizationId(1L);
        roleOrganization.setIsFinal(2);
        service.insertRoleOrganization(roleOrganization);

        SysRoleOrganization roleOrganization1 = new SysRoleOrganization();
        roleOrganization1.setName("总经理");
        roleOrganization1.setDescription("深圳xxx科技有限公司总经理");
        roleOrganization1.setFullName("深圳xxx科技有限公司总经理");
        roleOrganization1.setParentId(roleOrganization.getId());
        roleOrganization1.setSysRoleId(77L);
        roleOrganization1.setSysOrganizationId(1L);
        roleOrganization1.setIsFinal(2);
        service.insertRoleOrganization(roleOrganization1);

        for (int i = 1; i < 11; i++) {
            SysRoleOrganization roleOrganization2 = new SysRoleOrganization();
            roleOrganization2.setName("经理-" + i);
            roleOrganization2.setDescription("深圳xxx科技有限公司经理-" + i);
            roleOrganization2.setFullName("深圳xxx科技有限公司经理-" + i);
            roleOrganization2.setParentId(roleOrganization1.getId());
            roleOrganization2.setSysRoleId(77L);
            roleOrganization2.setSysOrganizationId(182L);
            roleOrganization2.setIsFinal(2);
            service.insertRoleOrganization(roleOrganization2);
        }

    }

    @Test
    public void isExistNameExcludeId() throws Exception {

    }

    @Test
    public void updateRoleOrganization() throws Exception {

    }

    @Test
    public void selectRoleOrganizationById() throws Exception {

    }

    @Test
    public void selectPage() throws Exception {

    }

    @Test
    public void selectSysRoleOrganizationTree() throws Exception {

    }

    @Test
    public void selectSysRoleOrganizationTreeChildrenList() throws Exception {

    }

}