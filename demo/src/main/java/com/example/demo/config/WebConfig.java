package com.example.demo.config;

import com.example.demo.filter.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @Auther: sunmingyao
 * @Date: 2018/11/22 10 44
 * @Description:
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    LoginInterceptor loginInterceptor(){

        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {


        InterceptorRegistration addInterceptor = registry.addInterceptor(loginInterceptor());

        // 登录页面和登录接口不拦截
        addInterceptor.excludePathPatterns("/login");
        addInterceptor.excludePathPatterns("/loginApi/**");
        addInterceptor.excludePathPatterns("/userApi/**");


        //排除静态资源拦截
        addInterceptor.excludePathPatterns("/layui/**","/css/**","/fonts/**","/images/**","/js/**");

        // 拦截配置
        addInterceptor.addPathPatterns("/**");
    }
}
