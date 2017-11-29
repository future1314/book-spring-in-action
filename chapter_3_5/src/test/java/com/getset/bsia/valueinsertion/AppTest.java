package com.getset.bsia.valueinsertion;

import com.getset.bsia.valueinsertion.configs.AppConfig;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AppTest {

    @Rule
    public StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    private CompactDisk yehuimei;

    @Test
    public void testProperties() {
        yehuimei.play();
    }

}
