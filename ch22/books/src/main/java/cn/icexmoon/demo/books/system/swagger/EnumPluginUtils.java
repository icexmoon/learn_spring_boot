package cn.icexmoon.demo.books.system.swagger;

import cn.icexmoon.demo.books.system.container.TwoTuple;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books
 * @Package : cn.icexmoon.demo.books.system.swagger
 * @ClassName : .java
 * @createTime : 2022/8/4 14:36
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class EnumPluginUtils {
    public static List<TwoTuple<String>> getEnumKeyValues(Object[] enumConstants, SwaggerDisplayEnum annotation){
        List<TwoTuple<String>> enumKeyValues = Arrays.stream(enumConstants).filter(Objects::nonNull).map(item -> {
            String keyAttrName = annotation.index();
            String valAttrName = annotation.name();
            Class<?> currentClass = item.getClass();
            Field indexField = ReflectionUtils.findField(currentClass, keyAttrName);
            ReflectionUtils.makeAccessible(indexField);
            Object value = ReflectionUtils.getField(indexField, item);
            Field descField = ReflectionUtils.findField(currentClass, valAttrName);
            ReflectionUtils.makeAccessible(descField);
            Object desc = ReflectionUtils.getField(descField, item);
            return new TwoTuple<>(value.toString(), desc.toString());

        }).collect(Collectors.toList());
        return enumKeyValues;
    }
}
