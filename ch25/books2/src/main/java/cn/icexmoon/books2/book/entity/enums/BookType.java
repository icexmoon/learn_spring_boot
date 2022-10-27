package cn.icexmoon.books2.book.entity.enums;

import cn.icexmoon.books2.system.IDesc;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.book.entity.enums
 * @ClassName : .java
 * @createTime : 2022/10/27 16:45
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public enum BookType implements IDesc<Integer> {
    ART(1, "艺术"),
    NOVEL(2, "小说"),
    SF(3, "科幻"),
    HIS(4, "历史"),
    OTHER(5, "其它");

    @JsonValue
    private Integer value;
    private String desc;

    BookType(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }


    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}
