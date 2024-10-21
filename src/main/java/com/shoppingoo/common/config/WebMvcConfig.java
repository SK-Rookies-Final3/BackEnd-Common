package com.shoppingoo.common.config;

import com.shoppingoo.common.interceptor.LoggerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration // 이 클래스가 Spring의 설정 클래스임을 나타냄
public class WebMvcConfig implements WebMvcConfigurer {

    // 오픈 API 경로 목록
    private List<String> OPEN_API = List.of(
            "/open-api/**"
    );

    // 기본적으로 제외할 경로 목록
    private List<String> DEFAULT_EXCLUDE = List.of(
            "/",
            "favicon.ico",
            "/error"
    );

    // Swagger 관련 경로 목록
    private List<String> SWAGGER = List.of(
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/v3/api-docs/**"
    );

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // LoggerInterceptor 등록
        registry.addInterceptor(new LoggerInterceptor());
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // CORS 설정: 모든 경로에 대해 CORS 허용
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // 허용할 출처
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 허용할 HTTP 메서드
                .allowedHeaders("*") // 허용할 헤더
                .allowCredentials(true); // 자격 증명 허용
    }
}
