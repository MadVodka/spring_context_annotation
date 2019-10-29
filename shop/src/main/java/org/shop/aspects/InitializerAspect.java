package org.shop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class InitializerAspect {
    private Logger logger;

    public InitializerAspect(Logger logger) {
        this.logger = logger;
    }

    @Pointcut("execution(public * org.shop.*Initializer.init*(..)) && !within(is(FinalType))")
    public void callInitMethod() {}

    @Before("callInitMethod()")
    public void beforeCallInitMethod(JoinPoint joinPoint) {
        logger.info("Initialization started on {}", joinPoint.getSignature());
    }

    @After("callInitMethod()")
    public void afterCallInitMethod(JoinPoint joinPoint) {
        logger.info("Initialization finished on {}", joinPoint.getSignature());
    }
}
