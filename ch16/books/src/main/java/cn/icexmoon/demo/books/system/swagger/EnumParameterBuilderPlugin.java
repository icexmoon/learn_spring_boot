package cn.icexmoon.demo.books.system.swagger;

import cn.icexmoon.demo.books.system.container.TwoTuple;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.AllowableListValues;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.ParameterBuilderPlugin;
import springfox.documentation.spi.service.contexts.ParameterContext;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books
 * @Package : cn.icexmoon.demo.books.system.swagger
 * @ClassName : .java
 * @createTime : 2022/8/4 11:30
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Component
public class EnumParameterBuilderPlugin implements ParameterBuilderPlugin {

    @Override
    public void apply(ParameterContext context) {
        Class<?> type = context.resolvedMethodParameter().getParameterType().getErasedType();
        if (Enum.class.isAssignableFrom(type)) {
            SwaggerDisplayEnum annotation = AnnotationUtils.findAnnotation(type, SwaggerDisplayEnum.class);
            if (annotation != null) {
                Object[] enumConstants = type.getEnumConstants();
                List<TwoTuple<String>> enumKeyValues = EnumPluginUtils.getEnumKeyValues(enumConstants, annotation);
                List<String> displayValues = enumKeyValues.stream().map(tuple -> tuple.getFirst()).collect(Collectors.toList());
                List<String> keyValues = enumKeyValues.stream().map(tuple -> tuple.getFirst() + ":" + tuple.getSecond()).collect(Collectors.toList());
                RequestParameterBuilder requestParameterBuilder = context.requestParameterBuilder();
                String description;
                try {
                    Field descField = RequestParameterBuilder.class.getDeclaredField("description");
                    descField.setAccessible(true);
                    description = descField.get(requestParameterBuilder) + "(" + String.join("; ", keyValues) + ")";
                } catch (IllegalAccessException | NoSuchFieldException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
                requestParameterBuilder.description(description);
                requestParameterBuilder.query(simpleParameterSpecificationBuilder -> simpleParameterSpecificationBuilder
                        .model(modelSpecificationBuilde -> modelSpecificationBuilde.scalarModel(ScalarType.INTEGER))
                        .enumerationFacet(enumerationElementFacetBuilder -> enumerationElementFacetBuilder.allowedValues(new AllowableListValues(displayValues, "Integer"))));
            }
        }
    }


    @Override
    public boolean supports(DocumentationType documentationType) {
        return true;
    }
}
