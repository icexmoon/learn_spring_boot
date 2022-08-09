package cn.icexmoon.demo.books.user.service.impl;

import cn.icexmoon.demo.books.user.service.IUserRoleService;
import cn.icexmoon.demo.books.user.entity.Role;
import cn.icexmoon.demo.books.user.entity.User;
import cn.icexmoon.demo.books.user.mapper.UserMapper;
import cn.icexmoon.demo.books.user.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author icexmoon
 * @since 2022-05-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private IUserRoleService userRoleService;

    @Override
    public User getUserById(int uid) {
        User user = this.getById(Integer.valueOf(uid));
        if (user != null) {
            List<Role> roles = userRoleService.getRolesByUid(uid);
            user.getRoles().addAll(roles);
        }
        return user;
    }

    @Override
    public User getUserByName(String name) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("name", name);
        User user = this.getOne(qw);
        if (user != null) {
            List<Role> roles = userRoleService.getRolesByUid(user.getId());
            user.getRoles().addAll(roles);
        }
        return user;
    }
}
