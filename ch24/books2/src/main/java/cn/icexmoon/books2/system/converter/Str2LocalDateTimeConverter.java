package cn.icexmoon.books2.system.converter;

import cn.icexmoon.books2.system.util.MyTimeUtil;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.system.converter
 * @ClassName : .java
 * @createTime : 2023/5/16 12:46
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class Str2LocalDateTimeConverter implements Converter<String, LocalDateTime> {
    @Override
    public LocalDateTime convert(String source) {
        return MyTimeUtil.convert2DateTime(source);
    }
}
