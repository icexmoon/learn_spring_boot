package com.example.validator;

import com.example.validator.system.converter.StringToPersonConverter;
import com.example.validator.system.pe.CustomPropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.Ordered;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : validator
 * @Package : com.example.validator
 * @ClassName : .java
 * @createTime : 2023/5/15 11:27
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Configuration
public class AppConfig {
    @Bean
    public CustomEditorConfigurer customEditorConfigurer(){
        CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();
//        Map<Class<?>, Class<? extends PropertyEditor>> editors = new HashMap<>();
//        editors.put(Dog.class, DogEditor.class);
//        editors.put(Person.class, PersonEditor.class);
//        customEditorConfigurer.setCustomEditors(editors);
        customEditorConfigurer.setPropertyEditorRegistrars(new PropertyEditorRegistrar[]{customPropertyEditorRegistrar()});
        customEditorConfigurer.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return customEditorConfigurer;
    }

    @Bean
    public CustomPropertyEditorRegistrar customPropertyEditorRegistrar(){
        return new CustomPropertyEditorRegistrar();
    }

//    @Bean
//    public ConfigurableWebBindingInitializer configurableWebBindingInitializer(ConversionService conversionService){
//        ConfigurableWebBindingInitializer configurableWebBindingInitializer = new ConfigurableWebBindingInitializer();
////        configurableWebBindingInitializer.setPropertyEditorRegistrar(customPropertyEditorRegistrar());
//        configurableWebBindingInitializer.setConversionService(conversionService);
//        return configurableWebBindingInitializer;
//    }

    @Bean
    public ConversionServiceFactoryBean conversionService(){
        ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
        HashSet<Object> converters = new HashSet<>();
        converters.add(new StringToPersonConverter());
        conversionServiceFactoryBean.setConverters(converters);
        return conversionServiceFactoryBean;
    }
}