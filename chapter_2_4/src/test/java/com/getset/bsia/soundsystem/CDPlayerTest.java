package com.getset.bsia.soundsystem;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class CDPlayerTest {

    private ApplicationContext context;

    @Rule
    public StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Before
    public void prepareContext() {
        this.context = new ClassPathXmlApplicationContext("xmls/soundsystem.xml");
    }

    @Test
    public void sgtPeppersTest() {
        CompactDisk sgtPeppers = (SgtPeppers)context.getBean("sgtPeppers");
        sgtPeppers.play();
        assertEquals("Playing Sgt. Papper's Lonely hearts Club Band by The Beetles\n", log.getLog());
    }

    @Test
    public void blankDiskTest() {
        CompactDisk blankDisk = (BlankDisk)context.getBean("blankDisk");
        blankDisk.play();
        assertEquals("Playing Sgt. Papper's Lonely hearts Club Band by The Beetles\nmusic 1  music 2  music 3  music 4  ", log.getLog());
    }
}
