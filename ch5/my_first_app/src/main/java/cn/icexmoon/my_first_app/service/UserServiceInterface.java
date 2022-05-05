package cn.icexmoon.my_first_app.service;

import cn.icexmoon.my_first_app.model.User;

import java.util.List;

public interface UserServiceInterface {
    long addUser(User user);
    void deleteUser(long id);
    List<User> getUsers();
    User getUser(long id);
    void updateUser(User user);
}
