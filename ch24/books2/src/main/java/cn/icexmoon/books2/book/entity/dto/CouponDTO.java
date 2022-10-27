package cn.icexmoon.books2.book.entity.dto;

import cn.icexmoon.books2.book.entity.enums.CouponType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.book.entity.dto
 * @ClassName : .java
 * @createTime : 2022/10/23 14:14
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Data
@Accessors(chain = true)
public class CouponDTO {
    private Integer addUserId;
    private Double amount;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime expireTime;
    private Double enoughAmount;
    private CouponType type;
}
