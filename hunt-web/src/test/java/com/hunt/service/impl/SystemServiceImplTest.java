package com.hunt.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.hunt.service.SystemService;

/**
 * @Author ouyangan
 * @Date 2016/10/28/21:26
 * @Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml"})
@Transactional
public class SystemServiceImplTest {
    @Autowired
    private SystemService service;

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

    }

    @Test
    public void insertSysControllerLog() throws Exception {

    }

    @Test
    public void insertSysDataGroup() throws Exception {

    }

    @Test
    public void isExistDataGroupName() throws Exception {

    }

    @Test
    public void selectDataGroupList() throws Exception {

    }

    @Test
    public void insertSysDataItem() throws Exception {

    }

    @Test
    public void isExistDataItemKeyName() throws Exception {

    }

    @Test
    public void deleteDataItemById() throws Exception {

    }

    @Test
    public void isExistDataItemNameExcludeId() throws Exception {

    }

    @Test
    public void selectDataItemPage() throws Exception {

    }

    @Test
    public void selectDataItemById() throws Exception {

    }

    @Test
    public void selectDataItemByKey() throws Exception {

        String s = service.selectDataItemByKey("geetest_id", 1L);
        String s1 = service.selectDataItemByKey("geetest_key", 1L);
        System.out.println(s);
        System.out.println(s1);
    }

    @Test
    public void updateDateItem() throws Exception {

    }

}