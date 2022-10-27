package cn.icexmoon.books2.book.service.impl;

import cn.icexmoon.books2.book.bo.EnoughCoupon;
import cn.icexmoon.books2.book.bo.FreeCoupon;
import cn.icexmoon.books2.book.entity.Coupon;
import cn.icexmoon.books2.book.entity.dto.CouponDTO;
import cn.icexmoon.books2.book.mapper.CouponMapper;
import cn.icexmoon.books2.book.service.CouponService;
import cn.icexmoon.books2.system.util.MyTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.book.service.impl
 * @ClassName : .java
 * @createTime : 2022/10/11 16:38
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Service
public class CouponServiceImpl implements CouponService {
    @Autowired
    private CouponMapper couponMapper;

    @Override
    public Coupon getCouponById(int id) {
        return couponMapper.getCouponById(id);
    }

    @Override
    public int addCoupon(CouponDTO dto) {
        Coupon coupon;
        switch (dto.getType()) {
            case FREE_COUPON:
                coupon = new FreeCoupon();
                break;
            case ENOUGH_COUPON:
                coupon = new EnoughCoupon()
                        .setEnoughAmount(dto.getEnoughAmount());
                break;
            default:
                throw new RuntimeException("不正确的优惠券类型");
        }
        coupon.setAddTime(LocalDateTime.now())
                .setAddUserId(dto.getAddUserId())
                .setAmount(dto.getAmount())
                .setExpireTime(dto.getExpireTime())
                .setType(dto.getType());
        couponMapper.addCoupon(coupon);
        return coupon.getId();
    }
}
