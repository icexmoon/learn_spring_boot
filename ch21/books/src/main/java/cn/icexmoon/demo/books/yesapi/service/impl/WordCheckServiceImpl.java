package cn.icexmoon.demo.books.yesapi.service.impl;

import cn.icexmoon.demo.books.system.YesApiConnect;
import cn.icexmoon.demo.books.yesapi.service.IWordCheckService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books
 * @Package : cn.icexmoon.demo.books.yesapi.service.impl
 * @ClassName : .java
 * @createTime : 2022/8/3 13:49
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Service
public class WordCheckServiceImpl implements IWordCheckService {
    @Autowired
    private YesApiConnect yesApiConnect;

    @Override
    public Response doWordCheck(String content) {
        Map<String, String> params = new HashMap<>();
        params.put("content", content);
        String body = yesApiConnect.doGet("api/App/Common_BannerWord/Check", params, null);
        return JSON.parseObject(body, Response.class);
    }
}
