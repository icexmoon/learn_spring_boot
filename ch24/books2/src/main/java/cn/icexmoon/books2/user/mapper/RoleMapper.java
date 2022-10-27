package cn.icexmoon.books2.user.mapper;

import cn.icexmoon.books2.user.dto.RoleQueryDTO;
import cn.icexmoon.books2.user.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.user.mapper
 * @ClassName : .java
 * @createTime : 2022/10/8 11:02
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public interface RoleMapper {
    @Select("SELECT * FROM `role`")
    List<Role> getAll();

    @Select("SELECT * FROM `role` WHERE id = #{id}")
    Role getRoleById(@Param("id") Integer id);

    List<Role> queryRoles(@Param("dto") RoleQueryDTO dto);
}
