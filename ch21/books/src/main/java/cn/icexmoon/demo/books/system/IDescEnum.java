package cn.icexmoon.demo.books.system;

import com.baomidou.mybatisplus.annotation.IEnum;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books
 * @Package : cn.icexmoon.demo.books.system
 * @ClassName : .java
 * @createTime : 2022/8/3 16:52
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public interface IDescEnum<T extends Serializable> extends IEnum<T> {
    String getDesc();
}
