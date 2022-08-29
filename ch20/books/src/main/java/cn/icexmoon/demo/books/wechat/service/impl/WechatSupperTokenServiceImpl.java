package cn.icexmoon.demo.books.wechat.service.impl;

import cn.icexmoon.demo.books.system.SysProperties;
import cn.icexmoon.demo.books.system.httpclient.HttpClientUtil;
import cn.icexmoon.demo.books.system.result.Result;
import cn.icexmoon.demo.books.system.result.ResultException;
import cn.icexmoon.demo.books.wechat.entity.WechatErrorResp;
import cn.icexmoon.demo.books.wechat.service.IWechatSupperAccessTokenService;
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
 * @createTime : 2022/8/15 11:36
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Service
public class WechatSupperTokenServiceImpl implements IWechatSupperAccessTokenService {
    @Autowired
    private HttpClientUtil httpClientUtil;
    @Autowired
    private SysProperties sysProperties;

    @Override
    public SuccessResp getAccessToken(String code) {
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
        url = String.format(url, sysProperties.getWxAppid(), sysProperties.getWxSecret(), code);
        HttpClientUtil.Response response = httpClientUtil.doGet(url);
        WechatErrorResp wechatErrorResp = JSON.parseObject(response.getBody(), WechatErrorResp.class);
        if (wechatErrorResp.getErrcode() != null && wechatErrorResp.getErrcode() != 0) {
            String errorMsg = wechatErrorResp.getErrmsg() != null ? wechatErrorResp.getErrmsg() : "";
            throw new ResultException(Result.ErrorCode.NETWORK_ERROR, errorMsg);
        }
        SuccessResp SuccessResp = JSON.parseObject(response.getBody(), IWechatSupperAccessTokenService.SuccessResp.class);
        return SuccessResp;
    }
}