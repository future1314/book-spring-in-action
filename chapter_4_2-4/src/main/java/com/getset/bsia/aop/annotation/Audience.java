package com.getset.bsia.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Audience {

    @Pointcut("execution(* com.getset.bsia.aop.annotation.Performance.perform(..))")
    public void performance() {}

    @Before("performance()")
    public void silenceCellPhone() {
        System.out.println("before>>> Silence cellphones...");
    }

    @Before("performance()")
    public void takeSeats() {
        System.out.println("before>>> Take seats...");
    }

    @AfterReturning("performance()")
    public void applause() {
        System.out.println("after returning>>> Applause...");
    }

    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("after throwing>>> Demand refund...");
    }

    @Around("execution(* com.getset.bsia.aop.annotation.Performance.perform(int))")
    public void around(ProceedingJoinPoint jp) {
        try {
            System.out.println("Around 1");
            jp.proceed();
            System.out.println("Around 2");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @After("execution(* com.getset.bsia.aop.annotation.Performance.perform(int)) && args(num)")
    public void afterPerform(int num) {
        System.out.println("after perform " + num);
    }
}
