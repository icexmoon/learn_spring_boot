package cn.icexmoon.demo.books.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String password;

    private String openId;

    @TableField(exist = false)
    private List<Role> roles = new ArrayList<Role>();

    /**
     * 使用微信的openId创建一个新的微信用户实例
     *
     * @param openId 微信openId
     * @return
     */
    public static User newInstance(String openId) {
        User sysUser = new User();
        sysUser.setName("微信用户");
        sysUser.setPassword("");
        return sysUser;
    }
}
