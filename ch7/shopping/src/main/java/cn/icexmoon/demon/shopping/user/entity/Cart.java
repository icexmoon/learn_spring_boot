package cn.icexmoon.demon.shopping.user.entity;

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
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userId;

    private Integer itemId;

    private Integer num;


}
