package com.example.validator.system.formatter;

import com.example.validator.entity.Name;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : validator
 * @Package : com.example.validator.system.formatter
 * @ClassName : .java
 * @createTime : 2023/5/16 14:46
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class NameFormatter implements Formatter<Name> {

    @Override
    public Name parse(String text, Locale locale) throws ParseException {
        if (text == null || text.isEmpty()) {
            throw new ParseException("字符串不能为空", 0);
        }
        int spaceIndex = text.indexOf(" ");
        if (spaceIndex <= 0 || spaceIndex == text.length() - 1) {
            throw new ParseException("缺少空格作为分隔符", spaceIndex);
        }
        String firstName = text.substring(0, spaceIndex);
        String lastName = text.substring(spaceIndex + 1);
        if (!"zh".equals(locale.getLanguage())){
            //非中文地区，姓在前名在后
            String temp = firstName;
            firstName = lastName;
            lastName = temp;
        }
        return new Name(firstName, lastName);
    }

    @Override
    public String print(Name object, Locale locale) {
        if ("zh".equals(locale.getLanguage())){
            return "%s %s".formatted(object.getFirstName(), object.getLastName());
        }
        //非中文地区，名在前姓在后
        return "%s %s".formatted(object.getLastName(), object.getFirstName());
    }
}
