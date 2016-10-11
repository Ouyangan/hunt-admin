package com.hunt.service.impl;

import com.hunt.dao.SysOrganizationMapper;
import com.hunt.model.entity.SysOrganization;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Author: ouyangan
 * @Date : 2016/10/11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring.xml")
public class SystemOrganizationServiceImplTest {
    @Autowired
    private SysOrganizationMapper sysOrganizationMapper;
    @Test
    public void insertOrganization() throws Exception {
        SysOrganization sysOrganization = new SysOrganization();
        sysOrganization.setName("深圳xx软件公司江西分公司");
        sysOrganization.setDescription("江西分公司");
        sysOrganization.setIsFinal(2);
        sysOrganization.setParentId(1L);
        sysOrganizationMapper.insert(sysOrganization);
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