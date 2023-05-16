package com.example.validator.system.converter;

import com.example.validator.entity.Name;
import com.example.validator.system.annotation.NameFormat;
import com.example.validator.system.formatter.NameFormatter;
import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : validator
 * @Package : com.example.validator.system.converter
 * @ClassName : .java
 * @createTime : 2023/5/16 15:33
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class NameFormatAnnotationFormatterFactory implements AnnotationFormatterFactory<NameFormat> {
    private static final Set<Class<?>> FIELD_TYPES = Set.of(Name.class);

    @Override
    public Set<Class<?>> getFieldTypes() {
        return FIELD_TYPES;
    }

    @Override
    public Printer<?> getPrinter(NameFormat annotation, Class<?> fieldType) {
        return new NameFormatter();
    }

    @Override
    public Parser<?> getParser(NameFormat annotation, Class<?> fieldType) {
        return new NameFormatter();
    }
}
