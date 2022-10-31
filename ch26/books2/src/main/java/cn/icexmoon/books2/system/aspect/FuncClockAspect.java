package cn.icexmoon.books2.system.aspect;

import cn.icexmoon.books2.system.annotation.FuncClock;
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
 * @createTime : 2022/10/28 16:13
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Aspect
@Component
public class FuncClockAspect {
    @Around("@annotation(funcClock)")
    public Object clockFunc(ProceedingJoinPoint pjp, FuncClock funcClock) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            return pjp.proceed();
        } finally {
            long timeLong = System.currentTimeMillis() - start;
            String methodName = pjp.getSignature().getName();
            String clsName = pjp.getThis().getClass().getName();
            System.out.println(String.format("%s.%s is executed in %d ms", clsName, methodName, timeLong));
        }
    }
}
