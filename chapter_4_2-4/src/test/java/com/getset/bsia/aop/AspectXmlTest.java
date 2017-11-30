package com.getset.bsia.aop;

import com.getset.bsia.aop.xml.Light;
import com.getset.bsia.aop.xml.Performance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app.xml")
public class AspectXmlTest {
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
