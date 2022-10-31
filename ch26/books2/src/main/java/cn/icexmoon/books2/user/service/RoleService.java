package cn.icexmoon.books2.user.service;

import cn.icexmoon.books2.user.dto.RoleQueryDTO;
import cn.icexmoon.books2.user.entity.Role;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.user.service
 * @ClassName : .java
 * @createTime : 2022/10/8 14:29
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public interface RoleService {
    Role getRoleById(Integer id);

    List<Role> getAllRoles();

    List<Role> queryRoles(RoleQueryDTO dto);
}
