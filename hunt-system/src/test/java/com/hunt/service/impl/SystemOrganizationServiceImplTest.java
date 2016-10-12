package com.hunt.service.impl;

import com.google.gson.Gson;
import com.hunt.dao.SysOrganizationMapper;
import com.hunt.model.dto.SysOrganizationTree;
import com.hunt.model.entity.SysOrganization;
import com.hunt.service.SystemOrganizationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import system.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: ouyangan
 * @Date : 2016/10/11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring.xml")
@Transactional
public class SystemOrganizationServiceImplTest {
    private static Logger log = LoggerFactory.getLogger(SystemOrganizationServiceImplTest.class);
    int count = 0;
    @Autowired
    private SysOrganizationMapper sysOrganizationMapper;
    @Autowired
    private SystemOrganizationService systemOrganizationService;



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
        for (int i = 1; i < 20; i++) {
            SysOrganization sysOrganization1 = new SysOrganization();
            sysOrganization1.setName("湖南分公司研发部基础架构组-" + i);
            sysOrganization1.setDescription("湖南分公司研发部基础架构组-" + i);
            sysOrganization1.setIsFinal(1);
            sysOrganization1.setParentId(59L);
            sysOrganizationMapper.insert(sysOrganization1);
            System.out.println(sysOrganization1);
        }
        for (int i = 1; i < 20; i++) {
            SysOrganization sysOrganization1 = new SysOrganization();
            sysOrganization1.setName("江西分公司研发部基础架构组-" + i);
            sysOrganization1.setDescription("江西分公司研发部基础架构组-" + i);
            sysOrganization1.setIsFinal(1);
            sysOrganization1.setParentId(78L);
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