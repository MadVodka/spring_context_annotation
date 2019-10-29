package org.shop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {
    private Logger logger;

    public ServiceAspect(Logger logger) {
        this.logger = logger;
    }

    @Pointcut("within(org.shop.api.*)")
    public void inServiceLayer() {}

    @Pointcut("execution(public !void org.shop.api.*.*(..))")
    public void callServiceMethodsWithReturning() {
    }

    @Pointcut("execution(public void org.shop.api.*.*(..))")
    public void callServiceMethodsWithVoid() {
    }

    @Before("callServiceMethodsWithReturning() || callServiceMethodsWithVoid()")
    public void beforeCallServiceMethods(JoinPoint joinPoint) {
        logger.info("Start of {}, arguments {}", joinPoint.getSignature(), joinPoint.getArgs());
    }

    @After("callServiceMethodsWithVoid()")
    public void afterCallServiceMethods(JoinPoint joinPoint) {
        logger.info("End of {}", joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "callServiceMethodsWithReturning()", returning = "object")
    public void afterReturningCallServiceMethods(JoinPoint joinPoint, Object object) {
        logger.info("Result of {} is: {}", joinPoint.getSignature(), object);
    }
}
