package com.mcc.anno;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)//指定注解只能加在方法上
@Retention(RetentionPolicy.RUNTIME)//指定注解的生命周期为运行时
public @interface LogOperation{
}
