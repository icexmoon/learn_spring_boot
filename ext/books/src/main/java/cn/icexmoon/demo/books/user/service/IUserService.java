package cn.icexmoon.demo.books.user.service;

import cn.icexmoon.demo.books.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author icexmoon
 * @since 2022-05-06
 */
public interface IUserService extends IService<User> {
    User getUserById(int uid);

    User getUserByName(String name);

    User getUserByOpenId(String openId, boolean autoCreate, String accessToken);
}
