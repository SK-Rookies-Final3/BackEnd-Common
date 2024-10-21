package com.shoppingoo.common.error;

// 오류 코드 인터페이스
public interface ErrorCodeIfs {

    // HTTP 상태 코드를 반환하는 메서드
    Integer getHttpStatusCode();

    // 사용자 정의 오류 코드를 반환하는 메서드
    Integer getErrorCode();

    // 오류 설명을 반환하는 메서드
    String getDescription();
}
