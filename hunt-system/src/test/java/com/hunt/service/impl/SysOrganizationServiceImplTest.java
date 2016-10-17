package com.hunt.service.impl;

import com.hunt.dao.SysOrganizationMapper;
import com.hunt.model.entity.SysOrganization;
import com.hunt.service.SysOrganizationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class SysOrganizationServiceImplTest {
    private static Logger log = LoggerFactory.getLogger(SysOrganizationServiceImplTest.class);
    int count = 0;
    @Autowired
    private SysOrganizationMapper sysOrganizationMapper;
    @Autowired
    private SysOrganizationService sysOrganizationService;


    @Test
    public void selectChildren() throws Exception {

    }

    @Test
    public void insertOrganization() throws Exception {
//        SysOrganization sysOrganization = new SysOrganization();
//        sysOrganization.setName("深圳xx软件公司");
//        sysOrganization.setDescription("总部");
//        sysOrganization.setIsFinal(2);
//        sysOrganization.setParentId(0L);
//        sysOrganizationMapper.insert(sysOrganization);
//        System.out.println(sysOrganization);
        for (int i = 1; i < 2; i++) {
            SysOrganization sysOrganization1 = new SysOrganization();
            sysOrganization1.setName("应用开发组" + i);
            sysOrganization1.setFullName("XXXX信息技术有限公司湖南分公司研发部应用开发组" + i);
            sysOrganization1.setDescription("XXXX信息技术有限公司湖南分公司研发部应用开发组" + i);
            sysOrganization1.setIsFinal(1);
            sysOrganization1.setParentId(187L);
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