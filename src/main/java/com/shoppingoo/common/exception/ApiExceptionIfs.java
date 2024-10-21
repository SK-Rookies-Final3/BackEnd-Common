package com.shoppingoo.common.exception;

import com.shoppingoo.common.error.ErrorCodeIfs;

// API 예외 인터페이스
public interface ApiExceptionIfs {

    // 오류 코드를 반환하는 메서드
    ErrorCodeIfs getErrorCodeIfs();

    // 오류 설명을 반환하는 메서드
    String getErrorDescription();
}
