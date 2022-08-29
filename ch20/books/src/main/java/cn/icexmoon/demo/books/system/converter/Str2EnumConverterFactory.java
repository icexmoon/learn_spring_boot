package cn.icexmoon.demo.books.system.converter;

import com.baomidou.mybatisplus.annotation.IEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books
 * @Package : cn.icexmoon.demo.books.system.converter
 * @ClassName : .java
 * @createTime : 2022/8/5 9:55
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description : Str2EnumConverter配套的工厂类
 */
public class Str2EnumConverterFactory<T extends Enum<?> & IEnum<Integer>> implements ConverterFactory<String, T> {

    @Override
    public <T1 extends T> Converter<String, T1> getConverter(Class<T1> targetType) {
        return new Str2EnumConverter<>(targetType);
    }
}
