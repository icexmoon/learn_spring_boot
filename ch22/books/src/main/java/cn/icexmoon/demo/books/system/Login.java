package cn.icexmoon.demo.books.system;

import cn.icexmoon.demo.books.system.result.IResult;
import cn.icexmoon.demo.books.system.result.Result;
import cn.icexmoon.demo.books.system.result.ResultException;
import cn.icexmoon.demo.books.system.shiro.WeChatToken;
import cn.icexmoon.demo.books.user.entity.User;
import cn.icexmoon.demo.books.user.service.IUserService;
import cn.icexmoon.demo.books.wechat.service.IWechatSupperAccessTokenService;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;


@Component
@Log4j2
public class Login {
    @Autowired
    private IUserService userService;
    @Autowired
    private IWechatSupperAccessTokenService wechatSupperAccessTokenService;

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
        try {
            subject.login(usernamePasswordToken);
        } catch (UnknownAccountException e) {
            throw new ResultException(Result.ErrorCode.LOGIN_ERROR, "账户不存在");
        } catch (AuthenticationException e) {
            throw new ResultException(Result.ErrorCode.LOGIN_ERROR, "账号或密码错误");
        } catch (AuthorizationException e) {
            throw new ResultException(Result.ErrorCode.DEFAULT_ERROR, "没有权限");
        }
        result.setData(subject.getSession().getId());
        return result;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class WeChatLoginInfo implements IResult {
        @ApiModelProperty("ccsp的访问令牌")
        private String token;
        @ApiModelProperty("微信openid")
        private String openId;
    }


    /**
     * 使用微信授权后的code登录系统并返回系统token
     *
     * @param code 微信授权后的code
     * @return
     */
    public WeChatLoginInfo weChatLogin(String code) {
        Subject subject = SecurityUtils.getSubject();
        if (subject.getPrincipal() != null) {
            String name = (String) subject.getPrincipal();
            User sysUser = userService.getUserByName(name);
            return new WeChatLoginInfo(subject.getSession().getId().toString(), sysUser.getOpenId());
        }
        IWechatSupperAccessTokenService.SuccessResp response = wechatSupperAccessTokenService.getAccessToken(code);
        String openid = response.getOpenid();
        subject.login(new WeChatToken(openid, response.getAccess_token()));
        log.info("session.timeout" + subject.getSession().getTimeout());
        return new WeChatLoginInfo(subject.getSession().getId().toString(), openid);
    }

    /**
     * 获取用户帐号
     * 如果没有获取到，抛出异常
     *
     * @return
     */
    public String mustGetUserName() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.getPrincipal() == null) {
            throw new ResultException(Result.ErrorCode.NEED_LOGIN, "当前操作需要登录");
        }
        String name = (String) subject.getPrincipal();
        if (name == null) {
            throw new ResultException(Result.ErrorCode.DEFAULT_ERROR, "用户名称不能为null");
        }
        return name;
    }
}
