package cn.icexmoon.books2.system;

import cn.icexmoon.books2.system.util.MyTimeUtil;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.system
 * @ClassName : .java
 * @createTime : 2022/10/27 9:06
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@JsonComponent
public class DateTimeJsonComponent {
    public static class Serializer extends JsonSerializer<LocalDateTime> {


        @Override
        public void serialize(LocalDateTime localDateTime, JsonGenerator jgen, SerializerProvider serializerProvider) throws IOException {
            jgen.writeString(MyTimeUtil.convert2timeStr(localDateTime));
        }
    }

    public static class Deserializer extends JsonDeserializer<LocalDateTime> {


        @Override
        public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
            return MyTimeUtil.convert2DateTime(jsonParser.getText());
        }
    }
}
