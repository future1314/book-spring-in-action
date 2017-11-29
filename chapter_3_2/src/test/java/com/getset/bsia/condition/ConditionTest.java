package com.getset.bsia.condition;

import com.getset.bsia.condition.configs.JavaConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JavaConfig.class)
public class ConditionTest {

    @Autowired
    @Qualifier("linuxOS")
    private OS winOS;
    @Autowired
    @Qualifier("winOS")
    private OS linuxOS;

    @Test
    public void ifWin() {
        System.out.println(winOS.getName());
        assertNotNull(winOS);
    }

    @Test
    public void ifLinux() {
        System.out.println(linuxOS.getName());
        assertNotNull(linuxOS);
    }
}
