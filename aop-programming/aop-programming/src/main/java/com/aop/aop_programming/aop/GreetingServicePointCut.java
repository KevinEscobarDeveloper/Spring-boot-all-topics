package com.aop.aop_programming.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointCut {
    @Pointcut("execution(* com.aop.aop_programming.services.GreetingService.*(..))")
    public void greetingLoggerPointCut() {

    }

    @Pointcut("execution(* com.aop.aop_programming.services.GreetingService.*(..))")
    public void greetingFooAscpectPointCut() {

    }
}
