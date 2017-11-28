package com.getset.bsia.soundsystem;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:soundsystem4x.xml")
public class SoundSystemXmlTest {
    @Rule
    public StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    private MediaPlayer cdPlayer4x;

    @Test
    public void playTest() {
        cdPlayer4x.play();
        assertEquals("Playing Yehuimei by Jielun\n" +
                "QingTian  YiFuZhiMing  SanNianErBan  ", log.getLog());
    }
}
