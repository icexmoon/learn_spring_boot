package com.example.spel;

import com.alibaba.fastjson2.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : spel
 * @Package : com.example.spel
 * @ClassName : .java
 * @createTime : 2023/5/18 21:05
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Data
@AllArgsConstructor
public class Result {
    private boolean success = true;
    private String msg = "";
    private Object data = null;

    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", success);
        jsonObject.put("msg", msg);
        jsonObject.put("data", data);
        return jsonObject.toString();
    }

    public static Result success(Object data) {
        return new Result(true, "success", data);
    }

    public static Result success() {
        return success(null);
    }

    public static Result fail(String msg) {
        return new Result(false, msg, null);
    }
}
