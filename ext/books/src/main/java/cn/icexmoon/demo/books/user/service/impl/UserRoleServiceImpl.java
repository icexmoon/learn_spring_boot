package cn.icexmoon.demo.books.user.service.impl;

import cn.icexmoon.demo.books.user.entity.UserRole;
import cn.icexmoon.demo.books.user.mapper.UserRoleMapper;
import cn.icexmoon.demo.books.user.service.IUserRoleService;
import cn.icexmoon.demo.books.user.entity.Role;
import cn.icexmoon.demo.books.user.service.IRoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {
    @Autowired
    private IRoleService roleService;

    @Override
    public List<Role> getRolesByUid(int uid) {
        List<Role> roles = new ArrayList<>();
        QueryWrapper<UserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", uid);
        List<UserRole> userRoles = this.list(queryWrapper);
        for (UserRole userRole :
                userRoles) {
            Role role = roleService.getRoleById(userRole.getRoleId());
            if (role != null) {
                roles.add(role);
            }
        }
        return roles;
    }
}
