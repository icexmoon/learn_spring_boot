package cn.icexmoon.demo.books.system.swagger;

import cn.icexmoon.demo.books.system.container.TwoTuple;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import springfox.documentation.builders.ModelSpecificationBuilder;
import springfox.documentation.builders.PropertySpecificationBuilder;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.AllowableListValues;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.schema.ModelPropertyBuilderPlugin;
import springfox.documentation.spi.schema.contexts.ModelPropertyContext;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books
 * @Package : cn.icexmoon.demo.books.system.swagger
 * @ClassName : .java
 * @createTime : 2022/8/4 14:23
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Component
public class EnumModelPropertyBuilderPlugin implements ModelPropertyBuilderPlugin {
    @Override
    public void apply(ModelPropertyContext context) {
        Optional<BeanPropertyDefinition> optional = context.getBeanPropertyDefinition();
        if (!optional.isPresent()) {
            return;
        }

        final Class<?> fieldType = optional.get().getField().getRawType();
        addDescForEnum(context, fieldType);
    }

    @Override
    public boolean supports(DocumentationType documentationType) {
        return true;
    }

    private void addDescForEnum(ModelPropertyContext context, Class<?> fieldType) {
        if (Enum.class.isAssignableFrom(fieldType)) {
            SwaggerDisplayEnum annotation = AnnotationUtils.findAnnotation(fieldType, SwaggerDisplayEnum.class);
            if (annotation != null) {
                Object[] enumConstants = fieldType.getEnumConstants();
                List<TwoTuple<String>> enumKeyValues = EnumPluginUtils.getEnumKeyValues(enumConstants, annotation);
                List<String> displayValues = enumKeyValues.stream().map(tuple -> tuple.getFirst() + ":" + tuple.getSecond()).collect(Collectors.toList());
                List<String> availableValues = enumKeyValues.stream().map(tuple -> tuple.getFirst()).collect(Collectors.toList());
                PropertySpecificationBuilder specificationBuilder = context.getSpecificationBuilder();
                Field descField = ReflectionUtils.findField(specificationBuilder.getClass(), "description");
                descField.setAccessible(true);
                String joinText = null;
                try {
                    joinText = (String) descField.get(specificationBuilder);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                joinText = joinText + "(" + String.join("; ", displayValues) + ")";
                specificationBuilder.type(new ModelSpecificationBuilder().scalarModel(ScalarType.INTEGER).build());
                specificationBuilder.description(joinText);
                AllowableListValues allowableListValues = new AllowableListValues(availableValues, "Integer");
                specificationBuilder.enumerationFacet(builder -> builder.allowedValues(allowableListValues));
            }
        }

    }
}
