package com.getset.bsia.aop.xml;

public class StageLight implements Light {
    public void enLight() {
        System.out.println("调亮舞台灯...");
    }

    public void deLight() {
        System.out.println("调暗舞台灯...");
    }
}
