package com.hunt.model.dto;

import com.hunt.model.entity.SysUser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author ouyangan
 * @Date 2016/10/8/13:55
 * @Description
 */
public class LoginUserInfo implements Serializable {
    private SysUser user;

    private List<UserRoleOriganization> userRoleOriganizationList = new ArrayList<>();

    private int platform;

    @Override
    public String toString() {
        return "LoginUserInfo{" +
                "user=" + user +
                ", userRoleOriganizationList=" + userRoleOriganizationList +
                ", platform=" + platform +
                '}';
    }

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public List<UserRoleOriganization> getUserRoleOriganizationList() {
        return userRoleOriganizationList;
    }

    public void setUserRoleOriganizationList(List<UserRoleOriganization> userRoleOriganizationList) {
        this.userRoleOriganizationList = userRoleOriganizationList;
    }

    public int getPlatform() {
        return platform;
    }

    public void setPlatform(int platform) {
        this.platform = platform;
    }
}
