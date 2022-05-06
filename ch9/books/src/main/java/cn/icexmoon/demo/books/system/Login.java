package cn.icexmoon.demo.books.system;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;


@Component
public class Login {
    /**
     * 根据用户名和密码检查身份并登录
     *
     * @param name
     * @param password
     * @return
     */
    public Result checkAndLogin(String name, String password) {
        Result result = new Result();
        if (ObjectUtils.isEmpty(name) || ObjectUtils.isEmpty(password)) {
            result.setSuccess(false);
            result.setMsg("用户名或密码为空。");
            return result;
        }
        //用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                name,
                password
        );
        try{
            subject.login(usernamePasswordToken);
        }
        catch (UnknownAccountException e){
            result.setSuccess(false);
            result.setMsg("账户不存在");
            return result;
        }
        catch (AuthenticationException e){
            result.setSuccess(false);
            result.setMsg("账号或密码错误");
            return result;
        }
        catch (AuthorizationException e){
            result.setSuccess(false);
            result.setMsg("没有权限");
            return result;
        }
        result.setData(subject.getSession().getId());
        return result;
    }
}
