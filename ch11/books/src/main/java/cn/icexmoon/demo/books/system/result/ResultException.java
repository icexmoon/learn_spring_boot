package cn.icexmoon.demo.books.system.result;

public class ResultException extends RuntimeException {

    private Result.ErrorCode code;

    public ResultException(Result.ErrorCode code, String msg) {
        super(msg);
        this.code = code;
    }

    public Result.ErrorCode getCode() {
        return code;
    }
}
