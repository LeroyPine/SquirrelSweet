package com.squirrel.java.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SquirrelAspect {


    // 标记为切面类

    // 标记切入点

    @Pointcut("@annotation(com.squirrel.java.annoation.SquLog))")
    public void squLog() {
    }
    // ssh


    @Around(value = "squLog()")
    public Object squ(ProceedingJoinPoint point) throws Throwable {
        System.out.println("aspect-log-start");
        Object proceed = point.proceed();
        System.out.println("aspect-log-end");
        return proceed;
    }

}
