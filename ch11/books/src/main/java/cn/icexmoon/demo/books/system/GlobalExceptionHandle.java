package cn.icexmoon.demo.books.system;

import cn.icexmoon.demo.books.system.result.Result;
import cn.icexmoon.demo.books.system.result.ResultException;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(ShiroException.class)
    public Result doHandleShiroException(ShiroException se, Model model) {
        se.printStackTrace();
        Result result = new Result();
        result.setSuccess(false);
        if (se instanceof UnknownAccountException) {
            throw new ResultException(Result.ErrorCode.LOGIN_ERROR, "该账户不存在");
        } else if (se instanceof LockedAccountException) {
            throw new ResultException(Result.ErrorCode.LOGIN_ERROR, "该账户已锁定");
        } else if (se instanceof IncorrectCredentialsException) {
            throw new ResultException(Result.ErrorCode.LOGIN_ERROR, "密码错误请重试");
        } else if (se instanceof UnauthorizedException) {
            throw new ResultException(Result.ErrorCode.DEFAULT_ERROR, "当前角色不能操作");
        } else if (se instanceof AuthorizationException) {
            throw new ResultException(Result.ErrorCode.DEFAULT_ERROR, "没有相应权限");
        } else {
            throw new ResultException(Result.ErrorCode.DEFAULT_ERROR, "没有相应权限");
        }
    }

    /**
     * 拦截并处理ResultException异常
     *
     * @param exp
     * @param model
     * @return
     */
    @ExceptionHandler(ResultException.class)
    public Result doHandleResultException(ResultException exp, Model model) {
        return Result.fail(exp);
    }
}

