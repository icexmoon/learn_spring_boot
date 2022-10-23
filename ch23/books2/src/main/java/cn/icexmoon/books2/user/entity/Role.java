package cn.icexmoon.books2.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.user.entity
 * @ClassName : .java
 * @createTime : 2022/10/8 11:00
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    private Integer id;
    private String name;
    private String cname;
    private Integer level;
    private Integer delFlag;
}
