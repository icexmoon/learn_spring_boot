package cn.icexmoon.demo.books.user.service.impl;

import cn.icexmoon.demo.books.user.entity.Permission;
import cn.icexmoon.demo.books.user.mapper.PermissionMapper;
import cn.icexmoon.demo.books.user.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author icexmoon
 * @since 2022-05-06
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
