package cn.icexmoon.demo.books.system.util;

import cn.icexmoon.demo.books.system.httpclient.HttpClientUtil;
import cn.icexmoon.demo.books.wechat.entity.WechatErrorResp;
import com.alibaba.fastjson.JSON;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ccsp-api
 * @Package : com.sjcx.ccsp.system.util
 * @ClassName : .java
 * @createTime : 2022/7/1 17:22
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description : 微信相关工具类
 */
public class WechatUtil {
    /**
     * 解析微信接口响应报文
     *
     * @param body      响应报文体
     * @param targetCls 解析的目标类型的class
     * @param <T>       解析的目标类型
     * @return 如果返回的是报错信息，直接抛出异常，否则返回解析后的目标对象
     */
    public static <T> T mustParseResponse(String body, Class<T> targetCls) {
        WechatErrorResp.checkResponse(body);
        return JSON.parseObject(body, targetCls);
    }

    /**
     * 解析微信接口响应报文
     *
     * @param response  httpclient响应实体
     * @param targetCls 解析的目标类型class
     * @param <T>       解析的目标类型
     * @return 如果返回的是报错信息，直接抛出异常，否则返回解析后的目标对象
     */
    public static <T> T mustParseResponse(HttpClientUtil.Response response, Class<T> targetCls) {
        return mustParseResponse(response.getBody(), targetCls);
    }
}
