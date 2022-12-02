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


    @Pointcut("@annotation(com.squirrel.java.annoation.SquLog))")
    public void squirrelLog() {
        //
    }
    // ssh


    @Around(value = "squirrelLog()")
    public Object squ(ProceedingJoinPoint point) throws Throwable {

        Object[] args = point.getArgs();

        log.info("start log:{}", JSON.toJSONString(args));

        Object proceed = point.proceed();

        log.info("end log:{}", JSON.toJSONString(proceed));

        return proceed;
    }

}
