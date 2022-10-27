package cn.icexmoon.books2.book.controller;

import cn.icexmoon.books2.book.entity.Coupon;
import cn.icexmoon.books2.book.entity.dto.CouponDTO;
import cn.icexmoon.books2.book.entity.enums.CouponType;
import cn.icexmoon.books2.book.service.CouponService;
import cn.icexmoon.books2.system.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.book.controller
 * @ClassName : .java
 * @createTime : 2022/10/11 16:40
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@RestController
@RequestMapping("/book/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;
    @GetMapping("/{id}")
    Coupon getCouponByid(@PathVariable int id){
        Coupon coupon = couponService.getCouponById(id);
        System.out.println(coupon.getClass());
        return coupon;
    }

    @PostMapping("/add")
    Result addCoupon(@RequestBody CouponDTO dto){
        return Result.success(couponService.addCoupon(dto));
    }

    @PostMapping("/params-add")
    Result addCouponWithParams(@RequestParam Integer addUserId,
                               @RequestParam Double amount,
                               @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                               @RequestParam LocalDateTime expireTime,
                               @RequestParam Double enoughAmount,
                               @RequestParam CouponType type){
        CouponDTO dto = new CouponDTO()
                .setAddUserId(addUserId)
                .setAmount(amount)
                .setExpireTime(expireTime)
                .setEnoughAmount(enoughAmount)
                .setType(type);
        return Result.success(couponService.addCoupon(dto));
    }
}
