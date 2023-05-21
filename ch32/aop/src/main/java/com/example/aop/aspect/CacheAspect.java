package com.example.aop.aspect;

import com.alibaba.fastjson2.JSON;
import com.example.aop.system.annotation.MethodCache;
import com.example.aop.system.util.MyStringUtil;
import jakarta.annotation.Resource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : aop
 * @Package : com.example.aop.aspect
 * @ClassName : .java
 * @createTime : 2023/5/21 12:29
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Component
@Aspect
public class CacheAspect {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Around("com.example.aop.aspect.CommonPointcuts.publicMethods() && @annotation(methodCacheAnnotation)")
    public Object anyPublicMethodsCalls(ProceedingJoinPoint pjp, MethodCache methodCacheAnnotation) throws Throwable {
        final String CACHE_PREFIX = "my.method.cache";
        String clsName = pjp.getTarget().getClass().getName();
        String methodName = pjp.getSignature().getName();
        Object[] args = pjp.getArgs();
        String callSignature = "%s.%s(%s)".formatted(clsName, methodName, JSON.toJSON(args));
        String redisKey = CACHE_PREFIX + "." + MyStringUtil.md5(callSignature);
        Object cachedResult = redisTemplate.opsForValue().get(redisKey);
        Object result;
        if (cachedResult != null) {
            result = cachedResult;
            return result;
        }
        result = pjp.proceed();
        redisTemplate.opsForValue().set(redisKey, result, methodCacheAnnotation.cacheLong(), methodCacheAnnotation.unit());
        return result;
    }
}
