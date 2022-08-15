package cn.icexmoon.demo.books.system.shiro;

import cn.icexmoon.demo.books.user.entity.Permission;
import cn.icexmoon.demo.books.user.entity.Role;
import cn.icexmoon.demo.books.user.entity.User;
import cn.icexmoon.demo.books.user.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books
 * @Package : cn.icexmoon.demo.books.system.shiro
 * @ClassName : .java
 * @createTime : 2022/8/15 11:25
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class WechatRealm extends AuthorizingRealm {
    @Autowired
    private IUserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户名
        String name = (String) principalCollection.getPrimaryPrincipal();
        //查询用户名称
        User user = userService.getUserByName(name);
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (Role role : user.getRoles()) {
            //添加角色
            simpleAuthorizationInfo.addRole(role.getName());
            //添加权限
            for (Permission permission : role.getPermissions()) {
                simpleAuthorizationInfo.addStringPermission(permission.getName());
            }
        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        WeChatToken token = (WeChatToken) authenticationToken;
        User sysUser = userService.getUserByOpenId((String) token.getPrincipal(), token.getAccessToken());
        if (sysUser == null) {
            throw new AuthenticationException("用户不存在");
        } else {
            ;
        }
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(sysUser.getName(), null, this.getName());
        return authenticationInfo;
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token != null && token instanceof WeChatToken;
    }

    @Override
    protected void assertCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) throws AuthenticationException {
        ;
    }
}