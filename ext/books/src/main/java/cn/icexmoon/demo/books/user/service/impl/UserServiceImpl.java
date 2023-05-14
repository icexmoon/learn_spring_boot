package cn.icexmoon.demo.books.user.service.impl;

import cn.icexmoon.demo.books.system.util.MyStringUtil;
import cn.icexmoon.demo.books.user.entity.Role;
import cn.icexmoon.demo.books.user.entity.User;
import cn.icexmoon.demo.books.user.entity.UserRole;
import cn.icexmoon.demo.books.user.mapper.UserMapper;
import cn.icexmoon.demo.books.user.service.IUserRoleService;
import cn.icexmoon.demo.books.user.service.IUserService;
import cn.icexmoon.demo.books.wechat.service.IWechatUserInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private IUserRoleService userRoleService;
    @Autowired
    private IWechatUserInfoService wechatUserInfoService;

    @Override
    public User getUserById(int uid) {
        User user = this.getById(Integer.valueOf(uid));
        if (user != null) {
            List<Role> roles = userRoleService.getRolesByUid(uid);
            user.getRoles().addAll(roles);
        }
        return user;
    }

    @Override
    public User getUserByName(String name) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("name", name);
        User user = this.getOne(qw);
        if (user != null) {
            List<Role> roles = userRoleService.getRolesByUid(user.getId());
            user.getRoles().addAll(roles);
        }
        return user;
    }

    @Override
    public User getUserByOpenId(String openId, boolean autoCreate, String accessToken) {

        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("weixin_id", openId);
        qw.last("LIMIT 1");
        User sysUser = this.getOne(qw);
        if (sysUser == null && autoCreate) {
            //系统中没有该微信用户，添加一个
            User newUser = User.newInstance(openId);
            //从微信获取昵称和头像
            IWechatUserInfoService.Response response = wechatUserInfoService.getUserInfo(accessToken, openId);
            newUser.setIcon(response.getHeadimgurl());
            String nickname = response.getNickname();
            nickname = MyStringUtil.convert2OtherEncoding(nickname, "ISO-8859-1", "UTF-8");
            newUser.setRealName(nickname);
            this.save(newUser);
//            //为新的微信用户添加访客角色
//            Role guestRole = roleService.getSpecialRole(Role.SpecialRole.GUEST);
//            UserRole ur = new UserRole();
//            ur.setUserId(newUser.getId());
//            ur.setRoleId(guestRole.getId());
//            userRoleService.addUserRole(ur);
            sysUser = newUser;
        }
        if (sysUser != null) {
            fillRoles(sysUser);
        }
        return sysUser;
    }
}
