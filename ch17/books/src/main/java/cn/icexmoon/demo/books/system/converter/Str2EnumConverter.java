package cn.icexmoon.demo.books.system.converter;

import com.baomidou.mybatisplus.annotation.IEnum;
import org.springframework.core.convert.converter.Converter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books
 * @Package : cn.icexmoon.demo.books.system.convert
 * @ClassName : .java
 * @createTime : 2022/8/5 9:39
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description : 将字符串转换为实现了IEnum接口的枚举类型的Converter
 */
public class Str2EnumConverter<T extends Enum<?> & IEnum<Integer>> implements Converter<String, T> {
    Class<T> cls;

    Str2EnumConverter(Class<T> cls) {
        this.cls = cls;
    }

    @Override
    public T convert(String source) {
        T[] enumConstants = cls.getEnumConstants();
        Integer sourceVal = Integer.valueOf(source);
        for (T enumInstance : enumConstants) {
            if (sourceVal.equals(enumInstance.getValue())){
                return enumInstance;
            }
        }
        return null;
    }
}
