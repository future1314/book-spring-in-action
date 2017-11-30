package com.getset.bsia.aop.xml;

public class Xiangsheng implements Performance {
    public void perform() {
        System.out.println("说相声...");
    }

    public void perform(int num) {
        System.out.println("说第" + num + "段相声...");
    }
}
