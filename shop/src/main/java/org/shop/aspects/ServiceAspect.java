package org.shop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class ServiceAspect {
    private static Logger logger = LoggerFactory.getLogger(ServiceAspect.class);

    @Pointcut("execution(public * org.shop.api.*.get*(..))")
    public void callGetMethods() {
    }

    @Before("callGetMethods()")
    public void beforeCallGetMethods(JoinPoint joinPoint) {
        logger.info("Starting operations on {}", joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "callGetMethods()", returning = "objects")
    public void afterReturningCallGetMethods(JoinPoint joinPoint, List objects) {
        logger.info("Result of {} is: {}", joinPoint.getSignature().getName(), objects);
    }
}
