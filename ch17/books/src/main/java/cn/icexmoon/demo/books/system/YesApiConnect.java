package cn.icexmoon.demo.books.system;

import cn.icexmoon.demo.books.system.httpclient.HttpClientUtil;
import cn.icexmoon.demo.books.system.result.Result;
import cn.icexmoon.demo.books.system.result.ResultException;
import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books
 * @Package : cn.icexmoon.demo.books.system
 * @ClassName : .java
 * @createTime : 2022/8/3 13:55
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Component
public class YesApiConnect {
    @Autowired
    private SysProperties sysProperties;
    @Autowired
    private HttpClientUtil httpClientUtil;

    @Data
    private static class Response {
        private Integer ret;
        private String msg;
        private Long _t;
        private String _auth;
    }

    public String doGet(String path, Map<String, String> params, Map<String, String> headers) {
        if (params.get("app_key") == null) {
            params.put("app_key", sysProperties.getYesApiAppKey());
        }
        String url = String.format("http://%s/%s", sysProperties.getYesApiHost(), path);
        HttpClientUtil.Response res = httpClientUtil.doGet(url, params, headers);
        int statusCode = res.getHttpResponse().getStatusLine().getStatusCode();
        //这里仅接受返回为200的响应，如果需要处理重定向等其他响应，需要做相应处理
        if (statusCode != 200) {
            throw new ResultException(Result.ErrorCode.DEFAULT_ERROR, String.format("yesApi接口调用出错，返回状态码为%d", statusCode));
        }
        Response reponse = JSON.parseObject(res.getBody(), Response.class);
        if (reponse.getRet() != 200) {
            throw new ResultException(Result.ErrorCode.DEFAULT_ERROR, String.format("yesApi接口调用出错，响应业务码是%d", reponse.getRet()));
        }
        return res.getBody();
    }
}
