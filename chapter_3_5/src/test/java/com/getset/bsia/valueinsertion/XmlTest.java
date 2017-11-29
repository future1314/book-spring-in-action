package com.getset.bsia.valueinsertion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app.xml")
public class XmlTest {
    @Autowired
    private CompactDisk blanckDiscXml;

    @Test
    public void xmlInsertionTest() {
        blanckDiscXml.play();
    }
}
