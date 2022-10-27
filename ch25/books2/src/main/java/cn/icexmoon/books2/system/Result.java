package cn.icexmoon.books2.system;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.system
 * @ClassName : .java
 * @createTime : 2022/10/22 16:20
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Data
@Accessors(chain = true)
public class Result<T> {
    private Integer code;
    private T data;
    private String msg;
    private boolean success;

    public static <T> Result<T> success(T data) {
        return success().setData(data);
    }

    public static Result success() {
        return new Result()
                .setCode(200)
                .setSuccess(true)
                .setData(null)
                .setMsg("成功");
    }

    public static Result fail(Integer code, String msg) {
        return new Result()
                .setData(null)
                .setSuccess(false)
                .setCode(code)
                .setMsg(msg);
    }

    public static Result fail(String msg){
        return fail(500, msg);
    }
}
