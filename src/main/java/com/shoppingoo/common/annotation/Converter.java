package com.shoppingoo.common.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // 이 애너테이션이 적용될 수 있는 대상은 클래스, 인터페이스, 열거형
@Retention(RetentionPolicy.RUNTIME) // 런타임 동안 애너테이션 정보가 유지됨
@Service // Spring의 서비스 컴포넌트로 등록됨
public @interface Converter {

    @AliasFor(annotation = Service.class) // Service 애너테이션의 value 속성과 동기화
    String value() default ""; // 서비스 이름, 기본값은 빈 문자열
}
