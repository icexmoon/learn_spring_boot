package cn.icexmoon.books2.system.aspect;

import cn.icexmoon.books2.system.util.MyLogUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.system.aspect
 * @ClassName : .java
 * @createTime : 2022/10/28 15:21
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Aspect
@Component
public class LoggingAspect {
    @Around("execution(public * cn.icexmoon.books2.*.controller.*.*(..))")
    public Object logRequest(ProceedingJoinPoint pjp) throws Throwable {
        String methodName = pjp.getSignature().getName();
        MyLogUtil.doLogging(String.format("before [%s] request", methodName));
        try {
            return pjp.proceed();
        } finally {
            MyLogUtil.doLogging(String.format("after [%s] request", methodName));
        }
    }
}
