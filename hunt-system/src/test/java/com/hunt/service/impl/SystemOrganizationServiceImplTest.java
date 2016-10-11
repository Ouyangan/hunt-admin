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
        sysOrganization.setCreateBy(0L);
        sysOrganization.setUpdateBy(0L);
        sysOrganization.setName("asfdaf");
        sysOrganization.setDescription("asdfwq");
        sysOrganization.setParentId(0L);
        sysOrganization.setIsFinal(2);
        sysOrganization.setCreateTime(new Date());
        sysOrganization.setUpdateTime(new Date());
        sysOrganization.setRank(0L);
        sysOrganization.setState(1);
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