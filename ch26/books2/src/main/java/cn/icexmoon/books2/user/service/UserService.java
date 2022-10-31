package cn.icexmoon.books2.user.service;

import cn.icexmoon.books2.user.entity.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.user.service
 * @ClassName : .java
 * @createTime : 2022/10/10 8:49
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public interface UserService {
    /**
     * 根据用户ID获取用户
     * @param id 用户ID
     * @return
     */
    User getUserById(int id);

    /**
     * 获取所有用户
     * @return
     */
    List<User> getAllUsers();
}
