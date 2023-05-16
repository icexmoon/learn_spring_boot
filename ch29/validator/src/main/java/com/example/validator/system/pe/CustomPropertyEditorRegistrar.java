package com.example.validator.system.pe;

import com.example.validator.entity.Dog;
import com.example.validator.entity.Person;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : validator
 * @Package : com.example.validator
 * @ClassName : .java
 * @createTime : 2023/5/15 9:24
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {

    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(Person.class, new PersonEditor());
        registry.registerCustomEditor(Dog.class, new DogEditor());
    }
}
