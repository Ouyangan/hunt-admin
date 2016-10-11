package com.hunt.service.impl;

import com.hunt.dao.SysOrganizationMapper;
import com.hunt.model.entity.SysOrganization;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Author: ouyangan
 * @Date : 2016/10/11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring.xml")
@Transactional
public class SystemOrganizationServiceImplTest {
    @Autowired
    private SysOrganizationMapper sysOrganizationMapper;

    @Test
    public void insertOrganization() throws Exception {
        for (int i = 1; i < 2; i++) {
            SysOrganization sysOrganization = new SysOrganization();
            sysOrganization.setName("深圳xx软件公司湖南分公司-" + i);
            sysOrganization.setDescription("湖南分公司-" + i);
            sysOrganization.setIsFinal(1);
            sysOrganization.setParentId(1L);
            sysOrganizationMapper.insert(sysOrganization);
            System.out.println(sysOrganization);
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