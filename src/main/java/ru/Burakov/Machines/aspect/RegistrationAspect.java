package ru.Burakov.Machines.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class RegistrationAspect {
    @AfterReturning(pointcut = "execution(* ru.Burakov.Machines.controllers.*Controller.*(..))", returning = "value")
    public void getSuccessfulMethod(JoinPoint joinPoint, Object value) {
        log.info("Метод контроллера {} успешно отработал и вернул значение: {}", joinPoint.getSignature().getName(), value );
    }

    @AfterThrowing(pointcut = "execution(* ru.Burakov.Machines.controllers.*Controller.*(..))", throwing = "error")
    public void getExceptionMethod(JoinPoint joinPoint, Throwable error) {
        log.info("Метод контроллера {} отработал с ошибкой: {}", joinPoint.getSignature().getName(), error.getMessage());
    }
}
