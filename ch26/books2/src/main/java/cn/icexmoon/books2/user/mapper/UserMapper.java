package cn.icexmoon.books2.user.mapper;

import cn.icexmoon.books2.user.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.user.mapper
 * @ClassName : .java
 * @createTime : 2022/10/10 8:27
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public interface UserMapper {
    /**
     * 获取用户
     * @param id 用户id
     * @return
     */
    User getUserById(@Param("id") int id);

    /**
     * 获取全部用户
     * @return
     */
    List<User> getAllUsers();
}
