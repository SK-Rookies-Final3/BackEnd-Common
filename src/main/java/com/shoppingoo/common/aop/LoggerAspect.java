package com.shoppingoo.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggerAspect {

    // 포인트컷 정의: 모든 컨트롤러, 서비스 구현체, 매퍼에 적용
    @Pointcut("execution(* com.shoppingoo..*.controller..*(..)) || " +
            "execution(* com.shoppingoo..*.service..*(..)) || " +
            "execution(* com.shoppingoo..*.mapper..*(..))")
    private void loggerTarget() {
        // 포인트컷 메서드는 내용이 없고, 어노테이션으로만 사용됨
    }

    @Around("loggerTarget()")
    public Object loggerPointer(ProceedingJoinPoint joinPoint) throws Throwable {
        String type = "";
        String className = joinPoint.getSignature().getDeclaringTypeName();

        // 클래스 이름에 따라 타입 결정
        if (className.indexOf("Controller") > -1) {
            type = "[Controller]";
        } else if (className.indexOf("ServiceImpl") > -1) {
            type = "[ServiceImpl]";
        } else if (className.indexOf("Mapper") > -1) {
            type = "[Mapper]";
        }

        String methodName = joinPoint.getSignature().getName(); // 호출된 메서드 이름 얻기

        // 로그 출력
        log.debug(type + " " + className + "." + methodName);

        // 실제 메서드 실행
        return joinPoint.proceed();
    }
}
