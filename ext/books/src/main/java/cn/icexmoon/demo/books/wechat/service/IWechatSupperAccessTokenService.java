package cn.icexmoon.demo.books.wechat.service;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ccsp-api
 * @Package : com.sjcx.ccsp.wechat.service
 * @ClassName : .java
 * @createTime : 2022/6/29 17:59
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description : 使用code获取公众号的（高级）access_token以及openID
 * 使用该access_token可以进一步获取用户信息（取决于授权时的scope）。
 */
public interface IWechatSupperAccessTokenService {
    @Data
    class SuccessResp {
        //网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
        private String access_token;
        //access_token接口调用凭证超时时间，单位（秒）
        private Integer expires_in;
        //用户刷新access_token
        private String refresh_token;
        //用户唯一标识，请注意，在未关注公众号时，用户访问公众号的网页，也会产生一个用户和公众号唯一的OpenID
        private String openid;
        //用户授权的作用域，使用逗号（,）分隔
        private String scope;
    }

    /**
     * 根据授权时获取的code获取access_token
     * @param code
     * @return
     */
    SuccessResp getAccessToken(String code);
}
