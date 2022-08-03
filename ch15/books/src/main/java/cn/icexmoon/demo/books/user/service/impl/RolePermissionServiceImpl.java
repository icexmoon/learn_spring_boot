package cn.icexmoon.demo.books.user.service.impl;

import cn.icexmoon.demo.books.user.entity.Permission;
import cn.icexmoon.demo.books.user.entity.RolePermission;
import cn.icexmoon.demo.books.user.mapper.PermissionMapper;
import cn.icexmoon.demo.books.user.mapper.RolePermissionMapper;
import cn.icexmoon.demo.books.user.service.IRolePermissionService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements IRolePermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> getPermissionsByRoleId(int roleId) {
        List<Permission> permissions = new ArrayList<>();
        QueryWrapper<RolePermission> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id", roleId);
        List<RolePermission> rolePermissions = this.list(queryWrapper);
        for (RolePermission rolePerm :
                rolePermissions) {
            Permission permission = permissionMapper.selectById(rolePerm.getPermId());
            if (permission != null) {
                permissions.add(permission);
            }
        }
        return permissions;
    }
}
