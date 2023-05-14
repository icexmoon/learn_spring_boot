package cn.icexmoon.demo.books.system.util;

import com.baomidou.mybatisplus.annotation.IEnum;

public class MyEnumUtil {
    /**
     * 匹配int值并返回对应的枚举实例（枚举类型要实现IEnum<Integer>接口）
     * @param cls 枚举类型的class对象
     * @param value 枚举类型的value值
     * @param <T> 具体的枚举类型
     * @return 匹配到的枚举值，如果没有匹配到，返回null
     */
    public static <T extends IEnum<Integer>> T getIEnumInstance(Class<T> cls, int value) {
        for (T instance : cls.getEnumConstants()) {
            if (instance.getValue() == value) {
                return instance;
            }
        }
        return null;
    }
}
