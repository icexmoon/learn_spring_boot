package cn.icexmoon.demo.books.system;

import cn.icexmoon.demo.books.system.result.Result;
import cn.icexmoon.demo.books.system.result.ResultException;
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
            throw new ResultException(Result.ErrorCode.LOGIN_ERROR, "用户名或密码为空。");
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
            throw new ResultException(Result.ErrorCode.LOGIN_ERROR, "账户不存在");
        }
        catch (AuthenticationException e){
            throw new ResultException(Result.ErrorCode.LOGIN_ERROR, "账号或密码错误");
        }
        catch (AuthorizationException e){
            throw new ResultException(Result.ErrorCode.DEFAULT_ERROR, "没有权限");
        }
        result.setData(subject.getSession().getId());
        return result;
    }
}
