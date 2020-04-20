package com.my.blog.config;

import com.my.blog.entity.User;
import com.my.blog.service.IUserService;
import com.my.blog.util.PasswordUtil;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2020/4/20 13:58
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private IUserService iUserService;

    @Override
    public String getName() {
        return "MyRealm";
    }

    /**
     * 验证密码
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String password = String.valueOf((char[]) token.getCredentials());
        User user = iUserService.queryUserByName(username);
        if (user == null || !PasswordUtil.verify(password, user.getPassword())) {
            return null;
        }
        return new SimpleAuthenticationInfo(username, password, getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }
}
