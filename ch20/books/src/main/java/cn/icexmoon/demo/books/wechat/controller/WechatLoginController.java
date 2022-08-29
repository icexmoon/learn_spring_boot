package cn.icexmoon.demo.books.wechat.controller;

import cn.icexmoon.demo.books.system.Login;
import cn.icexmoon.demo.books.system.SysProperties;
import cn.icexmoon.demo.books.system.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books
 * @Package : cn.icexmoon.demo.books.wechat.controller
 * @ClassName : .java
 * @createTime : 2022/8/9 10:59
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@RestController
@RequestMapping("/wechat/wechat-login")
@Api(tags = "微信认证")
public class WechatLoginController {
    @Autowired
    SysProperties sysProperties;
    @Autowired
    Login login;

    @GetMapping("/auth-url")
    public Result getAuthUrl() {
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
        String callback = "http://%s/wechat/wechat-login/callback";
        callback = String.format(callback, sysProperties.getHost());
        try {
            callback = URLEncoder.encode(callback, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return Result.fail(Result.ErrorCode.DEFAULT_ERROR, e.getLocalizedMessage());
        }
        url = String.format(url, sysProperties.getWxAppid(), callback);
        return Result.success(url);
    }

    @GetMapping("/callback")
    public String callback(
            @RequestParam("code") String code,
            @RequestParam("state") String state
    ) {
        return Result.success().toString();
    }

    @ApiOperation("微信登录")
    @PostMapping("/login/{code}")
    public Result login(@ApiParam("用户授权后获取到的code") @PathVariable String code) {
        Login.WeChatLoginInfo info = login.weChatLogin(code);
        return Result.success(info.getToken());
    }
}
