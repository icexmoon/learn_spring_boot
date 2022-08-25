package cn.icexmoon.demo.books.system.container;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books
 * @Package : cn.icexmoon.demo.books.system.container
 * @ClassName : .java
 * @createTime : 2022/8/4 14:11
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Getter
@AllArgsConstructor
public class TwoTuple<T> {
    T first;
    T second;
}
