package org.shop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RepositoryAspect {
    @Autowired
    @Qualifier("applicationLogger")
    private Logger logger;

    @Pointcut("execution(public !void org.shop.repository.*.*(..)) && !within(is(FinalType))")
    public void callRepositoryMethodsWithReturning() {
    }

    @Pointcut("execution(public void org.shop.repository.*.*(..)) && !within(is(FinalType))")
    public void callRepositoryMethodsWithVoid() {
    }

    @Before("callRepositoryMethodsWithReturning() || callRepositoryMethodsWithVoid()")
    public void beforeCallRepositoryMethods(JoinPoint joinPoint) {
        logger.info("Start of {}, arguments {}", joinPoint.getSignature(), joinPoint.getArgs());
    }

    @After("callRepositoryMethodsWithVoid()")
    public void afterCallRepositoryMethods(JoinPoint joinPoint) {
        logger.info("End of {}", joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "callRepositoryMethodsWithReturning()", returning = "object")
    public void afterReturningCallRepositoryMethods(JoinPoint joinPoint, Object object) {
        logger.info("Result of {} is: {}", joinPoint.getSignature(), object);
    }
}
