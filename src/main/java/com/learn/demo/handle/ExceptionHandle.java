package com.learn.demo.handle;

import com.learn.demo.common.exception.ResultException;
import com.learn.demo.common.resp.Result;
import com.learn.demo.common.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理器
 */

@RestControllerAdvice
public class ExceptionHandle {

    Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    private ResultException resultException;

    @ExceptionHandler(value = Exception.class)
    public Result handleException(Exception ex) {
        if (ex instanceof ResultException) {
            resultException = (ResultException) ex;
            return ResultUtil.fail(resultException.getCode(), resultException.getMessage());
        }
        logger.error("异常",ex);

        return ResultUtil.fail(1, ex.getMessage());
    }

}
