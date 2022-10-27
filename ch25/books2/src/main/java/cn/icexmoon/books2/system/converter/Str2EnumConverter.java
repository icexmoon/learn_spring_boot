package cn.icexmoon.books2.system.converter;

import cn.icexmoon.books2.system.IDesc;
import org.springframework.core.convert.converter.Converter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.system
 * @ClassName : .java
 * @createTime : 2022/10/26 11:55
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class Str2EnumConverter<T extends Enum<?> & IDesc<Integer>> implements Converter<String, T> {
    Class<T> cls;

    Str2EnumConverter(Class<T> cls) {
        this.cls = cls;
    }

    @Override
    public T convert(String source) {
        T[] enumConstants = cls.getEnumConstants();
        Integer sourceVal = Integer.valueOf(source);
        for (T enumInstance : enumConstants) {
            if (sourceVal.equals(enumInstance.getValue())) {
                return enumInstance;
            }
        }
        return null;
    }
}
