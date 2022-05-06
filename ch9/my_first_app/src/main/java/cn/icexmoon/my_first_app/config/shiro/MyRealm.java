package cn.icexmoon.my_first_app.config.shiro;

import cn.icexmoon.my_first_app.model.Account;
import cn.icexmoon.my_first_app.model.User;
import cn.icexmoon.my_first_app.service.AccountService;
import cn.icexmoon.my_first_app.service.AccountServiceImpl;
import cn.icexmoon.my_first_app.service.UserService;
import cn.icexmoon.my_first_app.service.UserServiceMPImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private AccountServiceImpl accountService;

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        Account account = accountService.getAcountByName(token.getUsername());
        if (account != null) {
            return new SimpleAuthenticationInfo(account, account.getPassword(), getName());
        }
        return null;
    }
}
