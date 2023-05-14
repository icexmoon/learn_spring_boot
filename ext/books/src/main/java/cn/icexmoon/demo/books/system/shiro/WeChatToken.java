package cn.icexmoon.demo.books.system.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ccsp-api
 * @Package : com.sjcx.ccsp.system.shiro
 * @ClassName : .java
 * @createTime : 2022/7/1 10:50
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description : 微信登录用的shiro token
 */
public class WeChatToken implements AuthenticationToken {
    private String openId;
    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    @Override
    public Object getPrincipal() {
        return openId;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    public WeChatToken(String openId, String accessToken) {
        this.openId = openId;
        this.accessToken = accessToken;
    }
}
