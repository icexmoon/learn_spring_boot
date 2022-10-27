package cn.icexmoon.books2.system.converter;

import cn.icexmoon.books2.system.IDesc;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.system
 * @ClassName : .java
 * @createTime : 2022/10/26 11:58
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class Str2EnumConverterFactory<T extends Enum<?> & IDesc<Integer>> implements ConverterFactory<String, T> {
    @Override
    public <T1 extends T> Converter<String, T1> getConverter(Class<T1> targetType) {
        return new Str2EnumConverter<>(targetType);
    }
}