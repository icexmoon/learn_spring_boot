package cn.icexmoon.books2.book.entity.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.book.entity.enums
 * @ClassName : .java
 * @createTime : 2022/10/23 14:06
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public enum CouponType {
    FREE_COUPON(1, "无门槛券"), ENOUGH_COUPON(2, "满减券");
    @JsonValue
    private Integer value;
    private String desc;

    public Integer getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    CouponType(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static CouponType match(Integer value) {
        for (CouponType ct : CouponType.values()) {
            if (ct.getValue().equals(value)) {
                return ct;
            }
        }
        return null;
    }
}
