package com.hunt.system.security.shiro;

import com.hunt.dao.*;
import com.hunt.model.entity.*;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: ouyangan
 * @Date : 2016/10/7
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private SysUserPermissionMapper sysUserPermissionMapper;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysPermissionMapper sysPermissionMapper;
    @Autowired
    private SysUserRoleOrganizationMapper sysUserRoleOrganizationMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysRoleOrganizationMapper sysRoleOrganizationMapper;
    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    /**
     * 鉴权信息
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        String loginStr = (String) principalCollection.getPrimaryPrincipal();
        SysUser user = sysUserMapper.selectUserByLoginName(loginStr);
        List<SysUserPermission> userPermissions = sysUserPermissionMapper.selectByUserId(user.getId());
        Set<String> permissions = new HashSet<>();
        Set<String> roles = new HashSet<>();
        for (SysUserPermission userPermission : userPermissions) {
            SysPermission sysPermission = sysPermissionMapper.selectById(userPermission.getSysPermissionId());
            permissions.add(sysPermission.getCode());
        }
        List<SysUserRoleOrganization> userRoleOrganizations = sysUserRoleOrganizationMapper.selectByUserId(user.getId());
        for (SysUserRoleOrganization sysUserRoleOrganization : userRoleOrganizations) {
            SysRoleOrganization sysRoleOrganization = sysRoleOrganizationMapper.selectById(sysUserRoleOrganization.getSysRoleOrganizationId());
            SysRole sysRole = sysRoleMapper.selectById(sysRoleOrganization.getSysRoleId());
            roles.add(sysRole.getName());
            List<SysRolePermission> sysRolePermissions = sysRolePermissionMapper.selectByRoleId(sysRole.getId());
            for (SysRolePermission sysRolePermission : sysRolePermissions) {
                SysPermission sysPermission = sysPermissionMapper.selectById(sysRolePermission.getSysPermissionId());
                permissions.add(sysPermission.getCode());
            }
        }
        info.addRoles(roles);
        info.addStringPermissions(permissions);
        return info;
    }

    /**
     * 登录验证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String loginName = (String) authenticationToken.getPrincipal();
        SysUser sysUser = sysUserMapper.selectUserByLoginName(loginName);
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(loginName, sysUser.getPassword(), ByteSource.Util.bytes(sysUser.getPasswordSalt()), getName());
        return authenticationInfo;
    }
}
