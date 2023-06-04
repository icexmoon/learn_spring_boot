package com.example.lombok.system;

import lombok.Value;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : lombok
 * @Package : com.example.lombok.system
 * @ClassName : .java
 * @createTime : 2023/6/1 10:19
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Value
public class Result<T> {
    boolean success;
    String errorCode;
    String errorMsg;
    T data;

    public static <T> Result<T> success(T data) {
        return new Result<T>(true, "", "", data);
    }

    public static Result<Object> success() {
        return success(null);
    }
}
