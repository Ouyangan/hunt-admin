package com.hunt.service.impl;

import com.hunt.model.dto.PageInfo;
import com.hunt.service.SystemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * @Author ouyangan
 * @Date 2016/10/24/19:21
 * @Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring.xml")
@Transactional
public class SystemServiceImplTest {
    @Autowired
    private SystemService systemService;
    @Test
    public void forceLogout() throws Exception {

    }

    @Test
    public void clearAuthorizationInfoCacheByUserId() throws Exception {

    }

    @Test
    public void clearAuthorizationInfoALL() throws Exception {

    }

    @Test
    public void clearAuthorizationInfoByRoleId() throws Exception {

    }

    @Test
    public void selectLogStatus() throws Exception {

    }

    @Test
    public void selectLog() throws Exception {
        PageInfo pageInfo = systemService.selectLog(1, 20, "", "", "", "", "", "");
        System.out.println(pageInfo.getRows());
    }

    @Test
    public void insertSysControllerLog() throws Exception {

    }

}