package com.psh.config;

import com.psh.interceptor.AdminInterceptor;
import com.psh.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "login", "logout", "/", "member/join",
                        "/css/**","/error"
                );
        registry.addInterceptor(new AdminInterceptor())
                .order(2)
                .addPathPatterns("**")
                .excludePathPatterns(
                        "login", "logout", "/", "member/join",
                        "/css/**","/error"
                );
    }
}
