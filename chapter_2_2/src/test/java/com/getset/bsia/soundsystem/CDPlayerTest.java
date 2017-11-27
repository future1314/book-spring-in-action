package com.getset.bsia.soundsystem;

import com.getset.bsia.soundsystem.config.CDPlayerConfig;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    private CompactDisk compactDisk;

    @Autowired
    private MediaPlayer cdPlayer;

    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(compactDisk);
    }

    @Test
    public void cdPlayerShouldPlay() {
        cdPlayer.play();
        assertEquals("Playing Sgt. Papper's Lonely hearts Club Band by The Beatles\n", log.getLog());
    }
}
