package com.bugtrackertool.bugtrackertool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    //spring-managed object created to allow app to access whitelist filter
    @Bean
    public Whitelist whitelist() {
        return new Whitelist();
    }

    //register filter with spring container
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor( whitelist() );
    }

}
