package cn.icexmoon.demo.books.wechat.service;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books
 * @Package : cn.icexmoon.demo.books.wechat.service
 * @ClassName : .java
 * @createTime : 2022/8/15 11:32
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description : 获取公众号的基础token
 */
public interface IWechatAccessTokenService {
    @Data
    class SuccessResp {
        //获取到的凭证
        private String access_token;
        //凭证有效时间，单位：秒
        private String expires_in;
    }

    /**
     * 获取公众号token
     *
     * @return
     */
    SuccessResp getAccessToken();
}
