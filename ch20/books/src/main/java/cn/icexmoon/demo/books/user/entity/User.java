package cn.icexmoon.demo.books.user.entity;

import cn.icexmoon.demo.books.system.util.MyStringUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    private Integer delFlag;
    //姓名或昵称
    private String realName;
    //头像
    private String icon;

    public static User newInstance(String openId) {
        User sysUser = new User();
        Random random = new Random();
        String flag = Long.toString(System.currentTimeMillis()) + Integer.toString(random.nextInt(1000));
        sysUser.setName(MyStringUtil.md5(flag));
        sysUser.setPassword("");
        sysUser.setIcon("");
        sysUser.setRealName("");
        sysUser.setOpenId(openId);
        return sysUser;
    }
}
