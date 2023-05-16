package com.example.validator.system.converter;

import com.example.validator.entity.Person;
import com.example.validator.system.pe.PersonEditor;
import org.springframework.core.convert.converter.Converter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : validator
 * @Package : com.example.validator.converter
 * @ClassName : .java
 * @createTime : 2023/5/15 18:59
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class StringToPersonConverter implements Converter<String, Person> {

    @Override
    public Person convert(String source) {
        return PersonEditor.str2Person(source);
    }

}
