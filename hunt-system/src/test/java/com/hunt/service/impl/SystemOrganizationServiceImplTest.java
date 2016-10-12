package com.hunt.service.impl;

import com.hunt.dao.SysOrganizationMapper;
import com.hunt.model.entity.SysOrganization;
import com.hunt.service.SystemOrganizationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: ouyangan
 * @Date : 2016/10/11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring.xml")
//@Transactional
public class SystemOrganizationServiceImplTest {
    @Autowired
    private SysOrganizationMapper sysOrganizationMapper;

    @Autowired
    private SystemOrganizationService systemOrganizationService;

    @Test
    public void selectChildren() throws Exception {

    }

    @Test
    public void insertOrganization() throws Exception {
        SysOrganization sysOrganization = new SysOrganization();
        sysOrganization.setName("深圳xx软件公司");
        sysOrganization.setDescription("总部");
        sysOrganization.setIsFinal(2);
        sysOrganization.setParentId(0L);
        sysOrganizationMapper.insert(sysOrganization);
        System.out.println(sysOrganization);
        for (int i = 2; i < 20; i++) {
            SysOrganization sysOrganization1 = new SysOrganization();
            sysOrganization1.setName("深圳xx软件公司湖南分公司-" + i);
            sysOrganization1.setDescription("湖南分公司-" + i);
            sysOrganization1.setIsFinal(1);
            sysOrganization1.setParentId(1L);
            sysOrganizationMapper.insert(sysOrganization1);
            System.out.println(sysOrganization1);
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