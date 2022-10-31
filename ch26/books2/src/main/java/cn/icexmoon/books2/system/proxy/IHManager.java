package cn.icexmoon.books2.system.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.system.proxy
 * @ClassName : .java
 * @createTime : 2022/10/31 10:07
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class IHManager {
    public static InvocationHandler getAroundInvocationHandler(AbsAspect aspect){
        return new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return aspect.call(method, args);
            }
        };
    }

    public static InvocationHandler getBeforeInvocationHandler(Object subject, AbsAspect aspect){
        return new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                try{
                    aspect.call(method, args);
                }
                catch (Exception e){
                    return null;
                }
                return method.invoke(subject, args);
            }
        };
    }
}
