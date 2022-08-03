package cn.icexmoon.demo.books.yesapi.service;

import cn.icexmoon.demo.books.system.result.Result;
import cn.icexmoon.demo.books.system.result.ResultException;
import lombok.Data;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books
 * @Package : cn.icexmoon.demo.books.yesapi.service
 * @ClassName : .java
 * @createTime : 2022/8/3 13:48
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public interface IWordCheckService {
    @Data
    class Response {
        @Data
        public static class InnerData {
            private Integer errCode;
            private String errMsg;
            private String[] sensitiveWord;
        }

        private Integer ret;
        private InnerData data;
        private String msg;
        private Integer _t;
        private String _auth;
    }

    /**
     * 执行敏感词检查
     *
     * @param content 内容
     * @return
     */
    Response doWordCheck(String content);

    static boolean isWordCheckAccess(Response response) {
        if (response.getData().getErrCode() == 0) {
            return true;
        }
        return false;
    }

    static String[] getSensitiveWords(Response response) {
        return response.getData().getSensitiveWord();
    }

    /**
     * 检查返回值中是否包含敏感词，如果存在，抛出异常
     *
     * @param response
     */
    static void checkSensitiveWords(Response response) {
        if (!isWordCheckAccess(response)) {
            throw new ResultException(Result.ErrorCode.PARAM_CHECK, "包含敏感词：" + Arrays.toString(getSensitiveWords(response)));
        }
    }
}
