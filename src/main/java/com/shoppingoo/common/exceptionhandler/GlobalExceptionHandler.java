package com.shoppingoo.common.exceptionhandler;

import com.shoppingoo.common.api.Api;
import com.shoppingoo.common.error.ErrorCode;
import com.shoppingoo.common.exception.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@Order(value = Integer.MAX_VALUE)
public class GlobalExceptionHandler {

    // ApiException을 처리하는 메서드
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Api<Object>> handleApiException(ApiException ex) {
        // ApiException 발생 시 에러 로그 출력
        log.error("API Exception: {}", ex.getMessage(), ex);

        // ApiException에서 HTTP 상태 코드와 에러 응답 생성
        return ResponseEntity
                .status(ex.getErrorCodeIfs().getHttpStatusCode()) // HTTP 상태 코드 설정
                .body(Api.ERROR(ex.getErrorCodeIfs(), ex.getErrorDescription())); // Api 객체 생성
    }

    // 모든 기타 예외를 처리하는 메서드
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Api<Object>> exception(Exception exception) {
        // 처리되지 않은 예외 발생 시 에러 로그 출력
        log.error("Unhandled exception: ", exception);

        // 서버 오류에 대한 응답 생성
        return ResponseEntity
                .status(500) // HTTP 상태 코드를 500으로 설정
                .body(
                        Api.ERROR(ErrorCode.SERVER_ERROR, exception.getMessage()) // Api 객체 생성
                );
    }
}
