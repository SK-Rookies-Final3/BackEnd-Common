package com.shoppingoo.common.api;

import com.shoppingoo.common.error.ErrorCodeIfs;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Api<T> {

    private Result result; // API 결과 상태를 나타내는 필드

    @Valid // body 필드의 유효성 검사를 위해 사용
    private T body; // API 응답의 본문 데이터

    // 성공 응답을 생성하는 정적 메서드
    public static <T> Api<T> OK(T data) {
        var api = new Api<T>();
        api.result = Result.OK(); // 결과 상태를 OK로 설정
        api.body = data; // 본문 데이터 설정
        return api; // 생성된 Api 객체 반환
    }

    // 오류 응답을 생성하는 정적 메서드 (Result 타입)
    public static Api<Object> ERROR(Result result) {
        var api = new Api<Object>();
        api.result = result; // 결과 상태를 지정된 result로 설정
        return api; // 생성된 Api 객체 반환
    }

    // 오류 응답을 생성하는 정적 메서드 (ErrorCodeIfs 타입)
    public static Api<Object> ERROR(ErrorCodeIfs errorCodeIfs) {
        var api = new Api<Object>();
        api.result = Result.ERROR(errorCodeIfs); // 결과 상태를 ERROR로 설정
        return api; // 생성된 Api 객체 반환
    }

    // 오류 응답을 생성하는 정적 메서드 (ErrorCodeIfs와 Throwable)
    public static Api<Object> ERROR(ErrorCodeIfs errorCodeIfs, Throwable tx) {
        var api = new Api<Object>();
        api.result = Result.ERROR(errorCodeIfs, tx); // 결과 상태를 ERROR로 설정
        return api; // 생성된 Api 객체 반환
    }

    // 오류 응답을 생성하는 정적 메서드 (ErrorCodeIfs와 설명)
    public static Api<Object> ERROR(ErrorCodeIfs errorCodeIfs, String description) {
        var api = new Api<Object>();
        api.result = Result.ERROR(errorCodeIfs, description); // 결과 상태를 ERROR로 설정
        return api; // 생성된 Api 객체 반환
    }
}
