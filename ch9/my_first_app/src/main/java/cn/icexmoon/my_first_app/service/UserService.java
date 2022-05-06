package cn.icexmoon.my_first_app.service;

import cn.icexmoon.my_first_app.mapper.UserMapper;
import cn.icexmoon.my_first_app.model.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy(false)
public class UserService implements UserServiceInterface {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void addSomeUsers(boolean broken) {

    }

    public long addUser(User user) {
        userMapper.insert(user);
        return user.getId();
    }

    public void deleteUser(long id) {

        userMapper.deleteById(Long.valueOf(id));
    }

    public List<User> getUsers() {
        return userMapper.selectList(null);
    }

    public User getUser(long id) {
        return userMapper.selectById(Long.valueOf(id));
    }

    public void updateUser(User user) {
        userMapper.updateById(user);
    }

}
