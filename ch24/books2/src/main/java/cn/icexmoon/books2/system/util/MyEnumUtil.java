package cn.icexmoon.books2.system.util;

import cn.icexmoon.books2.system.IDesc;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.system.util
 * @ClassName : .java
 * @createTime : 2022/10/26 15:23
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class MyEnumUtil {
    /**
     * 匹配int值并返回对应的枚举实例（枚举类型要实现IEnum<Integer>接口）
     * @param cls 枚举类型的class对象
     * @param value 枚举类型的value值
     * @param <T> 具体的枚举类型
     * @return 匹配到的枚举值，如果没有匹配到，返回null
     */
    public static <T extends IDesc<Integer>> T getIEnumInstance(Class<T> cls, int value) {
        for (T instance : cls.getEnumConstants()) {
            if (instance.getValue() == value) {
                return instance;
            }
        }
        return null;
    }
}
