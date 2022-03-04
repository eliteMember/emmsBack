package com.emms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.emms.cmmn.interceptor.AuthenticInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Autowired
	private AuthenticInterceptor authenticInterceptor;
	
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticInterceptor)
        
        		//원본
        		//.addPathPatterns("/api/**")
                //.excludePathPatterns("/api/cmmn/**")
        		//.excludePathPatterns("/api/login");
        
        		//테스트 진행
        		.excludePathPatterns("/**");
        		
    }
}
