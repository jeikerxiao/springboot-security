package com.jeiker.security.demo.exception;

import com.jeiker.security.demo.result.ApiResult;
import com.jeiker.security.demo.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@RestControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler
    public Result handler(HttpServletRequest req, HttpServletResponse res, Exception e) {
        log.info("Restful Http请求发生异常...");

        if (res.getStatus() == HttpStatus.BAD_REQUEST.value()) {
            log.info("修改返回状态值为200");
            res.setStatus(HttpStatus.OK.value());
        }

        if (e instanceof NullPointerException) {
            log.error("代码00：" + e.getMessage(), e);
            return ApiResult.failure("发生空指针异常");
        } else if (e instanceof IllegalArgumentException) {
            log.error("代码01：" + e.getMessage(), e);
            return ApiResult.failure("请求参数不合法");
        } else if (e instanceof SQLException) {
            log.error("代码02：" + e.getMessage(), e);
            return ApiResult.failure("数据库访问异常");
        } else {
            log.error("代码99：" + e.getMessage(), e);
            return ApiResult.failure("服务器代码发生异常,请联系管理员");
        }
    }

    /**
     * 处理所有业务异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public Result handleBusinessException(BusinessException e) {
        log.error("业务异常：{}", e.getMessage(), e);

        return ApiResult.failure(e.getMessage());
    }
}
