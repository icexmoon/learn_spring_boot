package cn.icexmoon.books2.user.dto;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.user.dto
 * @ClassName : .java
 * @createTime : 2022/10/8 17:06
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description : 查询角色的dto
 */
@Data
public class RoleQueryDTO {
    private String name;
    private String cname;
    private Integer level;
}