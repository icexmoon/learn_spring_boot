package cn.icexmoon.demo.books.system;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(ShiroException.class)
    public String doHandleShiroException(ShiroException se, Model model) {
        se.printStackTrace();
        Result result = new Result();
        result.setSuccess(false);
        if (se instanceof UnknownAccountException) {
            result.setMsg("该账户不存在");
        } else if (se instanceof LockedAccountException) {
            result.setMsg("该账户已锁定");
        } else if (se instanceof IncorrectCredentialsException) {
            result.setMsg("密码错误请重试");
        } else if (se instanceof UnauthorizedException) {
            result.setMsg("当前角色不能操作");
        } else if (se instanceof AuthorizationException) {
            result.setMsg("没有相应权限");
        } else {
            result.setMsg("操作失败请重试");
        }
        return result.toString();
    }
}

