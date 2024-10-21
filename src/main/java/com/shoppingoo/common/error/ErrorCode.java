package com.shoppingoo.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode implements ErrorCodeIfs {

    OK(200, 200, "성공"), // 성공 상태
    BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), 400, "잘못된 요청"), // 잘못된 요청 오류
    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), 500, "서버에러"), // 서버 오류
    NULL_POINT(HttpStatus.INTERNAL_SERVER_ERROR.value(), 512, "Null point") // Null 포인터 오류
   ;

    private final Integer httpStatusCode; // HTTP 상태 코드
    private final Integer errorCode; // 사용자 정의 오류 코드
    private final String description; // 오류 설명
}
