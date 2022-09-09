package cn.icexmoon.demo.books.system.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books
 * @Package : cn.icexmoon.demo.books.system.shiro
 * @ClassName : .java
 * @createTime : 2022/8/15 11:26
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
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
