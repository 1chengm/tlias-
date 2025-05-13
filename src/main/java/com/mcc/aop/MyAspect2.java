//package com.mcc.aop;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@Component
//@Aspect
//public class MyAspect2 {
//
//    //根据注解来匹配方法
//    //抽象的切入点
//    @Pointcut("@annotation(com.mcc.anno.LogOperation)")//注解全类名
//    public void pc() {}
//
//    //前置通知
//    @Before("pc()")
//    public void before() {
//        log.info("MyAspect1 -> before ...");
//    }
//
//    //环绕通知
//    @Around("pc()")
//    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
//        log.info("MyAspect2 -> around ...");
//        Object result = joinPoint.proceed();// 执行原始方法, 并获取返回值
//        // ProceedingJoinPoint 继承了 JoinPoint
//        log.info("MyAspect2 -> around ...");
//        return result;
//    }
//
//    //后置通知
//    @After("pc()")
//    public void after() {
//        log.info("MyAspect1 -> after ...");
//    }
//}