package cn.icexmoon.books2.book.bo;

import cn.icexmoon.books2.book.entity.Coupon;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.book.bo
 * @ClassName : .java
 * @createTime : 2022/10/11 16:23
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description : 满减券
 */
@Data
@Accessors(chain = true)
public class EnoughCoupon extends Coupon {
    private Double enoughAmount;
}
