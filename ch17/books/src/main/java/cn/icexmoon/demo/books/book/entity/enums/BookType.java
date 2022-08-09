package cn.icexmoon.demo.books.book.entity.enums;

import cn.icexmoon.demo.books.system.IDescEnum;
import cn.icexmoon.demo.books.system.swagger.SwaggerDisplayEnum;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books
 * @Package : cn.icexmoon.demo.books.book.entity.enums
 * @ClassName : .java
 * @createTime : 2022/8/3 16:55
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SwaggerDisplayEnum(index = "value", name = "desc")
public enum BookType implements IDescEnum<Integer> {
    ART(1, "艺术"), NOVEL(2, "小说"), SF(3, "科幻"), HISTORY(4, "历史"), OTHER(5, "其它");

    BookType(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @JsonValue
    private Integer value;
    private String desc;

    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
