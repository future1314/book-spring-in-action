package com.getset.bsia.aop;

import com.getset.bsia.aop.annotation.AppConfig;
import com.getset.bsia.aop.annotation.Performance;
import com.getset.bsia.aop.annotation.Light;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AspectAnnotationsTest {
    @Autowired
    private Performance xiangsheng;

    @Test
    public void performTest() {
        xiangsheng.perform();
    }

    @Test
    public void performNumTest() {
        xiangsheng.perform(3);
    }

    @Test
    public void declareParentsTest() {
        Light s = (Light) xiangsheng;
        s.enLight();
        s.deLight();
    }
}
