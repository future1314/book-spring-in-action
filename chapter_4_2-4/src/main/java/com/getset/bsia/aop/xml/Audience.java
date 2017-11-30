package com.getset.bsia.aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

public class Audience {

    public void silenceCellPhone() {
        System.out.println("before>>> Silence cellphones...");
    }

    public void takeSeats() {
        System.out.println("before>>> Take seats...");
    }

    public void applause() {
        System.out.println("after returning>>> Applause...");
    }

    public void demandRefund() {
        System.out.println("after throwing>>> Demand refund...");
    }

    public void around(ProceedingJoinPoint jp) {
        try {
            System.out.println("Around 1");
            jp.proceed();
            System.out.println("Around 2");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public void afterPerform(int num) {
        System.out.println("after perform " + num);
    }
}
