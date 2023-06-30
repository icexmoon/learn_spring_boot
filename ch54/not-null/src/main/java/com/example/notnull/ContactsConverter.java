package com.example.notnull;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.SneakyThrows;
import org.springframework.util.ObjectUtils;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : jpa-attr-converter
 * @Package : com.example.jpaattrconverter
 * @ClassName : .java
 * @createTime : 2023/6/30 13:43
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Converter
public class ContactsConverter implements AttributeConverter<Contacts, String> {

    @Override
    @SneakyThrows
    public String convertToDatabaseColumn(Contacts attribute) {
        ObjectMapper om = new ObjectMapper();
        return om.writeValueAsString(attribute);
    }

    @Override
    @SneakyThrows
    public Contacts convertToEntityAttribute(String dbData) {
        if (ObjectUtils.isEmpty(dbData)) {
            return null;
        }
        ObjectMapper om = new ObjectMapper();
        return om.readValue(dbData, Contacts.class);
    }
}
