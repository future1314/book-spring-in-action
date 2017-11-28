package com.getset.bsia.soundsystem;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:soundsystem.xml")
public class CDPlayerTest {

    @Rule
    public StandardOutputStreamLog log = new StandardOutputStreamLog();


    @Autowired
    private CompactDisk sgtPeppers;

    @Autowired
    private CompactDisk blankDisk;

    @Test
    public void sgtPeppersTest() {
        sgtPeppers.play();
        assertEquals("Playing Sgt. Papper's Lonely hearts Club Band by The Beetles\n", log.getLog());
    }

    @Test
    public void blankDiskTest() {
        blankDisk.play();
        assertEquals("Playing Sgt. Papper's Lonely hearts Club Band by The Beetles\nmusic 1  music 2  music 3  music 4  ", log.getLog());
    }
}
