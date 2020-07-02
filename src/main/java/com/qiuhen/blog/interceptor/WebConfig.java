package com.qiuhen.blog.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ProjectName: blog
 * @Package: com.qiuhen.blog.interceptor
 * @ClassName: WebConfig
 * @Author: qiuhen
 * @Description: web控制器
 * @Date: 2020/6/30 22:29
 * @Version: 1.0
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin")
                .excludePathPatterns("/admin/login");

        super.addInterceptors(registry);
    }
}
