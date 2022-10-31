package cn.icexmoon.books2.system.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.system.proxy
 * @ClassName : .java
 * @createTime : 2022/10/31 10:20
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description : 动态代理的切面基类，负责实现具体的被代理后的逻辑
 */
abstract public class AbsAspect {
    protected final Object subject;

    /**
     * @param subject 被代理的原始对象
     */
    protected AbsAspect(Object subject) {
        this.subject = subject;
    }

    /**
     * 被代理后执行的调用
     *
     * @param method 调用方法
     * @param args 参数
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    abstract public Object call(Method method, Object[] args) throws InvocationTargetException, IllegalAccessException;
}
