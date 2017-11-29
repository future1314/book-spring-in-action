package com.getset.bsia.valueinsertion;

import com.getset.bsia.valueinsertion.configs.AutoConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AutoConfig.class)
public class AutoTest {
    @Autowired
    private CompactDisk blankDisk2;

    @Test
    public void testAutoPropInsertion() {
        blankDisk2.play();
    }
}
