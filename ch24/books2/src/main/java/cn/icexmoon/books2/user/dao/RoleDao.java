package cn.icexmoon.books2.user.dao;

import cn.icexmoon.books2.user.entity.Role;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.user.dao
 * @ClassName : .java
 * @createTime : 2022/10/8 14:20
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public interface RoleDao {
    Role getRoleById(Integer id);
}
