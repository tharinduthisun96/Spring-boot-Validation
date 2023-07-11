package com.validation.validation.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Slf4j
@Component
public class UserAspect {
    @Pointcut("execution(* com.validation.validation.service.UserService.saveUser(..))")
    public void loggingPointCut(){ }

    @Before("loggingPointCut()")
    public void before(JoinPoint joinPoint){
        log.info("User Save Valid Request");
    }
    @After("loggingPointCut()")
    public void after(JoinPoint joinPoint){
        log.info("User Successfully saved");
    }
}
