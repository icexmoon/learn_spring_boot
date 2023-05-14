package cn.icexmoon.demo.books.system;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.handlers.AbstractJsonTypeHandler;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books
 * @Package : cn.icexmoon.demo.books.system
 * @ClassName : .java
 * @createTime : 2022/8/8 16:43
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class MyJsonTypeHandler<T> extends AbstractJsonTypeHandler<T> {
    private Class<T> cls;

    public MyJsonTypeHandler(Class<T> cls) {
        this.cls = cls;
    }

    @Override
    protected T parse(String json) {
        return JSON.parseObject(json, cls);
    }

    @Override
    protected String toJson(T obj) {
        return JSON.toJSONString(obj);
    }
}
