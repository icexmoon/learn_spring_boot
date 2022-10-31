package cn.icexmoon.books2.system.proxy;

import cn.icexmoon.books2.book.service.BookService;
import cn.icexmoon.books2.book.service.impl.BookServiceImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.system.proxy
 * @ClassName : .java
 * @createTime : 2022/10/31 10:45
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class BookServiceProxy {
    public static BookService getBookServiceAroundProxy(BookService bookService) {
        return (BookService) Proxy.newProxyInstance(BookServiceImpl.class.getClassLoader(),
                new Class<?>[]{BookService.class},
                IHManager.getAroundInvocationHandler(new AbsAspect(bookService) {
                    @Override
                    public Object call(Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
                        System.out.println("before book service is called.");
                        try{
                            return method.invoke(subject, args);
                        }
                        finally {
                            System.out.println("after book service is called.");
                        }
                    }
                }));
    }
}
