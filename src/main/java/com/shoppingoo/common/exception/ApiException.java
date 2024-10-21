package com.shoppingoo.common.exception;

import com.shoppingoo.common.error.ErrorCodeIfs;
import lombok.Getter;

@Getter
public class ApiException extends RuntimeException implements ApiExceptionIfs {

    private final ErrorCodeIfs errorCodeIfs; // 오류 코드
    private final String errorDescription; // 오류 설명

    // 오류 코드를 인자로 받는 생성자
    public ApiException(ErrorCodeIfs errorCodeIfs) {
        super(errorCodeIfs.getDescription()); // RuntimeException의 메시지로 오류 설명 설정
        this.errorCodeIfs = errorCodeIfs; // 오류 코드 초기화
        this.errorDescription = errorCodeIfs.getDescription(); // 오류 설명 초기화
    }

    // 오류 코드와 사용자 정의 오류 설명을 인자로 받는 생성자
    public ApiException(ErrorCodeIfs errorCodeIfs, String errorDescription) {
        super(errorDescription); // RuntimeException의 메시지로 사용자 정의 설명 설정
        this.errorCodeIfs = errorCodeIfs; // 오류 코드 초기화
        this.errorDescription = errorDescription; // 오류 설명 초기화
    }

    // 오류 코드와 Throwable을 인자로 받는 생성자
    public ApiException(ErrorCodeIfs errorCodeIfs, Throwable tx) {
        super(tx); // RuntimeException의 원인으로 Throwable 설정
        this.errorCodeIfs = errorCodeIfs; // 오류 코드 초기화
        this.errorDescription = errorCodeIfs.getDescription(); // 오류 설명 초기화
    }

    // 오류 코드, Throwable, 사용자 정의 오류 설명을 인자로 받는 생성자
    public ApiException(ErrorCodeIfs errorCodeIfs, Throwable tx, String errorDescription) {
        super(tx); // RuntimeException의 원인으로 Throwable 설정
        this.errorCodeIfs = errorCodeIfs; // 오류 코드 초기화
        this.errorDescription = errorDescription; // 오류 설명 초기화
    }
}
