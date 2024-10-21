package com.shoppingoo.common.exceptionhandler;

import com.shoppingoo.common.api.Api;
import com.shoppingoo.common.exception.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@Order(value = Integer.MIN_VALUE)
public class ApiExceptionHandler {

    // ApiException 예외를 처리하는 메서드
    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<Api<Object>> apiException(
            ApiException apiException // 처리할 ApiException 인스턴스
    ) {
        // 예외 발생 시 에러 로그 출력
        log.error("", apiException);

        // ApiException에서 오류 코드를 가져옴
        var errorCode = apiException.getErrorCodeIfs();

        // ResponseEntity를 생성하여 에러 응답 반환
        return ResponseEntity
                .status(errorCode.getHttpStatusCode()) // HTTP 상태 코드 설정
                .body(
                        Api.ERROR(errorCode, apiException.getErrorDescription()) // Api 객체 생성
                );
    }
}
