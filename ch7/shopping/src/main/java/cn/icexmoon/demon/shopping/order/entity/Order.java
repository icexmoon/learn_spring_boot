package cn.icexmoon.demon.shopping.order.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author icexmoon
 * @since 2022-05-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userId;

    private BigDecimal total;

    private LocalDateTime addTime;


}
