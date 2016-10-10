package com.hunt.system.sercurity;

import com.hunt.model.entity.SysUser;
import com.hunt.service.SysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: ouyangan
 * @Date : 2016/10/7
 */
public class shiroRealm extends AuthorizingRealm {
    @Autowired
    private SysUserService sysUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String loginName = (String) authenticationToken.getPrincipal();
        SysUser sysUser = sysUserService.selectUserByLoginName(loginName);
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(loginName, sysUser.getPassword(), ByteSource.Util.bytes(sysUser.getPasswordSalt()), getName());
        return authenticationInfo;
    }
}
