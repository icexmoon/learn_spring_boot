package cn.icexmoon.demo.books.system;


import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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
        return new Result(true, "", data);
    }

    public static Result success() {
        return Result.success(null);
    }

    public static Result error(String msg) {
        return new Result(false, msg, null);
    }
}
