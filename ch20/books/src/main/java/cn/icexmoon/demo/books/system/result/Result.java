package cn.icexmoon.demo.books.system.result;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Result {
    public enum ErrorCode {
        SUCCESS(200, "成功"),
        DB_NO_DATA(500, "数据库数据缺失"),
        PARAM_CHECK(400, "没有通过参数校验"),
        LOGIN_ERROR(400, "登录失败"),

        NO_PRIORITY(401, "缺少操作的相关权限"),
        REQUEST_PARSE(402, "HTTP请求解析错误"),
        TIME_PARSE(403, "时间解析出错"),
        NEED_LOGIN(404, "需要登录"),
        DEFAULT_ERROR(501, "默认错误"),
        NETWORK_ERROR(502, "网络错误");

        @JsonValue
        private Integer code;
        private String desc;

        private ErrorCode(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public Integer getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }

        @Override
        public String toString() {
            return this.code.toString();
        }
    }

    @ApiModelProperty("调用成功/失败")
    private boolean success = true;
    @ApiModelProperty("调用失败后的提示信息")
    private String msg = "";
    @ApiModelProperty("接口返回的数据")
    private Object data = null;
    @ApiModelProperty("错误码")
    private ErrorCode code = ErrorCode.SUCCESS;

    private static final Result SUCCESS_RESULT = new Result();

    /**
     * 获取成功Result
     *
     * @return
     */
    public static Result success() {
        return SUCCESS_RESULT;
    }

    /**
     * 获取成功的Result
     *
     * @param data
     * @return
     */
    public static Result success(Object data) {
        Result result = new Result();
        result.setData(data);
        return result;
    }

    /**
     * 获取失败Result
     *
     * @param errorCode 错误码
     * @param msg       错误信息
     * @return
     */
    public static Result fail(ErrorCode errorCode, String msg) {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(errorCode);
        result.setData(null);
        result.setMsg(msg);
        return result;
    }

    /**
     * 获取失败Result
     *
     * @param exp 产生错误的异常
     * @return
     */
    public static Result fail(ResultException exp) {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(exp.getCode());
        result.setData(null);
        result.setMsg(exp.getMessage());
        return result;
    }

    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", success);
        jsonObject.put("msg", msg);
        jsonObject.put("data", data);
        jsonObject.put("code", code.getCode());
        return jsonObject.toString();
    }
}
