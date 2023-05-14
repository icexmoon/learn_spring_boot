package cn.icexmoon.demo.books.wechat.entity;

import cn.icexmoon.demo.books.system.httpclient.HttpClientUtil;
import cn.icexmoon.demo.books.system.result.Result;
import cn.icexmoon.demo.books.system.result.ResultException;
import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books
 * @Package : cn.icexmoon.demo.books.wechat.entity
 * @ClassName : .java
 * @createTime : 2022/8/15 11:35
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Data
public class WechatErrorResp {
    //错误码，具体见 https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Get_access_token.html
    private Integer errcode;
    //错误说明
    private String errmsg;

    /**
     * 解析并检查微信接口的返回值，如果是报错信息，抛出异常
     *
     * @param body 接口返回的报文体
     */
    public static void checkResponse(String body) {
        WechatErrorResp wechatErrorResp = JSON.parseObject(body, WechatErrorResp.class);
        if (wechatErrorResp.getErrcode() != null && wechatErrorResp.getErrcode() != 0) {
            String errorMsg = wechatErrorResp.getErrmsg() != null ? wechatErrorResp.getErrmsg() : "";
            throw new ResultException(Result.ErrorCode.NETWORK_ERROR, errorMsg);
        }
    }

    /**
     * 解析并检查微信接口的返回值，如果是报错信息，抛出异常
     *
     * @param response HttpClientUtil返回的响应对象
     */
    public static void checkResponse(HttpClientUtil.Response response) {
        checkResponse(response.getBody());
    }
}
