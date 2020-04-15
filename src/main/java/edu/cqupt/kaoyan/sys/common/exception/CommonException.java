package edu.cqupt.kaoyan.sys.common.exception;


import edu.cqupt.kaoyan.sys.common.system.result.ResultCode;
import lombok.Getter;

/**
 * 自定义异常
 */
@Getter
public class CommonException extends Exception {

    private ResultCode resultCode;

    public CommonException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
