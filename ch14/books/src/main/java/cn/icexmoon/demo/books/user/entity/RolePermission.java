package cn.icexmoon.demo.books.user.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author icexmoon
 * @since 2022-05-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RolePermission implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer roleId;

    private Integer permId;


}
