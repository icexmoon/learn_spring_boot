package cn.icexmoon.demo.books.user.service;

import cn.icexmoon.demo.books.user.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author icexmoon
 * @since 2022-05-06
 */
public interface IRoleService extends IService<Role> {
    Role getRoleById(int id);
}
