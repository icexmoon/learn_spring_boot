package cn.icexmoon.books2.book.service;

import cn.icexmoon.books2.book.entity.Coupon;
import cn.icexmoon.books2.book.entity.dto.CouponDTO;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.book.service
 * @ClassName : .java
 * @createTime : 2022/10/11 16:38
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public interface CouponService {
    /**
     * 根据ID获取优惠券
     * @param id
     * @return
     */
    Coupon getCouponById(int id);

    int addCoupon(CouponDTO dto);
}
