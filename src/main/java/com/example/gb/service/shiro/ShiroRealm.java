package com.example.gb.service.shiro;

import com.example.gb.model.po.Administrator;
import com.example.gb.service.AdministratorService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ShiroRealm extends AuthorizingRealm {
    //管理端
    private static final Set<String> administerRoles = new HashSet<>();
    private static final Set<String> administerPermission = new HashSet<>();
    //玩家端
    private static final Set<String> adminRoles = new HashSet<>();
    private static final Set<String> adminPermission = new HashSet<>();
    static{
        administerRoles.add("administer");
        administerPermission.add("administer");
        adminRoles.add("admin");
        adminPermission.add("admin");
    }
    private final AdministratorService administratorService;
    private final HashedCredentialsMatcher hashedCredentialsMatcher;

    @Autowired
    public ShiroRealm(AdministratorService administratorService, HashedCredentialsMatcher hashedCredentialsMatcher){
        this.administratorService = administratorService;
        this.hashedCredentialsMatcher = hashedCredentialsMatcher;
    }

    /**
     * 權限
     * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 登入驗證
     * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String account = (String) authenticationToken.getPrincipal();
        if (account == null) throw new UnknownAccountException("用戶名不能為空");
        Administrator administrator = administratorService.findByAccount(account);
        return new SimpleAuthenticationInfo(administrator.getAccount(), administrator.getPassword(), ByteSource.Util.bytes(administrator.getSalt()), getName());
    }
}
