package com.example.gb.service.shiro;

import com.example.gb.service.AdministratorService;
import com.example.gb.tool.EncodeTool;
import jakarta.annotation.PostConstruct;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {
    private final AdministratorService administratorService;
    private final HashedCredentialsMatcher hashedCredentialsMatcher;
    @Autowired
    public ShiroConfig(AdministratorService administratorService, HashedCredentialsMatcher hashedCredentialsMatcher) {
        this.administratorService = administratorService;
        this.hashedCredentialsMatcher = hashedCredentialsMatcher;
    }

    @PostConstruct
    public void init(){
        SecurityUtils.setSecurityManager(securityManager());
    }

    @Bean
    public DefaultSecurityManager securityManager(){
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(realm());
        return defaultSecurityManager;
    }
    @Bean
    public ShiroRealm realm(){
        ShiroRealm shiroRealm = new ShiroRealm(administratorService, hashedCredentialsMatcher);
        shiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return shiroRealm;
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(EncodeTool.md5Hash);
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        return hashedCredentialsMatcher;
    }
}
