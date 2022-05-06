package cn.icexmoon.demo.books.user.service;

import cn.icexmoon.demo.books.user.entity.UserRole;
import cn.icexmoon.demo.books.user.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IUserRoleService extends IService<UserRole> {
    List<Role> getRolesByUid(int uid);
}
