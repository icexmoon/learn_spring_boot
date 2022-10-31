package cn.icexmoon.books2.user.entity;

import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.user.entity
 * @ClassName : .java
 * @createTime : 2022/10/10 8:21
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private String openId;
    private String realName;
    private String icon;
    private Integer deptId;
    private Integer delFlag;
    private List<Role> roles;
}
