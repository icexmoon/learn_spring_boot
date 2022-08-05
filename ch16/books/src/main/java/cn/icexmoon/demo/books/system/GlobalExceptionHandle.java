package cn.icexmoon.demo.books.system;

import cn.icexmoon.demo.books.system.result.Result;
import cn.icexmoon.demo.books.system.result.ResultException;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.ui.Model;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(ShiroException.class)
    public Result doHandleShiroException(ShiroException se, Model model) {
        se.printStackTrace();
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(Result.ErrorCode.LOGIN_ERROR);
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
        } else if (se instanceof AuthenticationException) {
            result.setMsg("密码不正确或帐号被锁定，请联系管理员");
        } else {
            result.setMsg("操作失败请重试");
        }
        return result;
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

    /**
     * 拦截参数校验异常
     *
     * @param exp
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Result doHandleResultException(ConstraintViolationException exp, Model model) {
        exp.printStackTrace();
        String msg = exp.getMessage();
        return Result.fail(Result.ErrorCode.PARAM_CHECK, msg);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result doHandleResultException(MissingServletRequestParameterException exp, Model model){
        exp.printStackTrace();
        String msg = exp.getMessage();
        return Result.fail(Result.ErrorCode.PARAM_CHECK, msg);
    }

    /**
     * 拦截参数验证产生的异常
     *
     * @param exp
     * @param model
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result doHandleCheckException(MethodArgumentNotValidException exp, Model model) {
        String msg = "请求参数出错";
        //如果存在错误信息，写入第一条错误的信息
        List<ObjectError> errors = exp.getAllErrors();
        System.out.println(exp.getLocalizedMessage());
        if (errors.size() > 0) {
            ObjectError error = errors.get(0);
            if (error != null) {
                //获取错误字段名
                String fieldName = "";
                Object[] args = error.getArguments();
                if (args != null && args.length > 0) {
                    Object arg = args[0];
                    if (arg instanceof DefaultMessageSourceResolvable) {
                        DefaultMessageSourceResolvable dmr = (DefaultMessageSourceResolvable) arg;
                        fieldName = dmr.getDefaultMessage();
                    }
                }
                msg = fieldName + error.getDefaultMessage();
            }
        }
        return Result.fail(Result.ErrorCode.PARAM_CHECK, msg);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Result doHandleCheckException(MethodArgumentTypeMismatchException exp, Model model) {
        exp.printStackTrace();
        String msg = exp.getMessage();
        return Result.fail(Result.ErrorCode.PARAM_CHECK, msg);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result doHandleCheckException(HttpMessageNotReadableException exp, Model model){
        exp.printStackTrace();
        String msg = exp.getMessage();
        return Result.fail(Result.ErrorCode.PARAM_CHECK, msg);
    }

    @ExceptionHandler(MissingPathVariableException.class)
    public Result doHandleCheckException(MissingPathVariableException exp, Model model){
        exp.printStackTrace();
        String msg = exp.getMessage();
        return Result.fail(Result.ErrorCode.PARAM_CHECK, msg);
    }
}

