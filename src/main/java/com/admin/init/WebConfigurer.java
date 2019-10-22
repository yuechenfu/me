package com.admin.init;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.admin.controller.interceptor.AuthInterceptor;

/**
 * 和springmvc的webmvc拦截配置一样
 * @author BIANP
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {
	 @Override
	 public void addInterceptors(InterceptorRegistry registry) {
        // 拦截所有请求，通过判断是否有 @LoginRequired 注解 决定是否需要登录
        registry.addInterceptor(AuthInterceptor()).addPathPatterns("/**");
	 }
	 
	 @Bean
	 public AuthInterceptor AuthInterceptor() {
		 return new AuthInterceptor();
	 }
	 
	
}