package cn.icexmoon.demo.books.wechat.service.impl;

import cn.icexmoon.demo.books.system.httpclient.HttpClientUtil;
import cn.icexmoon.demo.books.system.util.WechatUtil;
import cn.icexmoon.demo.books.wechat.service.IWechatUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ccsp-api
 * @Package : com.sjcx.ccsp.wechat.service.impl
 * @ClassName : .java
 * @createTime : 2022/7/1 17:11
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Service
public class WechatUserInfoServiceImpl implements IWechatUserInfoService {
    @Autowired
    private HttpClientUtil httpClientUtil;

    @Override
    public Response getUserInfo(String accessToken, String openId) {
        String url = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN";
        url = String.format(url, accessToken, openId);
        HttpClientUtil.Response response = httpClientUtil.doGet(url);
        return WechatUtil.mustParseResponse(response, Response.class);
    }
}
