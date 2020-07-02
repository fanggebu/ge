package com.qiuhen.blog.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ProjectName: blog
 * @Package: com.qiuhen.blog.interceptor
 * @ClassName: LoginInterceptor
 * @Author: qiuhen
 * @Description: 登录拦截
 * @Date: 2020/6/30 22:25
 * @Version: 1.0
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getSession().getAttribute("user") == null){
            response.sendRedirect("/admin");
            return false;
        }

        return true;



    }
}
