package per.zzch.gmall.admin.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import per.zzch.gmall.to.CommonResult;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {NullPointerException.class})
    public Object handlerNullPointException(Exception exception) {
        log.error("系统全局异常感知 信息：{}", exception.getMessage());
        return new CommonResult().validateFailed("出现了空指针……");
    }

    @ExceptionHandler(value = {ArithmeticException.class})
    public Object handlerArithmeticException(Exception exception) {
        log.error("系统全局异常感知 信息：{}", exception.getMessage());
        return new CommonResult().validateFailed("出现了数据计算错误……");
    }
}
