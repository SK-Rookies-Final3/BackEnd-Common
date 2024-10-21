package com.shoppingoo.common.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j // 로깅 기능을 위한 Lombok 애너테이션
public class LoggerInterceptor implements HandlerInterceptor {

    // 요청 처리 전에 호출되는 메서드
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("***************** START *****************"); // 요청 시작 로그
        log.debug(" Request URI \t" + request.getRequestURI()); // 요청 URI 로그
        return true; // true를 반환하여 요청 처리를 계속 진행
    }

    // 요청 처리 후에 호출되는 메서드
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        // modelAndView.addObject("test","TEST"); // 예시로 modelAndView에 데이터 추가 (주석 처리됨)
        log.debug("*****************  END  *****************"); // 요청 종료 로그
    }
}
