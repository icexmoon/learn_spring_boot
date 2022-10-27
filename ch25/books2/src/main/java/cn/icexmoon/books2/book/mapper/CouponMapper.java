package cn.icexmoon.books2.book.mapper;

import cn.icexmoon.books2.book.entity.Coupon;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.book.mapper
 * @ClassName : .java
 * @createTime : 2022/10/11 16:27
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public interface CouponMapper {
    Coupon getCouponById(@Param("id") int id);

    void addCoupon(@Param("coupon") Coupon coupon);
}
