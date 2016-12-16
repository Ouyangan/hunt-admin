package com.hunt.service;

import com.hunt.model.dto.PageInfo;
import com.hunt.model.entity.SysDataGroup;
import com.hunt.model.entity.SysDataItem;
import com.hunt.model.entity.SysIpForbidden;
import com.hunt.model.entity.SysLog;

import java.util.List;

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

    void insertSysControllerLog(SysLog runningLog);

    Long insertSysDataGroup(SysDataGroup sysDataGroup);

    boolean isExistDataGroupName(String name);

    List<SysDataGroup> selectDataGroupList();

    long insertSysDataItem(SysDataItem sysDataItem);

    boolean isExistDataItemKeyName(String key, long groupId);

    void deleteDataItemById(Long id);

    void updateDateItem(SysDataItem sysDataItem);

    boolean isExistDataItemNameExcludeId(Long id, String key, long groupId);

    PageInfo selectDataItemPage(int page, int rows);

    SysDataItem selectDataItemById(Long id);

    String selectDataItemByKey(String key, Long groupId);

    Long insertIp(SysIpForbidden sysIpForbidden);

    void deleteIp(long id);

    void updateIp(SysIpForbidden sysIpForbidden);

    PageInfo selectIp(int page, int rows);

    boolean isExistIp(String ip);

    boolean isExistIpExcludeId(String ip, long id);

    boolean isForbiddenIp(String remoteAddr);

    void openIpIntercept();

    void closeIpIntercept();

    boolean selectIPForbiddenStatus();
}
