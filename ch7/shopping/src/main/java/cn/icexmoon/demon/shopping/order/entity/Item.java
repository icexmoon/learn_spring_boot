package cn.icexmoon.demon.shopping.order.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("order_item")
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer orderId;

    private Integer itemId;

    private Integer num;

    private Integer price;


}
