package com.example.aop.aspect;

import com.example.aop.system.annotation.ThrowingRecall;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : aop
 * @Package : com.example.aop.aspect
 * @ClassName : .java
 * @createTime : 2023/5/21 10:13
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Aspect
@Component
public class RemoteConnectAspect {
    @Around("com.example.aop.aspect.CommonPointcuts.publicServiceMethods() && @annotation(recallAnnotation)")
    public Object remoteConnectRecall(ProceedingJoinPoint pjp, ThrowingRecall recallAnnotation) throws Throwable {
        final int MAX_RECALL_TIMES = recallAnnotation.Value();
        return this.methodRecallAfterThrowing(MAX_RECALL_TIMES, pjp);
    }

    private Object methodRecallAfterThrowing(final int MAX_RECALL_TIMES, ProceedingJoinPoint pjp) throws Throwable {
        int alreadyCallTimes = 0;
        Object result = null;
        while (true) {
            try {
                alreadyCallTimes++;
                result = pjp.proceed();
                break;
            } catch (Throwable e) {
                //尝试重新调用
                if (alreadyCallTimes - 1 >= MAX_RECALL_TIMES) {
                    //超过最大重试次数，抛出原始调用产生的异常
                    throw e;
                }
            }
        }
        return result;
    }
}
