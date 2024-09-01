package com.aop.aop_programming.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(1)
@Aspect
@Component
public class GreetingAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("GreetingServicePointCut.greetingLoggerPointCut()")
    public void logerBefore(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes: " + method + " con los argumentos " + args);
    }

    @After("GreetingServicePointCut.greetingLoggerPointCut()")
    public void logerAfter(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues: " + method + " con los argumentos " + args);
    }

    @AfterReturning("GreetingServicePointCut.greetingLoggerPointCut()")
    public void logerAfterReturning(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues de retornar: " + method + " con los argumentos " + args);
    }

    @AfterThrowing("GreetingServicePointCut.greetingLoggerPointCut()")
    public void logerAfterThrowing(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues de la excepcion: " + method + " con los argumentos " + args);
    }

    @Around("GreetingServicePointCut.greetingLoggerPointCut()")
    public Object loggerAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = proceedingJoinPoint.getSignature().getName();
        String args = Arrays.toString(proceedingJoinPoint.getArgs());
        Object result = null;
        try {
            logger.info("El metodo: {} () con los parametros {}", method, args);
            result = proceedingJoinPoint.proceed();
            logger.info("El metodo: {} () retorna el resultado {}", method, result);
            return result;
        } catch (Throwable e) {
            logger.error("Error en la llamada del metodo: {} ()",method);
            throw e;
        }
    }
}
