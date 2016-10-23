package com.hunt.service;

import com.hunt.model.dto.PageInfo;

/**
 * @Author: ouyangan
 * @Date : 2016/10/21
 */
public interface SystemService {
    void forceLogout(long userId);

    void clearAuthorizationInfoCacheByUserId(long userId);

    void clearAuthorizationInfoALL();

    void clearAuthorizationInfoByRoleId(long roleId);

    PageInfo selectLogStatus(int page, int rows);

    PageInfo selectLog(int page, int rows, String s, String order, String method, String url, String param, String result);

}
