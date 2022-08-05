package cn.icexmoon.demo.books.user.service.impl;

import cn.icexmoon.demo.books.user.entity.Role;
import cn.icexmoon.demo.books.user.mapper.RoleMapper;
import cn.icexmoon.demo.books.user.service.IRolePermissionService;
import cn.icexmoon.demo.books.user.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author icexmoon
 * @since 2022-05-06
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
    @Autowired
    private IRolePermissionService rolePermissionService;

//    @Autowired
//    private RoleMapper roleMapper;
    @Override
    public Role getRoleById(int id) {
        Role role = this.getById(Integer.valueOf(id));
//        Role role = roleMapper.selectById(Integer.valueOf(id));
        if (role != null) {
            role.getPermissions().addAll(rolePermissionService.getPermissionsByRoleId(id));
        }
        return role;
    }
}
