package cn.icexmoon.demo.books.user.service;

import cn.icexmoon.demo.books.user.entity.Permission;
import cn.icexmoon.demo.books.user.entity.RolePermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author icexmoon
 * @since 2022-05-06
 */
public interface IRolePermissionService extends IService<RolePermission> {
    List<Permission> getPermissionsByRoleId(int roleId);
}
