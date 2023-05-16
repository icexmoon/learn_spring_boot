package com.example.validator.system.pe;

import com.example.validator.entity.Person;

import java.beans.PropertyEditorSupport;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : validator
 * @Package : com.example.validator
 * @ClassName : .java
 * @createTime : 2023/5/15 9:16
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class PersonEditor extends PropertyEditorSupport {
    @Override
    public String getAsText() {
        Person person = (Person) this.getValue();
        return "%s:%d".formatted(person.getName(), person.getAge());
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
//        if (text == null || text.isEmpty()) {
//            throw new IllegalArgumentException("字符串不能为空");
//        }
//        int index = text.indexOf(":");
//        if (index <= 0) {
//            throw new IllegalArgumentException("缺少:符号");
//        }
//        if (text.length() <= index + 1) {
//            throw new IllegalArgumentException("缺少年龄信息");
//        }
//        String name = text.substring(0, index);
//        String ageText = text.substring(index + 1);
//        int age;
//        try {
//            age = Integer.parseInt(ageText);
//        } catch (NumberFormatException e) {
//            throw new IllegalArgumentException("年龄不是整数");
//        }
        setValue(str2Person(text));
    }

    public static Person str2Person(String text){
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("字符串不能为空");
        }
        int index = text.indexOf(":");
        if (index <= 0) {
            throw new IllegalArgumentException("缺少:符号");
        }
        if (text.length() <= index + 1) {
            throw new IllegalArgumentException("缺少年龄信息");
        }
        String name = text.substring(0, index);
        String ageText = text.substring(index + 1);
        int age;
        try {
            age = Integer.parseInt(ageText);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("年龄不是整数");
        }
        return new Person(name, age);
    }
}
