package cn.icexmoon.demo.books.wechat.controller;

import cn.icexmoon.demo.books.system.Login;
import cn.icexmoon.demo.books.system.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
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
 * @createTime : 2022/7/2 17:27
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@RestController
@RequestMapping("/wechat-login")
public class WechatLoginController {
    @Value("${cn.icexmoon.demo.books.host}")
    private String host;
    @Value("${cn.icexmoon.demo.books.appid}")
    private String appid;
    @Value("${cn.icexmoon.demo.books.secret}")
    private String secret;
    @Autowired
    private Login login;

    /**
     * 获取授权链接
     *
     * @return
     */
    @GetMapping("/auth-url")
    public String getAuthUrl() {
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
        String callback = "http://%s/wechat-login/callback";
        callback = String.format(callback, host);
        try {
            callback = URLEncoder.encode(callback, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return Result.error(e.getLocalizedMessage()).toString();
        }
        url = String.format(url, appid, callback);
        return Result.success(url).toString();
    }

    @GetMapping("/callback")
    public String callback(
            @RequestParam("code") String code,
            @RequestParam("state") String state
    ) {
        return Result.success().toString();
    }

    @PostMapping("/login/{code}")
    @ApiOperation("微信登录")
    public Result login(@NotBlank @PathVariable String code) {
        return login.weChatLogin(code);
    }
}
