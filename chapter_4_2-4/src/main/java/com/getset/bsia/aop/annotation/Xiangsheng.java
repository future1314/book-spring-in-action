package com.getset.bsia.aop.annotation;

import org.springframework.stereotype.Component;

@Component
public class Xiangsheng implements Performance {
    public void perform() {
        System.out.println("说相声...");
    }

    public void perform(int num) {
        System.out.println("说第" + num + "段相声...");
    }
}
