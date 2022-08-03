package cn.icexmoon.demo.books.system.httpclient;

import cn.icexmoon.demo.books.system.result.Result;
import cn.icexmoon.demo.books.system.result.ResultException;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books
 * @Package : cn.icexmoon.demo.books.system.httpclient
 * @ClassName : .java
 * @createTime : 2022/8/3 13:36
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Component
@Slf4j
public class HttpClientUtil {

    /**
     * Util工具类封装的返回值，除了原始的HttpResponse对象，还包含一个body作为响应报文体，
     * 因为返回的HttpResponse对象已经关闭，无法通过getEntity获取响应报文体
     */
    @Getter
    @AllArgsConstructor
    public static class Response {
        @ApiModelProperty("原始的apache HttpResponse对象")
        private HttpResponse httpResponse;
        @ApiModelProperty("响应报文内容")
        private String body;
        private long contentLength;
    }

    @Autowired
    private CloseableHttpClient httpClient;

    public Response doGet(String url, Map<String, String> param, Map<String, String> headers) {
        CloseableHttpResponse response = null;
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));
                }
            }
            builder.setCharset(Charset.forName("utf-8"));
            URI uri = builder.build();
            log.debug(uri.toString());

            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);
            if (headers != null && !headers.isEmpty()) {
                headers.forEach((name, value) -> httpGet.setHeader(name, value));
            }

            // 执行请求
            response = httpClient.execute(httpGet);
            Response utilResponse = new Response(response, EntityUtils.toString(response.getEntity()), response.getEntity().getContentLength());
            Header contentType = response.getFirstHeader("Content-Type");
            if (contentType != null && contentType.getValue().equals("image/jpeg")) {
                log.info("Http Client请求，GET url:[{}],参数:[{}],报文头:[{}],返回数据=[图片]", url, param, headers);;
            } else {
                log.info("Http Client请求，GET url:[{}],参数:[{}],报文头:[{}],返回数据=[{}]", url, param, headers, utilResponse.getBody());
            }
            return utilResponse;
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            log.error(sw.toString());
            String msg = String.format("http客户端调用出错，http method:GET，请求：%s。", url);
            log.error(msg);
            throw new ResultException(Result.ErrorCode.DEFAULT_ERROR, "http客户端调用出错");
        } finally {
            close(response);
        }
    }

    public Response doGet(String url) {
        return doGet(url, null, null);
    }

    public Response doPost(String url, Map<String, String> param, Map<String, String> headers) {
        CloseableHttpResponse response = null;
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建参数列表
            if (param != null) {
                List<NameValuePair> paramList = new ArrayList<>();
                for (String key : param.keySet()) {
                    paramList.add(new BasicNameValuePair(key, param.get(key)));
                }
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList, Charset.forName("UTF-8"));
                httpPost.setEntity(entity);
            }

            if (headers != null && !headers.isEmpty()) {
                headers.forEach((name, value) -> httpPost.setHeader(name, value));
            }

            // 执行http请求
            response = httpClient.execute(httpPost);
            Response utilResponse = new Response(response, EntityUtils.toString(response.getEntity()), response.getEntity().getContentLength());
            log.info("Http Client请求，POST url:[{}],参数:[{}],报文头:[{}],返回数据=[{}]", url, param, headers, utilResponse.getBody());
            return utilResponse;
        } catch (Exception e) {
            log.error("doPost url:" + url + " fail,cause :" + e.getMessage(), e);
            throw new ResultException(Result.ErrorCode.NETWORK_ERROR, String.format("HttpClient请求失败，原因：%s", e.getMessage()));
        } finally {
            close(response);
        }
    }


    private void close(CloseableHttpResponse response) {
        try {
            if (response != null) {
                response.close();
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    public Response doPost(String url) {
        return doPost(url, null, null);
    }

    public Response doPostJson(String url, String json) {
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建请求内容
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            Response utilResponse = new Response(response, EntityUtils.toString(response.getEntity()), response.getEntity().getContentLength());
            return utilResponse;
        } catch (Exception e) {
            log.error("doJson url:" + url + " fail,cause :" + e.getMessage(), e);
            throw new ResultException(Result.ErrorCode.NETWORK_ERROR, String.format("HttpClient请求失败，原因：%s", e.getMessage()));
        } finally {
            close(response);
        }
    }
}
