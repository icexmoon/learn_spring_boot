package cn.icexmoon.demo.books.user.controller;


import cn.icexmoon.demo.books.system.Login;
import cn.icexmoon.demo.books.system.result.IResult;
import cn.icexmoon.demo.books.user.entity.User;
import cn.icexmoon.demo.books.user.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author icexmoon
 * @since 2022-05-06
 */
@RestController
@RequestMapping("/user/user")
@Api(tags = "用户管理")
public class UserController {
    @Autowired
    private Login login;
    @Autowired
    private IUserService userService;

    @Data
    @AllArgsConstructor
    private static class GetUserInfoVO implements IResult {
        private Integer id;
        private String name;
        private String realName;
        private String icon;

        public static GetUserInfoVO newInstance(User user) {
            return new GetUserInfoVO(user.getId(), user.getName(), user.getRealName(), user.getIcon());
        }
    }

    @GetMapping("/info")
    @ApiOperation("获取当前用户信息")
    public GetUserInfoVO getUserInfo() {
        User user = userService.getUserByName(login.mustGetUserName());
        return GetUserInfoVO.newInstance(user);
    }
}
