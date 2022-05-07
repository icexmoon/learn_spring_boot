package cn.icexmoon.my_first_app.service;

import cn.icexmoon.my_first_app.mapper.UserMapper;
import cn.icexmoon.my_first_app.model.User;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceMPImpl extends ServiceImpl<UserMapper, User> implements UserServiceMP, UserServiceInterface {

    @Override
    @Transactional
    public void addSomeUsers(boolean broken) {
        final int SIZE = 3;
        for(int i=0;i<SIZE;i++){
            User user = new User();
            user.setAge(10);
            user.setName("test");
            this.addUser(user);
            if(i == SIZE-2){
                if (broken) {
                    throw new RuntimeException("someting broken the data save.");
                }
            }
        }
    }

    @Override
    public long addUser(User user) {
        this.save(user);
        return user.getId();
    }

    @Override
    public void deleteUser(long id) {
        this.removeById(Long.valueOf(id));
    }

    @Override
    public List<User> getUsers() {
        return this.list();
    }

    @Override
    public User getUser(long id) {
        return this.getById(Long.valueOf(id));
    }

    @Override
    public void updateUser(User user) {
        this.updateById(user);
    }
}
