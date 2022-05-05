package cn.icexmoon.demon.shopping.item.entity;

import java.math.BigDecimal;
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
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private BigDecimal price;

    private Integer store;


}
