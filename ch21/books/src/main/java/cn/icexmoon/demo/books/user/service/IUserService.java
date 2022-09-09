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

    /**
     * 获取用户
     * 如果不存在，创建
     *
     * @param openId      微信openId
     * @param accessToken 用于获取用户信息的accessToken
     * @return
     */
    User getUserByOpenId(String openId, String accessToken);
}
