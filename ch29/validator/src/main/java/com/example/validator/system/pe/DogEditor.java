package com.example.validator.system.pe;

import com.example.validator.entity.Dog;

import java.beans.PropertyEditorSupport;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : validator
 * @Package : com.example.validator.pe
 * @ClassName : .java
 * @createTime : 2023/5/15 9:52
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class DogEditor extends PropertyEditorSupport {
    @Override
    public String getAsText() {
        Dog dog = (Dog) this.getValue();
        return super.getAsText();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(new Dog(text));
    }
}
