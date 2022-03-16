package com.emms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer{
    
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/api/**")
            .allowedOrigins("http://192.168.0.6:3000")
            .allowedOrigins("http://localhost:3000");
        	
        /*	// ▼ 모든 접근에 대하여 허용 할 경우
        	.allowedOrigins("*");
       	*/
    }
}