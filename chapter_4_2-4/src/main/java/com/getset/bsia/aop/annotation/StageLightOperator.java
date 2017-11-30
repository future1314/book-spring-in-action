package com.getset.bsia.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StageLightOperator {

    @DeclareParents(value = "com.getset.bsia.aop.annotation.Performance+", defaultImpl = StageLight.class)
    private Light stageLight;
}
