package com.squirrel.java.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 松鼠方面
 *
 * @author luobaosong
 * @date 2022/11/15 15:02:10
 */
@Aspect
@Component
@Slf4j
public class SquirrelAspect {


    // 定义切点，拦截带有@SquLog注解的方法
    @Pointcut("@annotation(com.squirrel.java.annoation.SquLog)")
    public void squirrelLog() {
        // Pointcut for methods annotated with @SquLog
    }
    // ssh


    /**
     * 环绕通知，打印方法入参和返回值
     */
    @Around(value = "squirrelLog()")
    public Object logAround(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        log.info("[AOP日志] 方法开始，参数: {}", JSON.toJSONString(args));
        Object result = point.proceed();
        log.info("[AOP日志] 方法结束，返回: {}", JSON.toJSONString(result));
        return result;
    }

}
