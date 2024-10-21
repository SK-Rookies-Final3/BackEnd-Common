package com.shoppingoo.common.api;

import com.shoppingoo.common.error.ErrorCode;
import com.shoppingoo.common.error.ErrorCodeIfs;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Result {

    private Integer resultCode; // 결과 코드
    private String resultMessage; // 결과 메시지
    private String resultDescription; // 결과 설명

    // 성공 결과를 생성하는 정적 메서드
    public static Result OK() {
        return Result.builder()
                .resultCode(ErrorCode.OK.getErrorCode()) // 성공 코드 설정
                .resultMessage(ErrorCode.OK.getDescription()) // 성공 메시지 설정
                .resultDescription("성공") // 성공 설명 설정
                .build(); // 빌더를 통해 Result 객체 생성
    }

    // 오류 결과를 생성하는 정적 메서드 (ErrorCodeIfs 타입)
    public static Result ERROR(ErrorCodeIfs errorCodeIfs) {
        return Result.builder()
                .resultCode(errorCodeIfs.getErrorCode()) // 오류 코드 설정
                .resultMessage(errorCodeIfs.getDescription()) // 오류 메시지 설정
                .resultDescription("에러발생") // 오류 설명 설정
                .build(); // 빌더를 통해 Result 객체 생성
    }

    // 오류 결과를 생성하는 정적 메서드 (ErrorCodeIfs와 Throwable)
    public static Result ERROR(ErrorCodeIfs errorCodeIfs, Throwable tx) {
        return Result.builder()
                .resultCode(errorCodeIfs.getErrorCode()) // 오류 코드 설정
                .resultMessage(errorCodeIfs.getDescription()) // 오류 메시지 설정
                .resultDescription(tx.getLocalizedMessage()) // 예외 메시지를 오류 설명으로 설정
                .build(); // 빌더를 통해 Result 객체 생성
    }

    // 오류 결과를 생성하는 정적 메서드 (ErrorCodeIfs와 설명)
    public static Result ERROR(ErrorCodeIfs errorCodeIfs, String description) {
        return Result.builder()
                .resultCode(errorCodeIfs.getErrorCode()) // 오류 코드 설정
                .resultMessage(errorCodeIfs.getDescription()) // 오류 메시지 설정
                .resultDescription(description) // 제공된 설명을 오류 설명으로 설정
                .build(); // 빌더를 통해 Result 객체 생성
    }
}
