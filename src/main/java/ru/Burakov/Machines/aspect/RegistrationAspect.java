package ru.Burakov.Machines.aspect;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.Burakov.Machines.actuator.RequestActuator;

import java.util.concurrent.TimeUnit;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class RegistrationAspect {
    private final RequestActuator requestActuator;
    private final HttpServletRequest servlet;
    private final MeterRegistry registry;

    @AfterReturning(pointcut = "execution(* ru.Burakov.Machines.controllers.*Controller.*(..))", returning = "value")
    public void getSuccessfulMethod(JoinPoint joinPoint, Object value) {
        log.info("Метод контроллера {} успешно отработал и вернул значение: {}", joinPoint.getSignature().getName(), value );
        requestActuator.getCount(servlet.getRequestURI());
    }

    @AfterThrowing(pointcut = "execution(* ru.Burakov.Machines.controllers.*Controller.*(..))", throwing = "error")
    public void getExceptionMethod(JoinPoint joinPoint, Throwable error) {
        log.info("Метод контроллера {} отработал с ошибкой: {}", joinPoint.getSignature().getName(), error.getMessage());
    }

    @Around("execution(* ru.Burakov.Machines.controllers.*Controller.*(..))")
    public void logExecutionTime(ProceedingJoinPoint joinPoint){
        Timer timer = Timer.builder("requests_info.time").tag("method", joinPoint.getSignature().toString()).register(registry);
        long start = System.currentTimeMillis();
        timer.record(System.nanoTime() - start, TimeUnit.NANOSECONDS);
    }
}
