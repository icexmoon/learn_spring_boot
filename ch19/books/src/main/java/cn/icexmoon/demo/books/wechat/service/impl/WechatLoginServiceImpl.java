package cn.icexmoon.demo.books.wechat.service.impl;

import cn.icexmoon.demo.books.system.SysProperties;
import cn.icexmoon.demo.books.system.httpclient.HttpClientUtil;
import cn.icexmoon.demo.books.system.result.Result;
import cn.icexmoon.demo.books.system.result.ResultException;
import cn.icexmoon.demo.books.wechat.entity.WechatErrorResp;
import cn.icexmoon.demo.books.wechat.service.IWechatAccessTokenService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books
 * @Package : cn.icexmoon.demo.books.wechat.service.impl
 * @ClassName : .java
 * @createTime : 2022/8/15 11:34
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Service
public class WechatLoginServiceImpl implements IWechatAccessTokenService {
    @Autowired
    private HttpClientUtil httpClientUtil;
    @Autowired
    private SysProperties sysProperties;

    @Override
    public SuccessResp getAccessToken() {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
        url = String.format(url, sysProperties.getWxAppid(), sysProperties.getWxSecret());
        HttpClientUtil.Response response = httpClientUtil.doGet(url);
        //先尝试用错误结构解析
        WechatErrorResp errorResp = JSON.parseObject(response.getBody(), WechatErrorResp.class);
        if (errorResp.getErrcode() != null && errorResp.getErrcode() != 0) {
            //报错
            String errorMsg = errorResp.getErrmsg() != null ? errorResp.getErrmsg() : "";
            throw new ResultException(Result.ErrorCode.NETWORK_ERROR, String.format("获取公众号的access_token失败，错误信息为：%s", errorMsg));
        }
        //成功
        SuccessResp successResp = JSON.parseObject(response.getBody(), SuccessResp.class);
        return successResp;
    }
}
