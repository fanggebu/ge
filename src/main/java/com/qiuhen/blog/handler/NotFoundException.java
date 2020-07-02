package com.qiuhen.blog.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @ProjectName: blog
 * @Package: com.qiuhen.blog.handler
 * @ClassName: NotFoundException
 * @Author: qiuhen
 * @Description: 没有找到异常
 * @Date: 2020/6/28 10:05
 * @Version: 1.0
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
